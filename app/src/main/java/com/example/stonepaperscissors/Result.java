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
import android.widget.Toast;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {
    private static int rounds=1,player1Scores=0,player2Scores=0;
    private int win,tot_rounds,choiceP1,choiceP2;
    private String player1Name,player2Name;
    private TextView textView1,textView2;
    private ImageView imageView;
    private RelativeLayout relativeLayout;
    public static final String SCORES1 = "com.example.stonepaperscissors.PLAYER 1's SCORES";
    public static final String SCORES2 = "com.example.stonepaperscissors.PLAYER 2's SCORES";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        player1Name = intent.getStringExtra(Player2.MSGP1);
        player2Name = intent.getStringExtra(Player2.MSGP2);
        win = intent.getIntExtra(Rounds2.RESULT_MSG,0);
        tot_rounds = intent.getIntExtra(Player2.NUM_ROUNDS,0);
        choiceP1 = intent.getIntExtra(Rounds.P1_CHOICE,0);
        choiceP2 = intent.getIntExtra(Rounds2.P2_CHOICE,0);
        relativeLayout = (RelativeLayout)findViewById(R.id.player1View);
        textView1 = (TextView)findViewById(R.id.textViewP1Result);
        textView2 = (TextView)findViewById(R.id.textViewP1Score);
        imageView = (ImageView)findViewById(R.id.imageViewP1);
        String p1 = "DRAW!";
        String p2 = "DRAW!";
        if(win==1) {
            p1 = player1Name + " Won";
            p2 = player2Name + " Lost";
            relativeLayout.setBackgroundColor(Color.GREEN);
            relativeLayout = (RelativeLayout)findViewById(R.id.player2View);
            relativeLayout.setBackgroundColor(Color.RED);
            player1Scores++;
        }
        else if(win==2){
            p1 = player1Name + " Lost";
            p2 = player2Name + " Won";
            relativeLayout.setBackgroundColor(Color.RED);
            relativeLayout = (RelativeLayout)findViewById(R.id.player2View);
            relativeLayout.setBackgroundColor(Color.GREEN);
            player2Scores++;
        }
        rounds++;
        if(savedInstanceState!=null){
                player1Scores = savedInstanceState.getInt("Player 1 Scores");
                player2Scores = savedInstanceState.getInt("Player 2 Scores");
                rounds = savedInstanceState.getInt("Round");
        }
        String score;
        if(win!=0)
          score = "Score : ";
        else if(player1Name.charAt(player1Name.length()-1)!='s'&&player1Name.charAt(player1Name.length()-1)!='S')
            score = player1Name + "'s Score : ";
        else
            score = player1Name + "' Score : ";
        score = score + player1Scores;
        textView1.setText(p1);
        textView1 = (TextView)findViewById(R.id.textViewP2Result);
        textView1.setText(p2);
        textView2.setText(score);
        if(win!=0)
            score = "Score : ";
        else if(player2Name.charAt(player2Name.length()-1)!='s'&&player2Name.charAt(player2Name.length()-1)!='S')
            score = player2Name + "'s Score : ";
        else
            score = player2Name + "' Score : ";
        score = score + player2Scores;
        textView2 = (TextView)findViewById(R.id.textViewP2Score);
        textView2.setText(score);
        final int []imageArray={R.drawable.rock,R.drawable.paper,R.drawable.scissors};
        imageView.setImageResource(imageArray[choiceP1]);
        imageView = (ImageView)findViewById(R.id.imageViewP2);
        imageView.setImageResource(imageArray[choiceP2]);
        if(rounds>tot_rounds)
        {   Button button = (Button)findViewById(R.id.buttonResult);
            button.setText("Finish");
        }
    }
    public void onClicking(View view){
        if(rounds<=tot_rounds){
            Intent intent = new Intent(Result.this,Rounds.class);
            intent.putExtra(Player2.NUM_ROUNDS,tot_rounds);
            intent.putExtra(Player2.MSGP1, player1Name);
            intent.putExtra(Player2.MSGP2,player2Name);
            startActivity(intent);
            finish();
        }
        else{

          Intent intent = new Intent(Result.this,FinalResult.class);
          intent.putExtra(Player2.MSGP1,player1Name);
          intent.putExtra(Player2.MSGP2,player2Name);
          intent.putExtra(SCORES1,player1Scores);
          intent.putExtra(SCORES2,player2Scores);
          startActivity(intent);
          rounds=1;
          player1Scores=0;
          player2Scores=0;
          finish();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Player 1 Scores",player1Scores);
        outState.putInt("Player 2 Scores",player2Scores);
        outState.putInt("Round",rounds);
    }

}
