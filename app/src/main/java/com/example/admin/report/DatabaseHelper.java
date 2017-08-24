package com.example.admin.report;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 8/14/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //Log in table

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "student.db";

    private static final String TABLE_NAME = "peoples_student";
    private static final String COLUMNS_ID = "id";
    private static final String COLUMNS_NAME = "name";
    private static final String COLUMNS_EMAIL = "email";
    private static final String COLUMNS_UNAME = "uname";
    private static final String COLUMNS_PASS = "pass";
    private static final String COLUMNS_ROLE = "role";

    //inserting data table
    public static final String TEACHER_TABLE = "student_table";
    public static final String COL1 = "IDs";
    public static final String COL2 = "name";
    public static final String COL3 = "surname";
    public static final String COL4 = "email";
    public static final String COL5 = "image";
    public static final String COL6 = "subject";
    public static final String COL7 = "subject2";
    public static final String COL8 = "subject3";
    public static final String COL9 = "subject4";
    public static final String COL10 = "subject5";
    public static final String COL11 = "subject6";
    public static final String COL12 = "total";
    public static final String COL13 = "comment";

    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTables = "create table " + TABLE_NAME + " (id integer primary key autoincrement," + "name text, email text, uname text, pass text, role text ) ";
        db.execSQL(createTables);

        String createTable = "create table " + TEACHER_TABLE + " (IDs integer primary key autoincrement," + "name text, surname text, email text, image blob, subject integer, subject2 integer, subject3 integer, subject4 integer, subject5 integer, subject6 integer, total integer, comment text)";
        db.execSQL(createTable);

    }

    public void insertContact(Contact c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from peoples_student";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMNS_ID, count);
        values.put(COLUMNS_NAME, c.getName());
        values.put(COLUMNS_EMAIL, c.getEmail());
        values.put(COLUMNS_UNAME, c.getUsername());
        values.put(COLUMNS_PASS, c.getPassword());
        values.put(COLUMNS_ROLE, c.getRole());

        db.insert(TABLE_NAME, null, values);
        db.close();


    }

    public String[] searchPass(String uname) {
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);

        String[] b = new String[3];
        b[0] = "not found";

        if (cursor.moveToFirst()) {
            do {
                b[1] = cursor.getString(cursor.getColumnIndex(COLUMNS_UNAME));


                if (b[1].equals(uname)) {
                    b[0] = cursor.getString(cursor.getColumnIndex(COLUMNS_PASS));

                    break;
                }
                b[2] = cursor.getString(cursor.getColumnIndex(COLUMNS_ROLE));
            }
            while (cursor.moveToNext());
        }

        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

        String request = "DROP TABLE IF EXISTS " + TEACHER_TABLE;
        db.execSQL(request);
        this.onCreate(db);


    }

    public boolean addData(Report report) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, report.getName());
        contentValues.put(COL3, report.getSurname());
        contentValues.put(COL4, report.getEmail());
        contentValues.put(COL5, report.getImage());
        contentValues.put(COL6, report.getEnglish());
        contentValues.put(COL7, report.getMaths());
        contentValues.put(COL8, report.getIsizilu());
        contentValues.put(COL9, report.getLifeScience());
        contentValues.put(COL10, report.getComputer());
        contentValues.put(COL11, report.getPhysicalscience());
        contentValues.put(COL12, report.getTotal());
        contentValues.put(COL13, report.getComment());

        long result = db.insert(TEACHER_TABLE, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public List<Report> showData() {

        List<Report> reports = new ArrayList<>();


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from " + TEACHER_TABLE, null);


        if (data.moveToFirst()) {
            do {
                Report report1 = new Report();
                report1.setId(data.getInt(data.getColumnIndex(COL1)));
                report1.setName(data.getString(data.getColumnIndex(COL2)));
                report1.setSurname(data.getString(data.getColumnIndex(COL3)));
                report1.setEmail(data.getString(data.getColumnIndex(COL4)));
                report1.setEnglish(data.getInt(data.getColumnIndex(COL6)));
                report1.setMaths(data.getInt(data.getColumnIndex(COL7)));
                report1.setIsizilu(data.getInt(data.getColumnIndex(COL8)));
                report1.setLifeScience(data.getInt(data.getColumnIndex(COL9)));
                report1.setComputer(data.getInt(data.getColumnIndex(COL10)));
                report1.setPhysicalscience(data.getInt(data.getColumnIndex(COL11)));
                report1.setComment(data.getString(data.getColumnIndex(COL12)));
                report1.setTotal(data.getInt(data.getColumnIndex(COL13)));

                reports.add(report1);
            } while (data.moveToNext());
        }
        return reports;
    }

    public boolean updateData(Report report) {
        String update[] = {String.valueOf(report.getId())};
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, report.getName());
        contentValues.put(COL3, report.getSurname());
        contentValues.put(COL4, report.getEmail());
        contentValues.put(COL5, report.getEnglish());
        contentValues.put(COL6, report.getMaths());
        contentValues.put(COL7, report.getIsizilu());
        contentValues.put(COL8, report.getLifeScience());
        contentValues.put(COL9, report.getComputer());
        contentValues.put(COL10, report.getPhysicalscience());
        contentValues.put(COL11, report.getComputer());
        contentValues.put(COL12, report.getTotal());
        contentValues.put(COL13, report.getComment());

        db.update(TEACHER_TABLE, contentValues, "IDs = ?", update);
        return true;

    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TEACHER_TABLE, "IDs = ?", new String[]{id});
    }


}




