package vn.edu.usth.fakepinterest;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import vn.edu.usth.fakepinterest.SearchPage.SearchEnd;


public class ShareFragment extends BottomSheetDialogFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.share_layout, container, false);
        Button cancelButton = view.findViewById(R.id.close_share);
        cancelButton.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().popBackStack();
        });

        Button close_button = view.findViewById(R.id.close_share);
        close_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Handle the back button click to remove the fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Remove the current fragment
                fragmentTransaction.remove(ShareFragment.this);
                fragmentTransaction.commit();

                // Optional: Add a pop back stack call if you are using back stack
                fragmentManager.popBackStack();
            }
        });
        return view;
    }
}