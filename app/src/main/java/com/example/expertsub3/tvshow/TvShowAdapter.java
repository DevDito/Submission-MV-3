package com.example.expertsub3.tvshow;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.expertsub3.R;
import com.example.expertsub3.tvshow.pojo.ResultsItem;

import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ResultsItem> itemList;

    private TvShowAdapter.OnItemClickListener mItemClickListener;


    TvShowAdapter(List<ResultsItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public TvShowAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_list, viewGroup, false);

        return new TvShowAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof TvShowAdapter.ViewHolder) {
            final ResultsItem model = getItem(position);
            TvShowAdapter.ViewHolder genericViewHolder = (TvShowAdapter.ViewHolder) holder;

            genericViewHolder.itemTxtTitle.setText(model.getName());

            if(model.getOverview().length()>50){
                genericViewHolder.itemTxtOverview.setText(model.getOverview().substring(0,49)+" ...");
            }else{
                genericViewHolder.itemTxtOverview.setText(model.getOverview());
            }

            Glide.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w185"+model.getPosterPath()).into(genericViewHolder.imgPoster);
        }
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    void SetOnItemClickListener(final TvShowAdapter.OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    private ResultsItem getItem(int position) {
        return itemList.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(View view, ResultsItem model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPoster;
        private TextView itemTxtTitle;
        private TextView itemTxtOverview;

        ViewHolder(final View itemView) {
            super(itemView);

            this.imgPoster = itemView.findViewById(R.id.img_poster);
            this.itemTxtTitle = itemView.findViewById(R.id.item_txt_title);
            this.itemTxtOverview = itemView.findViewById(R.id.item_txt_overview);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, itemList.get(getAdapterPosition()));
                }
            });

        }
    }

}

