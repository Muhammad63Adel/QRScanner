package com.example.qrreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

    public class MainActivity extends AppCompatActivity {
        Button CreatBT ;
        Button ReadBT ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreatBT = findViewById(R.id.createBT);
        ReadBT = findViewById(R.id.ReadBT);



    }

        public void Creat(View view) {
            Intent i = new Intent(this,creat.class);
            startActivity(i);

        }

        public void Read(View view) {
            Intent i = new Intent(this,ReadQR.class);
            startActivity(i);
        }
    }
