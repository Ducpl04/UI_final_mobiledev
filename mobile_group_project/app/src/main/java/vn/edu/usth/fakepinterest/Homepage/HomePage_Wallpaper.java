package vn.edu.usth.fakepinterest.Homepage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.imageview.ShapeableImageView;

import vn.edu.usth.fakepinterest.R;

public class HomePage_Wallpaper extends Fragment {

    private static final String TAG = "HomePage_Wallpaper";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage_wallpaper, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout imageContainer1 = view.findViewById(R.id.left_linear_image);
        LinearLayout imageContainer2 = view.findViewById(R.id.right_linear_image);

        // Log the number of children in both containers
        Log.d(TAG, "Number of children in image container 1: " + imageContainer1.getChildCount());
        Log.d(TAG, "Number of children in image container 2: " + imageContainer2.getChildCount());

        // Create a common OnClickListener for all ShapeableImageView elements
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "ShapeableImageView clicked: " + v.getId());
                navigateToDestinationFragment();
            }
        };

        // Handle ShapeableImageView elements in both LinearLayouts
        handleShapeableImageViews(imageContainer1, onClickListener);
        handleShapeableImageViews(imageContainer2, onClickListener);
    }

    private void handleShapeableImageViews(LinearLayout container, View.OnClickListener onClickListener) {
        // Iterate through all child views in the container
        for (int i = 0; i < container.getChildCount(); i++) {
            View child = container.getChildAt(i);

            // Check if the child view is an instance of LinearLayout
            if (child instanceof LinearLayout) {
                LinearLayout verticalLayout = (LinearLayout) child;

                // Iterate through children of the LinearLayout
                for (int j = 0; j < verticalLayout.getChildCount(); j++) {
                    View innerChild = verticalLayout.getChildAt(j);

                    // Check if the inner child is a ShapeableImageView
                    if (innerChild instanceof ShapeableImageView) {
                        ShapeableImageView imageView = (ShapeableImageView) innerChild;
                        imageView.setOnClickListener(onClickListener);
                    }
                }
            }
        }
    }

    private void navigateToDestinationFragment() {
        Fragment destinationFragment = new clicked_on_image(); // Replace with your destination fragment
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the current fragment with the destination fragment
        fragmentTransaction.replace(R.id.main, destinationFragment); // Ensure this ID matches your container
        fragmentTransaction.addToBackStack(null); // Add to back stack to allow navigation back

        // Commit the transaction
        fragmentTransaction.commit();
    }
}