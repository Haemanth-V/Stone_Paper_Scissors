package com.example.stonepaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    public static final String EXTRA_MSG="com.example.stonepaperscissors.PLAYERS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
     public void onePlayer(View view){
         intent = new Intent(MainActivity.this, Player1.class);
         startActivity(intent);
         finish();
     }
     public void twoPlayer(View view) {
     intent = new Intent(MainActivity.this, Player2.class);
     startActivity(intent);
     finish();
    }
}