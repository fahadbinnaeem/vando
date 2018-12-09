package com.vando.tpl.vando.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.vando.tpl.vando.Adapters.FeedsListAdapter;
import com.vando.tpl.vando.R;
import com.vando.tpl.vando.Models.FeedItem;
import com.vando.tpl.vando.Request.GetFeedsRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


import CustomUI.CustomLinearLayoutManager;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    String chosenSearch;
    long myUserId;
    RecyclerView mainActivityFeeds;
    FeedsListAdapter feedsListAdapter;
    TextView tvWelcome,frndReqNotifiations;
    Intent mainIntent;
    Button bCreatPost;
    ImageButton bFrndReqNotificationIcon;
//    List<UserBriefInfo> frndRequestsList;
    private boolean hasNewItemsToScrolledDown = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    final int requestCountLimit=5;
    CustomLinearLayoutManager customLayoutManager;
//    private MySavedInfo mySavedInfo;
    private RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();
        initializeData();

        bCreatPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreatePostAct.class);
                //Intent intent = new Intent(MainActivity.this, EventPartcipationActivity.class);
//                intent.putExtra("userName", userName);
//                intent.putExtra("userId",myUserId);
                MainActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        tvWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,ItemDetailsActivity.class);
//                intent.putExtra("user_name",mySavedInfo.getMyUserName());
//                intent.putExtra("user_id",mySavedInfo.getMyUserId());
//                intent.putExtra("profile_pic", APIContract.PROFILE_PICS_BASE_URL+mySavedInfo.getMyProfilePic());
//                MainActivity.this.startActivity(intent);
            }
        });

        final Response.Listener<String> feedReqResponseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray feedsResponse = new JSONArray(response);
                    if(feedsResponse.length()>0) {
                        List<FeedItem> feedsList = new ArrayList<>();
                        for (int i = 0; i < feedsResponse.length(); i++) {
                            JSONObject feed = feedsResponse.getJSONObject(i);
                            FeedItem feedItem = new FeedItem("","","","","",2.2);
//                                    feed.getString("feeder_user_name"),   //userName
//                                    feed.getString("feed_text"),
//                                    feed.getString("date_time"),
//                                    feed.getString("feeder_profile_pic"),
//                                    feed.getString("feed_image_url"),
//                                    feed.getInt("user_id"),
//                                    feed.getInt("feed_id"));
                            feedsList.add(feedItem);
                        }
                        feedsListAdapter.addFeedItems(feedsList);
                        feedsListAdapter.notifyDataSetChanged();
                        hasNewItemsToScrolledDown = true;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        GetFeedsRequest getFeedsRequest = new GetFeedsRequest(myUserId,requestCountLimit,feedsListAdapter.getItemCount(), feedReqResponseListener);
        queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(getFeedsRequest);





        mainActivityFeeds.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                if(dy > 0) //check for scroll down
                {
                    visibleItemCount = customLayoutManager.getChildCount();
                    totalItemCount = customLayoutManager.getItemCount();
                    pastVisiblesItems = customLayoutManager.findFirstVisibleItemPosition();

                    if (hasNewItemsToScrolledDown)
                    {
                        if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                        {
                            hasNewItemsToScrolledDown = false;
                            GetFeedsRequest getFeedsRequest = new GetFeedsRequest(myUserId,requestCountLimit,feedsListAdapter.getItemCount(), feedReqResponseListener);
                            queue.add(getFeedsRequest);
                        }
                    }
                }
            }
        });

    }


    private void initializeView() {
        tvWelcome = (TextView)findViewById(R.id.tvWelcome);

        bCreatPost = (Button) findViewById(R.id.bCreatePost_mainActivity);
        mainActivityFeeds = (RecyclerView)findViewById(R.id.rvMainActivityFeeds);
        customLayoutManager = new
                CustomLinearLayoutManager(this, android.support.v7.widget.LinearLayoutManager.VERTICAL, false);
        mainActivityFeeds.setLayoutManager(customLayoutManager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initializeData() {
        mainIntent = getIntent();
        chosenSearch = mainIntent.getStringExtra("chosen_search");

        tvWelcome.setText("you chose food");
        feedsListAdapter = new FeedsListAdapter(MainActivity.this);
        mainActivityFeeds.setAdapter(feedsListAdapter);

        mainActivityFeeds.setItemViewCacheSize(20);

        List<FeedItem> feedList = new ArrayList<>();
        feedList.add(new FeedItem("dumy Alu palak","2 plates","03331234448","https://images.all-free-download.com/images/graphicthumb/food_picture_02_hd_pictures_167557.jpg","monday 2 pm",2.2));
        feedList.add(new FeedItem("dumy Alu palak2","3 plates","03331234448","https://images.all-free-download.com/images/graphicthumb/food_picture_02_hd_pictures_167557.jpg","monday 3 pm",2.2));
        feedList.add(new FeedItem("dumy Alu palak3","4 plates","03331234448","https://images.all-free-download.com/images/graphicthumb/food_picture_02_hd_pictures_167557.jpg","monday 4 pm",2.2));
        feedList.add(new FeedItem("dumy Alu palak4","5 plates","03331234448","https://images.all-free-download.com/images/graphicthumb/food_picture_02_hd_pictures_167557.jpg","monday 5 pm",2.2));

        feedsListAdapter.addFeedItems(feedList);
        feedsListAdapter.notifyDataSetChanged();
//        mySavedInfo = new MySavedInfo(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_search){
            Intent intent = new Intent(MainActivity.this,SearchActivity.class);
            MainActivity.this.startActivity(intent);
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        }
        return true;
    }

}

