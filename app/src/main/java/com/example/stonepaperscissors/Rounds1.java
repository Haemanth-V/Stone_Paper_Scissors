package com.example.stonepaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class Rounds1 extends AppCompatActivity {
    private int rounds,choicePlayer,choiceComp,win;
    private String playerName;
    public static final String PLAYER_CHOICE = "com.example.stonepaperscissors.PLAYER'S CHOICE" ;
    public static final String COMP_CHOICE = "com.example.stonepaperscissors.COMPUTER'S CHOICE";
    public static final String WINNER = "com.example.stonepaperscissors.WINNER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounds1);
        Intent intent = getIntent();
        rounds = intent.getIntExtra(Player1.NUM_ROUNDS,5);
        playerName = intent.getStringExtra(Player1.MSGP);
        Random random = new Random();
        choiceComp = random.nextInt(3);
    }
    public void stone(View view){
        choicePlayer=0;
        onePlayerResult();
    }
    public void paper(View view){
        choicePlayer=1;
        onePlayerResult();
    }
    public void scissor(View view){
        choicePlayer=2;
        onePlayerResult();
    }
    private void findWinner(){
        switch(choicePlayer){
            case 0 : switch(choiceComp){
                case 0 : win=0;
                    break;
                case 1 : win=2;
                    break;
                default :win=1;
            }
                break;
            case 1 : switch(choiceComp){
                case 0 : win=1;
                    break;
                case 1 : win=0;
                    break;
                default :win=2;
            }
                break;
            default : switch(choiceComp){
                case 0 : win=2;
                    break;
                case 1 : win=1;
                    break;
                default :win=0;
            }

        }
    }

    private void onePlayerResult(){
        findWinner();
        Intent intent = new Intent(Rounds1.this,Result1.class);
        intent.putExtra(Player1.NUM_ROUNDS,rounds);
        intent.putExtra(Player1.MSGP,playerName);
        intent.putExtra(PLAYER_CHOICE,choicePlayer);
        intent.putExtra(COMP_CHOICE,choiceComp);
        intent.putExtra(WINNER,win);
        startActivity(intent);
        finish();
    }
}

