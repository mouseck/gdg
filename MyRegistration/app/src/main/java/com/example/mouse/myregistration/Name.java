package com.example.mouse.myregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Name extends AppCompatActivity implements View.OnClickListener {

    Button btn_save, btn_exit;
    EditText edit_name, edit_sname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        btn_save = (Button) findViewById(R.id.button5);
        btn_exit = (Button) findViewById(R.id.button6);
        edit_name = (EditText) findViewById(R.id.editText);
        edit_sname = (EditText) findViewById(R.id.editText2);

        btn_save.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
        edit_name.setOnClickListener(this);
        edit_sname.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.button5:
                String name = edit_name.getText().toString();
                String sName = edit_sname.getText().toString();
                intent.putExtra("name",name);
                intent.putExtra("sName", sName);
                setResult(RESULT_OK, intent);
                break;
            case R.id.button6:
                setResult(RESULT_CANCELED, intent);
                break;
        }
        finish();

    }
}
