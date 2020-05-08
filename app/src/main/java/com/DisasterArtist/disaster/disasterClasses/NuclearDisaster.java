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

        tips.add("Look for a hospital if gravely injured, if not, try to help around, social services will most likely be overwhelmed.");
        tips.add("Avoid the rain post-nuclear disaster, as it is most likely very acidic.");
        tips.add("Look for bottled water, as much as possible, as it is probably gonna become the new currency.");
        tips.add("Have a fire emergency kit");

        return tips;
    }

    public ArrayList<String> populateCheckList(){
        //TODO Populate all the checklist for flood

        ArrayList<String> checkList = new ArrayList<>();

        checkList.add("Prepare an underground bunker with non-perishable rations/MREs, ideally enough for a couple of years.");
        checkList.add("Prepare a lot of bottled water.");
        checkList.add("Make sure to warn your friends and neighbors of the upcoming apocalypse.");

        return checkList;
    }
}
