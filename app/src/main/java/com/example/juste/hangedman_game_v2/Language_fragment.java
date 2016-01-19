package com.example.juste.hangedman_game_v2;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Konstantin on 17-01-2016.
 */
public class Language_fragment extends AppCompatActivity implements View.OnClickListener{

    private Button btnEn;
    private Button btnDk;
    private TextView txttxt;
    HangedmanLogic logic = new HangedmanLogic();
    String botPressed;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_choice);
       // View view = inflater.inflate(R.layout.language_choice, container, false);
        Log.d("language_fragment", "fragmentet blev vist!");
        btnDk = (Button) findViewById(R.id.btnDk);
        btnDk.setOnClickListener(this);
        btnEn = (Button) findViewById(R.id.btnEn);
        btnEn.setOnClickListener(this);
        txttxt = (TextView) findViewById(R.id.txttxt);

    }

    @Override
    public void onClick(View v) {
        if (v==btnDk) {
            botPressed = "danish";
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("message", botPressed);
            startActivity(intent);
        }
        else {
             botPressed = "english";
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("message", botPressed);
            startActivity(intent);
        }
    }
}
