package Connect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mbitconnect.R;
import com.example.mbitconnect.databinding.ActivityLogInBinding;
import com.example.mbitconnect.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {


//    Button createNewBtn,submitBtn;
    ActivityLogInBinding binding;
    FirebaseAuth auth;
    ProgressDialog dialog;
    boolean passwordVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth=FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("Logging in...");



        if(auth.getCurrentUser() != null) {
            startActivity(new Intent(LogInActivity.this, Dashboard.class));
            finish();
        }



        //password visibilty icon
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

        //-----------------------------------------------------


//        createNewBtn=(Button) findViewById(R.id.createNewBtn);
//        submitBtn=(Button) findViewById(R.id.submitBtn);

        binding.createNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_to_rigth,R.anim.right_to_left);
            }
        });

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(getApplicationContext(),Dashboard.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.left_to_rigth,R.anim.right_to_left);

                String email,pass;
                email=binding.emailBox.getText().toString();
                pass=binding.passwordBox.getText().toString();
                dialog.show();

                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();
                        if(task.isSuccessful())
                        {
                            Toast.makeText(LogInActivity.this, "success", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Dashboard.class);
                            startActivity(intent);
                             overridePendingTransition(R.anim.left_to_rigth,R.anim.right_to_left);
                            finish();

                        }
                        else{
                            Toast.makeText(LogInActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}