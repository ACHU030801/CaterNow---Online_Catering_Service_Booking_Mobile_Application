package com.achu.lab_2_q_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SadhyaActivity extends AppCompatActivity {
    EditText t1;
    Button b1;
    DBHelper2 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sadhya);
        t1=(EditText) findViewById(R.id.nog);
        DB = new DBHelper2(this);
        b1=(Button) findViewById(R.id.order);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type="Sadhya";
                String nog=t1.getText().toString();
                Boolean insert = DB.insertData(type, nog);
                if (insert == true)
                    Toast.makeText(SadhyaActivity.this, "Ordered successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
