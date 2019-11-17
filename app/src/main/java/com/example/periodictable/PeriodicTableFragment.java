package com.example.periodictable;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.periodictable.asynctask.AsyncTaskGetDelegate;
import com.example.periodictable.asynctask.AsyncTaskInsertDelegate;
import com.example.periodictable.asynctask.GetElementsAsyncTask;
import com.example.periodictable.asynctask.InsertElementsAsyncTask;
import com.example.periodictable.database.AppDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PeriodicTableFragment extends Fragment implements AsyncTaskInsertDelegate, AsyncTaskGetDelegate {

    public String packageName;
    public Context context;
    List<Element> elements;

    View placeholder;

    public PeriodicTableFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_periodic_table, container, false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        placeholder = view;
        packageName = getActivity().getPackageName();
        String url = "https://neelpatel05.pythonanywhere.com/";

        context = getContext();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new GsonBuilder().serializeNulls().create();
                Type listType = new TypeToken<ArrayList<Element>>() {
                }.getType();
                ArrayList<Element> elementResults = gson.fromJson(response, listType);
                AppDatabase db = AppDatabase.getInstance(context);
                InsertElementsAsyncTask insertElementsAsyncTask = new InsertElementsAsyncTask();
                insertElementsAsyncTask.setDatabase(db);
                insertElementsAsyncTask.setDelegate(PeriodicTableFragment.this);
                Element[] elements = elementResults.toArray(new Element[elementResults.size()]);
                insertElementsAsyncTask.execute(elements);
                requestQueue.stop();
            }
        };


        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "The request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);
        requestQueue.add(stringRequest);


        /*for (int i = 1; i < 118; i++) {
            String boxName = "R.id.element" + Integer.toString(i);
            ConstraintLayout box = view.findViewById(getStringResourceByName(boxName));
            ConstraintLayout box = view.findViewById(R.id.element1);
            TextView name = box.findViewById(R.id.name);
            TextView symbol = box.findViewById(R.id.symbol);
            name.setText(elements.get(1).getName());
            symbol.setText(elements.get(1).getSymbol());*/

        return placeholder;
    }

    @Override
    public void handleTaskResult(String result) {
        System.out.println("AsyncTask insert Done");
        GetElementsAsyncTask getElementsAsyncTask = new GetElementsAsyncTask();
        getElementsAsyncTask.setDatabase(AppDatabase.getInstance(getContext()));
        getElementsAsyncTask.setDelegate(this);
        getElementsAsyncTask.execute();
    }

    @Override
    public void handleTaskGetResult(List<Element> elements) {
        ConstraintLayout box = placeholder.findViewById(R.id.element1);
        TextView name = box.findViewById(R.id.name);
        TextView symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(0).getName());
        symbol.setText(elements.get(0).getSymbol());

        box = placeholder.findViewById(R.id.element2);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(1).getName());
        symbol.setText(elements.get(1).getSymbol());

        box = placeholder.findViewById(R.id.element3);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(2).getName());
        symbol.setText(elements.get(2).getSymbol());

        box = placeholder.findViewById(R.id.element4);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(3).getName());
        symbol.setText(elements.get(3).getSymbol());

        box = placeholder.findViewById(R.id.element5);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(4).getName());
        symbol.setText(elements.get(4).getSymbol());

        box = placeholder.findViewById(R.id.element6);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(5).getName());
        symbol.setText(elements.get(5).getSymbol());

        box = placeholder.findViewById(R.id.element7);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(6).getName());
        symbol.setText(elements.get(6).getSymbol());

        box = placeholder.findViewById(R.id.element8);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(7).getName());
        symbol.setText(elements.get(7).getSymbol());

        box = placeholder.findViewById(R.id.element9);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(8).getName());
        symbol.setText(elements.get(8).getSymbol());

        box = placeholder.findViewById(R.id.element10);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(9).getName());
        symbol.setText(elements.get(9).getSymbol());

        box = placeholder.findViewById(R.id.element11);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(10).getName());
        symbol.setText(elements.get(10).getSymbol());

        box = placeholder.findViewById(R.id.element12);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(11).getName());
        symbol.setText(elements.get(11).getSymbol());

        box = placeholder.findViewById(R.id.element13);
        name = box.findViewById(R.id.name);
        symbol = box.findViewById(R.id.symbol);
        name.setText(elements.get(12).getName());
        symbol.setText(elements.get(12).getSymbol());
    }

    //from https://stackoverflow.com/questions/7493287/android-how-do-i-get-string-from-resources-using-its-name/11595723#11595723
    /*private int getStringResourceByName(String boxName) {
        int resId = getResources().getIdentifier(boxName, "id", "com.example.periodictable.R");
        return resId;
    }*/

}