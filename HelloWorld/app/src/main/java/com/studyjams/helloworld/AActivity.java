package com.studyjams.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by vladstarikov on 2/6/17.
 */

public class AActivity extends DebugActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        findViewById(R.id.btn_start_activity_a).setOnClickListener(this);
        findViewById(R.id.btn_start_activity_b).setOnClickListener(this);
        findViewById(R.id.btn_start_activity_c).setOnClickListener(this);
        findViewById(R.id.btn_start_activity_d).setOnClickListener(this);
        findViewById(R.id.btn_go_home).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_start_activity_a:
                intent = new Intent(this, AActivity.class).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
            case R.id.btn_start_activity_b:
                intent = new Intent(this, BActivity.class);
                break;
            case R.id.btn_start_activity_c:
                intent = new Intent(this, CActivity.class);
                break;
            case R.id.btn_start_activity_d:
                intent = new Intent(this, DActivity.class);
                break;
            case R.id.btn_go_home:
                intent = new Intent(this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;
        }
        startActivity(intent);
    }
}
