package umn.ac.id.gamesecond;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText etFullname, etEmail, etPassword, etPhone;
    MaterialButton btnRegister;
    TextView registerToLogin;
    FirebaseAuth fAuth;
    ProgressBar pbRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        etFullname = (EditText) findViewById(R.id.etFullname);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPhone = (EditText) findViewById(R.id.etPhone);

        btnRegister = (MaterialButton) findViewById(R.id.btnRegister);

        registerToLogin = (TextView) findViewById(R.id.registerToLogin);

        fAuth = FirebaseAuth.getInstance();
        pbRegister = (ProgressBar) findViewById(R.id.pbRegister);

        if(fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    etEmail.setError("Email is required!");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    etPassword.setError("Password is Required");
                    return;
                }

                if(password.length() < 5) {
                    etPassword.setError("Password must be more than 5 characters");
                    return;
                }

                //Set the user data to Firebase
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Register.this, "Yay! User Register is successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Register.this, "Your User Register is failed :(", Toast.LENGTH_SHORT).show();
                            pbRegister.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        registerToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}