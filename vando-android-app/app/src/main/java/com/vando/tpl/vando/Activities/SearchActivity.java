package com.vando.tpl.vando.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import com.vando.tpl.vando.Adapters.SearchListAdapter;
import com.vando.tpl.vando.Models.SearchSuggestiontem;
import com.vando.tpl.vando.R;
import com.vando.tpl.vando.Request.SearchRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faraz on 06-Nov-16.
 */
public class SearchActivity extends AppCompatActivity {
    EditText searchText;
    ImageView img_back_arrow;
    RecyclerView searchResults;

    List<SearchSuggestiontem> suggestionListItems;

    SearchListAdapter searchListAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        suggestionListItems = new ArrayList<SearchSuggestiontem>();

        //searchResults.setNestedScrollingEnabled(false);
        //searchResults.setHasFixedSize(true);
        initializeView();
        initializeData();


        img_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        searchText.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);


        // Response received from the server
        final Response.Listener<String> searchReqResponseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //JSONObject jsonResponse = new JSONObject(response.toString());
                    JSONArray userSearchResults = new JSONArray(response.toString());
                    List<SearchSuggestiontem> searchUsersList = new ArrayList<>();
                    for(int i=0;i<userSearchResults.length();i++){
                        JSONObject userInfoFromResponse = userSearchResults.getJSONObject(i);
                        SearchSuggestiontem user = new SearchSuggestiontem("");
                        searchUsersList.add(user);
                    }
                    //Log.e("searchCount",searchUsersList.size()+"");
                    //suggestionListItems = searchUsersList;
                    searchListAdapter.setList(searchUsersList);
                    searchListAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("beforeTextChanged", "text");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("onTextChanged", "text");
                if(charSequence!=""){
                    SearchRequest searchRequest = new SearchRequest(charSequence.toString(), searchReqResponseListener);
                    RequestQueue queue = Volley.newRequestQueue(SearchActivity.this);
                    queue.add(searchRequest);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i("afterTextChanged", "text");
            }
        });
        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
    }

    private void initializeData() {
        CustomUI.CustomLinearLayoutManager customLayoutManager = new
                CustomUI.CustomLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        searchResults.setLayoutManager(customLayoutManager);
        searchListAdapter = new SearchListAdapter(SearchActivity.this);
        searchResults.setAdapter(searchListAdapter);


        suggestionListItems.add(new SearchSuggestiontem("Faraz"));
        suggestionListItems.add(new SearchSuggestiontem("Ali"));
        suggestionListItems.add(new SearchSuggestiontem("ashj"));
        suggestionListItems.add(new SearchSuggestiontem("sss"));


        searchListAdapter.setList(suggestionListItems);
        searchListAdapter.notifyDataSetChanged();
    }

    private void initializeView() {
        searchText = (EditText) findViewById(R.id.edt_tool_search);
        img_back_arrow = (ImageView) findViewById(R.id.img_tool_back);
        searchResults = (RecyclerView) findViewById(R.id.rvSearchResults);
    }


}
