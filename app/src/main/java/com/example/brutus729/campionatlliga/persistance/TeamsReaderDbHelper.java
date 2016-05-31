package com.example.brutus729.campionatlliga.persistance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class TeamsReaderDbHelper  extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TeamsFragment.db";
    public static final int DATABASE_VERSION = 3;

    public TeamsReaderDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear la tabla Quotes
        db.execSQL(TeamsDataSource.CREATE_TEAMS_SCRIPT);
        //Insertar registros iniciales
        db.execSQL(TeamsDataSource.INSERT_TEAMS_SCRIPT);

        /*  Nota: Usamos execSQL() ya que las sentencias son
            para uso interno y no están relacionadas con entradas
            proporcionadas por los usuarios
        */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*  Añade los cambios que se realizarán en el esquema
            en tu proxima versión
         */
        /**DROP THE TABLES!*/
        db.execSQL(TeamsDataSource.DELETE_TEAMS_SCRIPT);
        onCreate(db);
    }

}