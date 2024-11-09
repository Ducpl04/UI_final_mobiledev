package vn.edu.usth.fakepinterest.Saved;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.fakepinterest.Homepage.HomeRecycleAdapter;
import vn.edu.usth.fakepinterest.ImageData;
import vn.edu.usth.fakepinterest.ImageDataBoard;
import vn.edu.usth.fakepinterest.R;

public class SavedRecycleAdapter extends RecyclerView.Adapter<SavedRecycleAdapter.DataViewHolder> {

    List<ImageDataBoard> dataBoardList;
    Context context;
    public SavedRecycleAdapter(Context context, List<ImageDataBoard> dataBoardList){
            this.context = context;
            this.dataBoardList = dataBoardList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image_boards, parent, false);

        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        holder.textView.setText(dataBoardList.get(position).getImageName());
        holder.pinsView.setText(dataBoardList.get(position).getPins_quantities());
        holder.imageView.setImageResource(dataBoardList.get(position).getImageResources());
    }

    @Override
    public int getItemCount() {
        return dataBoardList.size();    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        Button button_share;
        TextView pinsView;

        public DataViewHolder(View itemView){
            super(itemView);

            pinsView = itemView.findViewById(R.id.image_pins_replacing);
            button_share = itemView.findViewById(R.id.click_to_dog);
            imageView = itemView.findViewById(R.id.item_image_replacing);
            textView = itemView.findViewById(R.id.image_name_replacing);
        }

    }
}
