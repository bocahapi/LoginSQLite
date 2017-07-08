package com.example.paradise.summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView helloUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloUser = (TextView) findViewById(R.id.gretting);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String username = bundle.getString("username");
            helloUser.setText("Welcome " + username);
        }
    }
}
