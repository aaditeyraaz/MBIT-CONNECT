package Connect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.mbitconnect.Profile;
import com.example.mbitconnect.R;
import com.example.mbitconnect.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Pattern;

import SpleshScreen.User;

public class SignupActivity extends AppCompatActivity {

    AppCompatButton loginBtn;
    ActivitySignupBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore database;
    ProgressDialog dialog;
    boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth=FirebaseAuth.getInstance();

        database=FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("We're creating new account...");



        binding.passwordBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=binding.passwordBox.getRight()-binding.passwordBox.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=binding.passwordBox.getSelectionEnd();
                        if(passwordVisible){
                            binding.passwordBox.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            binding.passwordBox.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else {
                            binding.passwordBox.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            binding.passwordBox.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;

                        }

                        binding.passwordBox.setSelection(selection);
                        return  true;
                    }
                }
                return false;
            }
        });

    binding.createNewBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String email,pass,name,regno;
              email=binding.emailBox.getText().toString();
              pass=binding.passwordBox.getText().toString();
              name=binding.nameBox.getText().toString();
              regno=binding.regnoBox.getText().toString();

              if(TextUtils.isEmpty((name))){
                  Toast.makeText(SignupActivity.this, "Please Enter Your Full Name", Toast.LENGTH_SHORT).show();
                  binding.nameBox.setError("Full Name is required");
                  binding.nameBox.requestFocus();
              }else if(TextUtils.isEmpty(email)){
                  Toast.makeText(SignupActivity.this, "Please Enter Your  Email", Toast.LENGTH_SHORT).show();
                  binding.emailBox.setError("Email is required");
                  binding.emailBox.requestFocus();
              }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                  Toast.makeText(SignupActivity.this, "Please Re-Enter Your  Email", Toast.LENGTH_SHORT).show();
                  binding.emailBox.setError("Valid email is required");
                  binding.emailBox.requestFocus();
              }else if(TextUtils.isEmpty(regno)){
                  Toast.makeText(SignupActivity.this, "Please Enter Your  Registration No", Toast.LENGTH_SHORT).show();
                  binding.regnoBox.setError("Registration is required");
                  binding.regnoBox.requestFocus();
              }else if(regno.length()!=11){
                  Toast.makeText(SignupActivity.this, "Please Re-Enter Your  Registration No", Toast.LENGTH_SHORT).show();
                  binding.regnoBox.setError("Vaild Registration is required ");
                  binding.regnoBox.requestFocus();
              }else if(TextUtils.isEmpty(pass)){
                  Toast.makeText(SignupActivity.this, "Please Enter Your  Password", Toast.LENGTH_SHORT).show();
                  binding.passwordBox.setError("Password is required ");
                  binding.passwordBox.requestFocus();
              }else if(pass.length()<6){
                  Toast.makeText(SignupActivity.this, "Password should be at least 6 digits", Toast.LENGTH_SHORT).show();
                  binding.passwordBox.setError("Password too weak");
                  binding.passwordBox.requestFocus();
              }
              else{

              }



              User  user=new User(name,email,pass,regno);

              dialog.show();
              auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {

                      if(task.isSuccessful())
                      {
                          String uid=task.getResult().getUser().getUid();
                          database
                                  .collection("users")
                                  .document(uid)
                                  .set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                      @Override
                                      public void onComplete(@NonNull Task<Void> task) {
                                          if(task.isSuccessful())
                                          {
                                              dialog.dismiss();

                                              startActivity(new Intent(getApplicationContext(),Dashboard.class));
//                                              Intent intent=new Intent(getApplicationContext(), Profile.class);
//                                              intent.putExtra("name",name);
//                                              intent.putExtra("email",email);
//                                              intent.putExtra("regno",regno);
//                                              //intent.putExtra("name",name);
//                                              startActivity(intent);
                                              finish();


                                          }
                                          else {
                                              Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  });

//                          dialog.dismiss();
//                          startActivity(new Intent(SignupActivity.this, LogInActivity .class));
//                          finish();
//                          Toast.makeText(SignupActivity.this, "success", Toast.LENGTH_SHORT).show();
                      }
                      else{
                          dialog.dismiss();
                          Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                      }
                  }
              });


          }
      });

    binding.loginBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),LogInActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.left_to_rigth,R.anim.right_to_left);
        }
    });
    }
}