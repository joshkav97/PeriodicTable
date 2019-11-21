package com.example.periodictable;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.periodictable.asynctask.AsyncTaskFindDelegate;
import com.example.periodictable.asynctask.FindElementAsyncTask;
import com.example.periodictable.database.AppDatabase;

public class ElementDetailActivity extends AppCompatActivity implements AsyncTaskFindDelegate {

    private TextView atomicNumber;
    private TextView atomicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_detail);

        atomicNumber = findViewById(R.id.atomicNumber);
        atomicName = findViewById(R.id.atomicName);

        Intent intent = getIntent();
        int atomicNumber = Integer.parseInt(intent.getStringExtra("atomicNumber"));
        AppDatabase db = AppDatabase.getInstance(this);
        FindElementAsyncTask findElementsAsyncTask = new FindElementAsyncTask();
        findElementsAsyncTask.setDatabase(db);
        findElementsAsyncTask.setDelegate(ElementDetailActivity.this);
        findElementsAsyncTask.execute(atomicNumber);

    }

    @Override
    public void handleTaskResult(Element element) {
        atomicNumber = findViewById(R.id.atomicNumber);
        atomicNumber.setText(Integer.toString(element.getAtomicNumber()));
        atomicName.setText(element.getName());
    }
}
