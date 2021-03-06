package com.agh.expenseapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class RestartFragment extends Fragment {
    /*
    Class responsible for dropping user's db in balance, enabling to start whole counting from scratch
     */

    Button b1, b2;
    DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_restart, container, false);

        // Handle user argument
        Bundle bundle = this.getArguments();
        final String user = bundle.get("user").toString();
        final Bundle arguments = new Bundle();
        arguments.putString("user", user);

        // Init db
        db = new DatabaseHelper(getContext());

        // Init and handle drop button considering portrait and horizontal orientation
        b2 = v.findViewById(R.id.dropButton);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteBalance(user);
                MenuFragment menuFragment = new MenuFragment();
                menuFragment.setArguments(arguments);
                StatisticsFragment statisticsFragment = new StatisticsFragment();
                statisticsFragment.setArguments(arguments);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                int orientation = getResources().getConfiguration().orientation;
                if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    transaction.replace(R.id.fragment_container2, statisticsFragment);
                    transaction.commit();
                } else {
                    transaction.replace(R.id.fragment_container, statisticsFragment);
                    transaction.commit();
                }
                Toast.makeText(getContext(), "Let's start from the beginning!", Toast.LENGTH_LONG).show();
            }
        });


        // Init and handle back button
        b1  = v.findViewById(R.id.backButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuFragment menuFragment = new MenuFragment();
                menuFragment.setArguments(arguments);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, menuFragment);
                transaction.commit();
            }
        });

        return v;
    }

}
