package com.valen.basededatoslocal.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ManagerDB {

    private final DbHelper dbHelper;
    private SQLiteDatabase db;

    public ManagerDB(Context context) {
        dbHelper = new DbHelper(context);
    }

    // Método para abrir la base de datos en modo escritura
    public void openDbWr() {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
    }

    // Método para cerrar la base de datos (opcional)
    public void closeDb() {
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    // Método para insertar una ciudad
    public long insertCiudad(int codigo, String nombre) {
        openDbWr(); // Asegurar que la base de datos esté abierta

        ContentValues valores = new ContentValues();
        valores.put("codigo", codigo);
        valores.put("Nombre", nombre);

        long resultado = db.insert("Ciudad", null, valores);
        return resultado;
    }

    // Método para insertar un departamento
    public long insertDepartamento(int codigo, String nombre) {
        openDbWr(); // Asegurar que la base de datos esté abierta

        ContentValues valores = new ContentValues();
        valores.put("codigo", codigo);
        valores.put("nombre", nombre);

        long resultado = db.insert("Departamento", null, valores);
        return resultado;
    }



    // Actualizar Ciudad
    public int updateCiudad(int codigo, String nuevoNombre) {
        openDbWr();
        ContentValues valores = new ContentValues();
        valores.put("Nombre", nuevoNombre);

        int filasAfectadas = db.update("Ciudad", valores, "codigo=?", new String[]{String.valueOf(codigo)});
        Log.d("ManagerDB", "Actualizando ciudad: " + codigo + ", resultado: " + filasAfectadas);
        return filasAfectadas;
    }

    // Actualizar Departamento
    public int updateDepartamento(int codigo, String nuevoNombre) {
        openDbWr();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nuevoNombre);

        int filasAfectadas = db.update("Departamento", valores, "codigo=?", new String[]{String.valueOf(codigo)});
        Log.d("ManagerDB", "Actualizando departamento: " + codigo + ", resultado: " + filasAfectadas);
        return filasAfectadas;
    }

    // Eliminar Ciudad
    public int deleteCiudad(int codigo) {
        openDbWr();
        int filasEliminadas = db.delete("Ciudad", "codigo=?", new String[]{String.valueOf(codigo)});
        Log.d("ManagerDB", "Eliminando ciudad: " + codigo + ", resultado: " + filasEliminadas);
        return filasEliminadas;
    }

    // Eliminar Departamento
    public int deleteDepartamento(int codigo) {
        openDbWr();
        int filasEliminadas = db.delete("Departamento", "codigo=?", new String[]{String.valueOf(codigo)});
        Log.d("ManagerDB", "Eliminando departamento: " + codigo + ", resultado: " + filasEliminadas);
        return filasEliminadas;
    }
}
