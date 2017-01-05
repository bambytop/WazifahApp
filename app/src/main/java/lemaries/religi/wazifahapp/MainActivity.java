package lemaries.religi.wazifahapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textDua, textCounter;
    int counter, duaIndex;
    String[] text = {"بِسْمِ اللهِ الرَّحْمـَنِ الرَّحِيمِ الْحَمْدُ للهِ رَبِّ الْعَالَمِينَ الرَّحْمـنِ الرَّحِيمِ مَـلِكِ يَوْمِ الدِّينِ إِيَّاكَ نَعْبُدُ وإِيَّاكَ نَسْتَعِينُ اهدِنَــــا الصِّرَاطَ المُستَقِيمَ صِرَاطَ الَّذِينَ أَنعَمتَ عَلَيهِمْ غَيرِ المَغضُوبِ عَلَيهِمْ وَلاَ الضَّالِّينَ",
            "بِسْمِ اللّهِ الرَّحْمـنِ الرَّحِيمِ الـم ذَلِكَ الْكِتَابُ لاَ رَيْبَ فِيهِ هُدًى لِّلْمُتَّقِينَ الَّذِينَ يُؤْمِنُونَ بِالْغَيْبِ وَيُقِيمُونَ الصَّلاةَ وَمِمَّا رَزَقْنَاهُمْ يُنفِقُونَ والَّذِينَ يُؤْمِنُونَ بِمَا أُنزِلَ إِلَيْكَ وَمَا أُنزِلَ مِن قَبْلِكَ وَبِالآخِرَةِ هُمْ يُوقِنُونَ أُوْلَـئِكَ عَلَى هُدًى مِّن رَّبِّهِمْ وَأُوْلَـئِكَ هُمُ الْمُفْلِحُونَ",
            "nanana3"};
    int[] text2 = {R.string.Al_Fatihah, R.string.Al_Baqarah1_5,R.string.app_name};
    int[] counterSelf = {2, 2, 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instansiasi Content
        textDua = (TextView) findViewById(R.id.textDua);
        textCounter = (TextView) findViewById(R.id.textCounter);

        counter = 0;
        duaIndex = 0;

        //Set
        textCounter.setText("");
    }


    public void onClickTextChanged(View view) {
//        counter++;
        try {
            Log.i("==:", "========================");
            Log.i("nilai duaIndex:", Integer.toString(duaIndex));
            Log.i("nilai counter:", Integer.toString(counter));
            if (counter < counterSelf[duaIndex]) {
//                textDua.setText(text[duaIndex]);
                textDua.setText(text2[duaIndex]);
                textCounter.setText("x" + (counter+1));
                counter++;
                Log.i("Dalam counter:", Integer.toString(counter));
            } else if (counter == counterSelf[duaIndex]) {
                textCounter.setText("x" + (counter+1));
                counter = 0;
                ++duaIndex;
            }
        } catch (Exception e) {
            Log.i("Error:", "nanana joker: " + e.toString());
        }


    }
}
