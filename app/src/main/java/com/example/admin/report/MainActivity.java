package com.example.admin.report;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DatabaseHelper(this);

        Button btn = (Button) findViewById(R.id.BSignUp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
            }
        });
    }

    public void onButtonClick(View v) {

        if (v.getId() == R.id.BLogin) {

            EditText editTextName = (EditText) findViewById(R.id.TFUsername);
            String str = editTextName.getText().toString();
            EditText editTextPass = (EditText) findViewById(R.id.TFPassword);
            String pass = editTextPass.getText().toString();

            String[] p = helper.searchPass(str);
            String password = p[0];
            String role = p[2];
            if (password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
            } else if (pass.equals(password)) {
                Toast.makeText(MainActivity.this, "Role " + role, Toast.LENGTH_SHORT).show();
                if (role.equalsIgnoreCase("teacher")) {
                    Intent i = new Intent(MainActivity.this, Display.class);
                    i.putExtra("Username", str);
                    startActivity(i);
                } else if (role.equalsIgnoreCase("student")) {
                    Intent i = new Intent(MainActivity.this, ViewData.class);
                    i.putExtra("Username", str);
                    startActivity(i);
                }

            } else {

                Toast.makeText(MainActivity.this, "Username and Password don't match" + password + " " + role, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
