package com.example.sqlite_full.models;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Helper extends SQLiteOpenHelper {
    public Helper(@Nullable Context context) {
        // Nom de la Bd, null, version
        super(context, "productManager", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Here we create tables
        db.execSQL("CREATE TABLE product(_id INTEGER PRIMARY KEY, nom TEXT, prix REAL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS product");
        onCreate(db);
    }

    public void insertProduct(Products products){

        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("nom",products.getNom());
        cv.put("prix",products.getPrix());

        db.insert("product",null,cv);
        db.close();
    }

    public void updateproduct(Products products){

        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("nom",products.getNom());
        cv.put("prix",products.getPrix());

        db.update("product",cv,"_id=?",new String[]{String.valueOf(products.id)});
        db.close();
    }

    public void deleteproduct(int id){

        SQLiteDatabase db= this.getWritableDatabase();

        db.delete("product","_id=?",new String[]{String.valueOf(id)});
        db.close();
    }

    public List<Products> getAllProducts(){

        final List<Products> products = new ArrayList<>();

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM product",null);

        try {

            // If moveToFirst() returns false then cursor is empty
            if (!cursor.moveToFirst()) {
                return new ArrayList<>();
            }

            do {

                // Read the values of a row in the table using the indexes acquired above
                final int id = cursor.getInt(0); // position of the column
                final String name = cursor.getString(1);
                final double price = cursor.getDouble(2);

                products.add(new Products(id, name, price));

            } while (cursor.moveToNext());

            return products;

        } finally {
            // Don't forget to close the Cursor once you are done to avoid memory leaks.
            // Using a try/finally like in this example is usually the best way to handle this
            cursor.close();

            // close the database
            db.close();
        }
    }


    public Products getOneProduct(int id){
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.query("product",new String[]{"_id","nom","prix"},
                "_id=?",new String[]{String.valueOf(id)},null,null,null);

        cursor.moveToFirst();
        Products product=new Products(cursor.getInt(0),cursor.getString(1),cursor.getDouble(2));

        return product;
    }
}
