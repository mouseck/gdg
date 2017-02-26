package com.example.mouse.smayak;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Smayak extends AppCompatActivity implements View.OnClickListener {

    ImageButton a;
    ImageButton b;
    ImageButton c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smayak);

        a = (ImageButton) findViewById(R.id.em2);
        a.setOnClickListener(this);

        c = (ImageButton) findViewById(R.id.map);
        c.setOnClickListener(this);

        b = (ImageButton) findViewById(R.id.call);
        b.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {



        switch (v.getId()){
            case R.id.em2:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"t.info.g.31@gmail.com"});
                //emailIntent.putExtra(Intent.EXTRA_CC, new String[]{"matrix007@ukr.net"});
                // emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{"matrix007@ukr.net"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello GDG");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Thank you GDG Сherkasy");

                emailIntent.setType("message/rtc822");
                startActivity(Intent.createChooser(emailIntent, "choose email client..."));
                break;
            case R.id.map:
                // Creates an Intent that will load a map of San Francisco
            /**/    Uri gmmIntentUri = Uri.parse("geo:0,0?q=Маяк+с.Піщане+Золотоніського+району,+Черкаської+області");
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
