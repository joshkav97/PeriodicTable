package com.example.periodictable;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class QuizFragment extends Fragment {

    Button quiz1;

    public QuizFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        quiz1 = view.findViewById(R.id.quiz1);

        quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), quiz1.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
