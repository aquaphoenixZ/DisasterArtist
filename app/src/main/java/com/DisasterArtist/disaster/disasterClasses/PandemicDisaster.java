package com.DisasterArtist.disaster.disasterClasses;

import java.util.ArrayList;

public class PandemicDisaster extends DisasterParent {
    public PandemicDisaster(){
        super();
        setDisasterType("Pandemic");
        setDisasterTips(populateTips());
        setDisasterCheckList(populateCheckList());
    }

    public ArrayList<String> populateTips(){
        //TODO Populate all the tips

        ArrayList<String> tips = new ArrayList<>();


        tips.add("Avoid contact with the infected.");
        tips.add("Regularly check for symptoms, if the symptoms match, call 911/go to a hospital");
        tips.add("Avoid large gatherings of people, it makes diseases spread like wildfire.");

        return tips;
    }

    public ArrayList<String> populateCheckList(){
        //TODO Populate all the checklist for flood

        ArrayList<String> checkList = new ArrayList<>();

        checkList.add("Make sure you have all your vaccine shots.");
        checkList.add("Always keep spare masks/sanitizer, in case you need to clean your hands/objects.");
        checkList.add("Make sure you have a great book/hobbies you want to pick up, in case of a quarantine.");

        return checkList;
    }
}
