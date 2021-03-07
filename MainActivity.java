package com.solution.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.solution.bottomnavigation.fragments.AccountFragments;
import com.solution.bottomnavigation.fragments.AddFragments;
import com.solution.bottomnavigation.fragments.FavouriteFragments;
import com.solution.bottomnavigation.fragments.HomeFragments;

public class MainActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadfragments(new HomeFragments());
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.Home:
                fragment = new HomeFragments();
                break;

            case R.id.Add:
                fragment = new AddFragments();
                break;

            case R.id.Favourite:
                fragment = new FavouriteFragments();
                break;

            case R.id.Account:
                fragment = new AccountFragments();
                break;
        }

        return loadfragments(fragment);
    }


    private boolean loadfragments(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framelayout, fragment)
                    .commit();
            return true;

        }
        return false;

    }
}