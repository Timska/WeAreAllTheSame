package weareallthesame.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ItemTagsOpenHelper extends SQLiteOpenHelper {

	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "itemName";
	public static final String COLUMN_TAG = "tag";

	public static final String TABLE_NAME = "ItemTags";

	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME_EXPRESSION = "ItemTagsDatabase.db";

	private static final String DATABASE_CREATE = String
			.format("create table %s (%s integer primary key autoincrement, %s text not null, %s text not null);",
					TABLE_NAME, COLUMN_ID, COLUMN_NAME, COLUMN_TAG);

	public ItemTagsOpenHelper(Context context) {
		super(context, DATABASE_NAME_EXPRESSION, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLE_NAME));
		onCreate(db);
	}
}
