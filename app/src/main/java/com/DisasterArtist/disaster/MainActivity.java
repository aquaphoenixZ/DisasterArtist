package com.DisasterArtist.disaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void showNews(View view) {
        Intent news = new Intent(MainActivity.this, NewsActivity.class );
        startActivity(news);
    }
}
