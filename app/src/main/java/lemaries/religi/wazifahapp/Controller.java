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

    private final String WAKTU_PAGI = "FAJAR", WAKTU_PETANG = "PETANG";

    private ArrayList<ModelPagi> tempModelPagi;
    private ArrayList<ModelPetang> tempModelPetang;
    private ArrayList<ModelSugra> tempModelSugra;
    private ArrayList<ModelKubra> tempModelKubra;
    private Databasehelper dbHelper;

    public Controller(Context context) {
        dbHelper = new Databasehelper(context);
        this.tempModelPagi = new ArrayList<>();
        this.tempModelSugra = new ArrayList<>();
        this.tempModelPetang = new ArrayList<>();
        this.tempModelKubra = new ArrayList<>();
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

    private void getBacaanPetang() {
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
        c_petang = dbHelper.query("Petang", null, null, null, null, null, null);
        if (c_petang.moveToFirst()) {
            do {
                this.tempModelPetang.add(new ModelPetang(c_petang.getInt(0), c_petang.getString(1), c_petang.getString(2)));
                Log.i("DATA MASUK", "ID_DOA: " + c_petang.getInt(0) + " NAMA: " + c_petang.getString(1) + " BACAAN: " + c_petang.getString(2));
            } while (c_petang.moveToNext());
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

    private void getKubraCounter() {
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
        c_kubra = dbHelper.query("Kubra", null, null, null, null, null, null);
        if (c_kubra.moveToFirst()) {
            do {
                this.tempModelKubra.add(new ModelKubra(c_kubra.getInt(0), c_kubra.getInt(1)));
                Log.i("KUBRA", "ID: " + c_kubra.getInt(0) + " COUNTER: " + c_kubra.getInt(1));
            } while (c_kubra.moveToNext());
        }
//        return this.tempModelSugra;
    }

    public ArrayList<String> getWZHKubra(String waktu) {
        ArrayList<String> temp = new ArrayList<>();
        this.getKubraCounter();
        if (waktu != null) {
            if (waktu.equalsIgnoreCase(WAKTU_PAGI)) {
                this.getBacaanPagi();
                ArrayList<String> tempPagi = new ArrayList<>();
                for (ModelPagi entryPagi : this.tempModelPagi
                        ) {
                    tempPagi.add(entryPagi.getBACAAN());
                }
                temp = tempPagi;

            } else if (waktu.equalsIgnoreCase(WAKTU_PETANG)) {
                this.getBacaanPetang();
                ArrayList<String> tempPetang = new ArrayList<>();
                for (ModelPetang entryPetang : this.tempModelPetang
                        ) {
                    tempPetang.add(entryPetang.getBACAAN());
                }
                temp = tempPetang;
            }
        }
        return temp;
    }

    public ArrayList<String> getWZHSugra(String waktu) {
        ArrayList<String> temp = new ArrayList<>();
        if (waktu != null) {
            if (waktu.equalsIgnoreCase(WAKTU_PAGI)) {
                this.getBacaanPagi();
                this.getSugraCounter();
                int counter = 0;
                ArrayList<String> tempPagi = new ArrayList<>();
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
                }
                temp = tempPagi;
            } else if (waktu.equalsIgnoreCase(WAKTU_PETANG)) {
                this.getBacaanPetang();
                this.getSugraCounter();
                int counter = 0;
                ArrayList<String> tempPetang = new ArrayList<>();
                for (ModelPetang entryPetang : this.tempModelPetang
                        ) {
                    Log.i("ID_DOA", entryPetang.getID_DOA() + "");
                    for (int i = 0; i < tempModelSugra.size(); i++) {
                        if (entryPetang.getID_DOA() == tempModelSugra.get(i).getFK_ID_DOA()) {
                            Log.i("DATA_BARU: ", entryPetang.getID_DOA() + ", " + tempModelSugra.get(i).getFK_ID_DOA());
                            tempPetang.add(counter, entryPetang.getBACAAN());
                            counter++;
                        }
                    }
                }
                temp = tempPetang;
            }
        }
        return temp;
    }


    // SUGRA

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
        }
        return tempPagi;
    }


    // KUBRA

    public ArrayList<String> getWZHSugraPetang() {
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
        }
        return tempPagi;
    }

    public int[] getCounterQueryKubra() {
        int[] counterQuery = new int[this.tempModelKubra.size()];

        for (int i = 0; i < counterQuery.length; i++) {
            counterQuery[i] = this.tempModelKubra.get(i).getCOUNTER();
        }


        return counterQuery;
    }

    public int[] getCounterQuerySugra() {
        int[] counterQuery = new int[this.tempModelSugra.size()];

        for (int i = 0; i < counterQuery.length; i++) {
            counterQuery[i] = 1;
        }


        return counterQuery;
    }

}
