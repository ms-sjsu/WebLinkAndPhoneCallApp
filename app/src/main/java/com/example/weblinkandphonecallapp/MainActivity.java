package com.example.weblinkandphonecallapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Implement the implicit intent for opening an url in web browser
    public void OnOpenURLClick(View view) {
        EditText e=(EditText)findViewById(R.id.url_string);
        String content = e.getText().toString();
        boolean hasHTTPPrefix = content.indexOf("http") !=-1? true: false;
        if(!hasHTTPPrefix)
        {
            content = "http://" + content;
        }
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(content));
        startActivity(implicit);
    }

    // Implement the implicit intent to dial a phone number
    public void OnRingClick(View view) {

        EditText e=(EditText)findViewById(R.id.num_phone);
        String content = e.getText().toString();
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+content));
        startActivity(implicit);
    }

    public void closeApp(View v) {
        MainActivity.this.finish();
    }
}
