package com.frame.frame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private int lastfragment;//用于记录上个选择的Fragmen
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        switchFragment(0);
                        return true;
                    case R.id.navigation_dashboard:
                        switchFragment(1);
                        return true;
                    case R.id.navigation_notifications:
                        switchFragment(2);
                        return true;
                    case R.id.navigation_user:
                        switchFragment(3);
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
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, fragments.get(0)).show(fragments.get(0)).commit();
    }

    //切换Fragment
    private void switchFragment(int index) {
        if (lastfragment != index) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(fragments.get(lastfragment));
            if (!fragments.get(index).isAdded()) {
                transaction.add(R.id.fl_content, fragments.get(index));
            }
            transaction.show(fragments.get(index)).commitAllowingStateLoss();
            lastfragment = index;
        }
    }
}
