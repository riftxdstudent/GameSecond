package umn.ac.id.gamesecond;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddProductActivity extends AppCompatActivity {
    FirebaseDatabase mdatabase;
    DatabaseReference mref;
    FirebaseStorage mstorage;
    ImageButton firebaseimag;
    EditText productname, detailproduct, priceproduct;
    Button submit;
    private static final int Gallery_Code=1;
    Uri imageUrl=null;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        firebaseimag = findViewById(R.id.firebaseimage);
        productname = findViewById(R.id.productname);
        detailproduct = findViewById(R.id.detailproduct);
        priceproduct = findViewById(R.id.priceproduct);
        submit = findViewById(R.id.submit);

        mdatabase = FirebaseDatabase.getInstance();
        mref = mdatabase.getReference().child("Product List");
        mstorage = FirebaseStorage.getInstance();
        progressDialog = new ProgressDialog(this);

        firebaseimag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, Gallery_Code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Gallery_Code && resultCode==RESULT_OK){
            imageUrl=data.getData();
            firebaseimag.setImageURI(imageUrl);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fn=productname.getText().toString().trim();
                String ln=detailproduct.getText().toString().trim();
                String kn=priceproduct.getText().toString().trim();

                if (!(fn.isEmpty()&& ln.isEmpty() && kn.isEmpty() && imageUrl!=null)){
                    progressDialog.setTitle("Uploading...");
                    progressDialog.show();

                    StorageReference filepath = mstorage.getReference().child("imagePost").child(imageUrl.getLastPathSegment());
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String t = task.getResult().toString();

                                    DatabaseReference newPost=mref.push();

                                    newPost.child("Name").setValue(fn);
                                    newPost.child("Detail").setValue(ln);
                                    newPost.child("Price").setValue(kn);
                                    newPost.child("Img").setValue(task.getResult().toString());
                                    progressDialog.dismiss();
                                }
                            });
                        }
                    });
                }
            }
        });
    }
}