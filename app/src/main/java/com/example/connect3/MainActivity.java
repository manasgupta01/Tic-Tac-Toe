package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //red = 1 and blue = 0;
    int activePlayer = 0;
    boolean gameIsActive=true;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{3,4,5},{0,1,2},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        public void dropIn(View view){

            ImageView counter = (ImageView) view;

            //counter.getTag().toString();

            int tappedCounter = Integer.parseInt(counter.getTag().toString());
            if(gameState[tappedCounter]==2 && gameIsActive) {

                gameState[tappedCounter]=activePlayer;

                counter.setTranslationY(-1000f);

                if (activePlayer == 0) {

                    counter.setImageResource(R.drawable.blue);
                    activePlayer = 1;

                } else {
                    counter.setImageResource(R.drawable.red);
                    activePlayer = 0;

                }
                counter.animate().translationYBy(1000f).setDuration(300);
                for(int[]winningPosition : winningPositions){
                    if(gameState[winningPosition[0]]==gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]]==gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]]!=2){
                        gameIsActive=false;
                        String winner = "RED";

                        if(gameState[winningPosition[0]]==0){
                            winner="BLUE";
                        }
                        //someone has won
                        TextView winnerMessage = (TextView)findViewById(R.id.winnerMessage);
                        winnerMessage.setText( winner+" has won!");
                        LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
                        playAgainLayout.setVisibility(View.VISIBLE);
                        playAgainLayout.setBackgroundColor(Color.parseColor("#FF0000"));
                        if(gameState[winningPosition[0]]==0){
                            playAgainLayout.setBackgroundColor(Color.parseColor("#0000FF"));
                        }

                    }
                    else{
                        boolean gameIsOver=true;
                        for(int counterState =0;counterState<9;counterState++){
                            if(gameState[counterState]==2) {
                                gameIsOver = false;
                            }
                            }
                            if(gameIsOver){

                                TextView winnerMessage = (TextView)findViewById(R.id.winnerMessage);
                                winnerMessage.setText("Its a DRAW");
                                LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
                                playAgainLayout.setBackgroundColor(Color.parseColor("#808080"));
                                playAgainLayout.setVisibility(View.VISIBLE);
                            }


                    }


                }
            }
        }

        public void playAgain(View v){
            gameIsActive=true;
            LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
            playAgainLayout.setVisibility(View.INVISIBLE);
            int activePlayer = 0;

            Arrays.fill(gameState, 2);
            ImageView imageView4=(ImageView) findViewById(R.id.imageView4);
            ImageView imageView5=(ImageView) findViewById(R.id.imageView5);
            ImageView imageView6=(ImageView) findViewById(R.id.imageView6);
            ImageView imageView7=(ImageView) findViewById(R.id.imageView7);
            ImageView imageView8=(ImageView) findViewById(R.id.imageView8);
            ImageView imageView9=(ImageView) findViewById(R.id.imageView9);
            ImageView imageView10=(ImageView) findViewById(R.id.imageView10);
            ImageView imageView11=(ImageView) findViewById(R.id.imageView11);
            ImageView imageView12=(ImageView) findViewById(R.id.imageView12);
            imageView4.setImageResource(0);
            imageView5.setImageResource(0);
            imageView6.setImageResource(0);
            imageView7.setImageResource(0);
            imageView8.setImageResource(0);
            imageView9.setImageResource(0);
            imageView10.setImageResource(0);
            imageView11.setImageResource(0);
            imageView12.setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}