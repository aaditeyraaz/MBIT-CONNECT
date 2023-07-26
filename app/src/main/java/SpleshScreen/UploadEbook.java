package SpleshScreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mbitconnect.R;
import com.example.mbitconnect.databinding.ActivityEbookBinding;
import com.example.mbitconnect.databinding.ActivityUploadEbookBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class UploadEbook extends AppCompatActivity
{
    Toolbar toolbar2;
   ActivityUploadEbookBinding binding;
   Uri filepath;

   StorageReference storageReference;
   DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityUploadEbookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle("  ");
        }

        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference("Ebook");

        binding.filelogo.setVisibility(View.INVISIBLE);
        binding.cenclefile.setVisibility(View.INVISIBLE);

        binding.cenclefile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.filelogo.setVisibility(View.INVISIBLE);
                binding.cenclefile.setVisibility(View.INVISIBLE);
                binding.fileBrowse.setVisibility(View.VISIBLE);
            }
        });


        binding.fileBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withContext(getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent=new Intent();
                                intent.setType("application/pdf");
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent,"Select Pdf Files"),101);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                    permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });


        binding.uploadfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processupload(filepath);
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101 && resultCode==RESULT_OK)
        {
            filepath=data.getData();
            binding.filelogo.setVisibility(View.VISIBLE);
            binding.cenclefile.setVisibility(View.VISIBLE);
            binding.fileBrowse.setVisibility(View.INVISIBLE);

        }
    }

    public void processupload(Uri filepath)
    {
       final ProgressDialog pd=new ProgressDialog(this);
        pd.setTitle("File Uploading..");
        pd.setCancelable(false);

        pd.show();
        String title=binding.filetitle.toString();
        StorageReference reference=storageReference.child("EbookUploads/"+System.currentTimeMillis()+".pdf");
        reference.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String title=binding.filetitle.getText().toString();
                                String author=binding.author.getText().toString();
                                FileInfoModel obj=new FileInfoModel(title,uri.toString(),author);
                                databaseReference.child(databaseReference.push().getKey()).setValue(obj);
                                pd.dismiss();

                                Toast.makeText(UploadEbook.this, "File Uploaded", Toast.LENGTH_SHORT).show();
                                binding.filelogo.setVisibility(View.INVISIBLE);
                                binding.cenclefile.setVisibility(View.INVISIBLE);
                                binding.fileBrowse.setVisibility(View.VISIBLE);
                                binding.filetitle.setText("");


                            }
                        });
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            float percent=(100*snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                            pd.setMessage("Uploaded: "+(int)percent+"%");
                    }
                });
    }
}