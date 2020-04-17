package com.DisasterArtist.disaster;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewsActivity extends MainActivity {
    private RecyclerView recView;
    private RecyclerView.Adapter recAdapter;
    private RecyclerView.LayoutManager  recLayMan;
    private JSONArray news = new JSONArray();

    //Gets the category for the search
    public String getSearchCategory(){
        TextView userSearch = findViewById(R.id.userSearch);
        return userSearch.getText().toString();
    }

    public void adaptJSONObject(){
        RequestQueue requestQueue =  Volley.newRequestQueue(this);

        //URL with category for Json parse
        String searchCategory = getSearchCategory();
        String newsUrl = "https://newsapi.org/v2/everything?q=disaster&apiKey=91639c1c24074b4ca5692f1088162e57";

        //Creates the volley request to retrieve the news
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, newsUrl, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            news = response.getJSONArray("articles");
                            recAdapter = new NewsRecyclerAdapter(news);
                            recView.setAdapter(recAdapter);
                            Log.i("NewsOb", news.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.getCause();
                        error.getStackTrace();
                        Log.e("RESPONSE ERROR", error.getMessage());
                    }
                });


        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        menu.findItem(R.id.nav_home).setVisible(true);

        return true;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.news_text);
        setSupportActionBar(toolbar);

        findViewById(R.id.main_panic_button).setOnClickListener(this);

        recView = (RecyclerView) findViewById(R.id.news_recyclerView);
        recLayMan = new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false);
        recView.setLayoutManager(recLayMan);
        adaptJSONObject();

    }
}
