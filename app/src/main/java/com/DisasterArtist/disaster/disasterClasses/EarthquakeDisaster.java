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

        tips.add("Look for a checkpoint, usually a hospital/public establishment where people can help the victims of the earthquake.");
        tips.add("If physically able, look under the rubble, you might save a life.");
        tips.add("Hide under tables, in case the ceiling or other rubbles start falling down, a concussion can mean death.");

        return tips;
    }

    public ArrayList<String> populateCheckList(){
        //TODO Populate all the checklist for flood

        ArrayList<String> checkList = new ArrayList<>();

        checkList.add("Check if the building you are in has some form of seismic mitigation incorporated inside its structure.");
        checkList.add("Make sure to keep an eye out for seismic activity. Eartquakes Canada takes care of monitoring recent/potential earthquakes. ");
        checkList.add("Make sure you do not have valuable objects susceptible to falling and breaking during an earthquake, like vases, or plates.");

        return checkList;
    }
}
