package com.agh.expenseapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MenuFragment extends Fragment {

    private Button b1,b2,b3,b4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        Bundle bundle = this.getArguments();
        String user = bundle.get("user").toString();

        final Bundle arguments = new Bundle();
        arguments.putString("user", user);



        b1  = v.findViewById(R.id.spendButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpendFragment spendFragment = new SpendFragment();
                spendFragment.setArguments(arguments);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.expenseLayout, spendFragment);
                transaction.commit();
            }
        });

        b2  = v.findViewById(R.id.earnButton);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EarnFragment earnFragment = new EarnFragment();
                earnFragment.setArguments(arguments);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.expenseLayout, earnFragment);
                transaction.commit();
            }
        });


        b3  = v.findViewById(R.id.statisticsButton);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatisticsFragment statisticsFragment = new StatisticsFragment();
                statisticsFragment.setArguments(arguments);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.expenseLayout, statisticsFragment);
                transaction.commit();
            }
        });


        b4  = v.findViewById(R.id.resetButton);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestartFragment restartFragment = new RestartFragment();
                restartFragment.setArguments(arguments);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.expenseLayout, restartFragment);
                transaction.commit();
            }
        });


        return v;
    }



}