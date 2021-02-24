package com.example.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.foodorderapp.Models.OrderModel;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    final static int DB_VERSION = 5;
    final static String DB_NAME = "mydatabase.db";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table orderFood " +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "description text," +
                        "price int," +
                        "quantity int," +
                        "image int," +
                        "phone text," +
                        "foodname text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP table if exists orderFood");
        onCreate(db);

    }

    public boolean insertOrder(String name, String phone, int quantity, int price, int image, String description, String foodName) {

        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("description", description);
        values.put("price", price);
        values.put("quantity", quantity);
        values.put("image", image);
        values.put("phone", phone);
        values.put("foodname", foodName);

        long check = database.insert("orderFood", null, values);

        if(check <= 0) {

            return false;

        } else {

            return true;

        }

    }

    public ArrayList<OrderModel> getOrder() {

        ArrayList<OrderModel> models = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select id, foodname, price, image from orderFood", null);

        if(cursor.moveToFirst()) {

            while (cursor.moveToNext()) {

                OrderModel model = new OrderModel(
                        cursor.getInt(3),
                        cursor.getString(1),
                        cursor.getInt(2) + "",
                        cursor.getInt(0) + "");

                models.add(model);

            }

        }

        cursor.close();
        database.close();

        return models;

    }

    public Cursor getOrderById(int id) {

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from orderFood where id =" + id, null);

        if(cursor != null) {

            cursor.moveToFirst();

        }

        return cursor;

    }

    public boolean updateOrder(String name, String phone, int quantity, int price, int image, String description, String foodName, int id) {

        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();

        /* id = 0
           name = 1
           description = 2
           price = 3
           image = 5
           phone = 6
           quantity = 4
           foodname = 7
         */

        values.put("name", name);
        values.put("description", description);
        values.put("price", price);
        values.put("quantity", quantity);
        values.put("image", image);
        values.put("phone", phone);
        values.put("foodname", foodName);

        long check = database.update("orderFood", values, "id=" + id, null);

        if(check <= 0) {

            return false;

        } else {

            return true;

        }

    }

    public boolean deleteOrder(String id) {

        SQLiteDatabase database = getWritableDatabase();
        long check = database.delete("orderFood", "id=" + id, null);

        if(check <= 0) {

            return false;

        } else {

            return true;

        }

    }

}
