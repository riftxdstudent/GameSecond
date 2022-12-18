package umn.ac.id.gamesecond;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ProductListAdapter extends FirebaseRecyclerAdapter <ProductListModel,ProductListAdapter.myviewholder> {


    public ProductListAdapter(@NonNull FirebaseRecyclerOptions<ProductListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull ProductListModel model) {
        holder.textview.setText(model.getName());
        holder.textview2.setText(model.getPrice());
        holder.textview3.setText(model.getDetail());
        Glide.with(holder.imageview1.getContext()).load(model.getImg()).into(holder.imageview1);

        holder.imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new DetailFragment(model.getName(),model.getDetail(),model.getPrice(),model.getImg())).addToBackStack(null).commit();
            }
        });
        holder.textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new DetailFragment(model.getName(),model.getDetail(),model.getPrice(),model.getImg())).addToBackStack(null).commit();
            }
        });
        holder.textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new DetailFragment(model.getName(),model.getDetail(),model.getPrice(),model.getImg())).addToBackStack(null).commit();
            }
        });
        holder.textview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new DetailFragment(model.getName(),model.getDetail(),model.getPrice(),model.getImg())).addToBackStack(null).commit();
            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView imageview1;
        TextView textview, textview2, textview3;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            imageview1 = itemView.findViewById(R.id.imageview1);
            textview = itemView.findViewById(R.id.textview);
            textview2 = itemView.findViewById(R.id.textview2);
            textview3 = itemView.findViewById(R.id.textview3);

        }

    }

}