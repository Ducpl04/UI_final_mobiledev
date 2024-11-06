package vn.edu.usth.fakepinterest.Homepage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.fakepinterest.ImageData;
import vn.edu.usth.fakepinterest.R;

public class HomePage_Wallpaper extends Fragment {

    HomeRecycleAdapter homeRecycleAdapter;
    RecyclerView recyclerView;

    private static final String TAG = "HomePage_Wallpaper";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_homepage_wallpaper, container, false);

        recyclerView = view.findViewById(R.id.recyclerviewhome);

        List<ImageData> dataList = new ArrayList<>();

        dataList.add(new ImageData(R.drawable.anime_6,"Data"));
        dataList.add(new ImageData(R.drawable.anime_3, "Data2"));
        dataList.add(new ImageData(R.drawable.garden_5, "Data3"));
        dataList.add(new ImageData(R.drawable.garden_10, "Data4"));
        dataList.add(new ImageData(R.drawable.garden_6, "Data5"));
        dataList.add(new ImageData(R.drawable.animal_6, "Data6"));
        dataList.add(new ImageData(R.drawable.garden_10, "Data4"));
        dataList.add(new ImageData(R.drawable.garden_5, "Data3"));
        dataList.add(new ImageData(R.drawable.animal_7, "Data7"));

        RecyclerView.LayoutManager layoutManager =  new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        homeRecycleAdapter = new HomeRecycleAdapter(requireContext(), dataList);
        recyclerView.setAdapter(homeRecycleAdapter);

        return view;
    }

}