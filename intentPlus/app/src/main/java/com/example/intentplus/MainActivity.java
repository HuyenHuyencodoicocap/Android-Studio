package com.example.intentplus;

import android.app.Activity;
import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextSoA;
    EditText editTextSoB;
    Button submit;
//    ActivityResultLauncher launcher= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
//        if(result.getResultCode()== 33){
//            int Tong= dat
//            Toast.makeText(this,)
//        }
//    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
//        Intent intentNS= getIntent();
//        String ns=intentNS.getStringExtra("NS");
//        editTextNS.setText(ns);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soA = Integer.parseInt(editTextSoA.getText().toString());
                int soB = Integer.parseInt(editTextSoB.getText().toString());

//                Bundle bundle= new Bundle();
//                bundle.putString("HoTen",ht);
//                bundle.putInt("Ns",ns);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                intent.putExtra("myBundle",bundle);
                intent.putExtra("SoA", soA);
                intent.putExtra("SoB", soB);

                startActivityForResult(intent, 99);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
        super.onActivityResult(requestCode, resultCode, data, caller);
        if (requestCode == 99 && resultCode == 33) {
            int tong = data.getIntExtra("Tong", 0);
            Toast.makeText(this,tong,Toast.LENGTH_SHORT).show();
        }

    }

    public void init () {
        editTextSoA = findViewById(R.id.editTextName);
        editTextSoB = findViewById(R.id.editTextNS);
        submit = findViewById(R.id.buttonSubmit);
    }
}