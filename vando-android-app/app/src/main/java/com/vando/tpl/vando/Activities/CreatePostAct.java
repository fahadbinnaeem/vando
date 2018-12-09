package com.vando.tpl.vando.Activities;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vando.tpl.vando.R;


import java.util.Calendar;

//import butterknife.Bind;
//import butterknife.ButterKnife;

public class CreatePostAct extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener {
    private static final String TAG = "CreatePostAct";
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private BroadcastReceiver mRegistrationBroadcastReceiver;

    EditText itemName,_addressText, quantity,_mobileText,_dobText, category;
    ProgressDialog progressDialog;

    Calendar calendar;

    DatePickerDialog datePicker;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //ButterKnife.bind(this);


        initializeView();
        initializeData();




    }

    private void initializeData() {
        calendar = Calendar.getInstance();
        datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                if(datePicker.isShown() && datePicker!=null){
                    String dateString = datePicker.getYear()+"-"+(datePicker.getMonth()+1)+"-"+datePicker.getDayOfMonth();
                    Log.i("datePicked",dateString);
                    _dobText.setText(dateString);
                }
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));



        _dobText.setOnClickListener(this);

        category.setOnClickListener(this);

        _dobText.setOnFocusChangeListener(this);
        category.setOnFocusChangeListener(this);



    }

    private void initializeView() {
        itemName = (EditText) findViewById(R.id.item_name);
        _addressText = (EditText) findViewById(R.id.input_address);
        quantity = (EditText) findViewById(R.id.quantity);
        _mobileText = (EditText) findViewById(R.id.input_mobile);
        category = (EditText)findViewById(R.id.category);

        _dobText = (EditText)findViewById(R.id.DOM);
    }

    public void ShowGenderPopup(){
        PopupMenu popup = new PopupMenu(CreatePostAct.this, category,R.style.AppTheme);

        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                category.setText(item.getTitle());
                return true;
            }
        });

        popup.show();
    }


    public boolean validate() {
        boolean valid = true;

        String name = itemName.getText().toString();
        String gender = category.getText().toString();
        String email = quantity.getText().toString();
        String dob = _dobText.getText().toString();


        if (name.isEmpty() || name.length() < 3) {
            itemName.setError("at least 3 characters");
            valid = false;
        } else {
            itemName.setError(null);
        }

        if (gender.isEmpty()) {
            category.setError("Select Gender");
            valid = false;
        } else {
            category.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            quantity.setError("enter a valid email address");
            valid = false;
        } else {
            quantity.setError(null);
        }

        if (dob.isEmpty()) {
            _dobText.setError("Enter Date Of Birth");
            valid = false;
        } else {
            _dobText.setError(null);
        }

        return valid;
    }

    @Override
    public void onClick(View view) {
        if(view==_dobText){
            datePicker.show();
        }else if(view== category){
            ShowGenderPopup();
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(view==_dobText){
            InputMethodManager imm = (InputMethodManager)getSystemService(CreatePostAct.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            if(b)
                datePicker.show();
        }else if(view== category){
            InputMethodManager imm = (InputMethodManager)getSystemService(CreatePostAct.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            if(b) {
                ShowGenderPopup();
            }
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
    }
}