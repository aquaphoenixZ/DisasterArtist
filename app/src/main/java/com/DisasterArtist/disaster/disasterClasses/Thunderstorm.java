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

        tips.add("Find shelter as soon as possible.");
        tips.add("Avoid water in general, an unlucky lightning bolt can be the demise of pretty much anyone.");
        tips.add("Avoid the rain as much as possible, getting sick during a storm is the worst possible scenario for anyone trying to survive through the storm.");

        return tips;
    }

    private ArrayList<String> populateCheckList(){
        //TODO Populate all the checklist for flood

        ArrayList<String> checkList = new ArrayList<>();

        checkList.add("Make sure to keep track of weather forecasts.");
        checkList.add("Prepare adequate clothing for dealing with a storm, along with an umbrella");
        checkList.add("If possible, shelter your car/anything valuable outside of your own house in prevision of an upcoming storm");

        return checkList;
    }
}
