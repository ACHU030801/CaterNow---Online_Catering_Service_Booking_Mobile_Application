package com.achu.lab_2_q_4;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {
    Button b1,b2,b3;
    DBHelper2 DB;
    DBHelper3 DB3;
    DBHelper4 DB4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        DB = new DBHelper2(this);
        DB3 = new DBHelper3(this);
        DB4 = new DBHelper4(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("TYPE :" + res.getString(0) + "\n");
                    buffer.append("NO OF GUEST :" + res.getString(1) + "\n");

                }
                showMessage("Data", buffer.toString());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB3.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("TYPE :" + res.getString(0) + "\n");
                    buffer.append("NO OF GUEST :" + res.getString(1) + "\n");

                }
                showMessage("Data", buffer.toString());
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB4.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("TYPE :" + res.getString(0) + "\n");
                    buffer.append("NO OF GUEST :" + res.getString(1) + "\n");

                }
                showMessage("Data", buffer.toString());
            }
        });
    }
    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
