package vn.edu.usth.fakepinterest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.fakepinterest.CreatePage.CreatePage;
import vn.edu.usth.fakepinterest.Homepage.HomePageAdapter;
import vn.edu.usth.fakepinterest.Homepage.HomePage_All;
import vn.edu.usth.fakepinterest.Notification.NotificationPage;
import vn.edu.usth.fakepinterest.Saved.SavedActivity;
import vn.edu.usth.fakepinterest.SearchPage.SearchActivity;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    HomePageAdapter homePageAdapter;
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("onCreate MainActivity", "onCreate State");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        homePageAdapter = new HomePageAdapter(this);
        viewPager2.setAdapter(homePageAdapter);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        frameLayout = findViewById(R.id.frameLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                        tabLayout.getTabAt(position).select();
                }
                super.onPageSelected(position);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                frameLayout.setVisibility(View.VISIBLE);
                viewPager2.setVisibility(View.GONE);

                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        tabLayout.setVisibility(View.VISIBLE);
                        viewPager2.setVisibility(View.VISIBLE); // Show the ViewPager again
                        frameLayout.setVisibility(View.GONE); // Hide frameLayout
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, new HomePage_All()).commit();
                        return true;

                    case R.id.bottom_search:
                        tabLayout.setVisibility(View.VISIBLE);
                        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.bottom_create:
                        CreatePage bottomSheet = new CreatePage();
                        bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
                        return true;

                    case R.id.bottom_notification:
                        tabLayout.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, new NotificationPage()).commit();
                        return true;

                    case R.id.bottom_saved:
                        tabLayout.setVisibility(View.VISIBLE);
                        Intent intent2 = new Intent(MainActivity.this, SavedActivity.class);
                        startActivity(intent2);
                        return true;
                }
                return false;
            }
        });
    }

}
