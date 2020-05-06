package com.DisasterArtist.disaster;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

public class SettingsActivity extends MainActivity {

    ListView listView;
    TextView textView;
    String[] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.setting_text);
        setSupportActionBar(toolbar);

        findViewById(R.id.main_panic_button).setOnClickListener(this);

        listView = (ListView) findViewById(R.id.settingsListView);
        textView = (TextView) findViewById(R.id.settingsTextView);
        listItems = getResources().getStringArray(R.array.settings_array);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItems);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String value = adapter.getItem(position);
                Toast.makeText(SettingsActivity.this, value, Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        openAccessibility();
                        break;
                    case 1:
                        //Panic Contact
                        openPanicDialog();
                        break;
                    case 2:
                        //Weather
                        break;
                    case 3:
                        //License
                        openLicenseDialog();
                        break;
                    case 4:
                        //About
                        openAboutDialog();
                        break;
                }
            }
        });

    }

    public void openAccessibility(){
        Intent settingsIntent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(settingsIntent);
    }

    public void openLicenseDialog(){
        AlertDialog.Builder licenseBuilder = new AlertDialog.Builder(SettingsActivity.this);
        ViewGroup licenseViewGroup = findViewById(android.R.id.content);
        View licenseDialogView = LayoutInflater.from(SettingsActivity.this).inflate(R.layout.license_layout, licenseViewGroup, false);
        licenseBuilder.setView(licenseDialogView);
        final AlertDialog licenseAlertDialog = licenseBuilder.create();

        /*Button btn = (Button) findViewById(R.id.buttonOk);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                licenseAlertDialog.dismiss();
            }
        });*/

        licenseAlertDialog.show();
    }

    public void openAboutDialog(){
        AlertDialog.Builder aboutBuilder = new AlertDialog.Builder(SettingsActivity.this);
        ViewGroup aboutViewGroup = findViewById(android.R.id.content);
        View aboutDialogView = LayoutInflater.from(SettingsActivity.this).inflate(R.layout.about_layout, aboutViewGroup, false);
        aboutBuilder.setView(aboutDialogView);
        final AlertDialog aboutAlertDialog = aboutBuilder.create();
        aboutAlertDialog.show();

        /*Button btn = (Button) findViewById(R.id.buttonOk);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                aboutAlertDialog.dismiss();
            }
        });*/
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        menu.findItem(R.id.nav_home).setVisible(true);

        return true;
    }
}