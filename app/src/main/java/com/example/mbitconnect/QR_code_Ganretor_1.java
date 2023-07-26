package com.example.mbitconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class QR_code_Ganretor_1 extends AppCompatActivity {
    Toolbar toolbar2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_ganretor1);

        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;
        imageView=(ImageView) findViewById(R.id.QR_Image);

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle("  ");
        }

        Bundle bundle=getIntent().getExtras();
        assert bundle!=null;
        String Name=bundle.getString("NAME");
        String RegNo=bundle.getString("REGNO");
        String Purpose=bundle.getString("PURPOSE");
      //  Toast.makeText(this, "Data"+Name+"\n"+RegNo+" \n"+Purpose, Toast.LENGTH_LONG).show();

        String combinedText = Name + "\n" + RegNo + "\n" +Purpose;  // Combine the fields


        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BitMatrix bitMatrix = multiFormatWriter.encode(combinedText, BarcodeFormat.QR_CODE, 700, 700);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
            imageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}