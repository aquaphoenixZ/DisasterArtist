package com.DisasterArtist.disaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.NewsViewHolder> {
    private JSONArray news;
    private String objectName;
    private String newsTitle;
    private String newsDesc;
    private String imageURL;


    public NewsRecyclerAdapter(JSONArray newsObject){
        this.news = newsObject;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_holder,
                parent,false);


        NewsViewHolder newsVH = new NewsViewHolder(view);

        return newsVH;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        try {

            JSONObject articleObj = (JSONObject) news.get(position);

            holder.title.setText(articleObj.getString("title"));
            holder.url.setText(articleObj.getString("url"));
            Picasso.with(holder.newsImage.getContext()).load(articleObj.getString("urlToImage")).into(holder.newsImage);
            holder.description.setText(articleObj.getString("description"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return news.length();
    }

    //View Holder for the news information
    public class NewsViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView newsImage;
        public TextView description;
        public TextView url;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            url = itemView.findViewById(R.id.news_url_txt);
            title = (TextView) itemView.findViewById(R.id.news_title_txt);
            newsImage = (ImageView) itemView.findViewById(R.id.img_newsImageHolder);
            description = (TextView) itemView.findViewById(R.id.news_desc_txt);
        }
    }
}
