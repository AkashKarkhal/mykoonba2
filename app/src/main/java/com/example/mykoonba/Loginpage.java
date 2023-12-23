package com.example.mykoonba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Loginpage extends AppCompatActivity {

    private EditText loginemail,loginpassword;
    private AppCompatButton loginbtn;
    FirebaseAuth auth;

    AppCompatButton back;
    TextView forgot,signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        loginbtn = findViewById(R.id.loginBtn);
        forgot=findViewById(R.id.forgotpassword);
        signup=findViewById(R.id.textView4);
        back=findViewById(R.id.backloginbtn);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Signin.class));
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ForgotPasswordActivity.class));
                finish();
            }
        });

        auth = FirebaseAuth.getInstance();
        loginemail = findViewById(R.id.loginemail);
        loginpassword=  findViewById(R.id.loginpassword);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Optional: finish the current activity if needed

                String email = loginemail.getText().toString();
                String pass = loginpassword.getText().toString();
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()){
                        auth.signInWithEmailAndPassword(email,pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(Loginpage.this, "Login Sucessfullly ", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                        finish(); //
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Loginpage.this, "Login Failed ", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }else{
                        loginpassword.setError("Password Cannot be Empty");
                    }


                } else if (email.isEmpty()) {
                    loginemail.setError("Email Cannot be Empty");

                }else{
                    loginemail.setError("Please Enter Valid Email");
                }

            }
        });
    }
}