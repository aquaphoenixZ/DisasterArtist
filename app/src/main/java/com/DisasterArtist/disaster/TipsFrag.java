package com.DisasterArtist.disaster;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.DisasterArtist.disaster.disasterClasses.DisasterParent;
import com.DisasterArtist.disaster.disasterClasses.FireDisaster;
import com.DisasterArtist.disaster.disasterClasses.FloodDisaster;

public class TipsFrag extends Fragment{


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.disaster_tips_layout, container, false);

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
        ListView fireTipsList = v.findViewById(R.id.tipsListView);
        FireDisaster fd = new FireDisaster();

        ImageView fireImage = v.findViewById(R.id.disaster_image);
        fireImage.setImageResource(R.drawable.firewild);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        fireTipsList.setAdapter(listAdapter);
    }

    public void floodTips(View v){

        ListView floodTipsList = v.findViewById(R.id.tipsListView);
        FloodDisaster fd = new FloodDisaster();

        ImageView floodImage = v.findViewById(R.id.disaster_image);
        floodImage.setImageResource(R.drawable.floods);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        floodTipsList.setAdapter(listAdapter);

    }
}
