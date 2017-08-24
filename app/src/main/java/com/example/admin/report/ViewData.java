package com.example.admin.report;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

public class ViewData extends AppCompatActivity {

    DatabaseHelper myDB;
    ListView listView;
    RAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        myDB = new DatabaseHelper(this);
        listView = (ListView)findViewById(R.id.list_view);

        List<Report> data = myDB.showData();
        adapter =new RAdapter(this, data);
        listView.setAdapter(adapter);
        }
    }

