package com.DisasterArtist.disaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.DisasterArtist.disaster.core.OnPromptPanicDialog;
import com.DisasterArtist.disaster.disasterClasses.FloodDisaster;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, OnPromptPanicDialog, View.OnClickListener
{

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
   public static Context mContext;

    private ImageButton mainPanicButton;
    private ImageButton menuPanicButton;
    private ImageButton floodDisasterBtn;
    //private boolean firstTimeOpeningApp = true; // boolean to tell if the app should open the dialog or not;
   // private String[] panicInfo;  // Array containing the contact info passed from the dialog
     // intent that opens the phone app when the panic button is clicked

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

        //Flood Button Behaviour
        floodDisasterBtn = findViewById(R.id.floodImageButton);
        floodDisasterBtn.setOnClickListener(this);

        //Shared preference
        preferences = getSharedPreferences("Saved info & settings", Context.MODE_PRIVATE);
        editor = preferences.edit();

        editor.putBoolean("First time opening app", true);
        editor.apply();
         editor.putString("test","Zach");

        //Panic Dialog
        if (preferences.getBoolean("First time opening app", true)){
            editor.putBoolean("First time opening app",false);
            editor.apply();
            openPanicDialog();
        }
    }




    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.main_panic_button:
            case R.id.menu_panic_button:
                openPanicSnack(v);break;


            case R.id.floodImageButton:
                    floodDisaster(v); break;


        }
    }

    public void openPanicDialog(){
        Log.d("Test","Dialog opened");
        PanicDialog dialog = new PanicDialog();
        dialog.show(getSupportFragmentManager(),"PanicDialog");
    }

    public void openPanicSnack(View view){
        //TODO implement snackbar
          Snackbar.make(view, "Panic Button Triggered", Snackbar.LENGTH_LONG).setAction("Panic", new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent PhoneCallIntent = new Intent(Intent.ACTION_DIAL);
                  PhoneCallIntent.setData(Uri.parse("tel:"+ preferences.getString("Contact Phone number", "444444")));
                  startActivity(PhoneCallIntent);
              }
          }).show();

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

    //-- Disaster button(s) onClick views
    public void floodDisaster(View view) {
        Toast.makeText(this, "You've clicked on Flood", Toast.LENGTH_SHORT).show();
        Intent disaster = new Intent(this, DisasterActivity.class);
        disaster.putExtra("KEY_DISASTER", R.string.flood_txt);
        startActivity(disaster);
    }

    public void fireDisaster(View view) {
        Toast.makeText(this, "You've clicked on Fire", Toast.LENGTH_SHORT).show();
        Intent disaster = new Intent(this, DisasterActivity.class);
        disaster.putExtra("KEY_DISASTER", R.string.fire_txt);
        startActivity(disaster);
    }
}



