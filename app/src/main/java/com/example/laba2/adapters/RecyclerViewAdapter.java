package com.example.laba2.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.laba2.activities.ViewPagerActivity;
import com.example.laba2.model.Civilization;
import com.example.laba2.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private String urlImage = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/";
    private Context mContext;
    private List<Civilization> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Civilization> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.civilization_row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bindItem(mData.get(position));
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_help.setText(mData.get(position).getHelptext());

        // Load image from the internet and set it into Imageview using glide

        Glide.with(mContext).load(urlImage + mData.get(position).getGraphic()).into(holder.img_thumbnail);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Civilization civItem;
        TextView tv_name;
        TextView tv_help;
        ImageView img_thumbnail;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.civ_name);
            tv_help = itemView.findViewById(R.id.help_text);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
            itemView.setOnClickListener(this);



        }

        public void bindItem(Civilization item)
        {
            civItem = item;
        }
//При клике создается новое активити и присваивается имя того элемента на которое мы нажали
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
            intent.putExtra("name", civItem.getName());
            v.getContext().startActivity(intent);
        }
    }

}
