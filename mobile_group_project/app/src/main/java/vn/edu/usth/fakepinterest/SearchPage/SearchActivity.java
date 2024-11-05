package vn.edu.usth.fakepinterest.SearchPage;

import static android.app.PendingIntent.getActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.fakepinterest.CreatePage.CreatePage;
import vn.edu.usth.fakepinterest.MainActivity;
import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.Saved.SavedActivity;

public class SearchActivity extends AppCompatActivity {
    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;
    //move to anther Fragment
    public void openFragment(View view) {
        // Create an instance of your Fragment
        SearchEnd fragment = new SearchEnd();

        // Begin a Fragment transaction
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.search_button_1, fragment) // Use the ID of your container layout
                .addToBackStack(null) // Adds the transaction to the back stack
                .commit();
    }

    protected void onCreate(Bundle savedInstanceState) {
        Log.i("onCreate MainActivity", "onCreate State");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_search);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.bottom_create:
                        CreatePage bottomSheet = new CreatePage();
                        bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
                        return true;

                    case R.id.bottom_notification:
                        Intent intent1 = new Intent(SearchActivity.this, MainActivity.class);
                        startActivity(intent1);
                        return true;

                    case R.id.bottom_saved:
                        Intent intent2 = new Intent(SearchActivity.this, SavedActivity.class);
                        startActivity(intent2);
                        return true;
                }
                return false;
            }
        });
    }
}