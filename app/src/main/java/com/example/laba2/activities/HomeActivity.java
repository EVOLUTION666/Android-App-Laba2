package com.example.laba2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.laba2.R;
import com.example.laba2.adapters.RecyclerViewAdapter;
import com.example.laba2.model.Civilization;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private final String JSON_URL = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/techs.ruleset.json";
    private final String IMAGE_URL = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/";
    private final static String TAG ="HomeActivity";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Civilization> lstCivilization;
    private RecyclerView recyclerView;



//Создаем recyclerview, парсим json и настраиваем recyclerview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        lstCivilization = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();

    }


//

//Парсим наш JSON файл и добавляем элементы в List
    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                            Civilization civilization = new Civilization();
                            civilization.setName(jsonObject.getString("name"));
                            if (jsonObject.has("helptext")) {
                                civilization.setHelptext(jsonObject.getString("helptext"));
                            } else {
                                civilization.setHelptext("This card does't have help text!");
                            }
                            civilization.setGraphic(jsonObject.getString("graphic"));
                            lstCivilization.add(civilization);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                Singleton.getInstance().setItems(lstCivilization);
                setuprecyclerview(lstCivilization);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(HomeActivity.this);
        requestQueue.add(request);



    }
//Добавляем Adapter для RecyclerView
    public void setuprecyclerview(List<Civilization> lstCivilization) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, lstCivilization);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);

    }

}
