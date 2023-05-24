package com.example.myrecyclerapplication;

import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActivityRemoteData extends AppCompatActivity {

    private static final String JSON_URL = "https://canadiancybertech.com/json/data.json";
    ListView listView;
    List<Menu> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_data);

        listView = findViewById(R.id.listView);
        menuList = new ArrayList<>();
        loadMenuList();
    }

    private void loadMenuList() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        //creating a string request to to set the request URL
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>(){
            @Override
            public void onResponse(String response){
                progressBar.setVisibility(View.INVISIBLE);
                try {
                    JSONObject obj = new JSONObject(response);

                    JSONArray menuItemsArray = obj.getJSONArray("menuItems");

                    for (int i = 0; i< menuItemsArray.length(); i++){
                        JSONObject menuItemsObject = menuItemsArray.getJSONObject(i);

                        Menu menuItem = new Menu(menuItemsObject.getString("name"),
                                menuItemsObject.getString("imageurl"),
                                menuItemsObject.getString("description"));

                        menuList.add(menuItem);
                    }
                    MyAdapter adapter = new MyAdapter(menuList, getApplicationContext());
                    listView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityRemoteData.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}