package vn.edu.usth.fakepinterest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import vn.edu.usth.fakepinterest.SearchPage.SearchEnd;

public class Account extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_account, container, false);

        ImageButton back = v.findViewById(R.id.button_main_1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Handle the back button click to remove the fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Remove the current fragment
                fragmentTransaction.remove(Account.this);
                fragmentTransaction.commit();

                // Optional: Add a pop back stack call if you are using back stack
                fragmentManager.popBackStack();
            }
        });

        return v;
    }
}