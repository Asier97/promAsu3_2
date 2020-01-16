package com.example.promasu3_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL("CREATE TABLE Usuarios (idUsuario INTEGER PRIMARY KEY, nombre TEXT, email TEXT)");

        db.execSQL("DROP TABLE IF EXISTS Libros");
        db.execSQL("CREATE TABLE Libros (isbn INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, autor TEXT, genero TEXT, descripcion TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL("CREATE TABLE Usuarios (idUsuario INTEGER PRIMARY KEY, nombre TEXT, email TEXT)");

        db.execSQL("DROP TABLE IF EXISTS Libros");
        db.execSQL("CREATE TABLE Libros (isbn INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, autor TEXT, genero TEXT, descripcion TEXT)");
    }
}

