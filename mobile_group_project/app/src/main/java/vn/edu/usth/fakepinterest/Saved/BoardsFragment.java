package vn.edu.usth.fakepinterest.Saved;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


import com.google.android.material.bottomsheet.BottomSheetDialog;

import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.SearchPage.AnimalAlbum;
import vn.edu.usth.fakepinterest.SearchPage.SearchEnd;
import vn.edu.usth.fakepinterest.SearchPage.SearchPageClick;

public class BoardsFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_boards, container, false);

        ImageButton createButton; // Use your actual button ID
        createButton = view.findViewById(R.id.pins_create);


        Button button1 = view.findViewById(R.id.animal_album);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new AnimalAlbum();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.boards_frag, clicked);
                transaction.addToBackStack(null); // Adds to back stack to allow navigation back
                transaction.commit();
            }
        });

        return view;
    }

}