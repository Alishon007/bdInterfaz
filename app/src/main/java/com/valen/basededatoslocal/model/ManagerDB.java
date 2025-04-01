package com.valen.basededatoslocal.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ManagerDB {

    DbHelper dbHelper;

    SQLiteDatabase db;

    public ManagerDB(Context context){
        dbHelper = new DbHelper(context);
    }
    // metodo para abrir la base de datos en modo escritura
    public void openDbWr(){
        db = dbHelper.getWritableDatabase();
    }
    //metodo para abrir la base de datos en modo lectura
    public void openRbRd(){
        db = dbHelper.getReadableDatabase();
    }

    public long insertCiudad(){

        //1. abrir la base de datos en modo escritura
        openDbWr();
        //2. crear un contenedor de valores para almacenar columnas y datos a insertar
        ContentValues valores = new ContentValues();
        valores.put("codigo",1);
        valores.put("Nombre","Popayan");
        long resul =  db.insert("Ciudad", null, valores);
        return resul;
    }
}
