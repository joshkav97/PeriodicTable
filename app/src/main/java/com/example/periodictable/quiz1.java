package com.example.periodictable;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.periodictable.asynctask.AsyncTaskFindDelegate;
import com.example.periodictable.asynctask.FindElementAsyncTask;
import com.example.periodictable.database.AppDatabase;

import java.util.Random;

public class quiz1 extends AppCompatActivity implements AsyncTaskFindDelegate {

    TextView atomicNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        int keyElementAtomicNumber = randomNumberGenerator();

        AppDatabase db = AppDatabase.getInstance(this);
        FindElementAsyncTask findElementsAsyncTask = new FindElementAsyncTask();
        findElementsAsyncTask.setDatabase(db);
        findElementsAsyncTask.setDelegate(quiz1.this);
        findElementsAsyncTask.execute(keyElementAtomicNumber);

    }

    @Override
    public void handleTaskResult(Element element) {
        atomicNumber = findViewById(R.id.atomicNumber);
        atomicNumber.setText(Integer.toString(element.getAtomicNumber()));
    }

    static int randomNumberGenerator(){
        Random random = new Random();
        int generatedNumber = random.nextInt(117)+1;
        return generatedNumber;
    }
}