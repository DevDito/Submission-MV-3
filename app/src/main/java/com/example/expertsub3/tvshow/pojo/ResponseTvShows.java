package com.example.expertsub3.tvshow.pojo;

import androidx.annotation.NonNull;

import com.androidnetworking.error.ANError;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTvShows {
    private ANError anError;

    public ResponseTvShows(ANError anError) {
        this.anError = anError;
    }

    public ResponseTvShows() {
    }

    public ANError getAnError() {
        return anError;
    }

    @SerializedName("page")
    private int page;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("results")
    private List<ResultsItem> results;

    @SerializedName("total_results")
    private int totalResults;

    public List<ResultsItem> getResults(){
        return results;
    }

    @NonNull
    @Override
    public String toString(){
        return
                "ResponseTvShows{" +
                        "page = '" + page + '\'' +
                        ",total_pages = '" + totalPages + '\'' +
                        ",results = '" + results + '\'' +
                        ",total_results = '" + totalResults + '\'' +
                        "}";
    }
}