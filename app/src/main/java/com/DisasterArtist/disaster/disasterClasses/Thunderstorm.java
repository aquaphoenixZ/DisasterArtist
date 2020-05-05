package com.DisasterArtist.disaster.disasterClasses;

import java.util.ArrayList;

public class Thunderstorm extends DisasterParent {
    public Thunderstorm(){
        super();
        setDisasterType("Thunderstorm");
        setDisasterTips(populateTips());
        setDisasterCheckList(populateCheckList());
    }

    private ArrayList<String> populateTips(){
        //TODO Populate all the tips

        ArrayList<String> tips = new ArrayList<>();


        return tips;
    }

    private ArrayList<String> populateCheckList(){
        //TODO Populate all the checklist for flood

        ArrayList<String> checkList = new ArrayList<>();

        return checkList;
    }
}
