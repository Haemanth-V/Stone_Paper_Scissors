package com.example.stonepaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Rounds extends AppCompatActivity {
    private TextView textView;
    private int players;
    private int choice,rounds;
    private String player1,player2;
    public static final String P1_CHOICE = "com.example.stonepaperscissors.PLAYER1 CHOICE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounds);
        Intent intent = getIntent();
        rounds = intent.getIntExtra(Player2.NUM_ROUNDS,5);
        player1 = intent.getStringExtra(Player2.MSGP1);
        player2 = intent.getStringExtra(Player2.MSGP2);
        String header;
        if(player1.charAt(player1.length()-1)!='s'&&player1.charAt(player1.length()-1)!='S')
          header = player1 + "'s Turn";
        else
            header =player1 + "' Turn";
        textView = (TextView) findViewById(R.id.textViewP1);
        textView.setText(header);
    }
    public void stone(View view){
        choice=0;
        if(players==1)
            onePlayer();
        else
            twoPlayer();
    }
    public void paper(View view){
        choice=1;
        if(players==1)
            onePlayer();
        else
            twoPlayer();
    }
    public void scissor(View view){
        choice=2;
        if(players==1)
            onePlayer();
        else
            twoPlayer();
    }
    private void onePlayer(){

    }
    private void twoPlayer(){
        Intent intent = new Intent(Rounds.this,Rounds2.class);
        intent.putExtra(P1_CHOICE,choice);
        intent.putExtra(Player2.NUM_ROUNDS,rounds);
        intent.putExtra(Player2.MSGP1,player1);
        intent.putExtra(Player2.MSGP2,player2);
        startActivity(intent);
        finish();
    }
}
