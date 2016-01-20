package com.example.juste.hangedman_game_v2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Konstantin on 20-01-2016.
 */
public class Fragment_GameWon extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View wonFragmentView = inflater.inflate(R.layout.fragment_game_won, container, false);
        return wonFragmentView;
    }
}