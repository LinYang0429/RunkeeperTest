package com.example.linyang.runkeepertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AchievementGroupRecyclerViewAdapter.ItemClickListener{

    AchievementGroupRecyclerViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Achievements achievements = new Achievements(this);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView recyclerViewList = findViewById(R.id.listOfAchievements);

        recyclerViewList.setLayoutManager(new LinearLayoutManager(this));
        listViewAdapter = new AchievementGroupRecyclerViewAdapter(this, achievements.getAchievement());
        listViewAdapter.setClickListener(this);
        recyclerViewList.setAdapter(listViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked group " + (position + 1) + " of " + listViewAdapter.getItemCount() + " groups.", Toast.LENGTH_SHORT).show();
    }
}
