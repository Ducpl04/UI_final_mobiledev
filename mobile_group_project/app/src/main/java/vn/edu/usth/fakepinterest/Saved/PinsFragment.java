package vn.edu.usth.fakepinterest.Saved;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import vn.edu.usth.fakepinterest.CreatePage.CreatePage;
import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.ShareFragment;

public class PinsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_pins, container, false);

        ImageButton createButton; // Use your actual button ID
        createButton = view.findViewById(R.id.pins_create);

        // Set an OnClickListener for the button
        createButton.setOnClickListener(v -> {
            // Show the BottomSheetDialogFragment
            CreatePage bottomSheet = new CreatePage();
            bottomSheet.show(getParentFragmentManager(), bottomSheet.getTag());
        });
        return view;
    }
}