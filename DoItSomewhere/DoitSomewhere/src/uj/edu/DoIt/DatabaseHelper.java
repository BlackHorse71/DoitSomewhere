package uj.edu.DoIt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.SensorManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.SensorManager;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME="loc";
	public static final String NAME="Name";
	public static final String VALUE="Location";
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE Locations (_id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Location TEXT);");
		
		ContentValues cv=new ContentValues();
		
		cv.put(NAME, "Rynek");
		cv.put(VALUE, "50,19");
		db.insert("Locations", NAME, cv);
		
		cv.put(NAME, "Sukiennice");
		cv.put(VALUE, "50,19");
		db.insert("Locations", NAME, cv);
		
		cv.put(NAME, "PKP");
		cv.put(VALUE, "50,19");
		db.insert("Locations", NAME, cv);
		
		cv.put(NAME, "Pomnik Adama");
		cv.put(VALUE, "50,19");
		db.insert("Locations", NAME, cv);

		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		android.util.Log.w("Locations", "Upgrading database, which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS Locations");
		onCreate(db);
	}
}
