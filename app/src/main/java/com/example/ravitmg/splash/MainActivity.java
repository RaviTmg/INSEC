package com.example.ravitmg.splash;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Eveents> orgObjectList  =new ArrayList<Eveents>();
    MainAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(getApplicationContext(), orgObjectList);
        recyclerView.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        getData();

    }

    private void getData() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://insecnotification.azurewebsites.net/event_json.php", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                parseData(response);
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }

    private void parseData(JSONArray response) {
        for (int i = 0; i < response.length(); i++) {

            Eveents eveents = new Eveents();
            try {
                JSONObject jsonObject = response.getJSONObject(i);
                eveents.setDate(jsonObject.getString("date"));
                eveents.setTitle(jsonObject.getString("Title"));
                eveents.setDesc(jsonObject.getString("Description"));
                orgObjectList.add(eveents);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            //orgObjectList.add(eveents);
        }
        adapter = new MainAdapter(getApplicationContext(), orgObjectList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
