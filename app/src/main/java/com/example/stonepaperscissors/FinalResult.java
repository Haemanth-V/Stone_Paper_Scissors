package com.example.stonepaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalResult extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        Intent intent = getIntent();
        int p1Scores = intent.getIntExtra(Result.SCORES1,0);
        int p2Scores = intent.getIntExtra(Result.SCORES2,0);
        String p1Name = intent.getStringExtra(Player2.MSGP1);
        String p2Name =  intent.getStringExtra(Player2.MSGP2);
        String winner = "Draw!";
        if(p1Scores>p2Scores)
            winner = p1Name + " Wins!";
        else if(p1Scores<p2Scores)
            winner = p2Name + " Wins!";
        textView = (TextView)findViewById(R.id.textViewFinalWinner);
        textView.setText(winner);
        textView = (TextView)findViewById(R.id.textViewP1FinalScores);
        String score;
        if(p1Name.charAt(p1Name.length()-1)!='s'&&p1Name.charAt(p1Name.length()-1)!='S')
            score = p1Name + "'s Score : ";
        else
            score = p1Name + "' Score : ";
        score = score + p1Scores;
        textView.setText(score);
        textView = (TextView)findViewById(R.id.textViewP2FinalScores);
        if(p2Name.charAt(p2Name.length()-1)!='s'&&p2Name.charAt(p2Name.length()-1)!='S')
            score = p2Name + "'s Score : ";
        else
            score = p2Name + "' Score : ";
        score = score + p2Scores;
        textView.setText(score);
    }

    public void exit(View view){
        Intent intent = new Intent(FinalResult.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
