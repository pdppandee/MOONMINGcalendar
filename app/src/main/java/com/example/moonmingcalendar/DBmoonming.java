package com.example.moonmingcalendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBmoonming extends SQLiteOpenHelper {

    private static final String TAG = "DBmoonming";

    public static final String TABLE_NAME = "MOONMING_table";
    public static final String COL_ID = "ID";
    public static final String COL_DAY = "day";
    public static final String COL_MONTH = "month";
    public static final String COL_YEAR = "year";
    public static final String COL_TIME = "time";
    public static final String COL_NAME = "name";
    public static final String COL_DETAILS = "details";
    public static final String COL_NOTIFICATION = "notification";
    public static final String COL_TYPE = "type";


    public DBmoonming(Context context) { super(context, TABLE_NAME, null, 1); }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_LIST_TABLE = "CREATE TABLE "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_DAY + " TEXT," + COL_MONTH + " TEXT," + COL_YEAR + " TEXT,"
                + COL_TIME + "TEXT," + COL_NAME + "TEXT," + COL_DETAILS + "TEXT," + COL_NOTIFICATION + "TEXT," + COL_TYPE + "TEXT);";

        db.execSQL(CREATE_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int j) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addEvent(String day,String month,String year,String time,String name,String details,String notification,String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_DAY, day);
        values.put(COL_MONTH, month);
        values.put(COL_YEAR, year);
        values.put(COL_TIME, time);
        values.put(COL_NAME, name);
        values.put(COL_DETAILS, details);
        values.put(COL_NOTIFICATION, notification);
        values.put(COL_TYPE, type);
        Log.d(TAG, "addData: Adding " +day+ ", "+month+ ", "+year + ", "+time + ", "+name
                + ", "+details+ ", "+notification+" and "+type+ " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, values);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getEventCalendar(String day,String month){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL_ID + "," + COL_NAME + " FROM " + TABLE_NAME
                + " WHERE " + COL_DAY + " = '" + day + "'"+ " AND " + COL_MONTH + " = '" + month + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }




}
