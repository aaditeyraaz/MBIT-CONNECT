package com.example.mbitconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScaneerCemara extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;
    DatabaseReference db;
    String dateTime;
    FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView=new ZXingScannerView(this);
        setContentView(scannerView);
       // db= FirebaseDatabase.getInstance().getReference("GatePass");
        firestore = FirebaseFirestore.getInstance();

        dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());


        Dexter.withContext(getApplicationContext())
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        scannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();

    }

    @Override
    public void handleResult(Result rawResult) {
     String data=rawResult.getText().toString();
//     db.push().setValue(data)
//             .addOnCompleteListener(new OnCompleteListener<Void>() {
//                 @Override
//                 public void onComplete(@NonNull Task<Void> task) {
//                     Toast.makeText(ScaneerCemara.this, "Data Inserted", Toast.LENGTH_SHORT).show();
//                     AdminScannerFragment.imageView.setVisibility(View.VISIBLE);
//                     onBackPressed();
//                 }
//             });

  //  String GrantBy= AdminScannerFragment.textView.getText().toString();
     AdminScannerFragment fm=new AdminScannerFragment();
    String GrantBy= AdminScannerFragment.name;

//        Map<String, Object> qrCode = new HashMap<>();
//        qrCode.put("dateTime", dateTime);
//        qrCode.put("GrantBy",GrantBy);
//        qrCode.put("GatePassdata", data);
//        firestore.collection("GatePass1").add(qrCode)
//                .addOnSuccessListener(documentReference -> {
//                    Toast.makeText(ScaneerCemara.this, "Data Inserted", Toast.LENGTH_SHORT).show();
//                    AdminScannerFragment.imageView.setVisibility(View.VISIBLE);
//                     onBackPressed();
//                })
//                .addOnFailureListener(e -> {
//                    // An error occurred
//                });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference qrDataRef = database.getReference("GatePass1");
        modelScanner scanner=new modelScanner();
        scanner.setTime(dateTime);
        scanner.setAdminGrant(GrantBy);
        scanner.setQrdate(data);

        qrDataRef.push().setValue(scanner).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(ScaneerCemara.this, "Successful....", Toast.LENGTH_SHORT).show();
                AdminScannerFragment.imageView.setVisibility(View.VISIBLE);
                onBackPressed();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
    }
}