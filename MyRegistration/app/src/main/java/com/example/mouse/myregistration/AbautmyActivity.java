package com.example.mouse.myregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AbautmyActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_save, btn_exit;
    EditText edit_abaut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abautmy);

        btn_save = (Button) findViewById(R.id.button9);
        btn_exit = (Button) findViewById(R.id.button10);
        edit_abaut = (EditText) findViewById(R.id.editText4);

        btn_save.setOnClickListener(this);
        btn_exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.button9:
                String abaut = edit_abaut.getText().toString();
                intent.putExtra("aboutMe",abaut);
                setResult(RESULT_OK, intent);
                break;
            case R.id.button10:
                setResult(RESULT_CANCELED, intent);
                break;
        }
        finish();
    }
}
