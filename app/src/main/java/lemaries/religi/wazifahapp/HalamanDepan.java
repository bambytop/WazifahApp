package lemaries.religi.wazifahapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.N)
public class HalamanDepan extends AppCompatActivity {
    ImageButton btnPreferences;
    Button btnSugra, btnKubra;
    Calendar calendar = Calendar.getInstance();
    private final String WAKTU_PAGI = "FAJAR", WAKTU_PETANG = "PETANG";
    int waktu_ini = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_depan);

        waktu_ini = calendar.get(Calendar.HOUR_OF_DAY);
        Toast.makeText(this, "waktu: "+waktu_ini, Toast.LENGTH_SHORT).show();


        //Instansiasi
        btnKubra = (Button) findViewById(R.id.btnKubra);
        btnSugra = (Button) findViewById(R.id.btnSugra);
        btnPreferences = (ImageButton) findViewById(R.id.btnPrefereces);
    }

    public void intentSugra(View view) {
        Intent intentSugra = new Intent(HalamanDepan.this, MainActivity.class);
        intentSugra.putExtra("opsi", "sugra");
        if (waktu_ini >= 0 && waktu_ini < 12) {
            intentSugra.putExtra("waktu", WAKTU_PAGI);
        } else if (waktu_ini >= 12 && waktu_ini < 24) {
            intentSugra.putExtra("waktu", WAKTU_PETANG);
        }

        startActivity(intentSugra);

    }

    public void intentKubra(View view) {
        Intent intentKubra = new Intent(HalamanDepan.this, MainActivity.class);
        intentKubra.putExtra("opsi", "kubra");
        if (waktu_ini >= 0 && waktu_ini < 12) {
            intentKubra.putExtra("waktu", WAKTU_PAGI);
        } else if (waktu_ini >= 12 && waktu_ini < 24) {
            intentKubra.putExtra("waktu", WAKTU_PETANG);
        }
        startActivity(intentKubra);

    }


}
