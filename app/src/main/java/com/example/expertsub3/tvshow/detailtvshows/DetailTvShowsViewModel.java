package com.example.expertsub3.tvshow.detailtvshows;

import androidx.lifecycle.ViewModel;

import com.example.expertsub3.tvshow.pojo.ResultsItem;

public class DetailTvShowsViewModel extends ViewModel {
    private ResultsItem resultsItem;

    public ResultsItem getResultsItem() {
        return resultsItem;
    }

    public void setResultsItem(ResultsItem resultsItem) {
        this.resultsItem = resultsItem;
    }
}
