package vn.edu.usth.fakepinterest.Notification;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import vn.edu.usth.fakepinterest.R;

public class UpdateFragment extends Fragment {

    private int[] layoutIds = {
            R.id.noti1,
            R.id.noti2,
            R.id.noti3,
            R.id.noti4,
            R.id.noti5
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        // Loop through each ID and set click listeners
        for (int id : layoutIds) {
            View layout = view.findViewById(id);
            if (layout != null) {
                layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle click
                        handleClick(v);
                    }
                });
            }
        }

        return view;
    }

    // Method to handle click events
    private void handleClick(View view) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.noti1:
                transaction.replace(R.id.main, new Clicked_update());
                break;

            case R.id.noti2:
                transaction.replace(R.id.main, new Clicked_update());
                break;

            case R.id.noti3:
                transaction.replace(R.id.main, new Clicked_update());
                break;

            case R.id.noti4:
                transaction.replace(R.id.main, new Clicked_update());
                break;

            case R.id.noti5:
                transaction.replace(R.id.main, new Clicked_update());
                break;

            default:
                break;
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
}