package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int c=0,i,j, tc;
    int gamecon[]={2,2,2,2,2,2,2,2,2};
    boolean gameactive=true;

    public void clickIt(View view) {
        ImageView ab = (ImageView) view;
        tc = Integer.parseInt(ab.getTag().toString());
        if (gamecon[tc] == 2 && gameactive) {
            gamecon[tc] = c;
            if (c == 0) {
                ab.setImageResource(R.drawable.xcross);
                ab.animate().alpha(1f).setDuration(500);
                c = 1;
            } else {
                ab.setImageResource(R.drawable.circle);
                ab.animate().alpha(1f).setDuration(500);
                c = 0;
            }
        }
        int wincombi[][]={{0,4,8},{2,4,6},{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8}};
        for(i=0;i<8;i++) {
            if ((gamecon[wincombi[i][0]] == 0) && (gamecon[wincombi[i][1]] == 0) && (gamecon[wincombi[i][2]] == 0)) {
                displayMessage(0);
                gameactive = false;
            } else if ((gamecon[wincombi[i][0]] == 1) && (gamecon[wincombi[i][1]] == 1) && (gamecon[wincombi[i][2]] == 1)) {
                displayMessage(1);
                gameactive = false;
            }
        }
    }
    public void displayMessage(int w)
    {
        TextView win=(TextView)findViewById(R.id.winDisplay);
        if(w==0)
            win.setText("Cross Wins!!");
        else
            win.setText("Circle Wins!!");
        LinearLayout disp=(LinearLayout)findViewById(R.id.playAgainLayout);
        disp.setVisibility(View.VISIBLE);
    }
    public void playagain(View view)
    {
        gameactive=true;
        LinearLayout disp=(LinearLayout)findViewById(R.id.playAgainLayout);
        disp.setVisibility(View.INVISIBLE);
        for (int i=0;i<9;i++)
        gamecon[i]=2;
        c=0;
        ((ImageView)findViewById(R.id.iV11)).setImageResource(0);
        ((ImageView)findViewById(R.id.iV12)).setImageResource(0);
        ((ImageView)findViewById(R.id.iV13)).setImageResource(0);
        ((ImageView)findViewById(R.id.iV21)).setImageResource(0);
        ((ImageView)findViewById(R.id.iV22)).setImageResource(0);
        ((ImageView)findViewById(R.id.iV23)).setImageResource(0);
        ((ImageView)findViewById(R.id.iV31)).setImageResource(0);
        ((ImageView)findViewById(R.id.iV32)).setImageResource(0);
        ((ImageView)findViewById(R.id.iV33)).setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
