package com.example.mykoonba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Passwordchangepage extends AppCompatActivity {

    EditText currentpasschange,newpasschange,confirmpasschange;
    AppCompatButton backbtn,resetbtn,verifybtn;
    FirebaseAuth firebaseAuth;
    String usercurrentpassword;

    FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordchangepage);

        currentpasschange = findViewById(R.id.Currentpasschange);
        newpasschange = findViewById(R.id.newpasswordchange);
        confirmpasschange = findViewById(R.id.confirmpasschang);
        backbtn = findViewById(R.id.backbtnpasswordhchange);
        resetbtn = findViewById(R.id.resetchane);
        verifybtn = findViewById(R.id.Authenticatchange);

        firebaseAuth = FirebaseAuth.getInstance();
        newpasschange.setEnabled(false);
        confirmpasschange.setEnabled(false);
        resetbtn.setEnabled(false);

        ImageView currentpassiconchange = findViewById(R.id.currentpassiconpasschange);
        currentpassiconchange.setImageResource(R.drawable.passhide);

        currentpassiconchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentpasschange.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    currentpasschange.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    currentpassiconchange.setImageResource(R.drawable.passhide);
                }
                else{
                    currentpasschange.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    currentpassiconchange.setImageResource(R.drawable.passhide);
                }
            }
        });

        ImageView newPassiconchange = findViewById(R.id.newpassiconchange);
        newPassiconchange.setImageResource(R.drawable.passhide);

        newPassiconchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newpasschange.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    newpasschange.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    currentpassiconchange.setImageResource(R.drawable.passhide);
                }
                else{
                    newpasschange.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    currentpassiconchange.setImageResource(R.drawable.passhide);
                }
            }
        });

        ImageView confirmpassiconchange = findViewById(R.id.confirmiconchange);
        confirmpassiconchange.setImageResource(R.drawable.passhide);

        confirmpassiconchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (confirmpasschange.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    confirmpasschange.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    confirmpassiconchange.setImageResource(R.drawable.passhide);
                }
                else{
                    confirmpasschange.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    confirmpassiconchange.setImageResource(R.drawable.passhide);
                }
            }
        });


        firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser.equals(" ")){
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }
        else {
            verifybtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usercurrentpassword = currentpasschange.getText().toString();
                    if (usercurrentpassword.isEmpty()){
                        currentpasschange.setError("Cannot be Empty");
                    }
                    else {
                        AuthCredential authCredential = EmailAuthProvider.getCredential(firebaseUser.getEmail(),usercurrentpassword);
                        firebaseUser.reauthenticate(authCredential).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    currentpasschange.setEnabled(false);
                                    newpasschange.setEnabled(true);
                                    confirmpasschange.setEnabled(true);
                                    resetbtn.setEnabled(true);
                                    verifybtn.setEnabled(false);

                                    


                                    resetbtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            String pass = newpasschange.getText().toString();
                                            String confirmpass = confirmpasschange.getText().toString();

                                            if (pass.isEmpty() ){
                                                newpasschange.setError("Cannot be Empty");
                                            }
                                           else if(confirmpass.isEmpty()){
                                                confirmpasschange.setError("Cannot be Empty");
                                            } else if (!pass.equals(confirmpass)) {
                                               confirmpasschange.setError("Password Not Matched");

                                            } else if (pass.equals(usercurrentpassword)) {
                                              confirmpasschange.setError(" new Password Cannot be Same as Old password");

                                            } else if (pass.length()<8) {
                                               confirmpasschange.setError("Password Must be  atleast 8 Digit Number");

                                            }
                                           else{
                                                   firebaseUser.updatePassword(pass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                       @Override
                                                       public void onComplete(@NonNull Task<Void> task) {
                                                           if(task.isSuccessful()){
                                                               Toast.makeText(Passwordchangepage.this, "Password Change Sucessfull", Toast.LENGTH_SHORT).show();
                                                               finish();
                                                           }
                                                           else{
                                                               Toast.makeText(Passwordchangepage.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                                                           }
                                                       }
                                                   }) ;
                                            }
                                        }
                                    });
                                }
                                else{
                                    Toast.makeText(Passwordchangepage.this, "Invalid password", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                }
            });
        }











    }
}