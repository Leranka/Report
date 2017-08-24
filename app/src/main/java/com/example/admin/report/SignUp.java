package com.example.admin.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUp extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);
    Spinner s;
    String select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        s = findViewById(R.id.spinner);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 1) {
                    select = "Teacher";
                }

                if (i == 2) {
                    select = "Student";
                }

                Toast.makeText(SignUp.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onSignUpClick(View v) {
        if (v.getId() == R.id.BSignUpButton) {
            EditText name = findViewById(R.id.TFName);
            EditText email = findViewById(R.id.TFEmail);
            EditText uname = findViewById(R.id.TFUname);
            EditText pass1 = findViewById(R.id.TFPass1);
            EditText pass2 = findViewById(R.id.TFpass2);
            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if (pass2str.isEmpty()) {
                Toast.makeText(SignUp.this, "Enter password", Toast.LENGTH_SHORT).show();
            } else if (!pass1str.equals(pass2str)) {
                Toast.makeText(SignUp.this, "Password don't match", Toast.LENGTH_SHORT).show();
            } else {
                //insert detail in database
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUsername(unamestr);
                c.setPassword(pass1str);
                c.setRole(select);

                helper.insertContact(c);

                if (select == "Teacher") {
                    Intent i = new Intent(SignUp.this, Display.class);
                    startActivity(i);
                }

                if (select == "Student") {
                    Intent i = new Intent(SignUp.this, ViewData.class);
                    startActivity(i);
                }

            }

        }
    }
}
