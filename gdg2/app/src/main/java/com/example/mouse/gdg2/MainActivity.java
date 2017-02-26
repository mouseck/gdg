package com.example.mouse.gdg2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b;
    Button c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.em2);
        btn.setOnClickListener(this);

        c = (Button) findViewById(R.id.button3);
        c.setOnClickListener(this);

        b = (Button) findViewById(R.id.call);

        b.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {



        switch (v.getId()){
            case R.id.em2:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"t.info.g.31@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_CC, new String[]{"matrix007@ukr.net"});
                // emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{"matrix007@ukr.net"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello GDG");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Thank you GDG Сherkasy");

                emailIntent.setType("message/rtc822");
                startActivity(Intent.createChooser(emailIntent, "choose email client..."));
                break;
            case R.id.button3:
                // Creates an Intent that will load a map of San Francisco
                Uri gmmIntentUri = Uri.parse("geo:49.748403, 31.830947");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                break;
            case R.id.call:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0631095871"));
                startActivity(callIntent);
                break;
        }


    }
}
