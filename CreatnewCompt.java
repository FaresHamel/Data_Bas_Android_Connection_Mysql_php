package com.example.practice.studentdocumentation.applicationdatabases;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.net.sip.SipAudioCall;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CreatnewCompt extends AppCompatActivity {

    public EditText usernameEditText;
    public EditText vorNameEditText;
    public EditText nachNameEditText;
    public EditText emailEditText;
    public EditText passwordEditText;
    public ImageButton btngetImage;
    public CheckBox checkBox;

    private RequestQueue requestQueue;
    private StringRequest newMyRequest ;
    private String   url1 = "http://192.168.43.62:8080/Android/login.php";;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creatnew_compt);

        Button btnnInscription = (Button) findViewById(R.id.bttn_creat_acount);

        btnnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameEditText = findViewById(R.id.user_name_client);
                vorNameEditText =findViewById(R.id.firstname_client);
                nachNameEditText = findViewById(R.id.lastname_creatcount_client);
                emailEditText = findViewById(R.id.email_client);
                passwordEditText = findViewById(R.id.client_creatcount_password);
                checkBox = findViewById(R.id.checkbox_remmeber_me);
                btngetImage = (ImageButton) findViewById(R.id.btn_get_new_imaage);

                String name = usernameEditText.getText().toString();
                String prenom = vorNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String email  = emailEditText.getText().toString();

                sendDatauser(name,prenom,password,email);
            }});}

    public void sendDatauser(final String nam, final String prename,final String pasworduser, final String emailuser){

        JSONObject jsonObject = new JSONObject();

        try {

            jsonObject.put("Name",nam);
            jsonObject.put("Prenom",prename);
            jsonObject.put("Email",emailuser);
            jsonObject.put("Password",pasworduser);
            
        }catch (JSONException E){
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST,
                url1, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("wtf er can resoin",""+response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse:" +error);
                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonObjReq);
    }


}
