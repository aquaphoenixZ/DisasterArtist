package com.DisasterArtist.disaster.disasterClasses;

import java.util.ArrayList;

public class EarthquakeDisaster extends DisasterParent {
    public EarthquakeDisaster(){
        super();
        setDisasterType("Earthquake");
        setDisasterTips(populateTips());
        setDisasterCheckList(populateCheckList());
    }

    public ArrayList<String> populateTips(){
        //TODO Populate all the tips

        ArrayList<String> tips = new ArrayList<>();


        return tips;
    }

    public ArrayList<String> populateCheckList(){
        //TODO Populate all the checklist for flood

        ArrayList<String> checkList = new ArrayList<>();

        return checkList;
    }
}