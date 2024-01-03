package com.example.mykoonba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

import java.util.Calendar;

public class Signin extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signmail,signpass,signconfrimpass,signfullname,signdateofbirth,signphnnumber;
    private AppCompatButton Createaccountbtn;
    private TextView Doyouaccount;

    ProgressBar progressBar;

    AppCompatButton backbtn;
    TextView Alreadyaccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        auth = FirebaseAuth.getInstance();
        signmail = findViewById(R.id.Emailidsignin);
        signpass = findViewById(R.id.passwordsignin);
        signconfrimpass = findViewById(R.id.confirmpasswordsignin);
        Createaccountbtn = findViewById(R.id.CreateAccount);

        Createaccountbtn = findViewById(R.id.CreateAccount);
        Alreadyaccount = findViewById(R.id.Doyoualreadyaccount);
        backbtn = findViewById(R.id.BackbtnCreateaccount);
        signfullname = findViewById(R.id.signfullname);
        signdateofbirth = findViewById(R.id.signdateofbirth);
        signphnnumber = findViewById(R.id.signphnnumber);


        progressBar=findViewById(R.id.progress_circular);
        progressBar.setVisibility(View.GONE);

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


        signpass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (signpass.getText().toString().length()<8){
                    signpass.setError("Minimum 8 Digits Must be Required");
                }
            }
        });

        signconfrimpass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!signpass.getText().toString().equals(signconfrimpass.getText().toString()) ||signpass.getText().toString().equals(signconfrimpass.getText().toString()) && signconfrimpass.getText().toString().isEmpty()) {
                    signconfrimpass.setError("Password Not matched");
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



        signdateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });


//        auntenthcation---------------------------------------------------------------------------------------------------------------------------


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
                else if (TextUtils.isEmpty(phnnumber)) {
                    signphnnumber.setError("Please Enter Your Correct Number");
                    signphnnumber.requestFocus();

                }
                else if (phnnumber.length()!=10) {
                    signphnnumber.setError("Please Enter Valid NumberY");
                    signphnnumber.requestFocus();

                }
                else if (TextUtils.isEmpty(dateofbirth)){
                    signdateofbirth.setError("Please Enter Your Date of Birth");
                    signdateofbirth.requestFocus();
                }

                else if (user.isEmpty()){
                    signmail.setError("Email Cannot be Empty");
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(user).matches()){
                    signmail.setError("Plaese Enter Valid Email-id");
                }
                else if (pass.isEmpty()){
                    signpass.setError("Password Cannot be Empty");
                }
                else if (pass.length()<8){
                    signpass.setError("Minimum 8 Digits Must be Required");
                }
                else if (confirmpass.isEmpty()){
                    signconfrimpass.setError("Confirm Password Cannot be Empty");
                }
                else if (!pass.equals(confirmpass) || pass.equals(confirmpass) && confirmpass.isEmpty()) {
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


        progressBar.setVisibility(View.VISIBLE);
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
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void showDatePickerDialog() {
        // Get the current date
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Handle the selected date
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        // You can use the selectedDate as needed (e.g., display it, save it, etc.)

                        signdateofbirth.setText(selectedDate);
                    }
                },
                year, month, day);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }
}