
package vn.edu.usth.fakepinterest.Notification;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class NotificationPagerAdapter extends FragmentStateAdapter {

    public NotificationPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return position == 0 ? new UpdateFragment() : new InboxFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
