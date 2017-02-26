package com.studyjams.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends DebugActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    public static final int REQUEST_CODE_CONTACTS = 11;

    Button btnStartForResult;
    EditText fAction;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAction = (EditText) findViewById(R.id.f_action);

        findViewById(R.id.btn_start_activity_a).setOnClickListener(this);
        findViewById(R.id.btn_start_activity_b).setOnClickListener(this);
        findViewById(R.id.btn_start_activity_c).setOnClickListener(this);
        findViewById(R.id.btn_start_activity_d).setOnClickListener(this);
        findViewById(R.id.btn_open_contacts).setOnClickListener(this);
        findViewById(R.id.btn_launch).setOnClickListener(this);

        btnStartForResult = (Button) findViewById(R.id.bnt_start_for_result);
        btnStartForResult.setOnClickListener(this);

        if (savedInstanceState != null && savedInstanceState.containsKey("text")) {
            text = savedInstanceState.getString("text");
            btnStartForResult.setText(text);
        }
        Log.d(TAG, "text = " + text);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ResultActivity.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
                text = data.getStringExtra("text");
                btnStartForResult.setText(text);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Canceled", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "text = " + text);
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (text != null) {
            outState.putString("text", text);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_start_activity_a:
                intent = new Intent(getApplicationContext(), AActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_start_activity_b:
                intent = new Intent(this, BActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_start_activity_c:
                intent = new Intent(this, CActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_start_activity_d:
                intent = new Intent(this, DActivity.class);
                startActivity(intent);
                break;
            case R.id.bnt_start_for_result:
                intent = new Intent(this, ResultActivity.class)
                        .putExtra("btnText", btnStartForResult.getText().toString())
                        .putExtra("number", 117);
                startActivityForResult(intent, ResultActivity.REQUEST_CODE);
                break;
            case R.id.btn_open_contacts:
//                Uri uri = Uri.parse("content://com.android.contacts/contacts");//TODO:show this
//                intent = new Intent(Intent.ACTION_PICK, uri);
                intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, REQUEST_CODE_CONTACTS);
                break;
            case R.id.btn_launch:
                try {
                    intent = new Intent(fAction.getText().toString());
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e(TAG, "Cannot launch this activity", e);
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}