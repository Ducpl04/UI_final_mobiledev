package vn.edu.usth.fakepinterest.Homepage;

import static android.view.View.inflate;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.fakepinterest.ImageData;
import vn.edu.usth.fakepinterest.R;
import vn.edu.usth.fakepinterest.ShareFragment;


public class HomeRecycleAdapter extends RecyclerView.Adapter<HomeRecycleAdapter.DataViewHolder> {

    List<ImageData> dataList;
    Context context;
    public HomeRecycleAdapter(Context context, List<ImageData> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public HomeRecycleAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);

        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecycleAdapter.DataViewHolder holder, int position) {
        holder.textView.setText(dataList.get(position).getImageName());

        holder.imageView.setImageResource(dataList.get(position).getImageResources());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        Button button_share;

        public DataViewHolder(View itemView){
            super(itemView);

            button_share = itemView.findViewById(R.id.click_to_dog);
            imageView = itemView.findViewById(R.id.item_image_replacing);
            textView = itemView.findViewById(R.id.image_name_replacing);
        }
    }
}
