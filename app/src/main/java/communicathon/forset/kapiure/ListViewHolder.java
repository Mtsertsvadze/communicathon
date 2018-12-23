package communicathon.forset.kapiure;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ListViewHolder extends RecyclerView.ViewHolder  {

    private ImageView info;
    private Button button;


    public ListViewHolder(@NonNull View itemView) {
        super(itemView);

        info = itemView.findViewById(R.id.item_info);
        //button = itemView.findViewById(R.id.item_button);
    }

    public void setData(int id){
        info.setImageResource(id);
    }
}
