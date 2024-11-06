package vn.edu.usth.fakepinterest.Notification;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.Saved.YourAccount;

public class Clicked_update extends Fragment {
    private ImageButton button_back_notification;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clicked_update, container, false);

        button_back_notification = view.findViewById(R.id.button_main_1);
        button_back_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the back button click to remove the fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Remove the current fragment
                fragmentTransaction.remove(Clicked_update.this);
                fragmentTransaction.commit();
                fragmentManager.popBackStack();
            }
        });

        return view;
    }
}