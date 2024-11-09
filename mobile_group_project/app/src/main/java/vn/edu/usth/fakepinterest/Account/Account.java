package vn.edu.usth.fakepinterest.Account;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.fakepinterest.Homepage.HomeRecycleAdapter;
import vn.edu.usth.fakepinterest.ImageData;
import vn.edu.usth.fakepinterest.R;

public class Account extends Fragment {
    RecyclerView recyclerView;
    HomeRecycleAdapter homeRecycleAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        ImageButton back = view.findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Handle the back button click to remove the fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Remove the current fragment
                fragmentTransaction.remove(Account.this);
                fragmentTransaction.commit();

                // Optional: Add a pop back stack call if you are using back stack
                fragmentManager.popBackStack();
            }
        });

        recyclerView = view.findViewById(R.id.recyclerviewhome);
        List<ImageData> dataList = new ArrayList<>();

        dataList.add(new ImageData(R.drawable.animal_1,"Data"));
        dataList.add(new ImageData(R.drawable.anime_3, "Data2"));
        dataList.add(new ImageData(R.drawable.animal_3, "Data3"));
        dataList.add(new ImageData(R.drawable.animal_4, "Data4"));
        dataList.add(new ImageData(R.drawable.animal_5, "Data5"));
        dataList.add(new ImageData(R.drawable.animal_6, "Data6"));
        dataList.add(new ImageData(R.drawable.animal_7, "Data7"));

        RecyclerView.LayoutManager layoutManager =  new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        homeRecycleAdapter = new HomeRecycleAdapter(requireContext(), dataList);
        recyclerView.setAdapter(homeRecycleAdapter);

        return view;
    }
}