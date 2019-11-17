package com.example.periodictable.database;

import android.os.AsyncTask;

import com.example.periodictable.Element;

import java.util.Arrays;

public class InsertElementsAsyncTask extends AsyncTask<Element, Integer, String> {
    private AsyncTaskDelegate delegate;
    private AppDatabase database;

    public void setDelegate(AsyncTaskDelegate delegate) {
        this.delegate = delegate;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    @Override
    protected String doInBackground(Element... elements) {
        database.elementDao().insertAll(Arrays.asList(elements));
        return "Elements inserted into database.";
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.handleTaskResult(result);
    }
}
