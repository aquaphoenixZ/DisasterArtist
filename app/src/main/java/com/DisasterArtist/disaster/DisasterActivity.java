package com.DisasterArtist.disaster;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.DisasterArtist.disaster.core.ui.main.SectionsPagerAdapter;

public class DisasterActivity extends MainActivity  {

    //Will get the information of the disaster clicked
    int disasterStarter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster);
        //Gets the type of disaster
        disasterStarter = getIntent().getIntExtra("KEY_DISASTER", R.string.app_name);
        //Sets toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(disasterStarter);
        setSupportActionBar(toolbar);
        //Panic button function
        findViewById(R.id.main_panic_button).setOnClickListener(this);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        //Send disaster information to disaster tips and checklist fragments
        /*Bundle bundle = new Bundle();
        bundle.putInt("KEY_DISASTER", disasterStarter);
        Fragment tipsFragment = (TipsFrag) new TipsFrag();
        Fragment checkFragment = (CheckListFrag) new CheckListFrag();
        tipsFragment.setArguments(bundle);
        checkFragment.setArguments(bundle);*/


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        menu.findItem(R.id.nav_home).setVisible(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

}