package com.example.stonepaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Rounds2 extends AppCompatActivity {
    private int choice1,choice2,win,rounds2;
    private String player1,player2;
    private TextView textView;
    public static final String P2_CHOICE = "com.example.stonepaperscissors.PLAYER2 CHOICE";
    public static final String RESULT_MSG="com.example.stonepaperscissors.RESULT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounds2);
        Intent intent = getIntent();
        choice1 = intent.getIntExtra(Rounds.P1_CHOICE,-1);
        rounds2 = intent.getIntExtra(Player2.NUM_ROUNDS,0);
        player1 = intent.getStringExtra(Player2.MSGP1);
        player2 = intent.getStringExtra(Player2.MSGP2);
        String header;
        if(player2.charAt(player2.length()-1)!='s'&&player2.charAt(player2.length()-1)!='S')
            header = player2 + "'s Turn";
        else
            header =player2 + "' Turn";
        textView = (TextView)findViewById(R.id.textViewP2);
        textView.setText(header);
    }
    public void stone2(View view){
        choice2=0;
        findWinner();
    }
    public void paper2(View view){
        choice2=1;
        findWinner();
    }
    public void scissor2(View view){
        choice2=2;
        findWinner();
    }
    private void findWinner(){
        switch(choice1){
            case 0 : switch(choice2){
                     case 0 : win=0;
                              break;
                     case 1 : win=2;
                              break;
                     default :win=1;
                     }
                     break;
            case 1 : switch(choice2){
                case 0 : win=1;
                    break;
                case 1 : win=0;
                    break;
                default :win=2;
            }
                break;
            default : switch(choice2){
                case 0 : win=2;
                    break;
                case 1 : win=1;
                    break;
                default :win=0;
            }

        }

        twoPlayerResult();
    }
    private void twoPlayerResult(){
        Intent intent = new Intent(Rounds2.this,Result.class);
        intent.putExtra(Player2.MSGP1,player1);
        intent.putExtra(Player2.MSGP2,player2);
        intent.putExtra(Player2.NUM_ROUNDS,rounds2);
        intent.putExtra(Rounds.P1_CHOICE,choice1);
        intent.putExtra(P2_CHOICE,choice2);
        intent.putExtra(RESULT_MSG,win);
        startActivity(intent);
        finish();
    }
}
