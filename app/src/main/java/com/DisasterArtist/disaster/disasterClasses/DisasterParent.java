package com.DisasterArtist.disaster.disasterClasses;

import java.util.ArrayList;

public class DisasterParent {

    private String disasterType;
    private ArrayList<String> disasterTips;
    private ArrayList<String> disasterCheckList;

    public DisasterParent(String disasterType, ArrayList<String> tips, ArrayList<String> disasterCheckList) {
        setDisasterTips(tips);
        setDisasterCheckList(disasterCheckList);
        setDisasterType(disasterType);
    }

    public DisasterParent(){

    }

    public void setDisasterType(String disaster){
        this.disasterType = disaster;
    }

    public void setDisasterTips(ArrayList<String> tips){
        this.disasterTips = tips;
    }

    public void setDisasterCheckList(ArrayList<String> checkList){
        this.disasterCheckList = checkList;
    }

    public String getDisasterType(){
        return this.disasterType;
    }

    public ArrayList<String> getDisasterTips(){
        return this.disasterTips;
    }

    public ArrayList<String> getDisasterCheckList(){
        return this.disasterCheckList;
    }
}
