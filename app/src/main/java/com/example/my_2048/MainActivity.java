package com.example.my_2048;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    public MainActivity() {
        mainActivity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = (LinearLayout) findViewById(R.id.container2);
        root.setBackgroundColor(0xfffaf8ef);

        tvScore = (TextView) findViewById(R.id.tvScore);
        tvBestScore = (TextView) findViewById(R.id.tvBestScore);

        gameView = (Gameview) findViewById(R.id.gameView);

        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameView.startGame();
        }});

        animLayer = (AnimLayer) findViewById(R.id.animLayer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void clearScore(){
        score = 0;
        showScore();
    }

    public void showScore(){
        tvScore.setText(score+"");
    }

    public void addScore(int s){
        score+=s;
        showScore();

        int maxScore = Math.max(score, getBestScore());
        saveBestScore(maxScore);
        showBestScore(maxScore);
    }

    public void saveBestScore(int s){
        Editor e = getPreferences(MODE_PRIVATE).edit();
        e.putInt("bestScore", s);
        e.apply();
    }

    public int getBestScore(){
        return getPreferences(MODE_PRIVATE).getInt("bestScore", 0);
    }

    public void showBestScore(int s){
        tvBestScore.setText(s+"");
    }

    public AnimLayer getAnimLayer() {
        return animLayer;
    }

    private int score = 0;
    private TextView tvScore,tvBestScore;
    private LinearLayout root = null;
    private Button btnNewGame;
    private Gameview gameView;
    private AnimLayer animLayer = null;

    private static MainActivity mainActivity = null;
    public static MainActivity getMainActivity() {
        return mainActivity;
    }
}

