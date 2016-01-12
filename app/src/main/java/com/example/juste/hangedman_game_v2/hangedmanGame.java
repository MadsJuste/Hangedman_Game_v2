package com.example.juste.hangedman_game_v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class hangedmanGame extends AppCompatActivity implements View.OnClickListener {
    HangedmanLogic logic = new HangedmanLogic();
    private Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF,buttonG,buttonH, buttonI,buttonJ, buttonK, buttonL,
            buttonM, buttonN, buttonO, buttonP, buttonQ, buttonR, buttonS, buttonT, buttonU, buttonV, buttonW, buttonX,
            buttonY, buttonZ, buttonÆ,buttonØ, buttonÅ;
    private ImageView iw;
    private TextView tw ;
    private TextView status;
    private TextView guesses;
    private ListView listView;
    private HorizontalScrollView HSView;
    private LinearLayout linearLayout;

    int nummer;
    String[] alfabet = {"a", "b", "c","d", "e","f", "g","h", "i","j", "k","l", "m","n",
            "o","p", "q","r", "s","t", "u","v","w", "x","y", "z", "æ","ø", "å"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        iw = (ImageView) findViewById(R.id.imageView2);
        tw = (TextView) findViewById(R.id.textView2);
        tw.setText(logic.getVisableWord());



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
                /*if (!logic.isLastLetterCorrect()) {
                    guesses.setText(guesses.getText() + " " + charecter);
                }*/
            if (logic.isTheGameWon()) {
                tw.setText("You have guessed the word: " + logic.getWord() + " and won");
            }
            if (logic.isTheGameLost()) {
                tw.setText("You have failed to guess the word: " + logic.getWord() + " and lost");
            }
            logic.logStatus();
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
        if (v==buttonA) {runGame(0);
        }else if(v==buttonB){runGame(1);
        }else if(v==buttonC){runGame(2);
        }else if(v==buttonD){runGame(3);
        }else if(v==buttonE){runGame(4);
        }else if(v==buttonF){runGame(5);
        }else if(v==buttonG){runGame(6);
        }else if(v==buttonH){runGame(7);
        }else if(v==buttonI){runGame(8);
        }else if(v==buttonJ){runGame(9);
        }else if(v==buttonK){runGame(10);
        }else if(v==buttonL){runGame(11);
        }else if(v==buttonM){runGame(12);
        }else if(v==buttonN){runGame(13);
        }else if(v==buttonO){runGame(14);
        }else if(v==buttonP){runGame(15);
        }else if(v==buttonQ){runGame(16);
        }else if(v==buttonR){runGame(17);
        }else if(v==buttonS){runGame(18);
        }else if(v==buttonT){runGame(19);
        }else if(v==buttonU){runGame(20);
        }else if(v==buttonV){runGame(21);
        }else if(v==buttonW){runGame(22);
        }else if(v==buttonX){runGame(23);
        }else if(v==buttonY){runGame(24);
        }else if(v==buttonZ){runGame(25);
        }else if(v==buttonÆ){runGame(26);
        }else if(v==buttonØ){runGame(27);
        }else if(v==buttonÅ){runGame(28);}

    }
}
