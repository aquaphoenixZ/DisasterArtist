package com.DisasterArtist.disaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.DisasterArtist.disaster.core.OnPromptPanicDialog;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, OnPromptPanicDialog, View.OnClickListener
{

    private ImageButton mainPanicButton;
    private ImageButton menuPanicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Panic Button Behaviour
        mainPanicButton = findViewById(R.id.main_panic_button);
        mainPanicButton.setOnClickListener(this);

        menuPanicButton = findViewById(R.id.menu_panic_button);
        menuPanicButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.main_panic_button:
            case R.id.menu_panic_button:
                openPanicDialog();
                openPanicSnack(v);break;

        }
    }

    public void openPanicDialog(){
        Log.d("Test","Dialog opened");
        PanicDialog dialog = new PanicDialog();
        dialog.show(getSupportFragmentManager(),"PanicDialog");
    }

    public void openPanicSnack(View view){
        //TODO implement snackbar
          Snackbar.make(view, "Panic Button Triggered", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed(){
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen((GravityCompat.START))) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        int id = item.getItemId();
        switch(id){
            case R.id.nav_news:
                Toast.makeText(this, "News", Toast.LENGTH_SHORT).show();
                Intent news = new Intent(this, NewsActivity.class);
                startActivity(news);
                break;
            case R.id.nav_home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.sorry_face:
                Toast.makeText(this, "yo tambien", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){

        onOptionsItemSelected(item);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void submitPanicInfo(String name, String address, String phone) {
        //TODO Implement panic button functionality
        Toast.makeText(this, "Panic Info Set", Toast.LENGTH_SHORT).show();
    }


}



