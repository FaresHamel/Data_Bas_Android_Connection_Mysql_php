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


        //Test JasonFile

//        String jsonFormUrl = "{\n" +
//                "   \n" +
//                "\n" +
//                "\n" +
//                "    \"info\":{\n" +
//                "        \"name\":\"fares\",\n" +
//                "        \"age\":23\n" +
//                "    } ,\n" +
//                "    \n" +
//                "    \"job\":[{\n" +
//                "\n" +
//                "           \"id\":1,\n" +
//                "           \"name\":\"Kellner\",\n" +
//                "           \"Plaz\":\"El Marsa\"\n" +
//                "          },\n" +
//                "           {\n" +
//                "\n" +
//                "            \"id\":2,\n" +
//                "            \"namejob\":\"Developer\",\n" +
//                "            \"plaz\":\"Florida\"\n" +
//                "         }\n" +
//                "\n" +
//                "     ]\n" +
//                "}";
//
//        try {
//
//            JSONObject jsonObject = new JSONObject(jsonFormUrl);
//
//            JSONObject inFo = jsonObject.getJSONObject("info");
//            String name = inFo.getString("name");
//            int age = inFo.getInt("age");
//
//
//            JSONArray jsonArray = jsonObject.getJSONArray("job");
//
//            for (int i=0;i<jsonArray.length();i++){
//
//                JSONObject job = jsonArray.getJSONObject(i);
//                int id = job.getInt("id");
//                String plaz = job.getString("plaz");
//                String namejob = job.getString("name");
//
//            }
//
//           } catch (JSONException e) {
//
//
//            e.printStackTrace();
//        }


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

//                sendData(
//                        vorNameEditText.getText().toString(),
//                        nachNameEditText.getText().toString(),
//                        emailEditText.getText().toString(),
//                        password.getText().toString());
//                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//
//
//                    @Override
//                    public void onResponse(String response) {
//
//
//                        Log.d("wtf er can resoin",response);
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                        Log.d("fuck hier",""+error);
//                    }
//                }){
//                    @Override
//                    protected Map<String, String> getParams()  {
//                        Map<String,String>parms=new HashMap<String, String>();
//                        parms.put("Name",vorNameEditText.getText().toString());
//                        parms.put("Email",emailEditText.getText().toString());
//                        parms.put("Prenom",nachNameEditText.getText().toString());
//                        parms.put("Password",passwordEditText.getText().toString());
//                        return parms;
//                    }
//                };
////
//
//                RequestQueue mynew = Volley.newRequestQueue(getApplicationContext());
//                mynew.add(request);
            }

           });



    }

    public void sendDatauser(final String nam, final String prename,final String pasworduser, final String emailuser){





//        Response.Listener<String> listenerrS= new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//
//                try {
//                    JSONArray jsonArray = new JSONArray(response);
//                    JSONObject jsonObject = jsonArray.getJSONObject(0);
//
//                    Toast.makeText(CreatnewCompt.this, ""+jsonObject, Toast.LENGTH_SHORT).show();
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        };


//         newMyRequest = new StringRequest(Request.Method.POST,url1,listenerrS,new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }){
//
//
//            @Override
//            protected Map<String, String> getParams()  {
//                Map<String,String>parms=new HashMap<>();
//
//                parms.put("Name",nam);
//                parms.put("Prenom",prename);
//                parms.put("Email",emailuser);
//                parms.put("Password",pasworduser);
//
//                return parms;
//            }
//
//        };


        JSONObject jsonObject = new JSONObject();

        try {

            jsonObject.put("Name",nam);
            jsonObject.put("Prenom",prename);
            jsonObject.put("Email",emailuser);
            jsonObject.put("Password",pasworduser);
            

        }catch (JSONException E){

        }






        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,

                url1, jsonObject,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("wtf er can resoin",""+response);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });



        final RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(jsonObjReq);
    }


    public void newImage(View view){


        Intent intentimag = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intentimag,100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK){


            Uri uri = data.getData();
            btngetImage.setImageURI(uri);

        }
    }



//    private void sendData(final String name2, final String prenom2, final String Email2, final String password2){
//
//        Toast.makeText(this, ""+name2+" "+prenom2+" "+password2, Toast.LENGTH_SHORT).show();
//
//        requestQueue = Volley.newRequestQueue(getApplicationContext());
//
//        Response.Listener<String> responselistener = new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                try {
//
//                    JSONArray jsonArray = new JSONArray(response);
//                    JSONObject jsonObject = jsonArray.getJSONObject(0);
//                    String dataseving = jsonObject.getString("success");
//
//                    if (dataseving.contains("insertion_ok")){
//
//
//                        Toast.makeText(CreatnewCompt.this, "yes das machst so", Toast.LENGTH_SHORT).show();
//
//                    }else {
//
//                        Toast.makeText(CreatnewCompt.this, "nichts macht", Toast.LENGTH_SHORT).show();
//
//                    }
//
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//
//        };
//
//        StringRequest stringRequest1 = new StringRequest(Request.Method.POST,url,responselistener,null){
//
//
//            @Override
//            protected Map<String, String> getParams(){
//
//                Map<String,String> res = new HashMap<>();
//
//                res.put("Name",name2);
//                res.put("Prenom",prenom2);
//                res.put("Email",Email2);
//                res.put("Password",password2);
//
//
//                return res;
//            }
//        };
//
//        requestQueue.add(stringRequest1);
//
//    }

}
