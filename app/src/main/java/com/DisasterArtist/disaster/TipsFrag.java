package com.DisasterArtist.disaster;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.DisasterArtist.disaster.disasterClasses.AndroidDisaster;
import com.DisasterArtist.disaster.disasterClasses.DisasterParent;
import com.DisasterArtist.disaster.disasterClasses.EarthquakeDisaster;
import com.DisasterArtist.disaster.disasterClasses.FireDisaster;
import com.DisasterArtist.disaster.disasterClasses.FloodDisaster;
import com.DisasterArtist.disaster.disasterClasses.LandslideDisaster;
import com.DisasterArtist.disaster.disasterClasses.NuclearDisaster;
import com.DisasterArtist.disaster.disasterClasses.PandemicDisaster;
import com.DisasterArtist.disaster.disasterClasses.Thunderstorm;

public class TipsFrag extends Fragment{


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.disaster_tips_layout, container, false);

        DisasterActivity  disasterActivity = (DisasterActivity) getActivity();

        int disasterArgs = disasterActivity.disasterStarter;

       switch (disasterArgs){
           case R.string.flood_txt: floodTips(root); break;
           case R.string.fire_txt: fireTips(root); break;
           case R.string.thunderstorm_txt: thunderTips(root); break;
           case R.string.earthquake_txt: earthquakeTips(root); break;
           case R.string.nuclear_txt: nuclearTips(root); break;
           case R.string.landslide_txt: slideTips(root); break;
           case R.string.pandemic_txt: pandemicTips(root); break;
           case R.string.android_txt: androidTips(root); break;
       }

        return root;
    }

    private void androidTips(View v) {
        ListView androidTip = v.findViewById(R.id.tipsListView);
        AndroidDisaster fd = new AndroidDisaster();

        ImageView androidImage = v.findViewById(R.id.disaster_image);
        androidImage.setImageResource(R.drawable.vanier_android);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

       androidTip.setAdapter(listAdapter);
    }

    private void pandemicTips(View v) {
        ListView pandemic = v.findViewById(R.id.tipsListView);
        PandemicDisaster fd = new PandemicDisaster();

        ImageView pandemicImage = v.findViewById(R.id.disaster_image);
        pandemicImage.setImageResource(R.drawable.pandemic);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        pandemic.setAdapter(listAdapter);
    }

    private void slideTips(View v) {
        ListView slideTipsList = v.findViewById(R.id.tipsListView);
        LandslideDisaster fd = new LandslideDisaster();

        ImageView slideImage = v.findViewById(R.id.disaster_image);
        slideImage.setImageResource(R.drawable.landsilepic);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        slideTipsList.setAdapter(listAdapter);
    }

    private void nuclearTips(View v) {
        ListView nuclearTipsList = v.findViewById(R.id.tipsListView);
        NuclearDisaster fd = new NuclearDisaster();

        ImageView nuclearImage = v.findViewById(R.id.disaster_image);
        nuclearImage.setImageResource(R.drawable.nuklear);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        nuclearTipsList.setAdapter(listAdapter);
    }

    private void earthquakeTips(View v) {
        ListView quakeTipsList = v.findViewById(R.id.tipsListView);
        EarthquakeDisaster fd = new EarthquakeDisaster();

        ImageView quakeImage = v.findViewById(R.id.disaster_image);
        quakeImage.setImageResource(R.drawable.quake);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        quakeTipsList.setAdapter(listAdapter);
    }

    private void thunderTips(View v) {
        ListView thunderTipsList = v.findViewById(R.id.tipsListView);
        Thunderstorm fd = new Thunderstorm();

        ImageView thunderImage = v.findViewById(R.id.disaster_image);
        thunderImage.setImageResource(R.drawable.thunderstorm);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        thunderTipsList.setAdapter(listAdapter);
    }

    public void fireTips(View v){

        //TODO This is dummy information
        ListView fireTipsList = v.findViewById(R.id.tipsListView);
        FireDisaster fd = new FireDisaster();

        ImageView fireImage = v.findViewById(R.id.disaster_image);
        fireImage.setImageResource(R.drawable.firewild);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        fireTipsList.setAdapter(listAdapter);
    }

    public void floodTips(View v){

        ListView floodTipsList = v.findViewById(R.id.tipsListView);
        FloodDisaster fd = new FloodDisaster();

        ImageView floodImage = v.findViewById(R.id.disaster_image);
        floodImage.setImageResource(R.drawable.floods);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        floodTipsList.setAdapter(listAdapter);

    }
}
