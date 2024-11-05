package vn.edu.usth.fakepinterest.CreatePage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import vn.edu.usth.fakepinterest.R;

public class CreatePage extends BottomSheetDialogFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheetlayout, container, false);

        ImageView cancelButton = view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().popBackStack();
        });
        return view;
    }
}
