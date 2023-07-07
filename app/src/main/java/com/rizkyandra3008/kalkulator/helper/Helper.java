package com.rizkyandra3008.kalkulator.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Helper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "pemantauan";

    public Helper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE suhu (id INTEGER PRIMARY KEY autoincrement, suhu TEXT NOT NULL, date TEXT NOT NULL, time TEXT NOT NULL)";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS suhu");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<HashMap<String, String>> getAll() {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        String QUERY = "SELECT * FROM suhu";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("suhu", cursor.getString(1));
                map.put("date", cursor.getString(2));
                map.put("time", cursor.getString(3));
                list.add(map);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void insert(String suhu, String date, String time) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "INSERT INTO suhu (suhu, date, time) VALUES ('" + suhu + "', '"+
        date +"', '" + time + "')";
        database.execSQL(QUERY);
    }

    public void delete(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "DELETE FROM suhu WHERE id = " +id;
        database.execSQL(QUERY);
    }


}
