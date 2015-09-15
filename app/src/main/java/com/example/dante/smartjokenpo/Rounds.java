package com.example.dante.smartjokenpo;

import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Dante on 13/08/2015.
 */
public class Rounds {
    //Atributos
    private int chooseHuman;
    private int chooseProg;


    // Empty Constructor
    public Rounds(){};

    // Full Constructor
    public Rounds(int chooseHuman, int chooseProg) {
        this.chooseHuman = chooseHuman;
        this.chooseProg = chooseProg;
    }

    //gets and sets
    public void setchooseHuman(int chooseHuman){
        this.chooseHuman = chooseHuman;
    }
    public void setchooseProg(int chooseProg){
        this.chooseProg = chooseProg;
    }

    public int getchooseHuman(){
        return chooseHuman;
    }
    public int getchooseProg(){
        return chooseProg;
    }




    public String compare(){
        String message = "";


        switch(this.chooseHuman + this.chooseProg) {
            case 11:
                message = "Draw: Rock , Rock";

                break;
            case 12:
                message = "Lose: Rock , Paper";

                break;
            case 13:
                message = "Win: Rock , Scissor";

                break;
            case 21:
                message = "Win: Paper , Rock";

                break;
            case 22:
                message = "Draw: Paper , Paper";

                break;
            case 23:
                message = ("Lose: Paper , Scissor");

                break;
            case 31:
                message = "Lose: Scissor , Rock";

                break;
            case 32:
                message = "Win: Scissor , Paper";

                break;
            case 33:
                message = "Draw: Scissor , Scissor";

                break;
        }
        return message;
    }

}
