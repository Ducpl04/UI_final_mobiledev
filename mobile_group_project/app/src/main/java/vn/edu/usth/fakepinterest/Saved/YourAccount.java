package vn.edu.usth.fakepinterest.Saved;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import vn.edu.usth.fakepinterest.Account;
import vn.edu.usth.fakepinterest.Homepage.clicked_on_image_door;
import vn.edu.usth.fakepinterest.R;

public class YourAccount extends Fragment {

    private ImageButton button_back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_your_account, container, false);

        button_back = view.findViewById(R.id.button_main_1);
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

        Button acc = view.findViewById(R.id.cheems_msg2);
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new Account();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.your_account, clicked);
                transaction.addToBackStack(null); // Adds to back stack to allow navigation back
                transaction.commit();
            }
        });
        return view;
    }
}