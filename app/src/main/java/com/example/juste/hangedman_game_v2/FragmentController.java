package com.example.juste.hangedman_game_v2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Konstantin on 20-01-2016.
 */


public class FragmentController extends ActionBarActivity implements Fragment_GameInfo.OnInfoListener {
    ArrayList<String> usedLetters = new ArrayList<String>();
    HangedmanLogic logic = new HangedmanLogic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_controller);

        // Sikre at der ikke laves flere Activities ovenpå denne af samme type
        if(savedInstanceState != null){
            return;
        }

        opStart();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
      //  getSupportActionBar().setLogo(R.drawable.hangman_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Instantier gameinfo fragmentet
        Fragment_GameInfo fragment_gameinfo = new Fragment_GameInfo();

        // Tilføj de instantierede fragmenter til fragmentmanager
        getSupportFragmentManager().beginTransaction()

                .add(R.id.fragment_game_lost, fragment_gameinfo)
                .commit();
    }


    public void lostGame() {
        if (logic.isTheGameLost()) {

            // Nulstiller spillet
            logic.refresh();
            usedLetters.clear();

            // Instantierer gamelost fragmentet
            Fragment_GameLost fragment_gamelost = new Fragment_GameLost();

            // Tilføjer gamelost til fragmentmanager
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_game_lost, fragment_gamelost)
                    .commit();


        }
    }




    // Henter listen af ord fra Galgelogik
    public ArrayList<String> getDrWords() {
        return logic.getpossibleWord();
    }

    // En asynkron metode til at hente ord fra DR i baggrunden
    private void opStart(){
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object... arg0) {
                try {
                    logic.getWordFromDR();
                    return "Ordene blev korrekt hentet fra DR's server";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Ordene blev ikke hentet korrekt: "+e;
                }
            }

            @Override
            protected void onPostExecute(Object resultat) {
                //info.setText("resultat: \n" + resultat.toString());
                // Sætter stjerner på ordet der skal gættes.
                Log.d("Ord der gættes på: ", logic.getWord());
            }
        }.execute();
    }

    @Override
    public void onInfoActive(boolean aktiv) {
        // Tænder og slukker for gameguess knap og tekstfelt
        if(aktiv){

            Fragment_GameInfo infoFragment = (Fragment_GameInfo)
                    getSupportFragmentManager().findFragmentById(R.id.fragment_game_lost);


        }
        else{
            System.out.println ("WTF");

        }
    }




    public interface OnClickListener {
    }
}
