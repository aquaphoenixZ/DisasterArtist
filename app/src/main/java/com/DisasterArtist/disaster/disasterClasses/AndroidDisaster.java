package com.DisasterArtist.disaster.disasterClasses;

import java.util.ArrayList;

public class AndroidDisaster extends DisasterParent {
    public AndroidDisaster(){
        super();
        setDisasterType("Android");
        setDisasterTips(populateTips());
        setDisasterCheckList(populateCheckList());
    }

    private ArrayList<String> populateTips(){
        //TODO Populate all the tips

        ArrayList<String> tips = new ArrayList<>();

        tips.add("Get in contact with Student Services.");
        tips.add("Trust me, just do it");
        tips.add("Call emergency");
        tips.add("Pray that Student Services already have a file about the teacher");

        return tips;
    }

    private ArrayList<String> populateCheckList(){

        ArrayList<String> checkList = new ArrayList<>();

        checkList.add("Do your homework.");
        checkList.add("Be a decent student");
        checkList.add("Have a genuine interest for the class.");

        return checkList;
    }
}
