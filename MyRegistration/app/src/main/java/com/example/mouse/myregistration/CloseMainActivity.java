package com.example.mouse.myregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CloseMainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_exit;
    TextView fName, lName, data, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close_main);

        btn_exit = (Button) findViewById(R.id.button11);

        btn_exit.setOnClickListener(this);

        fName = (TextView) findViewById(R.id.textView2);
        lName = (TextView) findViewById(R.id.textView3);
        data = (TextView) findViewById(R.id.textView4);
        about = (TextView) findViewById(R.id.textView5);

        Intent intent = getIntent();
        fName.setText(intent.getStringExtra("fName"));
        lName.setText(intent.getStringExtra("lName"));
        data.setText(intent.getStringExtra("bData"));
        about.setText(intent.getStringExtra("aboutMe"));

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button11:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }

    }
}
