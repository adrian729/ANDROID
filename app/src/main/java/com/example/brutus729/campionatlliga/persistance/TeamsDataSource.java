package com.example.brutus729.campionatlliga.persistance;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class TeamsDataSource {

    //TODO: como se puede hacer todo en una sola DB con diferentes tablas? Es mas facil hacer varias por separado???
    //TODO:UPDATE de la DB

    //Metainformación de la base de datos
    public static final String TEAMS_TABLE_NAME = "TeamsFragment";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla TeamsFragment
    public static class ColumnTeams{
        public static final String ID_TEAMS = BaseColumns._ID;
        public static final String NAME_TEAMS = "name";
        public static final String SHORT_NAME_TEAMS = "shortName";
        public static final String CITY_TEAMS = "city";
    }

    //Script para eliminar tabla TeamsFragment
    public static final String DELETE_TEAMS_SCRIPT = "drop table " +TEAMS_TABLE_NAME;

    //Script de Creación de la tabla TeamsFragment
    public static final String CREATE_TEAMS_SCRIPT =
            "create table "+TEAMS_TABLE_NAME+"(" +
                    ColumnTeams.ID_TEAMS+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnTeams.NAME_TEAMS+" "+STRING_TYPE+" not null," +
                    ColumnTeams.SHORT_NAME_TEAMS+" "+STRING_TYPE+" not null," +
                    ColumnTeams.CITY_TEAMS+" "+STRING_TYPE+" not null)";

    //Scripts de inserción por defecto
    public static final String INSERT_TEAMS_SCRIPT =
            "insert into " + TEAMS_TABLE_NAME
                    + " values(null,\"Equip0\",\"E0\",\"city0\"),"
                    + "(null,\"Equip1\",\"E1\",\"city1\"),"
                    + "(null,\"Equip2\",\"E2\",\"city2\"),"
                    + "(null,\"Equip3\",\"E3\",\"city3\"),"
                    + "(null,\"Equip4\",\"E4\",\"city4\"),"
                    + "(null,\"Equip5\",\"E5\",\"city5\"),"
                    + "(null,\"Equip6\",\"E6\",\"city6\"),"
                    + "(null,\"Equip7\",\"E7\",\"city7\"),"
                    + "(null,\"Equip8\",\"E8\",\"city8\"),"
                    + "(null,\"Equip9\",\"E9\",\"city9\")";

    //Variables para manipulación de datos
    private TeamsReaderDbHelper openHelper;
    private SQLiteDatabase database;

    public TeamsDataSource(Context context) {
        //Creando una instancia hacia la base de datos
        openHelper = new TeamsReaderDbHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public void saveTeamsRow(String name,String shortName,String city){
        //Nuestro contenedor de valores
        ContentValues values = new ContentValues();

        //Seteando name y shortName
        values.put(ColumnTeams.NAME_TEAMS,name);
        values.put(ColumnTeams.SHORT_NAME_TEAMS,shortName);
        values.put(ColumnTeams.CITY_TEAMS,city);

        //Insertando en la base de datos
        database.insert(TEAMS_TABLE_NAME,null,values);
    }

    public Cursor getAllTeams(){
        /*
        String query = "select * from " + TEAMS_TABLE_NAME + " WHERE _id=?";
        return database.rawQuery(query, new String[]{"2"});
        */
        //Seleccionamos todas las filas de la tabla TeamsFragment
        return database.rawQuery("select * from " + TEAMS_TABLE_NAME, null);
    }

}
