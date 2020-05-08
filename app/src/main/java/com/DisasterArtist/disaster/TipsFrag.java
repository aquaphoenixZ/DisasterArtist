package com.DisasterArtist.disaster;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
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

import com.DisasterArtist.disaster.disasterClasses.AndroidDisaster;
import com.DisasterArtist.disaster.disasterClasses.DisasterParent;
import com.DisasterArtist.disaster.disasterClasses.EarthquakeDisaster;
import com.DisasterArtist.disaster.disasterClasses.FireDisaster;
import com.DisasterArtist.disaster.disasterClasses.FloodDisaster;
import com.DisasterArtist.disaster.disasterClasses.LandslideDisaster;
import com.DisasterArtist.disaster.disasterClasses.NuclearDisaster;
import com.DisasterArtist.disaster.disasterClasses.PandemicDisaster;
import com.DisasterArtist.disaster.disasterClasses.Thunderstorm;

import java.util.ArrayList;
import java.util.List;

public class TipsFrag extends Fragment{

//    DatabaseHelper disasterDb = new DatabaseHelper(getActivity());
//    SQLiteDatabase db = disasterDb.getReadableDatabase();
//
//    //-- Defining a projection
//
//    String[] projection = {
//            BaseColumns._ID,
//            FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
//            FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE,
//    };
//
//    //Filter Results WHERE "title" = 'My Title'
//    String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + " = ? ";
//    String[] selectionArgs = { "My Title"};
//
//    // How you want the results to be sorted in the cursor.
//    String sortOrder =
//            FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";
//    Cursor cursor = db.query(
//    FeedReaderContract.FeedEntry.TABLE_NAME, // the table to query
//    projection,           //The array of columns to return ( pass null to get everything)
//    selection,            // The columns for the WHERE clause
//    selectionArgs,        // The values for the WHERE clause
//            null,        // dont group the rows
//            null,         // dont filter by row groups
//    sortOrder            // The sort order
//        );




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.disaster_tips_layout, container, false);

        DisasterActivity  disasterActivity = (DisasterActivity) getActivity();

        int disasterArgs = disasterActivity.disasterStarter;

       switch (disasterArgs){
           case R.string.flood_txt: floodTips(root); break;
           case R.string.fire_txt: fireTips(root); break;
           case R.string.thunderstorm_txt: thunderTips(root); break;
           case R.string.earthquake_txt: earthquakeTips(root); break;
           case R.string.nuclear_txt: nuclearTips(root); break;
           case R.string.landslide_txt: slideTips(root); break;
           case R.string.pandemic_txt: pandemicTips(root); break;
           case R.string.android_txt: androidTips(root); break;
       }

        return root;
    }

    private void androidTips(View v) {
        int id = 8;
        ListView androidTip = v.findViewById(R.id.tipsListView);
        AndroidDisaster fd = new AndroidDisaster();

        ImageView androidImage = v.findViewById(R.id.disaster_image);
        androidImage.setImageResource(R.drawable.vanier_android);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

       androidTip.setAdapter(listAdapter);
    }

    private void pandemicTips(View v) {
        int id = 7;
        ListView pandemic = v.findViewById(R.id.tipsListView);
        PandemicDisaster fd = new PandemicDisaster();

        ImageView pandemicImage = v.findViewById(R.id.disaster_image);
        pandemicImage.setImageResource(R.drawable.pandemic);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        pandemic.setAdapter(listAdapter);
    }

    private void slideTips(View v) {
        ListView slideTipsList = v.findViewById(R.id.tipsListView);
        LandslideDisaster fd = new LandslideDisaster();

        ImageView slideImage = v.findViewById(R.id.disaster_image);
        slideImage.setImageResource(R.drawable.landsilepic);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        slideTipsList.setAdapter(listAdapter);
    }

    private void nuclearTips(View v) {
        ListView nuclearTipsList = v.findViewById(R.id.tipsListView);
        NuclearDisaster fd = new NuclearDisaster();

        ImageView nuclearImage = v.findViewById(R.id.disaster_image);
        nuclearImage.setImageResource(R.drawable.nuklear);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        nuclearTipsList.setAdapter(listAdapter);
    }

    private void earthquakeTips(View v) {
        ListView quakeTipsList = v.findViewById(R.id.tipsListView);
        EarthquakeDisaster fd = new EarthquakeDisaster();

        ImageView quakeImage = v.findViewById(R.id.disaster_image);
        quakeImage.setImageResource(R.drawable.quake);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        quakeTipsList.setAdapter(listAdapter);
    }

    private void thunderTips(View v) {
        ListView thunderTipsList = v.findViewById(R.id.tipsListView);
        Thunderstorm fd = new Thunderstorm();

        ImageView thunderImage = v.findViewById(R.id.disaster_image);
        thunderImage.setImageResource(R.drawable.thunderstorm);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fd.getDisasterTips() );

        thunderTipsList.setAdapter(listAdapter);
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

//        ArrayList itemIds = new ArrayList<>();
//        while (cursor.moveToNext()){
//            long itemId = cursor.getLong(
//
//                    cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry._ID));
//
//        }

    }
}
