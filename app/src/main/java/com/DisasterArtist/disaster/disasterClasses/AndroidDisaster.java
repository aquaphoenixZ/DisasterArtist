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


        return tips;
    }

    private ArrayList<String> populateCheckList(){

        ArrayList<String> checkList = new ArrayList<>();

        return checkList;
    }
}
