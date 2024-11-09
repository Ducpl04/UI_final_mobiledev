package vn.edu.usth.fakepinterest.Account;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.fakepinterest.R;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.DataViewHolder> {
    private List<UserData> dataList;
    private Context context;


    public UserDataAdapter( Context context, List<UserData> dataList) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_proflie, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.textNameView.setText(dataList.get(position).getUserName());
        holder.userPins.setText(dataList.get(position).getUserPins());
        holder.imageView.setImageResource(dataList.get(position).getDataResources());
        holder.description.setText(dataList.get(position).getDescription());
        holder.userFollow.setText(dataList.get(position).getUserFollow());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public static class DataViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textNameView;
        TextView userPins;
        TextView description;
        TextView userFollow;

        public DataViewHolder(View itemView){
            super(itemView);
            userPins = itemView.findViewById(R.id.pins_count);
            imageView = itemView.findViewById(R.id.profile_image);
            textNameView = itemView.findViewById(R.id.username);
            description = itemView.findViewById(R.id.bio);
            userFollow = itemView.findViewById(R.id.followers_count);
        }
    }
}
