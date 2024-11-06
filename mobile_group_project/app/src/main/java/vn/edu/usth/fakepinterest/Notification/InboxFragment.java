package vn.edu.usth.fakepinterest.Notification;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.edu.usth.fakepinterest.R;

public class InboxFragment extends Fragment {

    private Button newMsgButton;
    private Button cheemsMsgButton;
    private Button cheemsMsg2Button;
    private Button cheemsMsg3Button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);

        cheemsMsgButton = view.findViewById(R.id.cheems_msg);
        cheemsMsgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment clicked = new ChatFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.main, clicked).commit();
            }
        });
        return view;
    }
}