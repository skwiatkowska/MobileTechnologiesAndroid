package com.agh.expenseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;

public class ExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        String user = getIntent().getStringExtra("user");

        Bundle arguments = new Bundle();
        arguments.putString("user", user);

        MenuFragment menuFragment = new MenuFragment();
        menuFragment.setArguments(arguments);
        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().add(R.id.expenseLayout, menuFragment).commit();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.fragment_menu);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.fragment_menu_vertical);
        }
    }
}