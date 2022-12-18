package umn.ac.id.gamesecond;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class NotificationAdapter extends FirebaseRecyclerAdapter<NotificationModel,NotificationAdapter.myviewholder> {
    public NotificationAdapter(@NonNull FirebaseRecyclerOptions<NotificationModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull NotificationModel model) {
        holder.nama.setText(model.getName());
        holder.idproduct.setText(model.getIdproduct());
        holder.nohp.setText(model.getPhone());
        holder.address.setText(model.getAddress());

                holder.nama.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AppCompatActivity activity = (AppCompatActivity) view.getContext();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new NotificationDescFragment(model.getName(), model.getIdproduct(),model.getAddress(),model.getPhone())).addToBackStack(null).commit();
                    }
                });
                holder.idproduct.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AppCompatActivity activity = (AppCompatActivity) view.getContext();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new NotificationDescFragment(model.getName(), model.getIdproduct(),model.getAddress(),model.getPhone())).addToBackStack(null).commit();
                    }
                });
                holder.nohp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AppCompatActivity activity = (AppCompatActivity) view.getContext();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new NotificationDescFragment(model.getName(), model.getIdproduct(),model.getAddress(),model.getPhone())).addToBackStack(null).commit();
                    }
                });
                holder.address.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AppCompatActivity activity = (AppCompatActivity) view.getContext();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new NotificationDescFragment(model.getName(), model.getIdproduct(),model.getAddress(),model.getPhone())).addToBackStack(null).commit();
                    }
                });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification,parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView nama, idproduct, nohp, address;

        public myviewholder(@NonNull View itemView){
            super(itemView);

            nama = itemView.findViewById(R.id.nama);
            idproduct = itemView.findViewById(R.id.idproduct);
            nohp = itemView.findViewById(R.id.nohp);
            address = itemView.findViewById(R.id.address);
        }
    }
}
