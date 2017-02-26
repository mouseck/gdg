package com.example.mouse.myregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {

    final int REQUEST_NAME = 1;
    final int REQUEST_DATA = 2;
    final int REQUEST_ABOUT_ME = 3;
    Button btn_name, btn_data, btn_abautmy, btn_register;
    String fName, lName, bData, aboutMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_name = (Button) findViewById(R.id.button);
        btn_data = (Button) findViewById(R.id.button2);
        btn_abautmy = (Button) findViewById(R.id.button3);
        btn_register = (Button) findViewById(R.id.button4);

        btn_name.setOnClickListener(this);
        btn_data.setOnClickListener(this);
        btn_abautmy.setOnClickListener(this);
        btn_register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button:
                Intent nameIntent = new Intent(this, Name.class);
                startActivityForResult(nameIntent, REQUEST_NAME);
                break;
            case R.id.button2:
                Intent dateIntent = new Intent(this, DataActivity.class);
                startActivityForResult(dateIntent, REQUEST_DATA);
                break;
            case R.id.button3:
                Intent aboutIntent = new Intent(this, AbautmyActivity.class);
                startActivityForResult(aboutIntent, REQUEST_ABOUT_ME);
                break;
            case R.id.button4:
                Intent registrationIntent = new Intent(this, CloseMainActivity.class);

                registrationIntent.putExtra("fName",fName);
                registrationIntent.putExtra("lName",lName);
                registrationIntent.putExtra("bData",bData);
                registrationIntent.putExtra("aboutMe",aboutMe);

                startActivity(registrationIntent);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK ) {
            switch (requestCode) {
                case REQUEST_NAME:
                    fName = data.getStringExtra("name");
                    lName = data.getStringExtra("sName");
                    break;
                case REQUEST_DATA:
                    bData = data.getStringExtra("data");
                    break;
                case REQUEST_ABOUT_ME:
                    aboutMe = data.getStringExtra("aboutMe");
                    break;
            }
        } else {
            Toast.makeText(this, "Wrong Result", Toast.LENGTH_LONG).show();

        }

    }
}
