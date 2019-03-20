package com.frame.frame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frame.library.utils.FragmentSwitchManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private FragmentSwitchManager switchManager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                switchManager.switchFragment(0);
                return true;
            case R.id.navigation_dashboard:
                switchManager.switchFragment(1);
                return true;
            case R.id.navigation_notifications:
                switchManager.switchFragment(2);
                return true;
            case R.id.navigation_user:
                switchManager.switchFragment(3);
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragments.add(Fragment1.newInstance());
        fragments.add(Fragment1.newInstance());
        fragments.add(Fragment1.newInstance());
        fragments.add(Fragment1.newInstance());
        switchManager = new FragmentSwitchManager(getSupportFragmentManager(), fragments, R.id.fl_content);
        switchManager.init();
    }
}
