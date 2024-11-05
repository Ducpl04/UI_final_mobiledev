package vn.edu.usth.fakepinterest.Saved;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import vn.edu.usth.fakepinterest.CreatePage.CreatePage;
import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.SearchPage.AnimalAlbum;
import vn.edu.usth.fakepinterest.SearchPage.SearchPageClick;

public class BoardsFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_boards, container, false);

        ImageButton createButton; // Use your actual button ID
        createButton = view.findViewById(R.id.pins_create);

        // Set an OnClickListener for the button
        createButton.setOnClickListener(v -> {
            // Show the BottomSheetDialogFragment
            CreatePage bottomSheet = new CreatePage();
            bottomSheet.show(getParentFragmentManager(), bottomSheet.getTag());
        });

        Button button1 = view.findViewById(R.id.animal_album);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new AnimalAlbum();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.main, clicked).commit();
            }
        });

        return view;
    }
}