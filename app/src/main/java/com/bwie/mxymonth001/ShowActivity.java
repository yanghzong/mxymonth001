package com.bwie.mxymonth001;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwie.mxymonth001.fragment.CategotyFragment;
import com.bwie.mxymonth001.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager vp;
    private TextView txtHome, txtCataegoty;
    private CategotyFragment categotyFragment;
    private HomeFragment homeFragment;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        categotyFragment = new CategotyFragment();
        homeFragment = new HomeFragment();
        list = new ArrayList<>();
        list.add(homeFragment);
        list.add(categotyFragment);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }
        });

    }

    private void initView() {
        vp = findViewById(R.id.fl);
        txtHome = findViewById(R.id.txt_home);
        txtCataegoty = findViewById(R.id.txt_categoty);
        txtHome.setOnClickListener(this);
        txtCataegoty.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_home:
                vp.setCurrentItem(0);
                break;
            case R.id.txt_categoty:
                vp.setCurrentItem(1);
                break;
        }
    }
}
