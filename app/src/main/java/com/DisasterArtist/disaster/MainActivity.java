package com.DisasterArtist.disaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
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

import static com.DisasterArtist.disaster.DisasterApp.CHANNEL_WEATHER_ID;

import java.io.File;
import java.security.Policy;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, OnPromptPanicDialog, View.OnClickListener
{

    private ImageButton mainPanicButton;
    private ImageButton menuPanicButton;
    private Switch darkModeSwitch;
    private NotificationManagerCompat notificationManager;
    private JSONObject weather = new JSONObject();
    private JSONObject weatherLocation = new JSONObject();
    private final String spinnerOptions[] =
            {"Select", "Calculator", "Camera", "Compass", "Flashlight", "Notes", "Recorder"};
    public static final String CALCULATOR_PACKAGE ="com.android.calculator2";
    public static final String CALCULATOR_CLASS ="com.android.calculator2.Calculator";
    public static final int ACTIVITY_RECORD_SOUND = 0;
    //public static Camera cam = null;
    private boolean flashlightOn = false;


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

        //Notification manager
        notificationManager = NotificationManagerCompat.from(this);

        //Tools Spinner
        final Spinner spinner = (Spinner) navigationView.getMenu().findItem(R.id.nav_tools).getActionView();
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerOptions));
        setSpinnerOnItemSelected(spinner);
    }

    private void setSpinnerOnItemSelected(final Spinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        //Calculator
                        Intent calculatorIntent = new Intent();
                        calculatorIntent.setAction(Intent.ACTION_MAIN);
                        calculatorIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                        calculatorIntent.setComponent(new ComponentName( CALCULATOR_PACKAGE, CALCULATOR_CLASS));
                        startActivity(calculatorIntent);
                        break;
                    case 2:
                        //Camera
                        Intent cameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                        startActivity(cameraIntent);
                        break;
                    case 3:
                        //TODO IMPLEMENT COMPASS
                        Toast.makeText(MainActivity.this, "Not Implemented", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        //Flashlight
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            try {
                                CameraManager camManager = (CameraManager) getSystemService(CAMERA_SERVICE);
                                String cameraId = null;
                                cameraId = camManager.getCameraIdList()[0];
                                changeFlashlightStatus();
                                camManager.setTorchMode(cameraId, flashlightOn);
                                spinner.setSelection(0);
                            } catch (CameraAccessException e) {
                                e.printStackTrace();
                            }
                            catch (IllegalArgumentException ie){
                                ie.printStackTrace();
                                Toast.makeText(MainActivity.this,
                                        "No Flashlight Available", Toast.LENGTH_SHORT).show();
                            }
                        }
                        break;
                    case 5:
                        //TODO IMPLEMENT NOTES
                        Toast.makeText(MainActivity.this, "Not Implemented Either", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        //Recorder
                        Intent recorderIntent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
                        startActivityForResult(recorderIntent, ACTIVITY_RECORD_SOUND);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void changeFlashlightStatus(){
        flashlightOn = !flashlightOn;
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
            case R.id.nav_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
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

            String weatherNotDesc = locationTxt.getText() + ", " + temperature.getText();
            sendWeatherNotification(weatherText.getText().toString(), weatherNotDesc);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //Weather Notification
    private void sendWeatherNotification(String title, String message){
        Notification weatherNotification = new NotificationCompat.Builder(this, CHANNEL_WEATHER_ID)
                .setSmallIcon(R.drawable.disasterlogo)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_STATUS).build();

        notificationManager.notify(1, weatherNotification);
    }

}



