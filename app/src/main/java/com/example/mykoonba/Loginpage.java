package com.example.mykoonba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Loginpage extends AppCompatActivity {

    private EditText loginemail,loginpassword;
    private AppCompatButton loginbtn;
    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    AppCompatButton back,google,facebook;
    TextView forgot,signup;

    AppCompatButton googlelogin;
    FirebaseDatabase database;
    GoogleSignInClient gcs;
    int RC_SIGN_IN = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        loginbtn = findViewById(R.id.loginBtn);
        forgot=findViewById(R.id.forgotpassword);
        signup=findViewById(R.id.textView4);
        back=findViewById(R.id.backloginbtn);
        googlelogin = findViewById(R.id.logingooglebtn);

       auth = FirebaseAuth.getInstance();
       database = FirebaseDatabase.getInstance();

       GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
               .requestIdToken(getString(R.string.default_web_client_id))
               .requestEmail()
               .build();

       gcs = GoogleSignIn.getClient(this,gso);


       googlelogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               googleSignin();

           }
       });






        ImageView passiconlogin = findViewById(R.id.passiconlogin);
        passiconlogin.setImageResource(R.drawable.passhide);

        passiconlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginpassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    loginpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    passiconlogin.setImageResource(R.drawable.passhide);

                }
                else{
                    loginpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    passiconlogin.setImageResource(R.drawable.passshow);
                }
            }
        });


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

    private void googleSignin() {


        Intent intent = gcs.getSignInIntent();
        startActivityForResult(intent,RC_SIGN_IN);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode==RC_SIGN_IN){

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {

                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebseauth(account.getIdToken());

            }
            catch (Exception e){
                Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebseauth(String idToken) {


        AuthCredential credential = GoogleAuthProvider.getCredential(idToken,null);

        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            FirebaseUser user = auth.getCurrentUser();

                            HashMap<String , Object> map = new HashMap<>();
                            map.put("id",user.getUid());
                            map.put("name",user.getDisplayName());
                            map.put("Profile",user.getPhotoUrl().toString());


                            database.getReference().child("users").child(user.getUid()).setValue(map);

                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                        else {

                            Toast.makeText(Loginpage.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}





