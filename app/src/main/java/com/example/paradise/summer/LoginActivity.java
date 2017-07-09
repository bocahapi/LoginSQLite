package com.example.paradise.summer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText editUsername;
    EditText editPassword;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isExist = databaseHelper.checkUserExist(
                        editUsername.getText().toString(),
                        editPassword.getText().toString()
                );

                Log.d("nama_tag", String.valueOf(isExist)   );

                if (isExist) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", editUsername.getText().toString());
                    startActivity(intent);
                } else {
                    editPassword.setText(null);
                    Toast.makeText(LoginActivity.this, "Login Failed! Username & Password Not Match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
