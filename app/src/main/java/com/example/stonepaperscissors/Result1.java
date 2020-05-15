package com.example.stonepaperscissors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Result1 extends AppCompatActivity {
    private static int rounds = 1, playerScore = 0,compScore;
    private int win,totRounds,choiceP, choiceC;
    private String pName;
    private TextView txtView;
    private ImageView imgView;
    private RelativeLayout bgColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);
        Intent intent = getIntent();
        totRounds = intent.getIntExtra(Player1.NUM_ROUNDS, 0);
        win = intent.getIntExtra(Rounds1.WINNER, -1);
        pName = intent.getStringExtra(Player1.MSGP);
        choiceP = intent.getIntExtra(Rounds1.PLAYER_CHOICE, -1);
        choiceC = intent.getIntExtra(Rounds1.COMP_CHOICE, -1);
        txtView = (TextView) findViewById(R.id.textViewWin1);
        bgColor = (RelativeLayout) findViewById(R.id.result1Player);
        String s = "DRAW!";
        if (win == 1) {
            s = pName + " WON!";
            bgColor.setBackgroundColor(Color.GREEN);
            playerScore++;
        }
        else if (win == 2) {
            s = pName + " LOST!";
            bgColor.setBackgroundColor(Color.RED);
            compScore++;
        }
        rounds++;
        if(savedInstanceState!=null){
            playerScore = savedInstanceState.getInt("Player Scores");
            compScore = savedInstanceState.getInt("COMP Scores");
            rounds = savedInstanceState.getInt("Round");
        }
        txtView.setText(s);
        txtView = (TextView) findViewById(R.id.textViewScoreP1);
        if (win == 0) {
            s = pName;
            if (pName.charAt(pName.length() - 1) != 's' && pName.charAt(pName.length() - 1) != 'S')
                s = s + "'s Score : ";
            else
                s = s + "' Score : ";
        } else s = "Your Score : ";
        s = s + playerScore;
        txtView.setText(s);
        txtView = (TextView)findViewById(R.id.textViewP1Move);
        s = pName;
        if (pName.charAt(pName.length() - 1) != 's' && pName.charAt(pName.length() - 1) != 'S')
            s = s + "'s Move";
        else
            s = s + "' Move";
        txtView.setText(s);
        final int []imageArray={R.drawable.rock,R.drawable.paper,R.drawable.scissors};
        imgView = (ImageView)findViewById(R.id.imageView1Player);
        imgView.setImageResource(imageArray[choiceP]);
        imgView = (ImageView)findViewById(R.id.imageViewComp);
        imgView.setImageResource(imageArray[choiceC]);
        if(rounds>totRounds)
        {   Button button = (Button)findViewById(R.id.buttonCnt);
            button.setText("Finish");
        }
    }
    public void proceed(View view){
        if(rounds<=totRounds){
            Intent intent = new Intent(Result1.this,Rounds1.class);
            intent.putExtra(Player1.NUM_ROUNDS,totRounds);
            intent.putExtra(Player1.MSGP, pName);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent = new Intent(Result1.this,FinalResult1.class);
            intent.putExtra(Player1.MSGP,pName);
            intent.putExtra("SCORES",playerScore);
            intent.putExtra("Rounds",rounds);
            intent.putExtra("COMP Scores",compScore);
            startActivity(intent);
            rounds=1;
            compScore=0;
            playerScore=0;
            finish();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Player Scores",playerScore);
        outState.putInt("COMP Scores",compScore);
        outState.putInt("Round",rounds);
    }

}
