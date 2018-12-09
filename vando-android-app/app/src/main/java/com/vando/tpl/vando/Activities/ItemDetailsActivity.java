package com.vando.tpl.vando.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tplmaps3d.MapController;
import com.tplmaps3d.MapView;
import com.tplmaps3d.sdk.utils.CommonUtils;
import com.vando.tpl.vando.Constants.DecryptManagerConstants;
import com.vando.tpl.vando.R;
import com.vando.tpl.vando.Utilities.MapUtils;

public class ItemDetailsActivity extends AppCompatActivity implements View.OnClickListener, MapView.OnMapReadyCallback{

    RecyclerView rvProfileImages, rvCommonFriends;
    CustomUI.LinearLayoutManager linearLayoutManager,linearLayoutManagerFrndList;
    TextView userName, quantity, itemManfectureDate;
    ImageView itemImage, editProfileStatus,friendShipStatus;
    private MapView mMapView;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        initializeView();
        initializeData();

        mMapView = (MapView) findViewById(R.id.map_IDA);
        mMapView.onCreate(savedInstanceState);

        // Loading map Asynchronously
        MapUtils.initAndLoadMaps(savedInstanceState, mMapView, this);

    }

    private void initializeView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userName = (TextView) findViewById(R.id.tvItemName_IDA);

        quantity = (TextView) findViewById(R.id.tvQuantity_IDA);
        itemManfectureDate = (TextView) findViewById(R.id.txtUserStatus);

        itemImage = (ImageView) findViewById(R.id.item_image);


        linearLayoutManager = new CustomUI.LinearLayoutManager(this, android.support.v7.widget.LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManagerFrndList = new CustomUI.LinearLayoutManager(this, android.support.v7.widget.LinearLayoutManager.HORIZONTAL, false);


    }

    private void initializeData() {

        intent = getIntent();
        //UserProfile userProfile = (UserProfile) intent.getSerializableExtra("userProfile");

//        userName.setText(intent.getStringExtra("user_name"));
//        quantity.setText(intent.getStringExtra("country"));
        Glide.with(ItemDetailsActivity.this)
                .load("https://images.all-free-download.com/images/graphicthumb/food_picture_02_hd_pictures_167557.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .into(itemImage);


    }

//    public void chageProfilePic(int position){
//        itemImage.setImageResource(allProfileImages.get(position));
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_profile, menu);
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//
//        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setIconifiedByDefault(true);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//               /* startActivity(new Intent(MainActivity.this,
//                        SearchResultActivity.class).putExtra(Constants.APP_QUERY, query));*/
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                break;
//            case R.id.action_settings:
//                finish();
//
//                break;
//            case R.id.action_about:
//                finish();
//
//                break;
//        }
        return true;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mMapView != null)
            mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mMapView != null)
            mMapView.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mMapView != null)
            mMapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mMapView != null)
            mMapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mMapView != null)
            mMapView.onDestroy();
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();

        if (mMapView != null)
            mMapView.onLowMemory();
    }

    @Override
    public void onMapReady(MapController mapController) {
        CommonUtils.showToast(this, "Map Ready", Toast.LENGTH_SHORT, false);

        mapController.registerMapDecryptManager(android.os.Environment.getExternalStorageDirectory().getAbsolutePath(),
                DecryptManagerConstants.getInstance(this).getKey());

        // Setting map max tilt value
        mapController.setMaxTilt(85);
    }
}
