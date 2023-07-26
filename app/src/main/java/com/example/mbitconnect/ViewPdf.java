package com.example.mbitconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import Connect.Website;

public class ViewPdf extends AppCompatActivity {
    WebView webView;
   // PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

       webView=(WebView) findViewById(R.id.viewpdf);
       // pdfView=(PDFView) findViewById(R.id.pdfView);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        webView.getSettings().setSupportMultipleWindows(true);



        String filename=getIntent().getStringExtra("filename");
        String fileurl=getIntent().getStringExtra("fileurl");
        ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle(filename);
        dialog.setCancelable(false);
        dialog.setMessage("Opening...");
        dialog.show();

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(ViewPdf.this, "Error: "+description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                dialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                dialog.dismiss();
            }
        });

        String url="";
        try{
            url=URLEncoder.encode(fileurl,"UTF-8");

        }catch (Exception e)
        {

        }
       webView.loadUrl("http://docs.google.com/gview?embedded=true&url="+url);
//       pdfView.fromAsset(url)
//               .defaultPage(0)
//               .scrollHandle(new DefaultScrollHandle(this))
//               .spacing(10)
//               .load();
//        dialog.dismiss();
    }
}