package com.DisasterArtist.disaster.disasterClasses;

import android.os.Bundle;

import com.DisasterArtist.disaster.DisasterActivity;
import com.DisasterArtist.disaster.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FloodDisaster extends DisasterParent{


    public FloodDisaster(){
        super();
        setDisasterType("Floods");
        setDisasterTips(populateTips());
        setDisasterCheckList(populateCheckList());
    }

    public ArrayList<String> populateTips(){
        //TODO Populate all the tips for flood

        ArrayList<String> tips = new ArrayList<>();

        tips.add("Don't freak out, place your sandbags around your house.");
        tips.add("Cut electricity in case the water gets to the wall outputs");
        tips.add("Call emergency");

        return tips;
    }

    public ArrayList<String> populateCheckList(){
        //TODO Populate all the checklist for flood

        ArrayList<String> checkList = new ArrayList<>();

        checkList.add("Buy sandbags");
        checkList.add("Cut the electricity");
        checkList.add("Buy a canoe");

        return checkList;
    }
}
