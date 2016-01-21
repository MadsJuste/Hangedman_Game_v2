package com.example.juste.hangedman_game_v2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by Konstantin on 21-01-2016.
 */
public class ListWords_Activity extends ActionBarActivity implements DR_List_Fragment.OnDRListener{

    DR_List_Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = (DR_List_Fragment) getSupportFragmentManager()
                .findFragmentById(R.id.drlisteview);
    }

    // Now we can define the action to take in the activity when the fragment event fires


    @Override
    public void onDRListener() {
       ???????????????????
        }
}