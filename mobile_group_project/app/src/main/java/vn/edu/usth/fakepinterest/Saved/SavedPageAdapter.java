package vn.edu.usth.fakepinterest.Saved;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.fakepinterest.Homepage.HomePageAdapter;
import vn.edu.usth.fakepinterest.Homepage.HomePage_All;
import vn.edu.usth.fakepinterest.Homepage.HomePage_Cat;
import vn.edu.usth.fakepinterest.Homepage.HomePage_Wallpaper;
import vn.edu.usth.fakepinterest.Notification.InboxFragment;
import vn.edu.usth.fakepinterest.Notification.UpdateFragment;
public class SavedPageAdapter extends FragmentStateAdapter{

    public SavedPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new PinsFragment();
            case 1: return new BoardsFragment();
            default: return new PinsFragment();
        }
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}