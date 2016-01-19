package com.example.juste.hangedman_game_v2;

import java.util.ArrayList;

/**
 * Created by Juste on 19-01-2016.
 */
public class UserLogic {
    private String name;
    private int score;


    public UserLogic() {}

    public String getName(){
        return name;
    }
    public int getScore(){return score;}
    public String toString(){
        return "name = "+ name + " score = " + score;
    }

}
