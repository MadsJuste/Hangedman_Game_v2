package com.example.juste.hangedman_game_v2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;
/**
 * Created by Konstantin on 17-01-2016.
 */
public class Statitstic_Fragment extends Fragment {

    public Text txtPlay;
    public Text txtWon;
    public Text txtLost;
    public Text txtAvTime;
    public EditText edtxtPlayed;
    public EditText edtxtWon;
    public EditText edtxtLost;
    public EditText edtxtTime;
    public Button btnReset;
    HangedmanLogic logic = new HangedmanLogic();


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View statisticFragmentView = inflater.inflate(R.layout.statistik_fragment, container, false);
        edtxtWon.setText(logic.WonStat());
        edtxtLost.setText(logic.LostStat());
        edtxtPlayed.setText(logic.TotalStat());
        edtxtTime.setText(logic.AverageTime());

        return statisticFragmentView;
    }

public void onClick(View v){
    if (v==btnReset){
        logic.ResetStat();
    }
}

}
