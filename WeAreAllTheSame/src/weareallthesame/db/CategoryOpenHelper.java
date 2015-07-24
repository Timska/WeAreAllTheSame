package weareallthesame.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CategoryOpenHelper extends SQLiteOpenHelper {

	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_TYPE = "type";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_RESOURCE = "resource";

	public static final String TABLE_NAME = "Categories";

	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME_EXPRESSION = "CategoryDatabase.db";

	private static final String DATABASE_CREATE = String
			.format("create table %s (%s integer primary key autoincrement, %s text not null, %s text not null, %s text not null);",
					COLUMN_TYPE, COLUMN_NAME, COLUMN_RESOURCE);

	public CategoryOpenHelper(Context context) {
		super(context, DATABASE_NAME_EXPRESSION, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLE_NAME));
		onCreate(db);
	}

}
