package com.valen.basededatoslocal.controller;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.valen.basededatoslocal.R;
import com.valen.basededatoslocal.model.DbHelper;
import com.valen.basededatoslocal.model.ManagerDB;

public class MainActivity extends AppCompatActivity {

    ManagerDB managerDB;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         managerDB = new ManagerDB(MainActivity.this);

         long resul= managerDB.insertCiudad();
         if(resul>0){
             Toast.makeText(this, "Datos insertados", Toast.LENGTH_SHORT).show();
         }
         else {
             Toast.makeText(this, "Error al insertar" + resul, Toast.LENGTH_SHORT).show();
         }


    }
}