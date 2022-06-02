package com.example.android.colony;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager1);
        Category1Adapter adapter = new Category1Adapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tablayout = (TabLayout) findViewById(R.id.tabs1);
        tablayout.setupWithViewPager(viewPager);

    }

}
