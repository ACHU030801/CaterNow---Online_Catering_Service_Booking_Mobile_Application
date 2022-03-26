package com.achu.lab_2_q_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BiriyaniActivity extends AppCompatActivity {
    EditText t1;
    Button b1;
    RadioButton r1,r2,r3;
    DBHelper3 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biriyani);
        r1=(RadioButton) findViewById(R.id.r1);
        r2=(RadioButton) findViewById(R.id.r2);
        r3=(RadioButton) findViewById(R.id.r3);
        t1=(EditText) findViewById(R.id.nog);
        DB = new DBHelper3(this);
        b1=(Button) findViewById(R.id.order);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type;
                if(r1.isChecked())
                    type= "Chicken Biriyani";
                else if(r2.isChecked())
                    type= "Mutton Biriyani";
                else
                    type= "Beef Biriyani";
                String nog=t1.getText().toString();
                Boolean insert = DB.insertData(type, nog);
                if (insert == true)
                    Toast.makeText(BiriyaniActivity.this, "Ordered successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
