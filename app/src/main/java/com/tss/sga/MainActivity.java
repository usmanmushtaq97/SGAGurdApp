package com.tss.sga;

import static com.tss.sga.Constant.SGAPerfernce;
import static com.tss.sga.Constant.isLgoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    Intent intent;
    int checkLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences(SGAPerfernce, Context.MODE_PRIVATE);
          checkLogin = sharedPreferences.getInt(isLgoin,0);
        if (checkLogin == 1) {
            new Handler().postDelayed((Runnable) () -> {
                Intent intent = new Intent(MainActivity.this, MainHomeActivity.class);
                startActivity(intent);
            },1500);
        } else {
            new Handler().postDelayed((Runnable) () -> {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            },1500);
        }
    }
}
