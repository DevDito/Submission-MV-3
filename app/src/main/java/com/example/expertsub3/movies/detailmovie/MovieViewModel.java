package com.example.expertsub3.movies.detailmovie;

import androidx.lifecycle.ViewModel;

import com.example.expertsub3.movies.pojo.ResultsItem;

public class MovieViewModel extends ViewModel {
    private ResultsItem resultsItem;

    public ResultsItem getResultsItem() {
        return resultsItem;
    }

    public void setResultsItem(ResultsItem resultsItem) {
        this.resultsItem = resultsItem;
    }
}

