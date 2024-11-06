package vn.edu.usth.fakepinterest.Notification;

import static vn.edu.usth.fakepinterest.R.id.bottom_navigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import vn.edu.usth.fakepinterest.MainActivity;
import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.Saved.PinsFragment;
import vn.edu.usth.fakepinterest.Saved.SavedActivity;
import vn.edu.usth.fakepinterest.Saved.SavedPageAdapter;
import vn.edu.usth.fakepinterest.SearchPage.SearchActivity;

public class NotificationActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    NotificationPagerAdapter pagerAdapter;
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification); // Use the fragment layout as activity layout

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        pagerAdapter = new NotificationPagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

        bottomNavigationView = findViewById(bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_notification);
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
                        Intent intent = new Intent(NotificationActivity.this, MainActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.bottom_search:
                        tabLayout.setVisibility(View.VISIBLE);
                        Intent intent1 = new Intent(NotificationActivity.this, SearchActivity.class);
                        startActivity(intent1);
                        return true;

                    case R.id.bottom_create:
                        showBottomSheetDialog();
                        return true;

                    case R.id.bottom_notification:
                        tabLayout.setVisibility(View.VISIBLE);
                        Intent intent3 = new Intent(NotificationActivity.this, NotificationActivity.class);
                        startActivity(intent3);
                        return true;

                    case R.id.bottom_saved:
                        Intent intent2 = new Intent(NotificationActivity.this, SavedActivity.class);
                        startActivity(intent2);
                        return true;
                }
                return false;
            }
        });
    }
    private void showBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View sheetView = getLayoutInflater().inflate(R.layout.bottomsheetlayout, null);
        bottomSheetDialog.setContentView(sheetView);
        bottomSheetDialog.show();
        viewPager2.setVisibility(View.VISIBLE);

        // Add a dismiss listener to restore the visibility of the main content
        bottomSheetDialog.setOnDismissListener(dialog -> {
            tabLayout.setVisibility(View.VISIBLE);
            viewPager2.setVisibility(View.VISIBLE);
        });
    }
}
