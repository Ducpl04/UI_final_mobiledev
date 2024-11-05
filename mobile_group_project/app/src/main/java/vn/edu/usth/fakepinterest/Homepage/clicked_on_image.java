package vn.edu.usth.fakepinterest.Homepage;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import vn.edu.usth.fakepinterest.MainActivity;
import vn.edu.usth.fakepinterest.R;

public class clicked_on_image extends Fragment {

    private ImageButton button_back_homepage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clicked_on_image, container, false);

        button_back_homepage = view.findViewById(R.id.button_main);
        button_back_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the back button click to remove the fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Remove the current fragment
                fragmentTransaction.remove(clicked_on_image.this);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}