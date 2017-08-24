package com.example.admin.report;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Admin on 8/15/2017.
 */

public class Results extends AppCompatActivity {

    DatabaseHelper helper;
    EditText name,surname,email,english,zulu,maths,life,computer,physical,comment,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        helper = new DatabaseHelper(this);

        name = (EditText) findViewById(R.id.etStudentName);
        surname = (EditText) findViewById(R.id.etStudentSurname);
        email = (EditText) findViewById(R.id.etStudentEmail);
        english = (EditText) findViewById(R.id.etStudentEnglish);
        zulu =  (EditText) findViewById(R.id.etStudentZulu);
        maths =(EditText) findViewById(R.id.etStudentMaths);
        life =  (EditText)findViewById(R.id.etStudentLife);
        computer = (EditText) findViewById(R.id.etStudentComputer);
        physical = (EditText) findViewById(R.id.etStudentPhysical);
        comment = (EditText) findViewById(R.id.etStudentComment);
        total = (EditText)findViewById(R.id.etStudentTotal);

        Intent i = getIntent();
        Report report = (Report) i.getSerializableExtra("select");


        name.setText(report.getName());
        surname.setText(report.getSurname());
        email.setText(report.getEmail());
        english.setText("" + report.getEnglish());
        zulu.setText("" + report.getIsizilu());
        maths.setText("" + report.getMaths());
        life.setText("" + report.getLifeScience());
        computer.setText("" + report.getComputer());
        physical.setText("" + report.getPhysicalscience());
        comment.setText(report.getComment());
        total.setText("" + report.getTotal());
    }
}
