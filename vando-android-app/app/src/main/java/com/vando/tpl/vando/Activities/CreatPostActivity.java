package com.vando.tpl.vando.Activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import com.vando.tpl.vando.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Sample app
 * 

 */
@SuppressLint("ResourceAsColor")
public class CreatPostActivity extends Activity {


	Button bAddImageCard,bTagFrnd,bCreateEvent,bRemake;
	ImageView nextCollageLayoutButton, previousCollageLayoutButton;
	private int PICK_IMAGE_REQUEST = 1;
	String myUserName;
	long myUserId;


	RecyclerView rvFrndList,rvTaggedFrndList;
	PopupWindow popupWindow;
	View popupView;
	boolean isPopUpWindowShowing = false;

	SharedPreferences sharedPreferences;
	SharedPreferences.Editor prefrenceEditor;


	private int mDeviceWidth = 0;
	private int defaultCollageThemeId = 4;
	private int currentCollageThemeId = defaultCollageThemeId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		sharedPreferences = getSharedPreferences("MSocial", MODE_PRIVATE);
		prefrenceEditor =  sharedPreferences.edit();
		prefrenceEditor.putBoolean("createPostActivityIsRunning",true);
		prefrenceEditor.commit();

		mDeviceWidth = getResources().getDisplayMetrics().widthPixels;

		setContentView(R.layout.activity_create_post);
		initView();
		initData();
	}

	@Override
	protected void onStop() {
		super.onStop();
		prefrenceEditor.putBoolean("createPostActivityIsRunning",false);
	}

	private void initView() {

//
//		bAddImageCard = (Button)findViewById(R.id.bAddImageCard);
//		bTagFrnd = (Button)findViewById(R.id.bTagFriend);
//		bCreateEvent = (Button)findViewById(R.id.bCreateEvent);
//		bRemake = (Button) findViewById(R.id.bReMake);
//
//		nextCollageLayoutButton = (ImageView)findViewById(R.id.next_collage_layout);
//		previousCollageLayoutButton = (ImageView) findViewById(R.id.previous_collage_layout);
//
//		popupView = LayoutInflater.from(this).inflate(R.layout.layout_frnd_list, null);
//		popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//		// Closes the popup window when touch outside.
//		popupWindow.setOutsideTouchable(true);
//		popupWindow.setFocusable(true);
//		// Removes default background.
//		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//		rvFrndList = (RecyclerView) popupView.findViewById(R.id.rvFrndListPopUp);
//		CustomLinearLayoutManager customLayoutManagerFrndList = new
//				CustomLinearLayoutManager(this, android.support.v7.widget.LinearLayoutManager.VERTICAL, false);
//		rvFrndList.setLayoutManager(customLayoutManagerFrndList);
//
//		rvTaggedFrndList = (RecyclerView)findViewById(R.id.rvTaggedFrnds);
//		CustomLinearLayoutManager customLayoutManagerTaggedFrndList = new
//				CustomLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//		rvTaggedFrndList.setLayoutManager(customLayoutManagerTaggedFrndList);
//
//
//		addPuzzleViewToLayout(R.id.LinearLayoutPuzzleView,1f);

	}

	private void initData() {

//		Intent intent = getIntent();
//		myUserName = intent.getStringExtra("userName");
//		myUserId = intent.getLongExtra("userId",-1);
//
//		mySavedInfo = new MySavedInfo(getApplicationContext());
//
//		meParticipant = new Participant(mySavedInfo.getMyUserName(),
//				mySavedInfo.getMyUserId(),mySavedInfo.getMyProfilePic(),"",false,0,"");
//
//
//		largeFrndListAdapter = new LargeFrndListAdapter(this);
//		rvFrndList.setAdapter(largeFrndListAdapter);
//
//		taggedfrndListAdapter = new FrndListAdapter(this);
//		rvTaggedFrndList.setAdapter(taggedfrndListAdapter);
//
//
//		popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//			@Override
//			public void onDismiss() {
//				taggdFrndList = largeFrndListAdapter.getSelectedItems();
//				taggedfrndListAdapter.setFrndListItems(taggdFrndList);
//				taggedfrndListAdapter.notifyDataSetChanged();
//
//				participants.clear();
//				participants.add(meParticipant);
//				for(int i=0;i<taggdFrndList.size();i++){
//					Participant participant = new Participant(taggdFrndList.get(i),"",false,i+1);
//					participants.add(participant);
//				}
//
//				// Make Collage with default theme Id
//				PuzzleUtil.makeCollage(mPuzzleView,participants,defaultCollageThemeId);
//
//			}
//		});
//
//
//
//		bAddImageCard.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				mPuzzleView.save(new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/" + System.currentTimeMillis()+".jpg"),4);
//			}
//		});
//
//		nextCollageLayoutButton.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				currentCollageThemeId = currentCollageThemeId+1<PuzzleUtil.numOfthemesAvailable(participants.size()) ? currentCollageThemeId+1 : currentCollageThemeId;
//				PuzzleUtil.makeCollage(mPuzzleView,participants,currentCollageThemeId);
//			}
//		});
//
//		previousCollageLayoutButton.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				currentCollageThemeId = currentCollageThemeId-1>0 ? currentCollageThemeId-1 : currentCollageThemeId;
//				PuzzleUtil.makeCollage(mPuzzleView,participants,currentCollageThemeId);
//			}
//		});
//
//		Response.Listener<String> frndListReqResponseListener = new Response.Listener<String>() {
//			@Override
//			public void onResponse(String response) {
//				try {
//					JSONArray frndListResponse = new JSONArray(response);
//					List<UserBriefInfo> frndsInfo = new ArrayList<>();
//					for(int i=0;i<frndListResponse.length();i++){
//						JSONObject frnd = frndListResponse.getJSONObject(i);
//						frndsInfo.add(new UserBriefInfo(frnd.getString("user_name"),
//								frnd.getString("profile_pic"),
//								frnd.getString("country"),
//								frnd.getInt("user_id")));
//					}
//					frndList = frndsInfo;
//					largeFrndListAdapter.setList(frndList);
//					largeFrndListAdapter.notifyDataSetChanged();
//
//				} catch (JSONException e) {
//					e.printStackTrace();
//				}
//			}
//		};
//
//		GetFrndListRequest getFrndListRequest = new GetFrndListRequest(myUserId, frndListReqResponseListener);
//		RequestQueue queue = Volley.newRequestQueue(CreatPostActivity.this);
//		queue.add(getFrndListRequest);
//
//		bTagFrnd.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				if(!popupWindow.isShowing())
//					showPopup();
//				else
//					hidePopUp();
//			}
//		});
//
//		bCreateEvent.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				mPuzzleView.requestCreateEvent(mySavedInfo.getMyUserId(), mySavedInfo.getMyUserName());
//			}
//		});
//
//
//
//
//		bRemake.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				String jsonString = "";
//				try {
//					jsonString = PuzzleUtil.getGeomJSON(mPuzzleView.getPuzzleLayout(),mPuzzleView.aspectRatio);
//					mPuzzleView.reset();
//
//					List<Participant> participants = new ArrayList<>();
//
//					for(int i=0;i<taggdFrndList.size();i++){
//						Participant participant = new Participant(taggdFrndList.get(i),"",false,taggdFrndList.size()-i);
//						participants.add(participant);
//					}
//					participants.add(meParticipant);
//
//					PuzzleUtil.makeCollage(mPuzzleView,participants,jsonString);
//				} catch (JSONException e) {
//					e.printStackTrace();
//				}
//			}
//		});


	}





	public void showPopup(){
		popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
	}

	public void hidePopUp(){
		popupWindow.dismiss();
	}


	private void showFileChooser() {
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
			Uri filePath = data.getData();
			//Getting the Bitmap from Gallery
			//addNewCard(MediaStore.Images.Media.getBitmap(getContentResolver(), filePath));

		}
	}

	@Override
	protected void onPause() {
		super.onPause();
	}
}
