package com.example.guest.thebetterweatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.button) Button mButton;
    @Bind(R.id.editText) EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String location = mEditText.getText().toString();
        Intent intent = new Intent(MainActivity.this,ForecastActivity.class);
        intent.putExtra("location", location);
        startActivity(intent);
    }
}
