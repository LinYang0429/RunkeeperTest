package com.example.linyang.runkeepertest;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

// Model class
public class Achievements {
    private LinkedHashMap<String, List<List<String>>> mAchievements;

    public Achievements(Context context) {
        mAchievements = new LinkedHashMap<>();

        List<String> detailed_item_1 = new ArrayList<String>();
        detailed_item_1.add(context.getString(R.string.longest_run));
        detailed_item_1.add(context.getString(R.string.longest_run_value));
        detailed_item_1.add(context.getString(R.string.longest_run_url));
        detailed_item_1.add("1");
        List<String> detailed_item_2 = new ArrayList<String>();
        detailed_item_2.add(context.getString(R.string.highest_elevation));
        detailed_item_2.add(context.getString(R.string.highest_elevation_value));
        detailed_item_2.add(context.getString(R.string.highest_elevation_url));
        detailed_item_2.add("1");
        List<String> detailed_item_3 = new ArrayList<String>();
        detailed_item_3.add(context.getString(R.string.fastest_5k));
        detailed_item_3.add(context.getString(R.string.fastest_5k_value));
        detailed_item_3.add(context.getString(R.string.fastest_5k_url));
        detailed_item_3.add("1");
        List<String> detailed_item_4 = new ArrayList<String>();
        detailed_item_4.add(context.getString(R.string.tenk));
        detailed_item_4.add(context.getString(R.string.tenk_value));
        detailed_item_4.add(context.getString(R.string.tenk_url));
        detailed_item_4.add("1");
        List<String> detailed_item_5 = new ArrayList<String>();
        detailed_item_5.add(context.getString(R.string.half_marathon));
        detailed_item_5.add(context.getString(R.string.half_marathon_value));
        detailed_item_5.add(context.getString(R.string.half_marathon_url));
        detailed_item_5.add("1");
        List<String> detailed_item_6 = new ArrayList<String>();
        detailed_item_6.add(context.getString(R.string.marathon));
        detailed_item_6.add(context.getString(R.string.marathon_value));
        detailed_item_6.add(context.getString(R.string.marathon_url));
        detailed_item_6.add("0");

        List<List<String>> group_item1 = new ArrayList();
        group_item1.add(detailed_item_1);
        group_item1.add(detailed_item_2);
        group_item1.add(detailed_item_3);
        group_item1.add(detailed_item_4);
        group_item1.add(detailed_item_5);
        group_item1.add(detailed_item_6);

        List<String> detailed_item_7 = new ArrayList<String>();
        detailed_item_7.add(context.getString(R.string.virtual_half_marathon));
        detailed_item_7.add(context.getString(R.string.virtual_half_marathon_value));
        detailed_item_7.add(context.getString(R.string.virtual_half_marathon_url));
        detailed_item_7.add("1");
        List<String> detailed_item_8 = new ArrayList<String>();
        detailed_item_8.add(context.getString(R.string.tokyo_hakone));
        detailed_item_8.add(context.getString(R.string.tokyo_hakone_value));
        detailed_item_8.add(context.getString(R.string.tokyo_hakone_url));
        detailed_item_8.add("1");
        List<String> detailed_item_9 = new ArrayList<String>();
        detailed_item_9.add(context.getString(R.string.virtual_10k));
        detailed_item_9.add(context.getString(R.string.virtual_10k_value));
        detailed_item_9.add(context.getString(R.string.virtual_10k_url));
        detailed_item_9.add("1");
        List<String> detailed_item_10 = new ArrayList<String>();
        detailed_item_10.add(context.getString(R.string.hakone));
        detailed_item_10.add(context.getString(R.string.hakone_value));
        detailed_item_10.add(context.getString(R.string.hakone_url));
        detailed_item_10.add("1");
        List<String> detailed_item_11 = new ArrayList<String>();
        detailed_item_11.add(context.getString(R.string.mizuno_singapore));
        detailed_item_11.add(context.getString(R.string.mizuno_singapore_value));
        detailed_item_11.add(context.getString(R.string.mizuno_singapore_url));
        detailed_item_11.add("1");
        List<String> detailed_item_12 = new ArrayList<String>();
        detailed_item_12.add(context.getString(R.string.virtual_5k));
        detailed_item_12.add(context.getString(R.string.virtual_5k_value));
        detailed_item_12.add(context.getString(R.string.virtual_5k_url));
        detailed_item_12.add("1");

        List<List<String>> group_item2 = new ArrayList();
        group_item2.add(detailed_item_7);
        group_item2.add(detailed_item_8);
        group_item2.add(detailed_item_9);
        group_item2.add(detailed_item_10);
        group_item2.add(detailed_item_11);
        group_item2.add(detailed_item_12);

        mAchievements.put("Personal Records", group_item1);
        mAchievements.put("Virtual Races", group_item2);
    }

    public LinkedHashMap<String, List<List<String>>> getAchievement() {
        Log.e("AABBCC", "Achievements: " + mAchievements.values().toString());
        return mAchievements;
    }
}
