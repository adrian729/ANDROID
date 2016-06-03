package com.example.brutus729.campionatlliga.persistance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;


public class PlayersDataSource {

    //Metainformación de la base de datos
    public static final String PLAYERS_TABLE_NAME = "Players";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";
    public static final String BOOL_TYPE = "bit";

    //Campos de la tabla Players
    public static class ColumnPlayers{
        public static final String ID_PLAYERS = BaseColumns._ID;
        public static final String NAME_PLAYERS = "name";
        public static final String SHORT_NAME_PLAYERS = "shortName";
        public static final String TEAM_PLAYERS = "team";
        public static final String TITULAR_PLAYERS = "titular";
    }

    //Script para eliminar tabla Players
    public static final String DELETE_PLAYERS_SCRIPT = "drop table " +PLAYERS_TABLE_NAME;

    //Script de Creación de la tabla Players
    public static final String CREATE_PLAYERS_SCRIPT =
            "create table "+PLAYERS_TABLE_NAME+"(" +
                    ColumnPlayers.ID_PLAYERS+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnPlayers.NAME_PLAYERS+" "+STRING_TYPE+" not null," +
                    ColumnPlayers.SHORT_NAME_PLAYERS+" "+STRING_TYPE+" not null," +
                    ColumnPlayers.TEAM_PLAYERS+" "+STRING_TYPE+" not null," +
                    ColumnPlayers.TITULAR_PLAYERS+" "+BOOL_TYPE+" not null)";

    //Scripts de inserción por defecto.
    public static final String INSERT_PLAYERS_SCRIPT =
            "insert into " + PLAYERS_TABLE_NAME
                    + " values" + introduirDataIni();
    //Automatizar valores por defecto.
    private static String introduirDataIni() {
        String stringData = "";
        for (int i = 0; i < 10; ++i) {

            for(int j = 0; j < 5; j++){
                stringData = stringData + "(null,\"Titular" + j + "\",\"T" + j +
                        "\",\"Equip" + i + "\"," + 1 + "),";
            }
            for(int j = 0; j < 7; j++){
                stringData = stringData + "(null,\"Suplent" + j + "\",\"S" + j +
                        "\",\"Equip" + i + "\"," + 0 + ")";
                if (!(i == 9 && j == 6)) stringData += ",";
            }
        }
        return stringData;
    }

    //Variables para manipulación de datos
    private SQLiteDatabase database;

    public PlayersDataSource(Context context) {
        //Creando una instancia hacia la base de datos
        database = new ReaderDbHelper(context).getWritableDatabase();
    }

    public void savePlayersRow(String name,String shortName,String team, boolean titular){
        //Nuestro contenedor de valores
        ContentValues values = new ContentValues();

        //Seteando name y shortName
        values.put(ColumnPlayers.NAME_PLAYERS,name);
        values.put(ColumnPlayers.SHORT_NAME_PLAYERS,shortName);
        values.put(ColumnPlayers.TEAM_PLAYERS,team);
        if(titular)
            values.put(ColumnPlayers.TITULAR_PLAYERS,1);
        else
            values.put(ColumnPlayers.TITULAR_PLAYERS,0);

        //Insertando en la base de datos
        database.insert(PLAYERS_TABLE_NAME,null,values);
    }

    public Cursor getAllPlayers(){
        /*
        String query = "select * from " + PLAYERS_TABLE_NAME + " WHERE _id=?";
        return database.rawQuery(query, new String[]{"2"});
        */
        //Seleccionamos todas las filas de la tabla Players
        return database.rawQuery("select * from " + PLAYERS_TABLE_NAME, null);
    }


}
