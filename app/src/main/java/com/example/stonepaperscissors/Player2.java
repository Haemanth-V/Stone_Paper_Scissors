package com.example.stonepaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Player2 extends AppCompatActivity {
    public static final String MSGP1 = "com.example.stonepaperscissors.PLAYER1";
    public static final String MSGP2 = "com.example.stonepaperscissors.PLAYER2";
    public static final String NUM_ROUNDS = "com.example.stonepaperscissors.NUMBER OF ROUNDS";
    public static final String NUM_PLAYERS = "com.example.stonepaperscissors.NUMBER OF PLAYERS";
    public String player1, player2;
    private EditText editText;
    private Button button;
    private int round;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2);
        Intent intent = getIntent();
       }
        public void proceedTwoPlayer(View view) {
        int p1=1,p2=1,r=1,equal=0;
        editText=(EditText)findViewById(R.id.editTextName1);
        player1 = editText.getText().toString().trim();
        if (TextUtils.isEmpty(player1)) {
            p1=0;
            String s = "Enter a name for Player 1!";
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        }
        editText=(EditText)findViewById(R.id.editTextName2);
        player2 = editText.getText().toString().trim();
        if (TextUtils.isEmpty(player2)) {
            p2=0;
            String s = "Enter a name for Player 2!";
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        }
        if(player1.equals(player2)){
            equal=1;
            String s = "Enter different names for the 2 Players";
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        }
        editText=(EditText)findViewById(R.id.editTextRounds);
        String t = editText.getText().toString().trim();
        if(TextUtils.isEmpty(t))
        {   r=0;
            String s = "Enter a number for Number of Rounds";
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        }
        else {
            round = Integer.parseInt(t);
            if (round <= 0) {
                r = 0;
                String s = "Enter a positive number for Number of Rounds";
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
        }
        if(p1==1 && p2==1 && r==1 && equal==0){
            Intent intent = new Intent(Player2.this, Rounds.class);
            intent.putExtra(NUM_ROUNDS,round);
            intent.putExtra(MSGP1, player1);
            intent.putExtra(MSGP2,player2);
            startActivity(intent);
            finish();
        }
    }

}