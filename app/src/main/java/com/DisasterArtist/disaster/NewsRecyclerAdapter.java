package com.DisasterArtist.disaster;

import android.util.Log;
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
            //TODO fix picasso image adapter with proper error handling
            JSONObject articleObj = (JSONObject) news.get(position);

            holder.title.setText(articleObj.getString("title"));
            holder.url.setText(articleObj.getString("url"));
            holder.description.setText(articleObj.getString("description"));

            String imageUrl = articleObj.getString("urlToImage");
            Log.i("NEWSURL", imageUrl);
            Log.i("NEWSURLLENGHT",Integer.toString(imageUrl.length()));
            if(imageUrl.length() != 0){
                Picasso.with(holder.newsImage.getContext()).load(imageUrl).into(holder.newsImage);
            }
            else {
                Picasso.with(holder.newsImage.
                        getContext()).load("https://www.courieranywhere.com/wp-content/uploads/2018/07/breaking-news-logo.jpg).into(holder.newsImage");
            }


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
