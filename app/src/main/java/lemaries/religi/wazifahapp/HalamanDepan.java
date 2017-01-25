package lemaries.religi.wazifahapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HalamanDepan extends AppCompatActivity {
    ImageButton btnPreferences;
    Button btnSugra, btnKubra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_depan);


        //Instansiasi
        btnKubra = (Button) findViewById(R.id.btnKubra);
        btnSugra = (Button) findViewById(R.id.btnSugra);
        btnPreferences = (ImageButton) findViewById(R.id.btnPrefereces);
    }

    public void intentSugra(View view) {
        Intent intentSugra = new Intent(HalamanDepan.this, MainActivity.class);
        intentSugra.putExtra("opsi","sugra");
        startActivity(intentSugra);

    }

    public void intentKubra(View view) {
        Intent intentKubra = new Intent(HalamanDepan.this, MainActivity.class);
        intentKubra.putExtra("opsi","kubra");
        startActivity(intentKubra);

    }


}
