package umn.ac.id.gamesecond;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HalamanCheckOutActivity extends AppCompatActivity {

    private DatabaseReference mdatabase;
    private EditText Name, Phone, Address, IDProduct;
    private Button Buttonpayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_check_out);

        Name = findViewById(R.id.insertyouname);
        Phone = findViewById(R.id.insertyounumber);
        Address = findViewById(R.id.insertyouaddress);
        IDProduct = findViewById(R.id.insertidproduct);
        Buttonpayment =findViewById(R.id.Buttonpayment);
        mdatabase = FirebaseDatabase.getInstance().getReference();
    }


    public void sendData (View view){
        String idproduct = IDProduct.getText().toString().trim();
        String name = Name.getText().toString().trim();
        String address = Address.getText().toString().trim();
        String phone = Phone.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Name.setError("Name is Required");
            return;
        }

        if(TextUtils.isEmpty(idproduct)) {
            IDProduct.setError("ID product is Required");
            return;

        }

        if(TextUtils.isEmpty(address)) {
            Address.setError("Address is Required");
            return;

        }

        if(TextUtils.isEmpty(phone)) {
            Phone.setError("Phone is Required");
            return;

        } else{
            Toast.makeText(this, "Payment Complete", Toast.LENGTH_SHORT).show();
        writeNewOrderList();

        switch (view.getId()) {
            case R.id.Buttonpayment:

        }
        }
    }

    public void writeNewOrderList() {
            OrderList orderList = new OrderList(Name.getText().toString(),
                    Phone.getText().toString(),
                    Address.getText().toString(),
                    IDProduct.getText().toString());
            mdatabase.child("Order List").child(orderList.getIDProduct()).setValue(orderList);

    }
}