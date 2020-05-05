package com.DisasterArtist.disaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.DisasterArtist.disaster.core.OnPromptPanicDialog;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, OnPromptPanicDialog, View.OnClickListener
{

    private ImageButton mainPanicButton;
    private ImageButton menuPanicButton;
    private Switch darkModeSwitch;
    JSONObject weather = new JSONObject();
    JSONObject weatherLocation = new JSONObject();

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

        //Disasters
        findViewById(R.id.floodImageButton).setOnClickListener(this);
        findViewById(R.id.wildfireImageButton).setOnClickListener(this);
        findViewById(R.id.nuclearImageButton).setOnClickListener(this);
        findViewById(R.id.earthquakeImageButton).setOnClickListener(this);
        findViewById(R.id.thunderStormImageButton).setOnClickListener(this);
        findViewById(R.id.landslideImageButton).setOnClickListener(this);
        findViewById(R.id.pandemicImageButton).setOnClickListener(this);
        findViewById(R.id.androidH20ImageButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.main_panic_button:
            case R.id.menu_panic_button:
                openPanicDialog();
                openPanicSnack(v);break;
            case R.id.floodImageButton:
                floodDisaster(v); break;
            case R.id.wildfireImageButton:
                fireDisaster(v); break;
            case R.id.thunderStormImageButton:
                thunderDisaster(v); break;
            case R.id.nuclearImageButton:
                nuclearDisaster(v); break;
            case R.id.earthquakeImageButton:
                earthDisaster(v); break;
            case R.id.pandemicImageButton:
                pandemicDisaster(v); break;
            case R.id.landslideImageButton:
                landslideDisaster(v); break;
            case R.id.androidH20ImageButton:
                androidDisaster(v); break;
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
        //DarkModeSwitch
        darkModeSwitch = findViewById(R.id.switchDarkMode);

        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                        lightMode();
                    else
                        darkMode();
                }
            }
        });

        weatherLocationSet();
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
            case R.id.dark_mode_switch:
                darkModeSwitch.setChecked(true);
                break;
        }

        return true;
    }

    public void darkMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    public void lightMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
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
        Toast.makeText(this, "Flood Disaster", Toast.LENGTH_SHORT).show();
        Intent disaster = new Intent(this, DisasterActivity.class);
        disaster.putExtra("KEY_DISASTER", R.string.flood_txt);
        startActivity(disaster);
    }

    public void fireDisaster(View view) {
        Toast.makeText(this, "Fire Disaster", Toast.LENGTH_SHORT).show();
        Intent disaster = new Intent(this, DisasterActivity.class);
        disaster.putExtra("KEY_DISASTER", R.string.fire_txt);
        startActivity(disaster);
    }

    private void thunderDisaster(View v) {
        Toast.makeText(this, "Thunderstorm", Toast.LENGTH_SHORT).show();
        Intent disaster = new Intent(this, DisasterActivity.class);
        disaster.putExtra("KEY_DISASTER", R.string.thunderstorm_txt);
        startActivity(disaster);
    }

    private void nuclearDisaster(View v) {
        Toast.makeText(this, "Nuclear Disaster", Toast.LENGTH_SHORT).show();
        Intent disaster = new Intent(this, DisasterActivity.class);
        disaster.putExtra("KEY_DISASTER", R.string.nuclear_txt);
        startActivity(disaster);
    }

    private void androidDisaster(View v) {
        Toast.makeText(this, "Android Disaster", Toast.LENGTH_SHORT).show();
        Intent disaster = new Intent(this, DisasterActivity.class);
        disaster.putExtra("KEY_DISASTER", R.string.android_txt);
        startActivity(disaster);
    }

    private void landslideDisaster(View v) {
        Toast.makeText(this, "Landslide", Toast.LENGTH_SHORT).show();
        Intent disaster = new Intent(this, DisasterActivity.class);
        disaster.putExtra("KEY_DISASTER", R.string.landslide_txt);
        startActivity(disaster);
    }

    private void pandemicDisaster(View v) {
        Toast.makeText(this, "Pandemic", Toast.LENGTH_SHORT).show();
        Intent disaster = new Intent(this, DisasterActivity.class);
        disaster.putExtra("KEY_DISASTER", R.string.pandemic_txt);
        startActivity(disaster);
    }

    private void earthDisaster(View v) {
        Toast.makeText(this, "Earthquake", Toast.LENGTH_SHORT).show();
        Intent disaster = new Intent(this, DisasterActivity.class);
        disaster.putExtra("KEY_DISASTER", R.string.earthquake_txt);
        startActivity(disaster);
    }

    //Filling Weather Api
    public void weatherLocationSet(){
        RequestQueue reqQueue = Volley.newRequestQueue(this);
        String city = "Montreal";
        String weatherUrl =
                "http://api.weatherstack.com/current?access_key=4fa748ce0b77a7e272b9b716d4173d64&query="
                + city;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, weatherUrl, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            weather = response.getJSONObject("current");
                            weatherLocation = response.getJSONObject("location");
                            setWeatherLocationViews(weather, weatherLocation);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.getCause();
                        error.getStackTrace();
                        Log.e("RESPONSE ERROR", error.getMessage());
                    }
                });
        reqQueue.add(jsonObjectRequest);
    }

    public void setWeatherLocationViews(JSONObject weather, JSONObject location){
        final TextView locationTxt = findViewById(R.id.locationTextView);
        final TextView weatherText = findViewById(R.id.weatherTextView);
        final TextView temperature = findViewById(R.id.temperatureView);
        final ImageView weatherIcon = findViewById(R.id.weatherIcon);

        try {
            locationTxt.setText(location.getString("name"));
            temperature.setText(weather.getString("temperature") + "°C");
            weatherText.setText(weather.getJSONArray("weather_descriptions").get(0).toString());
            if(weather.getString("weather_icons").length() != 0)
                Picasso.with(weatherIcon.getContext()).load(weather.getJSONArray("weather_icons").get(0).toString()).
                        into(weatherIcon);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}



