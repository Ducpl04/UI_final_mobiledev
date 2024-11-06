package vn.edu.usth.fakepinterest.Homepage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import vn.edu.usth.fakepinterest.R;

public class clicked_on_image_door extends Fragment {

    private ImageButton button_back_homepage;
    private Button save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clicked_on_image_door, container, false);

        button_back_homepage = view.findViewById(R.id.button_main);
        save = view.findViewById(R.id.save_button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Image saved!", Toast.LENGTH_SHORT).show();
            }
        });

        button_back_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the back button click to remove the fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Remove the current fragment
                fragmentTransaction.remove(clicked_on_image_door.this);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}