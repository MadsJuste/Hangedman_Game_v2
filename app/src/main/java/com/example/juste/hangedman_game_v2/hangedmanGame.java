package com.example.juste.hangedman_game_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.firebase.client.Firebase;
import java.util.HashMap;
import java.util.Map;


public class hangedmanGame extends AppCompatActivity implements View.OnClickListener {
    HangedmanLogic logic = new HangedmanLogic();
    private Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF,buttonG,buttonH, buttonI,buttonJ, buttonK, buttonL,
            buttonM, buttonN, buttonO, buttonP, buttonQ, buttonR, buttonS, buttonT, buttonU, buttonV, buttonW, buttonX,
            buttonY, buttonZ, buttonÆ,buttonØ, buttonÅ;
    private ImageView iw;
    private TextView tw ;
    private TextView guesses;
    private String name;
    Firebase myFBRef = new Firebase("https://hangedman-game.firebaseio.com/");
    int nummer;
    long timer = -System.currentTimeMillis();

    String[] alfabet = {"a", "b", "c","d", "e","f", "g","h", "i","j", "k","l", "m","n",
            "o","p", "q","r", "s","t", "u","v","w", "x","y", "z", "æ","ø", "å"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_hangedman_game);
        buttonA = (Button) findViewById(R.id.A);buttonB = (Button) findViewById(R.id.B);
        buttonC = (Button) findViewById(R.id.C);buttonD = (Button) findViewById(R.id.D);
        buttonE = (Button) findViewById(R.id.E);buttonF = (Button) findViewById(R.id.F);
        buttonG = (Button) findViewById(R.id.G);buttonH = (Button) findViewById(R.id.H);
        buttonI = (Button) findViewById(R.id.I);buttonJ = (Button) findViewById(R.id.J);
        buttonK = (Button) findViewById(R.id.K);buttonL = (Button) findViewById(R.id.L);
        buttonM = (Button) findViewById(R.id.M);buttonN = (Button) findViewById(R.id.N);
        buttonO = (Button) findViewById(R.id.O);buttonP = (Button) findViewById(R.id.P);
        buttonQ = (Button) findViewById(R.id.Q);buttonR = (Button) findViewById(R.id.R);
        buttonS = (Button) findViewById(R.id.S);buttonT = (Button) findViewById(R.id.T);
        buttonU = (Button) findViewById(R.id.U);buttonV = (Button) findViewById(R.id.V);
        buttonW = (Button) findViewById(R.id.W);buttonX = (Button) findViewById(R.id.X);
        buttonY = (Button) findViewById(R.id.Y);buttonZ = (Button) findViewById(R.id.Z);
        buttonÆ = (Button) findViewById(R.id.Æ);buttonØ = (Button) findViewById(R.id.Ø);
        buttonÅ = (Button) findViewById(R.id.Å);
        buttonA.setOnClickListener(this); buttonB.setOnClickListener(this); buttonC.setOnClickListener(this);buttonD.setOnClickListener(this); buttonE.setOnClickListener(this);
        buttonF.setOnClickListener(this); buttonG.setOnClickListener(this);buttonH.setOnClickListener(this);buttonI.setOnClickListener(this);buttonJ.setOnClickListener(this);
        buttonK.setOnClickListener(this);buttonL.setOnClickListener(this);buttonM.setOnClickListener(this);buttonN.setOnClickListener(this);buttonO.setOnClickListener(this);
        buttonP.setOnClickListener(this); buttonQ.setOnClickListener(this);buttonR.setOnClickListener(this);buttonS.setOnClickListener(this);buttonT.setOnClickListener(this);
        buttonU.setOnClickListener(this);buttonV.setOnClickListener(this);buttonW.setOnClickListener(this);buttonX.setOnClickListener(this);buttonY.setOnClickListener(this);
        buttonZ.setOnClickListener(this); buttonÆ.setOnClickListener(this);buttonØ.setOnClickListener(this); buttonÅ.setOnClickListener(this);
        guesses = (TextView) findViewById(R.id.LettersUsed);
        iw = (ImageView) findViewById(R.id.imageView2);
        tw = (TextView) findViewById(R.id.WordToGuess);
        tw.setText(logic.getVisableWord());
        iw.setImageResource(R.drawable.galge);
        name = getIntent().getStringExtra("name");




    }
    public void runGame(int i){

        String charecter;
        nummer=i;
        charecter = alfabet[nummer];
        if(logic.getUsedLetter().contains(charecter)){
            tw.setText("you have already guessed on this letter");
        }else {
            logic.guessLetter(charecter);
            tw.setText(logic.getVisableWord());
                if (!logic.isLastLetterCorrect()) {
                    guesses.setText(guesses.getText() + " " + charecter);
                    logic.minusPoints();
                }
            if (logic.isTheGameWon()) {
                tw.setText("You have guessed the word: " + logic.getWord() + " and score 100 points");
                logic.softReset();
                logic.plusPoints();
                guesses.setText("Letters Used: ");
                iw.setImageResource(R.drawable.galge);
            }
            if (logic.isTheGameLost()) {
                String push = ""+logic.getScore();
                Map<String, String> highscore = new HashMap<String, String>();
                highscore.put("score", push);
                highscore.put("name", name);
                myFBRef.push().setValue(highscore);
                String postID = myFBRef.getKey();
                Intent gameLost = new Intent(this, GameIsLostActivity.class);
                gameLost.putExtra("word", logic.getWord());
                gameLost.putExtra("score", logic.getScore());
                startActivity(gameLost);
            }
            logic.logStatus();
            timer += System.currentTimeMillis();
            System.out.println("hangedGame.runGame() " + timer);
        }

        switch(logic.getNumberOfWrongWords()){
            case 1 : iw.setImageResource(R.drawable.forkert1);
                break;
            case 2 : iw.setImageResource(R.drawable.forkert2);
                break;
            case 3 : iw.setImageResource(R.drawable.forkert3);
                break;
            case 4 : iw.setImageResource(R.drawable.forkert4);
                break;
            case 5 : iw.setImageResource(R.drawable.forkert5);
                break;
            case 6 : iw.setImageResource(R.drawable.forkert6);
                break;

        }
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.A: runGame(0);
                break;
            case R.id.B: runGame(1);
                break;
            case R.id.C: runGame(2);
                break;
            case R.id.D: runGame(3);
                break;
            case R.id.E: runGame(4);
                break;
            case R.id.F: runGame(5);
                break;
            case R.id.G: runGame(6);
                break;
            case R.id.H: runGame(7);
                break;
            case R.id.I: runGame(8);
                break;
            case R.id.J: runGame(9);
                break;
            case R.id.K: runGame(10);
                break;
            case R.id.L: runGame(11);
                break;
            case R.id.M: runGame(12);
                break;
            case R.id.N: runGame(13);
                break;
            case R.id.O: runGame(14);
                break;
            case R.id.P: runGame(15);
                break;
            case R.id.Q: runGame(16);
                break;
            case R.id.R: runGame(17);
                break;
            case R.id.S: runGame(18);
                break;
            case R.id.T: runGame(19);
                break;
            case R.id.U: runGame(20);
                break;
            case R.id.V: runGame(21);
                break;
            case R.id.W: runGame(22);
                break;
            case R.id.X: runGame(23);
                break;
            case R.id.Y: runGame(24);
                break;
            case R.id.Z: runGame(25);
                break;
            case R.id.Æ: runGame(26);
                break;
            case R.id.Ø: runGame(27);
                break;
            case R.id.Å: runGame(28);
                break;
        }
    }
}
