package com.example.afreen.speakupfinal;

/**
 * Created by sejal on 28/11/16.
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by sejal on 27/11/16.
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AFREEN on 11/18/2016.
 */

public class nn1 extends AppCompatActivity {
    Button insert7;
    EditText et;
    String email3;
    String qq;
    String com;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.grpcommnt6);
        et=(EditText)findViewById(R.id.problem);
        insert7 =(Button) findViewById(R.id.but13);
        insert7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupadmin n = new groupadmin();
                email3 = n.tt;
                qq=ph2.name;
                com=et.getText().toString();
                Toast.makeText(getApplicationContext(), email3, Toast.LENGTH_LONG).show();
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);

                nameValuePairs.add(new BasicNameValuePair("email8", com));
                nameValuePairs.add(new BasicNameValuePair("email", email3));
                nameValuePairs.add(new BasicNameValuePair("email9", qq));


                InputStream is = null;
                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://seju.esy.es/addgrpcommnt.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpClient.execute(httpPost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                    // Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb2 = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb2.append(line);
                    }
                    String result3 = sb2.toString();
                    Toast.makeText(getApplicationContext(), result3, Toast.LENGTH_LONG).show();
                    /** String result1=sb.toString();

                     Toast.makeText(getApplicationContext(),result1,Toast.LENGTH_LONG).show();
                     if(result1.equals("success")){
                     Intent intent=new Intent(ar.getContext(),Login.class);
                     ar.getContext().startActivity(intent);}
                     **/
                } catch (ClientProtocolException e) {
                    Log.e("ClientProtocol", "Log_tag");
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.e("Log_tag", "IOException");
                    e.printStackTrace();
                }


            }
        });
    }
}






