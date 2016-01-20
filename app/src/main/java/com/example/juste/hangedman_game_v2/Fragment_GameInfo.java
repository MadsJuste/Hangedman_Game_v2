package com.example.juste.hangedman_game_v2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Konstantin on 20-01-2016.
 */



public class Fragment_GameInfo extends Fragment {
    ImageView imgLost;
    HangedmanLogic logic = new HangedmanLogic();
    OnInfoListener iCallBack;

    // Interface til callback kommunikation til fragmentet
    public interface OnInfoListener{
        public void onInfoActive(boolean aktiv);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Sikrer at aktiviteten der skal callbackes fra har implementeret interface
        try{
            iCallBack = (OnInfoListener) getActivity();
        }
        catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " skal implementere OnInfoListener");
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        // Når fragmentet bliver aktivt nulstilles views igen for at sikre de er i start position


        iCallBack.onInfoActive(true);
    }

    @Override
    public void onPause(){
        super.onPause();
        // Når fragmentet bliver sat på pause nulstilles de views der er i det

        iCallBack.onInfoActive(false);
    }

    // Tilføjer View og binder fragmentets view containers til deres respektive id
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View infoFragmentView = inflater.inflate(R.layout.fragment_game_lost, container, false);
        imgLost = (ImageView) infoFragmentView.findViewById(R.id.imgLost);

        return infoFragmentView;
    }


    // Metode til fragmentcontroller for at styre billeder baseret på antal forkerte gæt
    public void setImage(){


        }

    }

