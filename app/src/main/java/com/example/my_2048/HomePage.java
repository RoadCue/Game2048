package com.example.my_2048;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

public class HomePage extends Activity implements View.OnClickListener {

    private Button startGame,rankList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        find();
    }
    private void find(){
        startGame=findViewById(R.id.startGame);
        rankList=findViewById(R.id.rankList);

        startGame.setOnClickListener(this);
        rankList.setOnClickListener(this);
    }
    public int getBestScore(){
        return getPreferences(MODE_PRIVATE).getInt("bestScore", 0);
    }
    private String str="您的历史最高分数为"+String.valueOf(10)+"分!";

    public void onClick(View view){
        int id=view.getId();
        if(id==R.id.startGame){
            Toast.makeText(this,"欢迎进入2048游戏!轻划屏幕以开始游戏！",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this, MainActivity.class);
            startActivity(i);
        } else if(id==R.id.rankList){
            Toast.makeText(this,"抱歉，该功能尚未完善!",Toast.LENGTH_SHORT).show();
        }
    }
}