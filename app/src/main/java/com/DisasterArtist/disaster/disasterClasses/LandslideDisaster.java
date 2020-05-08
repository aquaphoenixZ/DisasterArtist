package com.DisasterArtist.disaster.disasterClasses;

import java.util.ArrayList;

public class LandslideDisaster extends DisasterParent {
    public LandslideDisaster(){
        super();
        setDisasterType("Landslide");
        setDisasterTips(populateTips());
        setDisasterCheckList(populateCheckList());
    }

    public ArrayList<String> populateTips(){
        //TODO Populate all the tips

        ArrayList<String> tips = new ArrayList<>();

        tips.add("Call 911, you are in no position to be able to deal with this without greatly endangering yourself.");
        tips.add("Get as far from the source as possible, in this case, the valley/plain/mountain in question, a mudslide can make movement nearly impossible after a while.");
        tips.add("While it might seem counter-intuitive, avoid vehicles as much as possible, as they usually dont have the required tires to drive through thick mud.");

        return tips;
    }

    public ArrayList<String> populateCheckList(){
        //TODO Populate all the checklist for flood

        ArrayList<String> checkList = new ArrayList<>();

        checkList.add("Prepare spare mud tires, so that you can use your vehicles.");
        checkList.add("Check the weather forecast, if you live near a mountain, and strong rain is predicted, you might need to be on your toes.");
        checkList.add("Make sure your entrances/windows are properly isolated, and that your walls are solid, so that you can ensure staying inside is safe.");

        return checkList;
    }
}
