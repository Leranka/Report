package com.example.admin.report;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Admin on 8/23/2017.
 */

public class List extends AppCompatActivity {

    ListView lv;
    public static Report SELECTED_ITEM;
    private Report s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        lv = (ListView) findViewById(R.id.list_view);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(List.this, Results.class);

                Report museum = (Report) lv.getItemAtPosition(i);
                SELECTED_ITEM = museum;
                intent.putExtra("select",SELECTED_ITEM);
                startActivity(intent);
            }
        });
    }
}
