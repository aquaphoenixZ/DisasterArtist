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

        tips.add("Always check for door handles, if they are warm, avoid the room at all cost.");
        tips.add("Avoid standing up as inhaling too much smoke could be very harmful. Stay as close to the floor as humanly possible.");
        tips.add("Close every window possible, Oxygen helps flames spread.");
        tips.add("Have a fire emergency kit");

        return tips;
    }

    public ArrayList<String> populateCheckList(){
        //TODO Populate all the checklist for flood

        ArrayList<String> checkList = new ArrayList<>();

        checkList.add("Regularly test your smoke detectors.");
        checkList.add("Make sure your establishment has at least 1 fire extinguisher, and that it is not empty.");
        checkList.add("Make sure to close the windows whenever you are leaving a building and/or a room, in case a fire happens while you are not present.");

        return checkList;
    }
}
