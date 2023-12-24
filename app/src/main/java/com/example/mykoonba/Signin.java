package com.example.mykoonba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

public class Signin extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signmail,signpass,signconfrimpass,signfullname,signdateofbirth,signphnnumber;
    private AppCompatButton Createaccountbtn;
    private TextView Doyouaccount;


    AppCompatButton backbtn;
    TextView Alreadyaccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Createaccountbtn = findViewById(R.id.CreateAccount);
        Alreadyaccount = findViewById(R.id.Doyoualreadyaccount);
        backbtn = findViewById(R.id.BackbtnCreateaccount);
        signfullname = findViewById(R.id.signfullname);
        signdateofbirth = findViewById(R.id.signdateofbirth);
        signphnnumber = findViewById(R.id.signphnnumber);


        ImageView passiconsign = findViewById(R.id.passiconsign);
        passiconsign.setImageResource(R.drawable.passhide);
        passiconsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (signpass.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    signpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    passiconsign.setImageResource(R.drawable.passhide);

                }
                else{
                    signpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    passiconsign.setImageResource(R.drawable.passshow);
                }
            }
        });

       ImageView  confirmpassiconsignin = findViewById(R.id.confirmpassiconsign);
       confirmpassiconsignin.setImageResource(R.drawable.passhide);

       confirmpassiconsignin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (signconfrimpass.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                   signconfrimpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                   confirmpassiconsignin.setImageResource(R.drawable.passhide);
               }
               else{
                   signconfrimpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                   confirmpassiconsignin.setImageResource(R.drawable.passshow);
               }
           }
       });






        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Alreadyaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Loginpage.class));
            }
        });



//        auntenthcation---------------------------------------------------------------------------------------------------------------------------

        auth = FirebaseAuth.getInstance();
        signmail = findViewById(R.id.Emailidsignin);
        signpass = findViewById(R.id.passwordsignin);
        signconfrimpass = findViewById(R.id.confirmpasswordsignin);
        Createaccountbtn = findViewById(R.id.CreateAccount);


        Createaccountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = signmail.getText().toString();
                String pass = signpass.getText().toString();
                String confirmpass = signconfrimpass.getText().toString();
                String fullname = signfullname.getText().toString();
                String dateofbirth = signdateofbirth.getText().toString();
                String phnnumber = signphnnumber.getText().toString();

                if (TextUtils.isEmpty(fullname)){
                    signfullname.setError("Please Enter Your Full Name");
                    signfullname.requestFocus();

                }
                if (TextUtils.isEmpty(phnnumber)) {
                    signphnnumber.setError("Please Enter Your Correct Number");
                    signphnnumber.requestFocus();

                }
                if (phnnumber.length()!=10) {
                    signphnnumber.setError("Please Enter Valid NumberY");
                    signphnnumber.requestFocus();

                }
                if (TextUtils.isEmpty(dateofbirth)){
                    signdateofbirth.setError("Please Enter Your Date of Birth");
                    signdateofbirth.requestFocus();
                }

                if (user.isEmpty()){
                    signmail.setError("Email Cannot be Empty");
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(user).matches()){
                    signmail.setError("Plaese Enter Valid Email-id");
                }
                if (pass.isEmpty()){
                    signpass.setError("Password Cannot be Empty");
                }
                if (pass.length()<8){
                    signpass.setError("Minimum 8 Digits Must be Required");
                }
                if (confirmpass.isEmpty()){
                    signconfrimpass.setError("Confirm Password Cannot be Empty");
                }
                if (!pass.equals(confirmpass) || pass.equals(confirmpass) && confirmpass.isEmpty()) {
                    signconfrimpass.setError("Password Not matched");
                    signpass.clearComposingText();
                    signconfrimpass.clearComposingText();
                }

                else{

                    registerUser(user,pass,phnnumber,fullname,dateofbirth);
                }

            }
        });




    }

    private void registerUser(String user, String pass, String phnnumber, String fullname, String dateofbirth) {


        auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser =  auth.getCurrentUser();

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Register Users ");
                    databaseReference.child(firebaseUser.getUid()).setValue(new UserProfiledata(fullname,dateofbirth,phnnumber)).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(Signin.this, "Account Created Sucessfully", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getApplicationContext(), Verification_email_of_signin.class);
                                i.putExtra("mode","signin");
                                startActivity(i);
                                finish();

                            }
                            else{
                                Toast.makeText(Signin.this, "Account Creation is Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });






                }
                else{
                    Toast.makeText(Signin.this, "Account Creation Failed " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}