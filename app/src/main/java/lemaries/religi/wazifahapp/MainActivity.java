package lemaries.religi.wazifahapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textDua, textCounter;
    int counter = 0, duaIndex = 0;
    String[] text = {"بِسْمِ اللهِ الرَّحْمـَنِ الرَّحِيمِ الْحَمْدُ للهِ رَبِّ الْعَالَمِينَ الرَّحْمـنِ الرَّحِيمِ مَـلِكِ يَوْمِ الدِّينِ إِيَّاكَ نَعْبُدُ وإِيَّاكَ نَسْتَعِينُ اهدِنَــــا الصِّرَاطَ المُستَقِيمَ صِرَاطَ الَّذِينَ أَنعَمتَ عَلَيهِمْ غَيرِ المَغضُوبِ عَلَيهِمْ وَلاَ الضَّالِّينَ",
            "بِسْمِ اللّهِ الرَّحْمـنِ الرَّحِيمِ الـم ذَلِكَ الْكِتَابُ لاَ رَيْبَ فِيهِ هُدًى لِّلْمُتَّقِينَ الَّذِينَ يُؤْمِنُونَ بِالْغَيْبِ وَيُقِيمُونَ الصَّلاةَ وَمِمَّا رَزَقْنَاهُمْ يُنفِقُونَ والَّذِينَ يُؤْمِنُونَ بِمَا أُنزِلَ إِلَيْكَ وَمَا أُنزِلَ مِن قَبْلِكَ وَبِالآخِرَةِ هُمْ يُوقِنُونَ أُوْلَـئِكَ عَلَى هُدًى مِّن رَّبِّهِمْ وَأُوْلَـئِكَ هُمُ الْمُفْلِحُونَ",
            "nanana3"};
    int[] text2 = {R.string.Al_Fatihah, R.string.Al_Baqarah1_5, R.string.app_name};
    int[] textQuery;
    int[] counterSelf = {2, 2, 2};
    int[] counterQuery;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getString("opsi").equalsIgnoreCase("sugra")) {
                //Ada 30 query
                textQuery = new int[]{R.string.Al_Fatihah, R.string.Al_Baqarah1_5,
                        R.string.Al_Baqarah255_257, R.string.Al_Baqarah284_286, R.string.Al_Ikhlas, R.string.Al_Falaq,
                        R.string.An_Naas, R.string.doa_1, R.string.doa_2, R.string.doa_3, R.string.doa_4, R.string.doa_5,
                        R.string.doa_6, R.string.doa_7, R.string.doa_8, R.string.doa_9, R.string.doa_10, R.string.doa_11,
                        R.string.doa_12, R.string.doa_13, R.string.doa_14, R.string.doa_15, R.string.Shalawat, R.string.doa_16, R.string.doa_17,
                        R.string.doa_18, R.string.doa_19, R.string.doa_20, R.string.Ali_Imran26_27, R.string.doa_21, R.string.doa_22};
                counterQuery = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            } else if (bundle.getString("opsi").equalsIgnoreCase("kubra")) {
                //Ada 30 query
                textQuery = new int[]{R.string.Al_Fatihah, R.string.Al_Baqarah1_5,
                        R.string.Al_Baqarah255_257, R.string.Al_Baqarah284_286,R.string.Ali_Imran1_2,R.string.Thaaha111_112,R.string.Al_Isra110_111, R.string.Al_Muminun115_118,R.string.Ar_Ruum17_26,R.string.Al_Mukmin1_3,
                        R.string.Al_Hasyr22_24,R.string.Al_Zalzalah,R.string.Al_kafirun,R.string.An_Nasr, R.string.Al_Ikhlas, R.string.Al_Falaq,
                        R.string.An_Naas, R.string.doa_1, R.string.doa_2, R.string.doa_3, R.string.doa_4, R.string.doa_5,
                        R.string.doa_6, R.string.doa_7, R.string.doa_8, R.string.doa_9, R.string.doa_10, R.string.doa_11,
                        R.string.doa_12, R.string.doa_13, R.string.doa_14, R.string.doa_15, R.string.Shalawat, R.string.doa_16, R.string.doa_17,
                        R.string.doa_18, R.string.doa_19, R.string.doa_20, R.string.Ali_Imran26_27, R.string.doa_21, R.string.doa_22};
                counterQuery = new int[]{1, 1, 1, 1,  1,1,7,1,1,1,1,1,1,1,1,  3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 10, 100, 10, 1, 1, 1, 1, 1, 1};
            }
        }


        //Instansiasi Content
        textDua = (TextView) findViewById(R.id.textDua);
        textCounter = (TextView) findViewById(R.id.textCounter);

        ///Ubah font

        Typeface font_arab = Typeface.createFromAsset(getAssets(),"me_quran.ttf");
        textDua.setTypeface(font_arab);

        //Set
        textCounter.setText("");
    }


    public void onClickTextChanged(View view) {
//        counter++;
        try {
            Log.i("==:", "========================");
            Log.i("nilai duaIndex:", Integer.toString(duaIndex));
            Log.i("nilai counter:", Integer.toString(counter));
            Log.i("panjangA", "" + counterQuery.length);
//            if (counter < counterSelf[duaIndex]) {
////                textDua.setText(text[duaIndex]);
//                textDua.setText(text2[duaIndex]);
//                textCounter.setText("x" + (counter + 1));
//                counter++;
//                Log.i("Dalam counter:", Integer.toString(counter));
//            } else if (counter == counterSelf[duaIndex]) {
//                textCounter.setText("x" + (counter + 1));
//                counter = 0;
//                ++duaIndex;
//            }
            if (counter < counterQuery[duaIndex]) {
//                textDua.setText(text[duaIndex]);
                textDua.setText(textQuery[duaIndex]);
                textCounter.setText("x" + (counter + 1));
                counter++;
                Log.i("Dalam counter:", Integer.toString(counter));
            } else if (duaIndex + 1 == counterQuery.length) {
                Toast.makeText(getApplicationContext(), "Anda sudah diujung", Toast.LENGTH_SHORT).show();
            } else if (counter == counterQuery[duaIndex]) {
//                textCounter.setText("x" + (counter + 1));
                textCounter.setText("");
                textDua.setText(textQuery[duaIndex + 1]);
                counter = 1;
                ++duaIndex;
            }

        } catch (Exception e) {
            Log.i("Error:", "nanana joker: " + e.toString());
        }


    }
}
