package umn.ac.id.gamesecond;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class DeleteDataAdapter extends FirebaseRecyclerAdapter<DeleteDataModel, DeleteDataAdapter.ViewHolder> {

    public DeleteDataAdapter(@NonNull FirebaseRecyclerOptions<DeleteDataModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull DeleteDataModel model) {

        holder.deletenameproduct.setText(model.getName());
        holder.deleteprice.setText(model.getPrice());
        holder.deletedetail.setText(model.getDetail());
        holder.deletenameproduct.setText(model.getName());
        Glide.with(holder.deleteimage.getContext()).load(model.getImg()).into(holder.deleteimage);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference().child("Product List")
                        .child(getRef(position).getKey())
                        .removeValue()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(view.getContext(), "Deleted Succssfully", Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delete, parent,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView deletenameproduct, deleteprice, deletedetail;
        ImageView deleteimage, delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            deletenameproduct = itemView.findViewById(R.id.deletenameproduct);
            deleteprice = itemView.findViewById(R.id.deleteprice);
            deletedetail = itemView.findViewById(R.id.deletedetail);
            deleteimage = itemView.findViewById(R.id.deleteimage);
            delete = itemView.findViewById(R.id.delete);


        }
    }
}
