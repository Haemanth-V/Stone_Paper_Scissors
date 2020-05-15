package com.example.stonepaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Player1 extends AppCompatActivity {
    private EditText editText;
    private String player;
    public static final String MSGP = "com.example.stonepaperscissors.PLAYER";
    public static final String NUM_ROUNDS = "com.example.stonepaperscissors.NUMBER OF ROUNDS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player1);
    }

    public void proceedOnePlayer(View view) {
        int p = 1, r = 1, rounds = 0;
        editText = (EditText) findViewById(R.id.editTextName1P1);
        player = editText.getText().toString().trim();
        if (TextUtils.isEmpty(player)) {
            p = 0;
            String s = "Enter the Player's Name";
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        }
        editText = (EditText) findViewById(R.id.editTextRoundsP1);
        String t = editText.getText().toString().trim();
        if (TextUtils.isEmpty(t)) {
            r = 0;
            String s = "Enter a number for Number of Rounds";
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        } else {
            rounds = Integer.parseInt(t);
            if (rounds <= 0) {
                r = 0;
                String s = "Enter a positive number for Number of Rounds";
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
        }
        if (p == 1 && r == 1) {
            Intent intent = new Intent(Player1.this, Rounds1.class);
            intent.putExtra(NUM_ROUNDS, rounds);
            intent.putExtra(MSGP, player);
            startActivity(intent);
            finish();
        }
    }
}
