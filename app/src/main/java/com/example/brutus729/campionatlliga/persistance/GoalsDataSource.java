package com.example.brutus729.campionatlliga.persistance;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class GoalsDataSource {

    //Metainformación de la base de datos
    public static final String GOALS_TABLE_NAME = "Goals";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla Goals
    public static class ColumnGoals{
        public static final String ID_GOALS = BaseColumns._ID;
        public static final String NUM_GOALS = "numGoals";
        public static final String WEEK_GOALS = "week";
        public static final String TEAM_GOALS = "team";
        public static final String PLAYER_GOALS = "player";
    }

    //Script para eliminar tabla Goals
    public static final String DELETE_GOALS_SCRIPT = "drop table " +GOALS_TABLE_NAME;

    //Script de Creación de la tabla Goals
    public static final String CREATE_GOALS_SCRIPT =
            "create table "+GOALS_TABLE_NAME+"(" +
                    ColumnGoals.ID_GOALS+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnGoals.NUM_GOALS+" "+INT_TYPE+" not null," +
                    ColumnGoals.WEEK_GOALS+" "+INT_TYPE+" not null," +
                    ColumnGoals.TEAM_GOALS+" "+STRING_TYPE+" not null," +
                    ColumnGoals.PLAYER_GOALS+" "+STRING_TYPE+" not null)";

    //Scripts de inserción por defecto.
    public static final String INSERT_GOALS_SCRIPT =
            "insert into " + GOALS_TABLE_NAME
                    + " values" + introduirDataIni();
    //Automatizar valores por defecto.
    private static String introduirDataIni() {
        String stringData = "";
        return stringData;
    }

    //Variables para manipulación de datos
    private SQLiteDatabase database;

    public GoalsDataSource(Context context) {
        //Creando una instancia hacia la base de datos
        database = new ReaderDbHelper(context).getWritableDatabase();
    }

    public void saveGoalsRow(int numGoals, int week, String team, String player){
        //Nuestro contenedor de valores
        ContentValues values = new ContentValues();

        //Seteando name y shortName
        values.put(ColumnGoals.NUM_GOALS,numGoals);
        values.put(ColumnGoals.WEEK_GOALS,week);
        values.put(ColumnGoals.TEAM_GOALS,team);
        values.put(ColumnGoals.PLAYER_GOALS,player);

        //Insertando en la base de datos
        database.insert(GOALS_TABLE_NAME,null,values);
    }

    public Cursor getAllGoals(){
        /*
        String query = "select * from " + GOALS_TABLE_NAME + " WHERE _id=?";
        return database.rawQuery(query, new String[]{"2"});
        */
        //Seleccionamos todas las filas de la tabla Goals
        return database.rawQuery("select * from " + GOALS_TABLE_NAME, null);
    }


}
