package com.example.stonepaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FinalResult1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result1);
        Intent intent = getIntent();
        String pName = intent.getStringExtra(Player1.MSGP);
        int score = intent.getIntExtra("SCORES",0);
        int scoreC = intent.getIntExtra("COMP Scores",0);
        int rounds = intent.getIntExtra("Rounds",0);
        RelativeLayout bgColour = (RelativeLayout)findViewById(R.id.finalScreen);
        TextView txtView = (TextView)findViewById(R.id.textViewFinalWinnerP1);
        String res;
        if(score>scoreC){
            res = pName + " WINS!";
            bgColour.setBackgroundColor(Color.GREEN);
        }
        else if(score<scoreC){
            res = pName + " LOSES!";
            bgColour.setBackgroundColor(Color.RED);
        }
        else {
            res = "DRAW!";
            bgColour.setBackgroundColor(Color.YELLOW);
        }
        txtView.setText(res);
        txtView = (TextView)findViewById(R.id.textViewFinalScoresPlayer);
        res = pName;
        if (pName.charAt(pName.length() - 1) != 's' && pName.charAt(pName.length() - 1) != 'S')
            res = res + "'s Score : ";
        else
            res = res + "' Score : ";
        res = res + score;
        txtView.setText(res);
        txtView = (TextView)findViewById(R.id.textViewFinalRounds);
        rounds--;
        res = "Number of Rounds : "+rounds;
        txtView.setText(res);
    }
    public void exit1(View view){
        Intent intent = new Intent(FinalResult1.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
