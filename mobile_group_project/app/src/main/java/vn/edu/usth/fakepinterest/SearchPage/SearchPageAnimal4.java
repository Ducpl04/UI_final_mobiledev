package vn.edu.usth.fakepinterest.SearchPage;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import vn.edu.usth.fakepinterest.MainActivity;
import vn.edu.usth.fakepinterest.R;

public class SearchPageAnimal4 extends SearchPageClick{

    ImageButton button_back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.animal4_click, container, false);

        button_back = v.findViewById(R.id.button_back_click_animal4);
        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment clicked = new SearchEnd();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.main, clicked).commit();
            }
        });

        return v;
    }
}
