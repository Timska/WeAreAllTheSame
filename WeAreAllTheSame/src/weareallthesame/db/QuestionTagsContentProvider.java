package weareallthesame.db;

import java.util.Arrays;
import java.util.HashSet;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class QuestionTagsContentProvider extends ContentProvider {

	private QuestionTagsOpenHelper helper;
	// used for the UriMacher
	private static final int ITEMS = 1;
	private static final int ITEM_ID = 2;

	private static final String AUTHORITY = "weareallthesame.db5";
	private static final String BASE_PATH = "questions_tags";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
			+ "/" + BASE_PATH);
	// The next two strings are for the getType overridden method
	public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
			+ "/questions_tags";
	public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
			+ "/question_tag";

	private static final UriMatcher sURIMatcher = new UriMatcher(
			UriMatcher.NO_MATCH);

	static {
		sURIMatcher.addURI(AUTHORITY, BASE_PATH, ITEMS);
		sURIMatcher.addURI(AUTHORITY, BASE_PATH + "/#", ITEM_ID);
	}

	@Override
	public boolean onCreate() {
		helper = new QuestionTagsOpenHelper(getContext());
		return true;
	}

	@Override
	public String getType(Uri uri) {
		switch (sURIMatcher.match(uri)) {
		case ITEMS:
			return CONTENT_TYPE;
		case ITEM_ID:
			return CONTENT_ITEM_TYPE;
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// Using SQLiteQueryBuilder instead of query() method
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

		// check if the caller has requested a column which does not exists
		checkColumns(projection);

		// Set the table
		queryBuilder.setTables(QuestionTagsOpenHelper.TABLE_NAME);
		int uriType = sURIMatcher.match(uri);
		switch (uriType) {
		case ITEMS:
			break;
		case ITEM_ID:
			// adding the ID to the original query
			queryBuilder.appendWhere(QuestionTagsOpenHelper.COLUMN_ID + "="
					+ uri.getLastPathSegment());
			break;
		default:
			throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = queryBuilder.query(db, projection, selection,
				selectionArgs, null, null, sortOrder);

		// make sure that potential listeners are getting notified
		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		return cursor;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		int uriType = sURIMatcher.match(uri);
		SQLiteDatabase sqlDB = helper.getWritableDatabase();
		long id = 0;
		switch (uriType) {
		case ITEMS:
			id = sqlDB.insert(QuestionTagsOpenHelper.TABLE_NAME, null, values);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return ContentUris.withAppendedId(CONTENT_URI, id);
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int uriType = sURIMatcher.match(uri);
		SQLiteDatabase sqlDB = helper.getWritableDatabase();
		int rowsUpdated = 0;
		switch (uriType) {
		case ITEMS:
			rowsUpdated = sqlDB.update(QuestionTagsOpenHelper.TABLE_NAME,
					values, selection, selectionArgs);
			break;
		case ITEM_ID:
			String id = uri.getLastPathSegment();
			if (TextUtils.isEmpty(selection)) {
				rowsUpdated = sqlDB.update(QuestionTagsOpenHelper.TABLE_NAME,
						values, QuestionTagsOpenHelper.COLUMN_ID + "=" + id,
						null);
			} else {
				rowsUpdated = sqlDB.update(QuestionTagsOpenHelper.TABLE_NAME,
						values, QuestionTagsOpenHelper.COLUMN_ID + "=" + id
								+ " and " + selection, selectionArgs);
			}
			break;
		default:
			throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return rowsUpdated;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int uriType = sURIMatcher.match(uri);
		SQLiteDatabase sqlDB = helper.getWritableDatabase();
		int rowsDeleted = 0;
		switch (uriType) {
		case ITEMS:
			rowsDeleted = sqlDB.delete(QuestionTagsOpenHelper.TABLE_NAME,
					selection, selectionArgs);
			break;
		case ITEM_ID:
			String id = uri.getLastPathSegment();
			if (TextUtils.isEmpty(selection)) {
				rowsDeleted = sqlDB.delete(QuestionTagsOpenHelper.TABLE_NAME,
						QuestionTagsOpenHelper.COLUMN_ID + "=" + id, null);
			} else {
				rowsDeleted = sqlDB.delete(QuestionTagsOpenHelper.TABLE_NAME,
						QuestionTagsOpenHelper.COLUMN_ID + "=" + id + " and "
								+ selection, selectionArgs);
			}
			break;
		default:
			throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return rowsDeleted;
	}

	private void checkColumns(String[] projection) {
		String[] available = { QuestionTagsOpenHelper.COLUMN_ID,
				QuestionTagsOpenHelper.COLUMN_QUESTION,
				QuestionTagsOpenHelper.COLUMN_TAG };
		if (projection != null) {
			HashSet<String> requestedColumns = new HashSet<String>(
					Arrays.asList(projection));

			HashSet<String> availableColumns = new HashSet<String>(
					Arrays.asList(available));
			// check if all columns which are requested are available
			if (!availableColumns.containsAll(requestedColumns)) {
				throw new IllegalArgumentException(
						"Unknown columns in projection");
			}
		}
	}

}
