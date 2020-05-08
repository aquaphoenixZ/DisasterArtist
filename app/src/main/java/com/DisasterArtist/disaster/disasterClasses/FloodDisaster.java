package com.DisasterArtist.disaster.disasterClasses;

import android.os.Bundle;

import com.DisasterArtist.disaster.DisasterActivity;
import com.DisasterArtist.disaster.FeedReaderContract;
import com.DisasterArtist.disaster.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

        tips.add("Avoid closed underground spaces as much as possible");
        tips.add("Seal off windows/doors that might flood the establishment if left unchecked");
        tips.add("If possible, find shelter in a tall building, ideally on a rooftop");

        return tips;
    }

    public ArrayList<String> populateCheckList(){
        //TODO Populate all the checklist for flood

        ArrayList<String> checkList = new ArrayList<>();

        checkList.add("Make sure to have sandbags to seal off doors");
        checkList.add("Make sure to have adequate footwear (Rain and/or high boots)");
        checkList.add("Make sure to not leave too many electronics, or anything susceptible to flood damage underground.");

        return checkList;
    }
}
