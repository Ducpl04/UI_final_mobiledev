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
import vn.edu.usth.fakepinterest.SearchPage.SearchEnd;

public class ChatFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        ImageButton button_back = view.findViewById(R.id.button_main_1);
        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Remove the current fragment
                fragmentTransaction.remove(ChatFragment.this);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}