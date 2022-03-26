package com.achu.lab_2_q_4;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnlogin;
    RadioButton r1,r2;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        r1=(RadioButton)findViewById(R.id.radioButton3);
        r2=(RadioButton)findViewById(R.id.radioButton4);
        btnlogin = (Button) findViewById(R.id.button);

        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        if(r1.isChecked())
                        {
                            Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                            Intent intent  = new Intent(getApplicationContext(), AdminActivity.class);
                            startActivity(intent);
                        }
                        else if(r2.isChecked())
                        {
                            Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                            Intent intent  = new Intent(getApplicationContext(), UserActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "Please mention whether you are admin or a user", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}