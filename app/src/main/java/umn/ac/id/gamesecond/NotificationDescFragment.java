package umn.ac.id.gamesecond;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class NotificationDescFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String nama, idproduct, nohp, address;
    public NotificationDescFragment() {

    }

    public NotificationDescFragment(String nama, String idproduct, String nohp, String address){
        this.nama = nama;
        this.idproduct = idproduct;
        this.nohp = nohp;
        this.address = address;
    }

    public static NotificationDescFragment newInstance(String param1, String param2) {
        NotificationDescFragment fragment = new NotificationDescFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification_desc, container, false);

        TextView Namaholder = view.findViewById(R.id.Nama);
        TextView IDProdukholder = view.findViewById(R.id.IDProduk);
        TextView Alamatholder = view.findViewById(R.id.Alamat);
        TextView Nohpholder = view.findViewById(R.id.NoHP);

        Namaholder.setText(nama);
        IDProdukholder.setText(idproduct);
        Alamatholder.setText(address);
        Nohpholder.setText(nohp);

        return view;
    }
    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new NotificationFragment()).addToBackStack(null).commit();

    }
}