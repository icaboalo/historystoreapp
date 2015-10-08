package com.icaboalo.historystoreapp.sqlite.constant;

/**
 * Created by icaboalo on 10/7/2015.
 */
public class DbConstants {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "history.db";

    public static final String TABLE_CAPTURE_DATA = "udacity";

    //    users columns
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PRODUCT_NAME = "username";
    public static final String COLUMN_PRODUCT_CATEGORY = "password";
    public static final String COLUMN_PRODUCT_QUANTITY= "first_name";



    //    create udacity table
    public static final String CREATE_TABLE_CAPTURE_DATA =
            "CREATE TABLE " + TABLE_CAPTURE_DATA + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PRODUCT_NAME + " TEXT, " +
                    COLUMN_PRODUCT_CATEGORY + " TEXT, " +
                    COLUMN_PRODUCT_QUANTITY + " TEXT);";}
