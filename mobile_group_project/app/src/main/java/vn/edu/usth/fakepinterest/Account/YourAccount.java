package vn.edu.usth.fakepinterest.Account;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.SearchPage.SearchPageClick;

public class YourAccount extends Fragment {

    private ImageButton button_back;
    private Button acc;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_your_account, container, false);

        button_back = view.findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the back button click to remove the fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Remove the current fragment
                fragmentTransaction.remove(YourAccount.this);
                fragmentTransaction.commit();
                fragmentManager.popBackStack();
            }
        });

        Button openFragmentButton = view.findViewById(R.id.view_profile);
        openFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment clicked = new Account();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.saved_page, clicked);
                transaction.addToBackStack(null); // Adds to back stack to allow navigation back
                transaction.commit();
            }
        });

        return view;
    }
}