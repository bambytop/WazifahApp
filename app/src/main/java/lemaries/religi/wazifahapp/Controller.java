package lemaries.religi.wazifahapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Kotak Hitam on 1/25/2017.
 */

public class Controller {
    private Cursor c_pagi, c_petang, c_sugra, c_kubra;

    private ArrayList<ModelPagi> tempModelPagi;
    private ArrayList<ModelSugra> tempModelSugra;
    private Databasehelper dbHelper;

    public Controller(Context context) {
        dbHelper = new Databasehelper(context);
        this.tempModelPagi = new ArrayList<>();
    }

    private ArrayList<ModelPagi> getBacaanPagi() {
        try {
            dbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Tidak bisa membuat database \n Unable to create database");
        }
        try {
            dbHelper.openDataBase();
        } catch (SQLiteException sqle) {
            throw sqle;
        }
        c_pagi = dbHelper.query("Tabel_Pagi", null, null, null, null, null, null);
        if (c_pagi.moveToFirst()) {
            do {
                this.tempModelPagi.add(new ModelPagi(c_pagi.getInt(0), c_pagi.getString(1), c_pagi.getString(2)));
                Log.i("DATA MASUK", "ID_DOA: " + c_pagi.getInt(0) + " NAMA: " + c_pagi.getString(1) + " BACAAN: " + c_pagi.getString(2));
            } while (c_pagi.moveToNext());
        }
        return this.tempModelPagi;
    }

    private void getSugraCounter() {
        try {
            dbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Tidak bisa membuat database \n Unable to create database");
        }
        try {
            dbHelper.openDataBase();
        } catch (SQLiteException sqle) {
            throw sqle;
        }
        c_sugra = dbHelper.query("Tabel_Sugra", null, null, null, null, null, null);
        if (c_sugra.moveToFirst()) {
            do {
                this.tempModelSugra.add(new ModelSugra(c_sugra.getInt(0), c_sugra.getInt(1), c_sugra.getInt(2)));
                Log.i("SUGRA", "ID: " + c_sugra.getInt(0) + " FK_ID_DOA: " + c_sugra.getInt(1) + " COUNTER: " + c_sugra.getInt(2));
            } while (c_sugra.moveToNext());
        }
//        return this.tempModelSugra;
    }

    public void getWZHSugraPagi() {
        ArrayList<ModelPagi> tempPagi = this.getBacaanPagi();


    }

}
