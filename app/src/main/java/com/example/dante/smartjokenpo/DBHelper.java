package com.example.dante.smartjokenpo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.SparseIntArray;

/**
 * Created by Dante on 13/09/2015.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static final String NOME_BASE = "SmartJoKenPo";
    private static final int VERSAO_BASE = 1;

    public DBHelper(Context context){
        super(context, NOME_BASE, null, VERSAO_BASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        String sqlCreateTabelaStatistics = "CREATE TABLE statistics("
                + "id PRIMARY KEY,"
                + "win INTEGER,"
                + "lose INTEGER,"
                + "draw INTEGER,"
                + "rock INTEGER,"
                + "paper INTEGER,"
                + "scissors INTEGER"
                + ")";
        db.execSQL(sqlCreateTabelaStatistics);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String sqlDropTabelaStatistics = "DROP TABLE statistics";
        db.execSQL(sqlDropTabelaStatistics);

        onCreate(db);
    }

    public int selectStatistics(String campo){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + campo + "FROM statistics WHERE id = 1";
        Cursor c =  db.rawQuery(query, null);
        int valor = Integer.parseInt(c.toString());
        return valor;
    }

    public void updateStatistics(String s){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "UPDATE statistics SET "
                + s +" = " + s +" + 1"
                +"WHERE id = 1";

        db.execSQL(sql);
        db.close();

    }




}
