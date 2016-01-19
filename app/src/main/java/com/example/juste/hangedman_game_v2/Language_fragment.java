package com.example.juste.hangedman_game_v2;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.w3c.dom.Text;

/**
 * Created by Konstantin on 17-01-2016.
 */
public class Language_fragment extends AppCompatActivity implements View.OnClickListener{

    private Button btnEn;
    private Button btnDk;
    private Text txttxt;
    HangedmanLogic logic = new HangedmanLogic();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_choice);
       // View view = inflater.inflate(R.layout.language_choice, container, false);
        Log.d("language_fragment", "fragmentet blev vist!");
        btnDk = (Button) findViewById(R.id.btnDk);
        btnDk.setOnClickListener(this);
        btnEn = (Button) findViewById(R.id.btnEn);
        btnEn.setOnClickListener(this);





    }

    public void getWordDR ()  {


        new AsyncTask() {
            @Override
            protected Object doInBackground(Object... arg0) {
                try {
                    logic.getWordFromDR();
                    return "Words picked up properly from DR";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Words are not picked up properly from DR: " + e;
                }
            }


        }.execute();
    }

    public void getWordGuardian ()  {


        new AsyncTask() {
            @Override
            protected Object doInBackground(Object... arg0) {
                try {
                    logic.getWordFromTimes();
                    return "Words picked up properly from Times";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Words are not picked up properly from Times: " + e;
                }
            }


        }.execute();
    }

    @Override
    public void onClick(View v) {
if (v==btnDk) {
   getWordDR();
}
        else {
            getWordGuardian();
        }
    }
}
