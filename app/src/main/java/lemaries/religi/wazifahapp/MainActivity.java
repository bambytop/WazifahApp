package lemaries.religi.wazifahapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textDua, textCounter;
    int counter = 0, duaIndex = 0;
    List<String> textBaca;
    int[] textQuery;
    int[] counterSelf = {2, 2, 2};
    int[] counterQuery;
    Bundle bundle;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bundle = getIntent().getExtras();
        //Instansiasi Controller
        controller = new Controller(this.getApplicationContext());
        if (bundle != null) {
            if (bundle.getString("opsi").equalsIgnoreCase("sugra")) {
                textBaca = controller.getWZHSugra(bundle.getString("waktu"));
                counterQuery = controller.getCounterQuerySugra();
            } else if (bundle.getString("opsi").equalsIgnoreCase("kubra")) {
                textBaca = controller.getWZHKubra(bundle.getString("waktu"));
                counterQuery = controller.getCounterQueryKubra();
            }
        }
        int hours = new Time(System.currentTimeMillis()).getHours();
        Log.i("WAKTU", "waktu: ");

        //Instansiasi Content
        textDua = (TextView) findViewById(R.id.textDua);
        textCounter = (TextView) findViewById(R.id.textCounter);

        ///Ubah font
        Typeface font_arab = Typeface.createFromAsset(getAssets(), "me_quran.ttf");
        textDua.setTypeface(font_arab);

        //Set
        textCounter.setText("");
    }


    public void onClickTextChanged(View view) {

        try {
            Log.i("==:", "========================");
            Log.i("nilai duaIndex:", Integer.toString(duaIndex));
            Log.i("nilai counter:", Integer.toString(counter));
            Log.i("panjangA", "" + counterQuery.length);
            if (counter < counterQuery[duaIndex]) {

                textDua.setText(textBaca.get(duaIndex));
                if (counter != 0) {
                    textCounter.setText("x" + (counter + 1));
                }
                counter++;
                Log.i("Dalam counter:", Integer.toString(counter));
            } else if (duaIndex + 1 == counterQuery.length) {
                Toast.makeText(getApplicationContext(), "Anda sudah diujung", Toast.LENGTH_SHORT).show();
            } else if (counter == counterQuery[duaIndex]) {

                textCounter.setText("");

                textDua.setText(textBaca.get(duaIndex + 1));
                counter = 1;
                ++duaIndex;
            }

        } catch (Exception e) {
            Log.i("Error:", "ERROR: " + e.toString());
        }


    }

    // Balik tekan 2 kali
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        if(duaIndex == 0) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan kembali lagi untuk ke halaman utama", Toast.LENGTH_SHORT).show();
        if (duaIndex != 0) {
            counter = 0;
            duaIndex -= 1;
            textDua.setText(textBaca.get(duaIndex));
        }

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}
