package com.achu.lab_2_q_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PorottaActivity extends AppCompatActivity {
    EditText t1;
    Button b1;
    RadioButton r1,r2,r3;
    DBHelper4 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porotta);
        r1=(RadioButton) findViewById(R.id.r1);
        r2=(RadioButton) findViewById(R.id.r2);
        r3=(RadioButton) findViewById(R.id.r3);
        t1=(EditText) findViewById(R.id.nog);
        DB = new DBHelper4(this);
        b1=(Button) findViewById(R.id.order);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type;
                if(r1.isChecked())
                    type= "Porotta & Chicken";
                else if(r2.isChecked())
                    type= "Beef & chicken";
                else
                    type= "Mutton & Chicken";
                String nog=t1.getText().toString();
                Boolean insert = DB.insertData(type, nog);
                if (insert == true)
                    Toast.makeText(PorottaActivity.this, "Ordered successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
