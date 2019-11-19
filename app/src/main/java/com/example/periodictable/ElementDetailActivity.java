package com.example.periodictable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ElementDetailActivity extends AppCompatActivity {

    public TextView atomicNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_detail);

        atomicNumberTextView = findViewById(R.id.atomicNumber);

        Intent intent = getIntent();
        String atomicNumber = intent.getStringExtra("atomicNumber");

        atomicNumberTextView.setText(atomicNumber);

    }
}
