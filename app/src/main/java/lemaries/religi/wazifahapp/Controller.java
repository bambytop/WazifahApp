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
        this.tempModelSugra = new ArrayList<>();
    }

    /**
     * Methodnya digunakan untuk mengembalikan arraylist dari bacaan pagi
     *
     * @return
     */
    private void getBacaanPagi() {
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
        c_pagi = dbHelper.query("Pagi", null, null, null, null, null, null);
        if (c_pagi.moveToFirst()) {
            do {
                this.tempModelPagi.add(new ModelPagi(c_pagi.getInt(0), c_pagi.getString(1), c_pagi.getString(2)));
                Log.i("DATA MASUK", "ID_DOA: " + c_pagi.getInt(0) + " NAMA: " + c_pagi.getString(1) + " BACAAN: " + c_pagi.getString(2));
            } while (c_pagi.moveToNext());
        }
//        return this.tempModelPagi;
    }

    /**
     * Method untuk mengambil dari database
     */
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
        c_sugra = dbHelper.query("Sugra", null, null, null, null, null, null);
        if (c_sugra.moveToFirst()) {
            do {
                this.tempModelSugra.add(new ModelSugra(c_sugra.getInt(0), c_sugra.getInt(1), c_sugra.getInt(2)));
                Log.i("SUGRA", "ID: " + c_sugra.getInt(0) + " FK_ID_DOA: " + c_sugra.getInt(1) + " COUNTER: " + c_sugra.getInt(2));
            } while (c_sugra.moveToNext());
        }
//        return this.tempModelSugra;
    }

    public ArrayList<String> getWZHSugraPagi() {
        this.getBacaanPagi();
        this.getSugraCounter();
        ArrayList<String> tempPagi = new ArrayList<>();

        int counter = 0;
        for (ModelPagi entryPagi : this.tempModelPagi
                ) {
            Log.i("ID_DOA", entryPagi.getID_DOA() + "");
            for (int i = 0; i < tempModelSugra.size(); i++) {
                if (entryPagi.getID_DOA() == tempModelSugra.get(i).getFK_ID_DOA()) {
                    Log.i("DATA_BARU: ", entryPagi.getID_DOA() + ", " + tempModelSugra.get(i).getFK_ID_DOA());
                    tempPagi.add(counter, entryPagi.getBACAAN());
                    counter++;
                }
            }
//            if (counter <= tempModelSugra.size()) {
//                if (entryPagi.getID_DOA() == tempModelSugra.get(counter).getFK_ID_DOA()) {
//                    Log.i("DATA_BARU: ", entryPagi.getID_DOA()+", "+tempModelSugra.get(counter).getFK_ID_DOA());
//                    tempPagi.add(counter, entryPagi.getBACAAN());
//                }
//            }
//
//            counter++;
        }
        return tempPagi;
    }

    public int[] getCounterQuery() {
        int[] counterQuery = new int[this.tempModelSugra.size()];

        for (int i = 0; i < counterQuery.length; i++) {
            counterQuery[i] = 1;
        }


        return counterQuery;
    }

}
