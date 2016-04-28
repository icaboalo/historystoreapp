package com.icaboalo.historystoreapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.icaboalo.historystoreapp.sqlite.constant.DbConstants;

/**
 * Created by icaboalo on 10/7/2015.
 */
public class HistoryOpenHelper extends SQLiteOpenHelper{

    public HistoryOpenHelper(Context context) {
        super(context, DbConstants.DATABASE_NAME, null, DbConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbConstants.CREATE_TABLE_CAPTURE_DATA);
    }

    public void insertProduct(String productName, String productCategory, String productQuantity){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        database.insert(DbConstants.TABLE_CAPTURE_DATA, null, values);
        database.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DbConstants.TABLE_CAPTURE_DATA);
        onCreate(db);
    }
}
