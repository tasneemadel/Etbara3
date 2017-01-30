package com.example.taseneem21.bloodbank_v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by taseneem 21 on 11/27/2016.
 */


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class login_activity extends Activity {
    public static boolean first = true;
    Button loginbutton;
    TextView signup;
    String usernametxt;
    String passwordtxt;
    EditText password;
    EditText username;
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    public static final String LOGIN_URL = "http://simplifiedcoding.16mb.com/UserRegistration/volleyLogin.php";

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";

    //final ProgressDialog progressDialog=new ProgressDialog(login_activity.this,R.style.AppTheme_Dark_Dialog);
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      /*  if (first) {

        Parse.initialize(new Parse.Configuration.Builder(login_activity.this)
                        .applicationId("XQGRoNrmtgMo6Fy8Lz8r5BLuCkh9M4ar0GdIqOJO")

                        .clientKey("hB4jUT37nDPimVHQT1b7RBkrjK7C8a6Qo1mzBXFO")
                        .addNetworkInterceptor(new ParseLogInterceptor())
                        .server("https://parseapi.back4app.com/")
                //https://api.parse.com
//https://parseapi.back4app.com/
                        .build()
        );
      //  ParseObject testObject = new ParseObject("TestObject");
       // testObject.put("foo", "bar");
        //testObject.saveInBackground();
            first = false;
         }*/

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.input_password);
        loginbutton = (Button) findViewById(R.id.btn_login);
        signup=(TextView) findViewById(R.id.link_signup);

        loginbutton.setOnClickListener(new View.OnClickListener() {

                                           public void onClick(View arg0) {
                                               Intent i = new Intent(login_activity.this, Home.class);
                                               startActivity(i);

                                               //          progressDialog.setIndeterminate(true);
                                               //        progressDialog.setMessage("Authenticating...");
                                               //      progressDialog.show();


                                               // Retrieve the text entered from the EditText
                                               usernametxt = username.getText().toString();
                                               passwordtxt = password.getText().toString();

                                               //    userLogin();
                                               //openProfile();
             /*   ParseUser.logInInBackground(usernametxt, passwordtxt, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            // If user exist and authenticated, send user to Welcome.class
                            Intent intent = new Intent(
                                    login_activity.this,
                                    Home.class);
                            progressDialog.dismiss();
                            startActivity(intent);

                            Toast.makeText(getApplicationContext(),
                                    "Successfully Logged in",
                                    Toast.LENGTH_LONG).show();
                            Intent i = new Intent(login_activity.this, Home.class);


                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "No such user exist, please signup",

                                    Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });*/

                                           }

                                       }

        );

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(login_activity.this, signup_activity.class);

                startActivity(intent);
                finish();
            }
        });

    }







    private void userLogin() {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            openProfile();
                        }else{
                            Toast.makeText(login_activity.this, response, Toast.LENGTH_LONG).show();

                            //                progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(login_activity.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_USERNAME,usernametxt);
                map.put(KEY_PASSWORD,passwordtxt);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void openProfile(){
        Intent intent = new Intent(this, Home.class);
        intent.putExtra(KEY_USERNAME, usernametxt);
        startActivity(intent);
    }

}
