package vn.edu.usth.fakepinterest.Saved;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.fakepinterest.Homepage.HomeRecycleAdapter;
import vn.edu.usth.fakepinterest.ImageDataBoard;
import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.ShareFragment;

public class PinsFragment extends Fragment {
    RecyclerView recyclerView;
    SavedRecycleAdapter savedRecycleAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pins, container, false);

        ImageButton createButton; // Use your actual button ID
        createButton = view.findViewById(R.id.pins_create);

        recyclerView = view.findViewById(R.id.recyclerviewhome);
        List<ImageDataBoard> dataList = new ArrayList<>();

        dataList.add(new ImageDataBoard(R.drawable.animal_1,"Data", "23 Pins"));
        dataList.add(new ImageDataBoard(R.drawable.anime_6,"Data2", "10 Pins"));
        dataList.add(new ImageDataBoard(R.drawable.garden_2,"Data", "24 Pins"));
        dataList.add(new ImageDataBoard(R.drawable.wallpaper_1,"Data", "232 Pins"));
        dataList.add(new ImageDataBoard(R.drawable.animal_2,"Data", "2 Pins"));
        dataList.add(new ImageDataBoard(R.drawable.anime_3,"Data", "19 Pins"));

        RecyclerView.LayoutManager layoutManager =  new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        savedRecycleAdapter = new SavedRecycleAdapter(requireContext(), dataList);
        recyclerView.setAdapter(savedRecycleAdapter);
        return view;
    }
}