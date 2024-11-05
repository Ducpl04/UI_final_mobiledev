package vn.edu.usth.fakepinterest.Homepage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HomePageAdapter extends FragmentStateAdapter {

    public HomePageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new HomePage_All();
            case 1: return new HomePage_Wallpaper();
            case 2: return new HomePage_Cat();
            default: return new HomePage_All();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
