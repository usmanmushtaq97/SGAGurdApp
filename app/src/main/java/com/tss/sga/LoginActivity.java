package com.tss.sga;

import static com.tss.sga.Constant.Email;
import static com.tss.sga.Constant.ID;
import static com.tss.sga.Constant.Name;
import static com.tss.sga.Constant.Phone;
import static com.tss.sga.Constant.SGAPerfernce;
import static com.tss.sga.Constant.USERNAME;
import static com.tss.sga.Constant.isLgoin;
import static com.tss.sga.Constant.loginUrl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;

public class LoginActivity extends AppCompatActivity {
   Button loginBtn;
   EditText usernameEmail;
   EditText userPassword;
    private int status=0;
   String userName;
   String userPasswordtext;

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = findViewById(R.id.button_login);
        userPassword = findViewById(R.id.editTextTextPassword);
        usernameEmail = findViewById(R.id.email_username_login_id);
        sharedpreferences = getSharedPreferences(SGAPerfernce, Context.MODE_PRIVATE);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = usernameEmail.getText().toString();
                userPasswordtext =  userPassword.getText().toString();
                if( !userPasswordtext.isEmpty() && !userName.isEmpty()){
                    Login();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Please Enter Require Feild", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    private  void Login(){
        //getting the progressbar

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        //creating a string request to send request to the url
        userName = usernameEmail.getText().toString();
        userPasswordtext =  userPassword.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://sga.topsolutions.pk/admin/api/login.php?accesskey=554&username="+userName+"&password="+userPasswordtext,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion
                        progressBar.setVisibility(View.INVISIBLE);
                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);
                              Log.d("response", response);
                                int statuscode = obj.getInt("code");
                                if(statuscode == 1){
                                    JSONArray tutorialsArray = obj.getJSONArray("user");
                                    for (int i = 0; i < tutorialsArray.length(); i++) {
                                        //getting the json object of the particular index inside the array
                                        JSONObject tutorialsObject = tutorialsArray.getJSONObject(i);
                                        int id = tutorialsObject.getInt("id");
                                        String name = tutorialsObject.getString("name");
                                        String email = tutorialsObject.getString("email");
                                        String mobile = tutorialsObject.getString("phone");
                                        String username = tutorialsObject.getString("username");
                                        //creating a tutorial object and giving them the values from json object
                                        SharedPreferences.Editor editor = sharedpreferences.edit();
                                        editor.putString(Name, name);
                                        editor.putString(Phone, mobile);
                                        editor.putString(Email, email);
                                        editor.putInt(ID, id);
                                        editor.putInt(isLgoin, 1);
                                        editor.putString(USERNAME,username);
                                        editor.apply();
                                        Intent intent = new Intent(LoginActivity.this, MainHomeActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                                else {
                                    Toast.makeText(LoginActivity.this, "Your Entered Information Wrong", Toast.LENGTH_SHORT).show();
                                }
                            //we have the array named tutorial inside the object
                            //so here we are getting that json array



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occur
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }
}


