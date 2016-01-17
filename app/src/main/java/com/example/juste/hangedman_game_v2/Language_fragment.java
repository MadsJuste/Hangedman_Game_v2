package com.example.juste.hangedman_game_v2;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.w3c.dom.Text;

/**
 * Created by Konstantin on 17-01-2016.
 */
public class Language_fragment extends Fragment implements View.OnClickListener{

    private Button btnEn;
    private Button btnDk;
    private Text txttxt;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.language_choice, container, false);
        Log.d("language_fragment", "fragmentet blev vist!");
        btnDk = (Button) view.findViewById(R.id.btnDk);
        btnDk.setOnClickListener(this);
        btnEn = (Button) view.findViewById(R.id.btnEn);
        btnEn.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {

    }
}
