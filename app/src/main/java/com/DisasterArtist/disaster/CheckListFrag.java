package com.DisasterArtist.disaster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.DisasterArtist.disaster.disasterClasses.AndroidDisaster;
import com.DisasterArtist.disaster.disasterClasses.EarthquakeDisaster;
import com.DisasterArtist.disaster.disasterClasses.FireDisaster;
import com.DisasterArtist.disaster.disasterClasses.FloodDisaster;
import com.DisasterArtist.disaster.disasterClasses.LandslideDisaster;
import com.DisasterArtist.disaster.disasterClasses.NuclearDisaster;
import com.DisasterArtist.disaster.disasterClasses.PandemicDisaster;
import com.DisasterArtist.disaster.disasterClasses.Thunderstorm;

public class CheckListFrag extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO For Layout needs to change ListView to Recyclerview or add custom adapter in order  to add checkbox
        View root = inflater.inflate(R.layout.disaster_checklist_layout, container, false);
        DisasterActivity  disasterActivity = (DisasterActivity) getActivity();

        int disasterArgs = disasterActivity.disasterStarter;

        switch (disasterArgs){
            case R.string.flood_txt: floodCheck(root); break;
            case R.string.fire_txt: fireCheck(root); break;
            case R.string.thunderstorm_txt: thunderCheck(root); break;
            case R.string.earthquake_txt: earthquakeCheck(root); break;
            case R.string.nuclear_txt: nuclearCheck(root); break;
            case R.string.landslide_txt: slideCheck(root); break;
            case R.string.pandemic_txt: pandemicCheck(root); break;
            case R.string.android_txt: androidCheck(root); break;
        }

        return root;

    }

    private void androidCheck(View v) {
        ListView androidCheckList = v.findViewById(R.id.checkListView);
        AndroidDisaster fd = new AndroidDisaster();

        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterCheckList() );

        androidCheckList.setAdapter(listAdapter);
    }

    private void pandemicCheck(View v) {
        ListView pandemic = v.findViewById(R.id.checkListView);
        PandemicDisaster fd = new PandemicDisaster();

        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterCheckList() );

        pandemic.setAdapter(listAdapter);
    }

    private void slideCheck(View v) {
        ListView landslide = v.findViewById(R.id.checkListView);
        LandslideDisaster fd = new LandslideDisaster();

        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterCheckList() );

        landslide.setAdapter(listAdapter);
    }

    private void nuclearCheck(View v) {
        ListView nuclear = v.findViewById(R.id.checkListView);
        NuclearDisaster fd = new NuclearDisaster();

        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterCheckList() );

        nuclear.setAdapter(listAdapter);
    }

    private void earthquakeCheck(View v) {
        ListView earthquake = v.findViewById(R.id.checkListView);
        EarthquakeDisaster fd = new EarthquakeDisaster();

        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterCheckList() );

        earthquake.setAdapter(listAdapter);
    }

    private void thunderCheck(View v) {
        ListView thunder = v.findViewById(R.id.checkListView);
        Thunderstorm fd = new Thunderstorm();

        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterCheckList() );

        thunder.setAdapter(listAdapter);
    }

    public void fireCheck(View v){
        //TODO This is dummy information
        ListView fireCheckList = v.findViewById(R.id.checkListView);
        FireDisaster fd = new FireDisaster();

        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterCheckList() );

        fireCheckList.setAdapter(listAdapter);

    }

    public void floodCheck(View v){

        ListView floodCheckList = v.findViewById(R.id.checkListView);
        FloodDisaster fd = new FloodDisaster();

        ArrayAdapter<String>listAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterCheckList() );

        floodCheckList.setAdapter(listAdapter);

    }

}
