package com.example.moonmingcalendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbPayHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBPayHelper";
    private static final String TABLE_NAME = "list_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "day";
    private static final String COL3 = "name";
    private static final String COL4 = "detail";
    private static final String COLNoti = "noti";
    private static final String COL6 = "time";

    public DbPayHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " + COL3 + " TEXT, "  + COL4 + " TEXT, "  + COLNoti + " BOOLEAN, "  + COL6 + " TEXT);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String day,String name,String detail,Boolean noti,String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL2, day);
        values.put(COL3, name);
        values.put(COL4, detail);
        values.put(COLNoti, noti);
        values.put(COL6, time);
        Log.d(TAG, "addData: Adding " +day+ ", "+name+ ", "+detail
                + ", "+noti+" and "+time+ " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, values);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getEventListName(String day){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL3 + " FROM " +
                TABLE_NAME + " WHERE " + COL2+ " = '" + day + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getEventListDetail(String day){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL4 + " FROM " +
                TABLE_NAME + " WHERE " + COL2+ " = '" + day + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getDate(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL2 +  " FROM " +
                TABLE_NAME + " WHERE " + COL1+ " = '" + id + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getTime(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL6 +  " FROM " +
                TABLE_NAME + " WHERE " + COL1+ " = '" + id + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }



    public Cursor getEventID(String day,String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME + " WHERE " +
                COL2 + " = '" + day +  "'" + " AND " + COL3 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL3 + "," + COL4 + "," + COLNoti + "," + COL6 +  "," + COL2 + " FROM " +
                TABLE_NAME + " WHERE " + COL1+ " = '" + id + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getEventNoti(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLNoti + " FROM " +
                TABLE_NAME + " WHERE " + COL1 + " = '" + id + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void updateDate(String newDate, String id, String oldDate){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newDate + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldDate + "'";
        Log.d(TAG, "updateDate: query: " + query);
        Log.d(TAG, "updateDate: Setting date to " + newDate);
        db.execSQL(query);
    }

    public void updateName(String newName, String id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL3 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL3 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    public void updateDetail(String newDetail, String id, String oldDetail){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL4 +
                " = '" + newDetail + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL4 + " = '" + oldDetail + "'";
        Log.d(TAG, "updateDetail: query: " + query);
        Log.d(TAG, "updateDetail: Setting detail to " + newDetail);
        db.execSQL(query);
    }

    public void updateTime(String newTime, String id, String oldTime){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL6 +
                " = '" + newTime + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL6 + " = '" + oldTime + "'";
        Log.d(TAG, "updateTime: query: " + query);
        Log.d(TAG, "updateTime: Setting time to " + newTime);
        db.execSQL(query);
    }

    public void updateNoti(Boolean newNoti, String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COLNoti +
                " = '" + newNoti + "' WHERE " + COL1 + " = '" + id + "'" ;
        Log.d(TAG, "updateNoti: query: " + query);
        Log.d(TAG, "updateNoti: Setting noti to " + newNoti);
        db.execSQL(query);
    }

    public void deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" ;
        Log.d(TAG, "deleteEvent: query: " + query);
        Log.d(TAG, "deleteID: id: " + id);
        db.execSQL(query);
    }


}