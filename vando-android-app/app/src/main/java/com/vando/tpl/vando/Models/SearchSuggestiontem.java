package com.vando.tpl.vando.Models;


import com.vando.tpl.vando.Utilities.APIContract;

/**
 * Created by Faraz on 06-Nov-16.
 */
public class SearchSuggestiontem {


    private String searchSuggestion;

    public SearchSuggestiontem(String searchSuggestion) {
        this.searchSuggestion = searchSuggestion;
    }

    public String getSearchSuggestion() {
        return searchSuggestion;
    }

    public void setSearchSuggestion(String searchSuggestion) {
        this.searchSuggestion = searchSuggestion;
    }


}
