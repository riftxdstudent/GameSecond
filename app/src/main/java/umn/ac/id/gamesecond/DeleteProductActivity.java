package umn.ac.id.gamesecond;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteProductActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DeleteDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);

        recyclerView = findViewById(R.id.deletelist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<DeleteDataModel> options =
                new FirebaseRecyclerOptions.Builder<DeleteDataModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference()
                        .child("Product List"), DeleteDataModel.class)
                        .build();

        adapter = new DeleteDataAdapter(options);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}