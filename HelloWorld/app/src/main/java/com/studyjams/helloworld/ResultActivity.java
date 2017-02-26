package com.studyjams.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

/**
 * Created by vladstarikov on 2/6/17.
 */

public class ResultActivity extends DebugActivity {

    public static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final EditText fText = (EditText) findViewById(R.id.f_text);

        String text = getIntent().getStringExtra("btnText");
        if (text != null) {
            fText.setText(text);
        }

        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        findViewById(R.id.btn_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, new Intent().putExtra("text", fText.getText().toString()));
                finish();
            }
        });
    }
}
