package com.DisasterArtist.disaster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.DisasterArtist.disaster.disasterClasses.FireDisaster;
import com.DisasterArtist.disaster.disasterClasses.FloodDisaster;

public class CheckListFrag extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO For Layout needs to change ListView to Recyclerview or add custom adapter in order  to add checkbox
        View root = inflater.inflate(R.layout.disaster_checklist_layout, container, false);
        DisasterActivity  disasterActivity = (DisasterActivity) getActivity();

        int disasterArgs = disasterActivity.disasterStarter;

        switch (disasterArgs){
            case R.string.flood_txt: floodTips(root); break;
            case R.string.fire_txt: fireTips(root); break;
        }

        return root;

    }

    public void fireTips(View v){

        //TODO This is dummy information
        ListView fireCheckList = v.findViewById(R.id.checkListView);
        FireDisaster fd = new FireDisaster();

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterCheckList() );

        fireCheckList.setAdapter(listAdapter);

    }

    public void floodTips(View v){

        ListView floodCheckList = v.findViewById(R.id.checkListView);
        FloodDisaster fd = new FloodDisaster();

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterCheckList() );

        floodCheckList.setAdapter(listAdapter);

    }

}
