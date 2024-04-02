package com.example.pspottake7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;



public class BookingPage extends AppCompatActivity {

    Button button;
    Button backbtn;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText slotnumber;
    private EditText name;
    private EditText starttime;
    private EditText endtime;
    private EditText date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_page);

        button=findViewById(R.id.button);
        slotnumber=findViewById(R.id.slotnumber);
        name=findViewById(R.id.editTextText2);
        starttime=findViewById(R.id.editTextTime);
        endtime=findViewById(R.id.editTextTime2);
        date=findViewById(R.id.editTextDate);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sslotnumber = slotnumber.getText().toString();
                String sname = name.getText().toString();
                String sstarttime = starttime.getText().toString();
                String sendtime = endtime.getText().toString();
                String sdate = date.getText().toString();
                Log.d("BookingPage", "Booking : " + sslotnumber);

                Map<String, Object> booking = new HashMap<>();
                booking.put("Slot_number", sslotnumber);
                booking.put("name", sname );
                booking.put("starttime", sstarttime );
                booking.put("endtime", sendtime );
                booking.put("date", sdate );

                db.collection("booking_list").add(booking)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("BookingPage", "Booking successfull: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("BookingPage", "Error while booking");
                            }
                        });

                Intent i = new Intent(BookingPage.this, BookingSuccessfullPage.class);
                startActivity(i);
                finish();
            }
        });



    }
}