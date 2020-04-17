package com.DisasterArtist.disaster.disasterClasses;

import java.util.ArrayList;

public class FireDisaster extends DisasterParent {

    public FireDisaster(){
        super();
        setDisasterType("Fire");
        setDisasterTips(populateTips());
        setDisasterCheckList(populateCheckList());
    }

    public ArrayList<String> populateTips(){
        //TODO Populate all the tips for flood

        ArrayList<String> tips = new ArrayList<>();

        tips.add("Lay down on the floor so the smoke doesn't hit you");
        tips.add("You have tree minutes to get out, don't grab unnecessary things");
        tips.add("Call emergency");
        tips.add("Have a fire emergency kit");

        return tips;
    }

    public ArrayList<String> populateCheckList(){
        //TODO Populate all the checklist for flood

        ArrayList<String> checkList = new ArrayList<>();

        checkList.add("Buy Fire emergency kit");
        checkList.add("Have a smoke detector");
        checkList.add("Seriously, Call emergency");

        return checkList;
    }
}
