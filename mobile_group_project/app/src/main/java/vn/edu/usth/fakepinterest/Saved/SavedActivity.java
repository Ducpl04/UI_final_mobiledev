package vn.edu.usth.fakepinterest.Saved;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.fakepinterest.MainActivity;
import vn.edu.usth.fakepinterest.Notification.NotificationActivity;
import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.SearchPage.SearchActivity;

public class SavedActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    SavedPageAdapter savedPageAdapter;
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    ImageButton imageButton;

    protected void onCreate(Bundle savedInstanceState) {
        Log.i("onCreate MainActivity", "onCreate State");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        imageButton = findViewById(R.id.go_to_account);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new YourAccount();
                // Perform the fragment transaction
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.saved_page, fragment);
                transaction.addToBackStack(null); // Adds the transaction to the back stack so the user can navigate back
                transaction.commit();
            }
        });

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        savedPageAdapter = new SavedPageAdapter(this);
        viewPager2.setAdapter(savedPageAdapter);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_saved);
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
                        Intent intent = new Intent(SavedActivity.this, MainActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.bottom_search:
                        tabLayout.setVisibility(View.VISIBLE);
                        Intent intent1 = new Intent(SavedActivity.this, SearchActivity.class);
                        startActivity(intent1);
                        return true;

                    case R.id.bottom_create:
                        showBottomSheetDialog();
                        return true;

                    case R.id.bottom_notification:
                        tabLayout.setVisibility(View.VISIBLE);
                        Intent intent3 = new Intent(SavedActivity.this, NotificationActivity.class);
                        startActivity(intent3);
                        return true;

                    case R.id.bottom_saved:
                        tabLayout.setVisibility(View.VISIBLE);
                        viewPager2.setVisibility(View.VISIBLE); // Show the ViewPager again
                        frameLayout.setVisibility(View.GONE); // Hide frameLayout
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, new PinsFragment()).commit();
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
