package com.example.pspottake7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.Manifest;
import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.checkerframework.checker.i18nformatter.qual.I18nFormat;

public class DashboardPage extends AppCompatActivity {

    ImageView imageView;
    TextView scanResultsTV;
    Button scanButton;
    TextView textViewbook;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    DrawerLayout drawerLayout;





    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initQRCodeScanner();
            } else {
                Toast.makeText(this, "Camera permission is required", Toast.LENGTH_SHORT).show();
                finish();
            }
        }

    }

    @Override
    protected  void  onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Scan cancelled", Toast.LENGTH_SHORT).show();
            }else {
                scanResultsTV.setText("Scanned:" + result.getContents());
            }
         }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    private void initQRCodeScanner(){
        IntentIntegrator integrator = new IntentIntegrator(DashboardPage.this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setOrientationLocked(false);
        integrator.setPrompt("Scan a QR code");
        integrator.initiateScan();

    }

    private static final int PERMISSION_REQUEST_CAMERA = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_page);

        drawerLayout = findViewById(R.id.drawer_layout);

        imageView = findViewById(R.id.logout_image);
        imageView1 = findViewById(R.id.slot1);
        imageView2 = findViewById(R.id.slot2);
        imageView3 = findViewById(R.id.slot3);
        imageView4 = findViewById(R.id.slot4);
        imageView5 = findViewById(R.id.slot5);
        imageView6 = findViewById(R.id.slot6);
        textViewbook = findViewById(R.id.bookslot);
        scanButton = findViewById(R.id.scan_button);
        scanResultsTV = findViewById(R.id.textView11);

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(DashboardPage.this, new String[]{Manifest.permission.CAMERA},PERMISSION_REQUEST_CAMERA);
                    }else {
                        initQRCodeScanner();
                    }
                }else {
                    initQRCodeScanner();
                }
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardPage.this, LoginPage.class);
                startActivity(i);
                finish();
                Toast.makeText(DashboardPage.this, "Logout Successful", Toast.LENGTH_SHORT).show();
            }
        });
        textViewbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardPage.this, BookingPage.class);
                startActivity(i);
                finish();


            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardPage.this, BookingPage.class);
                startActivity(i);
                finish();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardPage.this, BookingPage.class);
                startActivity(i);
                finish();
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardPage.this, BookingPage.class);
                startActivity(i);
                finish();
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardPage.this, BookingPage.class);
                startActivity(i);
                finish();
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardPage.this, BookingPage.class);
                startActivity(i);
                finish();
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardPage.this, BookingPage.class);
                startActivity(i);
                finish();
            }
        });
    }
}