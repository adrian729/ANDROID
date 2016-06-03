package com.example.brutus729.campionatlliga.persistance;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class MatchesDataSource {


    //Metainformación de la base de datos
    public static final String MATCHES_TABLE_NAME = "Matches";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla Matches
    public static class ColumnMatches{
        public static final String ID_MATCHES = BaseColumns._ID;
        public static final String WEEK_MATCHES = "week";
        public static final String LOCAL_TEAM_MATCHES = "lTeam";
        public static final String VISITOR_TEAM_MATCHES = "vTeam";
    }

    //Script para eliminar tabla Matches
    public static final String DELETE_MATCHES_SCRIPT = "drop table " +MATCHES_TABLE_NAME;

    //Script de Creación de la tabla Matches
    public static final String CREATE_MATCHES_SCRIPT =
            "create table "+MATCHES_TABLE_NAME+"(" +
                    ColumnMatches.ID_MATCHES+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnMatches.WEEK_MATCHES+" "+INT_TYPE+" not null," +
                    ColumnMatches.LOCAL_TEAM_MATCHES+" "+STRING_TYPE+" not null," +
                    ColumnMatches.VISITOR_TEAM_MATCHES+" "+STRING_TYPE+" not null)";

    //Scripts de inserción por defecto.
    public static final String INSERT_MATCHES_SCRIPT =
            "insert into " + MATCHES_TABLE_NAME
                    + " values" + introduirDataIni();
    //Automatizar valores por defecto.
    private static String introduirDataIni() {
        String stringData = "";
        for (int i = 0; i < 5; ++i) {
            stringData = stringData + "(null," + 1 + ",\"Equip" + i +
                        "\",\"Equip" + (9-i) + "\"),";
            stringData = stringData + "(null," + 2 + ",\"Equip" + (9-i) +
                    "\",\"Equip" + i + "\")";
            if(i < 4) stringData += ",";
        }
        return stringData;
    }

    //Variables para manipulación de datos
    private SQLiteDatabase database;

    public MatchesDataSource(Context context) {
        //Creando una instancia hacia la base de datos
        database = new ReaderDbHelper(context).getWritableDatabase();
    }

    public void saveMatchesRow(String local,String visitor,int week){
        //Nuestro contenedor de valores
        ContentValues values = new ContentValues();

        //Seteando name y shortName
        values.put(ColumnMatches.WEEK_MATCHES,week);
        values.put(ColumnMatches.LOCAL_TEAM_MATCHES,local);
        values.put(ColumnMatches.VISITOR_TEAM_MATCHES,visitor);

        //Insertando en la base de datos
        database.insert(MATCHES_TABLE_NAME,null,values);
    }

    public Cursor getAllMatches(){
        /*
        String query = "select * from " + MATCHES_TABLE_NAME + " WHERE _id=?";
        return database.rawQuery(query, new String[]{"2"});
        */
        //Seleccionamos todas las filas de la tabla Matches
        return database.rawQuery("select * from " + MATCHES_TABLE_NAME, null);
    }


}
