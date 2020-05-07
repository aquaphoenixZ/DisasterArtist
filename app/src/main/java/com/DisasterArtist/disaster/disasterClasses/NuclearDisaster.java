package com.DisasterArtist.disaster.disasterClasses;

import java.util.ArrayList;

//TODO: Fix the bug with the return button; clicking back crashes the app
public class NuclearDisaster extends DisasterParent {
    public NuclearDisaster(){
        super();
        setDisasterType("Nuclear");
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
