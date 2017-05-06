package lemaries.religi.wazifahapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

public class splashscreen extends AppCompatActivity {

    private static int splashInterval = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splashscreen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentHalamanDepan = new Intent(splashscreen.this, HalamanDepan.class);
                startActivity(intentHalamanDepan);
                this.finish();
            }

            public void finish() {
                //Buat ngetest bisa disini nanti
                Log.i("splash","Bisa");
            }
        }, splashInterval);


    }
}
