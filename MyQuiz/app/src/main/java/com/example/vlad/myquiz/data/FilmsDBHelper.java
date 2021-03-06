package com.example.vlad.myquiz.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilmsDBHelper extends SQLiteOpenHelper {

    String DB_PATH = null;
    private static String DB_NAME = "Filmsdb";
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    //public static final String LOG_TAG = FilmsDBHelper.class.getSimpleName();
    /**
     * Имя файла базы данных


    private static final String DATABASE_NAME = "Films.db";

     * Версия базы данных. При изменении схемы увеличить на единицу
     */
   // private static final int DATABASE_VERSION = 1;

    public FilmsDBHelper(Context context) {
       // super(context, DB_NAME,null, DATABASE_VERSION);
        super(context, DB_NAME,null, 13);
        this.myContext = context;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
        Log.e("Path 1", DB_PATH);
    }

    public void createDataBase() throws IOException{
        boolean dbExist = checkDataBase();
        if (dbExist){

            this.getReadableDatabase();
            try {
                copyDataBase();
            }
            catch (IOException e){
                throw new Error("Error copying database");
            }//РАБОТАЕТ КОПИРОВАНИЕ ЗАНОГО

        }
        else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            }
            catch (IOException e){
                throw new Error("Error copying database");
            }
        }
    }
    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try {
            String MyPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(MyPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e){
        }
        if (checkDB != null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException{
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() throws SQLException{
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close(){
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
       /* if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        //db.execSQL("DROP TABLE IF EXISTS + TABLE_NAME);
        try {
            updateDataBase(); // Никак не работает
        } catch (IOException ioe){
            throw new Error("Unable to update database");
        }
       /* this.getReadableDatabase();
        try {
            copyDataBase();
        }
        catch (IOException e){
            throw new Error("Error copying database");
        }*/
    }

    public void updateDataBase() throws IOException{
       /* boolean dbExist = checkDataBase();
        if (dbExist){

            this.getReadableDatabase();
            try {
                copyDataBase();
            }
            catch (IOException e){
                throw new Error("Error copying database");
            }

        }
        else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            }
            catch (IOException e){
                throw new Error("Error copying database");
            }
        }*/
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
        return myDataBase.query("EZ_FILMS",null, null,null,null,null,null);
    }
}
