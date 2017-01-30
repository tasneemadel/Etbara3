package com.example.taseneem21.bloodbank_v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
public class signup_activity extends Activity implements AdapterView.OnItemSelectedListener{
    Button signupbtn;
    EditText userEt,passEt,emailE;
    Spinner bloodtype;
    Spinner city;
    Spinner zipcode;
    TextView loginTv;
    public static final String REGISTER_URL = "http://simplifiedcoding.16mb.com/UserRegistration/volleyLogin.php";

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";
    public static final String KEY_Email="Email";
    public static final String KEY_Bloodtype="BloodType";
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    private String username;
    private String password;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(signup_activity.this,login_activity.class);
        startActivity(i);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);


        signupbtn = (Button) findViewById(R.id.btn_signup);
        userEt = (EditText) findViewById(R.id.input_name);
        bloodtype=(Spinner) findViewById(R.id.input_bloodtype);
        city=(Spinner) findViewById(R.id.city);
        zipcode=(Spinner) findViewById(R.id.zipcode);
        passEt = (EditText) findViewById(R.id.input_password);
        emailE = (EditText) findViewById(R.id.input_email);
        loginTv = (TextView) findViewById(R.id.link_login);





        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.BloodType_array,
                        android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> staticAdapter1 = ArrayAdapter
                .createFromResource(this, R.array.city_array,
                        android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> staticAdapter2 = ArrayAdapter
                .createFromResource(this, R.array.zipcode_array,
                        android.R.layout.simple_spinner_item);

        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         staticAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        bloodtype.setAdapter(staticAdapter);
        city.setAdapter(staticAdapter1);
        zipcode.setAdapter(staticAdapter2);

        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(signup_activity.this,login_activity.class);
                startActivity(intent);
                finish();

            }
        });




        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(signup_activity.this,
                        R.style.AppTheme_Dark_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Processing...");
                progressDialog.show();
                if (userEt.getText().toString().equalsIgnoreCase("") || passEt.getText().toString().equalsIgnoreCase("") || emailE.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(signup_activity.this, "Please Complete the required Fields", Toast.LENGTH_SHORT).show();
                } else {

                   // registerUser();

                    Intent i=new Intent();

                    startActivity(i);

            /*        final ParseUser parseUser = new ParseUser();
                    parseUser.setUsername(userEt.getText().toString());
                    parseUser.setPassword(passEt.getText().toString());
                    parseUser.setEmail(emailE.getText().toString());

                    parseUser.put("BloodType",bloodtype.getText().toString());

                    parseUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(signup_activity.this, "Successful Registeration", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(signup_activity.this, Home.class);
                                i.putExtra("user", parseUser.getUsername());

                                startActivity(i);
                                progressDialog.dismiss();
                            } else {
                                Toast.makeText(signup_activity.this, "Failed", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();

                            }
                        }
                    }

                    );

*/
                }
           /*     new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                // On complete call either onLoginSuccess or onLoginFailed
                                signupbtn.setEnabled(true);
                                finish();
                                // onLoginFailed();
                                progressDialog.dismiss();
                            }
                        }, 100000);*/

            }   });

    }


    private void registerUser(){



        final String username = userEt.getText().toString().trim();
        final String password = passEt.getText().toString().trim();
        final String email = emailE.getText().toString().trim();
      //  final String bloodtyp = bloodtype.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(signup_activity.this,response,Toast.LENGTH_LONG).show();
                        final ProgressDialog progressDialog = new ProgressDialog(signup_activity.this,
                                R.style.AppTheme_Dark_Dialog);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(signup_activity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME,username);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_Email, email);
        //        params.put(KEY_Bloodtype, bloodtyp);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
