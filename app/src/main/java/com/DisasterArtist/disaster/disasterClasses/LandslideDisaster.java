package com.DisasterArtist.disaster.disasterClasses;

import java.util.ArrayList;

public class LandslideDisaster extends DisasterParent {
    public LandslideDisaster(){
        super();
        setDisasterType("Landslide");
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
