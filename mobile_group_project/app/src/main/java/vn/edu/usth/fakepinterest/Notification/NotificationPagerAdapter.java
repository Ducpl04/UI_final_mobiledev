package vn.edu.usth.fakepinterest.Notification;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.fakepinterest.Saved.BoardsFragment;
import vn.edu.usth.fakepinterest.Saved.PinsFragment;

public class NotificationPagerAdapter extends FragmentStateAdapter {

    public NotificationPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new UpdateFragment();
            case 1: return new InboxFragment();
            default: return new UpdateFragment();
        }
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}