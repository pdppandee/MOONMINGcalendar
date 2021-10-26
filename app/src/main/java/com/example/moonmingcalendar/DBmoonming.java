package com.example.moonmingcalendar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBmoonming extends SQLiteOpenHelper {

    private static final String TAG = "DBmoonming";

    public static final String TABLE_NAME = "MOONMING_table";
    public static final String COL_ID = "ID";
    public static final String COL_DAY = "day";
    public static final String COL_MONTH = "month";
    public static final String COL_YEAR = "year";
    public static final String COL_TIME = "time";
    public static final String COL_EVENTNAME = "eventname";
    public static final String COL_EVENTDETAILS = "eventdetails";
    public static final String COL_EVENTNOTI = "eventnoti";


    public DBmoonming(Context context) { super(context, TABLE_NAME, null, 1); }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_LIST_TABLE = "CREATE TABLE "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_DAY + " TEXT," + COL_MONTH + " TEXT," + COL_YEAR + " TEXT,"
                + COL_TIME + "TEXT," + COL_EVENTNAME + "TEXT," + COL_EVENTDETAILS + "TEXT," + COL_EVENTNOTI + "TEXT);";

        db.execSQL(CREATE_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int j) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
