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

import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.SearchPage.SearchEnd;

public class TheSecondChosenOne extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_the_second_chosen_one, container, false);

        ImageButton button_back = v.findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Remove the current fragment
                fragmentTransaction.remove(TheSecondChosenOne.this);
                fragmentTransaction.commit();

                // Optional: Add a pop back stack call if you are using back stack
                fragmentManager.popBackStack();
            }
        });
        return v;
    }
}