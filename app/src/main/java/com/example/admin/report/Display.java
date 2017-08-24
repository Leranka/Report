package com.example.admin.report;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Display extends Activity {
    DatabaseHelper peopleDB;
    Button btnAddData, btnViewData, btnUpdataData, btnDeleteData, btnSignout;
    EditText eName, eEmail, eSurname, eID, eSubj, eSubj2,eSubj3,eSubj4,eSubj5,eSubj6,eTotal, eComment;
    ImageView imageView;
    byte[] byteArray;
    public final static int PICK_IMAGE_REQUEST = 1;
    Report report;
    public static int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        report = new Report();

        peopleDB = new DatabaseHelper(this);

        eName = findViewById(R.id.Display);
        eEmail = findViewById(R.id.etNewEmail);
        eSurname = findViewById(R.id.etNewTv);
        eID = findViewById(R.id.etID);
        eSubj = findViewById(R.id.etMarks);
        eSubj2 = findViewById(R.id.etMarks2);
        eSubj3 = findViewById(R.id.etMarks3);
        eSubj4 = findViewById(R.id.etMarks4);
        eSubj5 = findViewById(R.id.etMarks5);
        eSubj6 = findViewById(R.id.etMarks6);
        eTotal = findViewById(R.id.etTotal);
        eComment = findViewById(R.id.etComment);
        btnAddData = findViewById(R.id.btnAddData);
        btnViewData = findViewById(R.id.btnViewData);
        btnUpdataData = findViewById(R.id.btnUpdateData);
        btnDeleteData = findViewById(R.id.btnDeleteData);
        btnSignout = findViewById(R.id.btnSignout);
        imageView = findViewById(R.id.rImage);

        addData();
        updateData();
        deletData();

        btnSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Display.this,MainActivity.class);
                startActivity(i);
            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Display.this,ViewData.class);
                startActivity(intent);
            }
        });
    }


    public void addData() {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = eName.getText().toString();
                String email = eEmail.getText().toString();
                String surname = eSurname.getText().toString();
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byteArray = stream.toByteArray();
                int subject = Integer.valueOf(eSubj.getText().toString());
                int subject2 = Integer.valueOf(eSubj2.getText().toString());
                int subject3 = Integer.valueOf(eSubj3.getText().toString());
                int subject4 = Integer.valueOf(eSubj4.getText().toString());
                int subject5 = Integer.valueOf(eSubj5.getText().toString());
                int subject6 = Integer.valueOf(eSubj6.getText().toString());
                Toast.makeText(Display.this,"failed" + name,Toast.LENGTH_SHORT).show();
                double marks = subject + subject2 +subject3 + subject4 +subject5 +subject6;
                double mark = marks/600;
                double perc = mark*100;


                total = Integer.valueOf((int) perc);

                if (marks > 50){
                    Toast.makeText(Display.this,"passed",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Display.this,"failed"+name,Toast.LENGTH_SHORT).show();
                }
                String comment = eComment.getText().toString();

                Toast.makeText(Display.this,"failed" + name,Toast.LENGTH_SHORT).show();
                report.setName(name);
                report.setEmail(email);
                report.setSurname(surname);
                report.setImage(byteArray);
                report.setEnglish(subject);
                report.setIsizilu(subject2);
                report.setLifeScience(subject3);
                report.setComputer(subject4);
                report.setPhysicalscience(subject5);
                report.setTotal(total);
                report.setComment(comment);

                boolean insertData = peopleDB.addData(report);

                if (insertData == true) {
                    Toast.makeText(Display.this, "Data successfully inserted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Display.this, "Something went wrong :(.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);

            }
        });
    }

    public void updateData() {
        btnUpdataData.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                int temp = eID.getText().toString().length();

                String name = eName.getText().toString();
                String email = eEmail.getText().toString();
                String surname = eSurname.getText().toString();
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byteArray = stream.toByteArray();
                int subject = Integer.valueOf(eSubj.getText().toString());
                int subject2 = Integer.valueOf(eSubj2.getText().toString());
                int subject3 = Integer.valueOf(eSubj3.getText().toString());
                int subject4 = Integer.valueOf(eSubj4.getText().toString());
                int subject5 = Integer.valueOf(eSubj5.getText().toString());
                int subject6 = Integer.valueOf(eSubj6.getText().toString());
                double marks = subject + subject2 +subject3 + subject4 +subject5 +subject6;
                double mark = marks/600;
                double perc = mark*100;
                int total = Integer.valueOf((int) perc);

                if (marks > 50){
                    Toast.makeText(Display.this,"passed",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Display.this,"failed"+name,Toast.LENGTH_SHORT).show();
                }
                String comment = eComment.getText().toString();

                report.setName(name);
                report.setEmail(email);
                report.setSurname(surname);
                report.setImage(byteArray);
                report.setEnglish(subject);
                report.setIsizilu(subject2);
                report.setLifeScience(subject3);
                report.setComputer(subject4);
                report.setPhysicalscience(subject5);
                report.setTotal(total);
                report.setComment(comment);
                if (temp > 0) {
                    boolean update = peopleDB.updateData(report);
                    if (update == true) {
                        Toast.makeText(Display.this, "Successfully updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Display.this, "Something went wrong :(.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Display.this, "Enter ID to update  :(.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void deletData() {
        btnDeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = eID.getText().toString().length();
                if (temp > 0) {
                    Integer deleterow = peopleDB.deleteData(eID.getText().toString());
                    if (deleterow > 0) {
                        Toast.makeText(Display.this, "Successfully deleted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Display.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Display.this, "Enter ID to delete :(.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            // When an Image is picked
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                    && null != data) {

                // Get the Image from data
                Uri selectedImage = data.getData();
                InputStream image_stream = getContentResolver().openInputStream(selectedImage);
                Bitmap bitmap = BitmapFactory.decodeStream(image_stream);
                imageView.setImageBitmap(bitmap);

                Toast.makeText(this, "image selected",
                        Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "select image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
    }

}
