package vn.edu.usth.fakepinterest.SearchPage;

import static android.app.PendingIntent.getActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.fakepinterest.MainActivity;
import vn.edu.usth.fakepinterest.Notification.NotificationActivity;
import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.Saved.SavedActivity;
import vn.edu.usth.fakepinterest.Saved.YourAccount;

public class SearchActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Button button;


    protected void onCreate(Bundle savedInstanceState) {
        Log.i("onCreate MainActivity", "onCreate State");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        button = findViewById(R.id.search_button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SearchEnd();
                // Perform the fragment transaction
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.activity_search, fragment);
                transaction.addToBackStack(null); // Adds the transaction to the back stack so the user can navigate back
                transaction.commit();
            }
        });

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

                    case R.id.bottom_search:
                        Intent intent0 = new Intent(SearchActivity.this, SearchActivity.class);
                        startActivity(intent0);
                        return true;

                    case R.id.bottom_create:
                        showBottomSheetDialog();
                        return true;

                    case R.id.bottom_notification:
                        Intent intent3 = new Intent(SearchActivity.this, NotificationActivity.class);
                        startActivity(intent3);
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
    private void showBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View sheetView = getLayoutInflater().inflate(R.layout.bottomsheetlayout, null);
        bottomSheetDialog.setContentView(sheetView);
        bottomSheetDialog.show();
    }
}