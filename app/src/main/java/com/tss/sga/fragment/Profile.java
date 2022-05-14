package com.tss.sga.fragment;

import static com.tss.sga.Constant.Email;
import static com.tss.sga.Constant.Name;
import static com.tss.sga.Constant.Phone;
import static com.tss.sga.Constant.SGAPerfernce;
import static com.tss.sga.Constant.USERNAME;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tss.sga.R;
public class Profile extends Fragment {
    View view;
    Context mContext;
    String  username;
    String  email;
    String  name;
    String  mobile;
    TextView nameTextView,emailTextView,phoneTexView, userTextView,  mobileTexView;
    int  userID;
   // attach context
   public Profile() {
        // Required empty public constructor
    }
        @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        nameTextView = view.findViewById(R.id.tv_name);
        emailTextView = view.findViewById(R.id.email_text_id);
        phoneTexView = view.findViewById(R.id.phone_text_id);
        userTextView = view.findViewById(R.id.username_txt_id);
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SGAPerfernce,Context.MODE_PRIVATE);
        name  = sharedPreferences.getString(Name,"Default");
        email =sharedPreferences.getString(Email,"Test@email.com");
        mobile = sharedPreferences.getString(Phone, "00000");
        username = sharedPreferences.getString(USERNAME,"username");
        nameTextView.setText(name);
        emailTextView.setText(email);
        phoneTexView.setText(mobile);
        userTextView.setText(username);
        // Inflate the layout for this fragment
        return  view;
    }
}