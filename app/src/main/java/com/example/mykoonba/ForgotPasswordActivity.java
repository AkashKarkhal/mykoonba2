package com.example.mykoonba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText forgotemail;

    AppCompatButton back,resetPassword;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        resetPassword=findViewById(R.id.forgotresetBtn);
        back=findViewById(R.id.backforgotbtn);
        forgotemail = findViewById(R.id.forgotemail);

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = forgotemail.getText().toString();
                if (email.isEmpty()){
                    forgotemail.setError("Enter email");
                    forgotemail.requestFocus();

                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    forgotemail.setError("Enter Valid Email");
                    forgotemail.requestFocus();
                }
                else{
                    firebaseAuth  = FirebaseAuth.getInstance();
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ForgotPasswordActivity.this, "Please Check Your Email and Verify ", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), LoginSignupActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                if(firebaseAuth.getCurrentUser()!=null){
                                    firebaseAuth.signOut();
                                }
                                finish();

                            }
                            else{
                                Toast.makeText(ForgotPasswordActivity.this, "Failed To Send Verification Link", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}