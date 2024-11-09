package vn.edu.usth.fakepinterest.SearchPage;

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
import vn.edu.usth.fakepinterest.Saved.TheSecondChosenOne;


public class SearchEnd extends Fragment {
    Button meow1;
    Button meow2;
    Button meow3;
    Button button1;
    Button button2;
    Button button4;
    ImageButton back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_end, container, false);

        back = v.findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Handle the back button click to remove the fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Remove the current fragment
                fragmentTransaction.remove(SearchEnd.this);
                fragmentTransaction.commit();

                // Optional: Add a pop back stack call if you are using back stack
                fragmentManager.popBackStack();
            }
        });

        button1 = v.findViewById(R.id.search_end_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new SearchPageClick();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.search_end_act, clicked);
                transaction.addToBackStack(null); // Adds to back stack to allow navigation back
                transaction.commit();
            }
        });

        button2 = v.findViewById(R.id.search_end_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new SearchPageClick();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.search_end_act, clicked);
                transaction.addToBackStack(null); // Adds to back stack to allow navigation back
                transaction.commit();
            }
        });


        Button button3 = v.findViewById(R.id.search_end_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new SearchPageClick();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.search_end_act, clicked);
                transaction.addToBackStack(null); // Adds to back stack to allow navigation back
                transaction.commit();
            }
        });

        button4 = v.findViewById(R.id.search_end_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new SearchPageClick();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.search_end_act, clicked);
                transaction.addToBackStack(null); // Adds to back stack to allow navigation back
                transaction.commit();
            }
        });


        meow1 = v.findViewById(R.id.search_end_meow_1);
        meow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new TheSecondChosenOne();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.search_end_act, clicked);
                transaction.addToBackStack(null); // Adds to back stack to allow navigation back
                transaction.commit();
            }
        });

        meow2 = v.findViewById(R.id.search_end_meow_2);
        meow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new TheSecondChosenOne();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.search_end_act, clicked);
                transaction.addToBackStack(null); // Adds to back stack to allow navigation back
                transaction.commit();
            }
        });


        meow3 = v.findViewById(R.id.search_end_meow_3);
        meow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new TheSecondChosenOne();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.search_end_act, clicked);
                transaction.addToBackStack(null); // Adds to back stack to allow navigation back
                transaction.commit();
            }
        });
        return v;

    }

}