package com.projects.nikita.pocketgym.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;


public class CategoriesProvider extends ContentProvider {
    //хелпер с БД
    private MainDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    final int DB_VERSION = 3;

    //имя БД
    private static final String DB_NAME = "myDB";
//имя таблицы
    private static final String DB_TABLE = "Table0";

    //поля
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "category";
    public static final String COLUMN_GROUP = "dayGroup";
    //скрипт создания таблицы 0
    private static final String DB_CREATE = "CREATE TABLE " +
            DB_TABLE + " (" +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_NAME + " TEXT, " +COLUMN_GROUP + " integer);";

    //URI authority
    private static final String AUTHORITY = "com.projects.nikita.pocketgym.provider.Categories";

    //uri path
    private static final String CAT_PATH = "path";

    // Общий Uri
    public static final Uri CAT_CONTENT_URI = Uri.parse("content://"
            + AUTHORITY + "/" + CAT_PATH);

    // Типы данных
    // набор строк
    static final String CAT_CONTENT_TYPE = "vnd.android.cursor.dir/vnd."
            + AUTHORITY + "." + CAT_PATH;

    // одна строка
    static final String CAT_CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."
            + AUTHORITY + "." + CAT_PATH;

    //// UriMatcher
    // общий Uri
    private static final int URI_CATS = 1;

    // Uri с указанным ID
    private static final int URI_CATS_ID = 2;

    private static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, CAT_PATH, URI_CATS);
        uriMatcher.addURI(AUTHORITY, CAT_PATH + "/#", URI_CATS_ID);
    }

    @Override
    public boolean onCreate() {
        Log.d("mylog", "onCreate()");

        dbHelper = new MainDatabaseHelper(
            getContext(),        // the application context
            DB_NAME,              // the name of the database)
            null,                // uses the default SQLite cursor
            DB_VERSION           // the version number
    );

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.d("mylog", "query: " + uri.toString());
        switch (uriMatcher.match(uri)){
            case URI_CATS:
                Log.d("mylog", "URI_CATS");
                break;
            case URI_CATS_ID:
                String id = uri.getLastPathSegment();
                Log.d("mylog", "URI_CATS_COLUMN " + id);
                if(TextUtils.isEmpty(selection)){ selection = COLUMN_ID + " = " + id; }
                else { selection = selection +" AND "+ COLUMN_ID + " = " + id;}
                break;
            default:
                throw new IllegalArgumentException("Wrong uri" + uri);
        }
        //получаем бд
        db = dbHelper.getWritableDatabase();
        //получаем курсов
        Cursor c = db.query(DB_TABLE, projection, selection, selectionArgs, null, null, sortOrder);
        // просим ContentResolver уведомлять этот курсор
        // об изменениях данных в CAT_CONTENT_URI
        c.setNotificationUri(getContext().getContentResolver(), CAT_CONTENT_URI);
        Log.d("mylog", "URI_CATS returned OK! you have " + c.getCount());
        return c;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case URI_CATS:
                return CAT_CONTENT_TYPE;
            case URI_CATS_ID:
                return CAT_CONTENT_ITEM_TYPE;
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.d("mylog", "insert " + uri.toString());
        if(uriMatcher.match(uri) != URI_CATS) {
            Log.d("mylog", "WRONG URI"+uri.toString());
            throw new IllegalArgumentException("Wrong uri " + uri.toString());
        }
        db = dbHelper.getWritableDatabase();
        long rowID = db.insert(DB_TABLE, null, values);
        Uri resultUri = ContentUris.withAppendedId(CAT_CONTENT_URI, rowID);
        // уведомляем ContentResolver, что данные по адресу resultUri изменились
        getContext().getContentResolver().notifyChange(resultUri, null);
        return resultUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.d("mylog", "delete " + uri.toString());
        switch(uriMatcher.match(uri)) {
            case URI_CATS:
                Log.d("mylog", "URI_CATS");
                break;
            case URI_CATS_ID:
                Log.d("mylog", "URI_CATS_ID");
                String id = uri.getLastPathSegment();
                if(TextUtils.isEmpty(selection)){ selection = COLUMN_ID + " = " + id; }
                else { selection = selection +" AND "+ COLUMN_ID + " = " + id;}
                break;
            default:
                throw new IllegalArgumentException("Wrong uri " + uri.toString());
        }
        db = dbHelper.getWritableDatabase();
        int count = db.delete(DB_TABLE, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Log.d("mylog", "update " + uri.toString());
        switch(uriMatcher.match(uri)) {
            case URI_CATS:
                Log.d("mylog", "URI_CATS");
                break;
            case URI_CATS_ID:
                Log.d("mylog", "URI_CATS_ID");
                String id = uri.getLastPathSegment();
                if(TextUtils.isEmpty(selection)){ selection = COLUMN_ID + " = " + id; }
                else { selection = selection +" AND "+ COLUMN_ID + " = " + id;}
                break;
            default:
                throw new IllegalArgumentException("Wrong uri " + uri.toString());
        }
        db = dbHelper.getWritableDatabase();
        int count = db.update(DB_TABLE, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    protected final static class MainDatabaseHelper extends SQLiteOpenHelper{

        public MainDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion == 2 && newVersion == 3){
                db.beginTransaction();
                try {
                    db.execSQL("drop table if exists " + DB_TABLE);
                    db.execSQL(DB_CREATE);
                    db.setTransactionSuccessful();
                }finally { db.endTransaction(); }
            }
        }
    }
}
