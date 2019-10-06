package com.example.qrreader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




public class ReadQR extends AppCompatActivity {
    final Activity activity = this;
    Button ReadBT;

    BottomSheetBehavior bottomSheetBehavior;
    TextView showTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_qr);


        View bottomSheet =findViewById(R.id.bottom_sheet_read);
        bottomSheetBehavior =BottomSheetBehavior.from(bottomSheet);


        showTextView = findViewById(R.id.show);
        ReadBT = findViewById(R.id.ReadBT);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i){
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Toast.makeText(creat.this, "The Image Saved Successfully", Toast.LENGTH_SHORT).show();
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        //Toast.makeText(creat.this, "The Image Is Ready To Save", Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode, data);
        if (result != null){
            if(result.getContents() == null){
                Toast.makeText(this, "you cancelled the scanning ",Toast.LENGTH_SHORT).show();

            }else{
                String str = result.getContents();
                showTextView.setText(str);
               //Toast.makeText(this, " the QR code contains : "+ "\n"+ str ,Toast.LENGTH_SHORT).show();
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    public void Read(View view) {
        showTextView.setText("");
        Scan();
    }


    public void Scan (){

        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("scan");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }
}
