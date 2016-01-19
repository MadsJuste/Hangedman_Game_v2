package com.example.juste.hangedman_game_v2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;
/**
 * Created by Konstantin on 17-01-2016.
 */
public class Statistic_Activity extends AppCompatActivity implements View.OnClickListener {

    public Text txtPlay;
    public Text txtWon;
    public Text txtLost;
    public Text txtAvTime;

    public TextView edtxtPlayed;
    public TextView edtxtWon;
    public TextView edtxtLost;
    public TextView edtxtTime;
    public Button btnReset;
    HangedmanLogic logic = new HangedmanLogic();


    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistik_fragment);
        edtxtPlayed = (TextView) findViewById(R.id.edtxtPlayed);
        edtxtWon = (TextView) findViewById(R.id.edtxtWon);
        edtxtLost = (TextView) findViewById(R.id.edtxtLost);
       // edtxtTime = (EditText) findViewById(R.id.edtxtTime);

String str =Integer.toString(logic.WonStat());
        edtxtWon.setText(str);

        String str1 =Integer.toString(logic.LostStat());
       edtxtLost.setText(str1);

        String str2 = Integer.toString(logic.TotalStat());
        edtxtPlayed.setText(str2);

       // edtxtTime.setText(logic.AverageTime());


    }

public void onClick(View v){
    if (v==btnReset){
        logic.ResetStat();
    }
}

}
