package com.example.periodictable;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.periodictable.asynctask.AsyncTaskFindDelegate;
import com.example.periodictable.asynctask.FindElementAsyncTask;
import com.example.periodictable.database.AppDatabase;

public class ElementDetailActivity extends AppCompatActivity implements AsyncTaskFindDelegate {

    public TextView atomicNumberTextView;
    public TextView symbolTextView;
    public TextView nameTextView;
    public TextView atomicRadiusTextView;
    public TextView boilingPointTextView;
    public TextView yearDiscoveredTextView;
    public TextView densityTextView;
    public TextView bondingTypeTextView;
    public TextView meltingPointTextView;
    public TextView affinityTextView;
    public TextView negativeTextView;
    public TextView configTextView;
    public TextView ionRadiusTextView;
    public TextView energyTextView;
    public TextView standardTextView;
    public TextView vanTextView;
    public TextView oxiTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_detail);

        atomicNumberTextView = findViewById(R.id.atomicNumber);
        symbolTextView = findViewById(R.id.symbol);
        nameTextView = findViewById(R.id.name);
        atomicRadiusTextView = findViewById(R.id.atomicRadius);
        boilingPointTextView = findViewById(R.id.boilingPoint);
        yearDiscoveredTextView = findViewById(R.id.yearDiscovered);
        densityTextView = findViewById(R.id.density);
        bondingTypeTextView = findViewById(R.id.bondingType);
        meltingPointTextView = findViewById(R.id.meltingPoint);
        affinityTextView = findViewById(R.id.electronAffinity);
        negativeTextView = findViewById(R.id.electronNegativity);
        configTextView = findViewById(R.id.electronConfiguration);
        ionRadiusTextView = findViewById(R.id.ionRadius);
        energyTextView = findViewById(R.id.ionisationEnergy);
        standardTextView = findViewById(R.id.standardState);
        vanTextView = findViewById(R.id.vanDerWaalsRadius);
        oxiTextView = findViewById(R.id.oxidisationState);

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
        atomicNumberTextView.setText(Integer.toString(element.getAtomicNumber()));
        symbolTextView.setText(element.getSymbol());
        nameTextView.setText(element.getName());
        atomicRadiusTextView.setText(element.getAtomicRadius());
        boilingPointTextView.setText(element.getBoilingPoint());
        yearDiscoveredTextView.setText(element.getYearDiscovered());
        densityTextView.setText(element.getDensity());
        bondingTypeTextView.setText(element.getBondingType());
        meltingPointTextView.setText(element.getMeltingPoint());
        affinityTextView.setText(element.getElectronAffinity());
        negativeTextView.setText(element.getElectronNegativity());
        configTextView.setText(element.getElectronicConfiguration());
        ionRadiusTextView.setText(element.getIonRadius());
        energyTextView.setText(element.getIonizationEnergy());
        standardTextView.setText(element.getStandardState());
        vanTextView.setText(element.getVanDerWaalsRadius());
        oxiTextView.setText(element.getOxidationStates());

    }
}