package vn.edu.usth.fakepinterest.LoginPage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.fakepinterest.MainActivity;
import vn.edu.usth.fakepinterest.R;

public class    Login_Page extends AppCompatActivity {
    private Button continue_button;
    private Button continue_fb_button;
    private Button continue_gg_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("onCreate LoginPage", "onCreate State");        setContentView(R.layout.activity_login_page);


        // Continue button
        continue_button = findViewById(R.id.continue_button);

        continue_button.findViewById(R.id.continue_button);

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Continue facebook button
        continue_fb_button = findViewById(R.id.continue_fb);
        continue_fb_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Continue google button
        continue_gg_button = findViewById(R.id.continue_gg);
        continue_gg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Page.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onStart() {
        super.onStart();
        Log.i("onStart LoginPage", "onStart State");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("onResume LoginPage", "onResume State");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("onPause LoginPage", "onPause State");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("onStop LoginPage", "onStop State");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy LoginPage", "onDestroy State");
    }
}