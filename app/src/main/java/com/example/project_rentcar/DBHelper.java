package com.example.project_rentcar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Project.db";

    public DBHelper(Context context) {
        super(context, "Project.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT, phone TEXT)");
        MyDB.execSQL("create Table cars(cid TEXT primary key, cBrand TEXT, cType TEXT, cSeat TEXT, cGear TEXT,  cEngine TEXT, cOwner TEXT, cStatus TEXT, cRate TEXT, cLocation TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists cars");
    }

    public Boolean insertData(String username, String password, String phone) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("phone", phone);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public String owner(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if (cursor.getCount()>0)
            return username;
        else
            return "false";
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean insertCar(String id, String cBrand, String cType, String cSeat, String cGear, String cEngine, String cOwner, String cStatus, String cRate, String cLocation) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cid", id);
        contentValues.put("cBrand", cBrand);
        contentValues.put("cType", cType);
        contentValues.put("cSeat", cSeat);
        contentValues.put("cGear", cGear);
        contentValues.put("cEngine", cEngine);
        contentValues.put("cOwner", cOwner);
        contentValues.put("cStatus", cStatus);
        contentValues.put("cRate", cRate);
        contentValues.put("cLocation", cLocation);
        long result = MyDB.insert("cars", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

//    public Boolean updateCar(String id) {
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("Status", "renting");
//        Cursor cursor = MyDB.rawQuery("Select * from cars where id = ?", new String[]{id});
//        if (cursor.getCount() > 0) {
//            long result = MyDB.update("cars", contentValues, "id=?", new String[]{id});
//            if (result == -1) return false;
//            else
//                return true;
//        } else {
//            return false;
//        }
//    }

//    public Boolean deleteCar(String id) {
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        Cursor cursor = MyDB.rawQuery("Select * from cars where id = ?", new String[]{id});
//        if (cursor.getCount() > 0) {
//            long result = MyDB.delete("cars", "id=?", new String[]{id});
//            if (result == -1) return false;
//            else
//                return true;
//        } else {
//            return false;
//        }
//    }

    public Cursor viewCars() {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from cars", null);
        return cursor;
    }

//    public Cursor getListContents(){
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        Cursor data = MyDB.rawQuery("Select * from cars", null);
//        return data;
//    }


    public boolean checkID(String id){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from cars where cid = ?", new String[] {id});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
