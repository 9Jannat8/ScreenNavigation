package com.example.screennavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayoutId);
        viewPager = findViewById(R.id.viewPagerId);

        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }

    class PagerAdapter extends FragmentPagerAdapter{

        String[] text = {"Bangladesh", "India", "Pakistan"};

        public PagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            if (position == 0)
            {
                return new BangladeshFragment();
            }

            if (position == 1)
            {
                return new IndiaFragment();
            }

            if (position == 2)
            {
                return new PakistanFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return text.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return text[position];
        }
    }
}