package com.example.mouse.myregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_save, btn_exit;
    EditText edit_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        btn_save = (Button) findViewById(R.id.button7);
        btn_exit = (Button) findViewById(R.id.button8);
        edit_data = (EditText) findViewById(R.id.editText3);

        btn_save.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){

            case R.id.button7:
                String data = edit_data.getText().toString();
                intent.putExtra("data",data);
                setResult(RESULT_OK, intent);
                break;
            case R.id.button8:
                setResult(RESULT_CANCELED, intent);
                break;

        }
        finish();
    }

}
