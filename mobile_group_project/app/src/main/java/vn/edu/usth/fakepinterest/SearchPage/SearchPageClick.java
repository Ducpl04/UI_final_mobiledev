package vn.edu.usth.fakepinterest.SearchPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.ShareFragment;

public class SearchPageClick extends Fragment {
    ImageButton button_back;
    Button animal4;
    Button share1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_page, container, false);

        button_back = v.findViewById(R.id.button_back_click);
        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment clicked = new SearchEnd();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.main, clicked).commit();
            }
        });

        share1 = v.findViewById(R.id.share1);
        share1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareFragment shareFragment = new ShareFragment();
                shareFragment.show(getActivity().getSupportFragmentManager(), shareFragment.getTag());
            }
        });

        animal4 = v.findViewById(R.id.go_to_animail4_end);
        animal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new SearchPageAnimal4();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.main, clicked).commit();
            }
        });
        return v;
    }

}