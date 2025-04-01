package com.valen.basededatoslocal.controller;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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

    EditText edtCodCiudad, edtCiudad, edtCodDepa, edtDepartamento;
    Button btnEnviar, btnActualizar, btnEliminar;

    ManagerDB managerDB;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCodCiudad = findViewById(R.id.edtCodCiudad);
        edtCiudad = findViewById(R.id.edtCiudad);
        edtCodDepa = findViewById(R.id.edtCodDepa);
        edtDepartamento = findViewById(R.id.edtDepartamento);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnEliminar = findViewById(R.id.btnEliminar);

         managerDB = new ManagerDB(MainActivity.this);


        btnEnviar.setOnClickListener(v -> {
            // Obtener los valores ingresados
            int codigoCiudad = Integer.parseInt(edtCodCiudad.getText().toString());
            String nombreCiudad = edtCiudad.getText().toString();
            int codigoDepa = Integer.parseInt(edtCodDepa.getText().toString());
            String nombreDepa = edtDepartamento.getText().toString();


            long resul = managerDB.insertCiudad(codigoCiudad,nombreCiudad);
            if (resul > 0) {
                Toast.makeText(this, "Datos insertados", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al insertar" + resul, Toast.LENGTH_SHORT).show();
            }
            long resultDepa = managerDB.insertDepartamento(codigoDepa, nombreDepa);

            if (resultDepa > 0) {
                Toast.makeText(this, "Datos insertados" + resultDepa, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al insertar" + resultDepa, Toast.LENGTH_SHORT).show();
            }
        });



        btnActualizar.setOnClickListener(v -> {
            int codigoCiudad = Integer.parseInt(edtCodCiudad.getText().toString());
            String nuevoNombreCiudad = edtCiudad.getText().toString();
            int codigoDepa = Integer.parseInt(edtCodDepa.getText().toString());
            String nuevoNombreDepa = edtDepartamento.getText().toString();

            int filasActualizadasCiudad = managerDB.updateCiudad(codigoCiudad, nuevoNombreCiudad);
            int filasActualizadasDepa = managerDB.updateDepartamento(codigoDepa, nuevoNombreDepa);

            if (filasActualizadasCiudad > 0 || filasActualizadasDepa > 0) {
                Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al actualizar", Toast.LENGTH_SHORT).show();
            }
        });

        // Botón para Eliminar Datos
        btnEliminar.setOnClickListener(v -> {
            int codigoCiudad = Integer.parseInt(edtCodCiudad.getText().toString());
            int codigoDepa = Integer.parseInt(edtCodDepa.getText().toString());

            int filasEliminadasCiudad = managerDB.deleteCiudad(codigoCiudad);
            int filasEliminadasDepa = managerDB.deleteDepartamento(codigoDepa);

            if (filasEliminadasCiudad > 0 || filasEliminadasDepa > 0) {
                Toast.makeText(this, "Datos eliminados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al eliminar", Toast.LENGTH_SHORT).show();
            }
        });


    }
}