package com.example.csbanking;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity
{
    EditText name,amount,email,surl;
    Button send,Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name=(EditText)findViewById(R.id.txtName);
        email=(EditText)findViewById(R.id.txtEmail);
        amount=(EditText)findViewById(R.id.txtAmount);
        surl=(EditText)findViewById(R.id.txtImageUrl);

        Clear=(Button)findViewById(R.id.btnClear);
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        send = (Button)findViewById(R.id.btnSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert();
            }
        });
    }

    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("Name",name.getText().toString());
        map.put("Amount",amount.getText().toString());
        map.put("Email",email.getText().toString());
        map.put("Surl",surl.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("students").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        name.setText("");
                        amount.setText("");
                        email.setText("");
                        surl.setText("");
                        Toast.makeText(getApplicationContext(),"Sent Successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Could not send",Toast.LENGTH_LONG).show();
                    }
                });

    }
    public void clear()
    {
        name.setText("");
        amount.setText("");
        email.setText("");
        surl.setText("");
    }
}