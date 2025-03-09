package com.example.dekiemtra;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
TextView textViewTen;
TextView textViewSoDien;
TextView textViewLoaiHinh;
Button buttonQuayLai;
Double tienDien=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        Intent intent = getIntent();
        String ten = intent.getStringExtra("ten");
        String soDien = intent.getStringExtra("soDien");
        String loaiHinh = intent.getStringExtra("loaiHinh");
        textViewTen.setText(ten);
        textViewSoDien.setText(soDien);
        textViewLoaiHinh.setText(loaiHinh);
//        int intSoDien= Integer.parseInt(soDien);
        Double intSoDien= Double.parseDouble(soDien);

        buttonQuayLai.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);
            if(loaiHinh.equalsIgnoreCase("KinhDoanh")){
                if(intSoDien<50){
                     tienDien = intSoDien * 800.0+(intSoDien * 800.0)*0.1 ;
                }else if(intSoDien>=50 && intSoDien<=100){
                     tienDien = intSoDien * 1200.0+(intSoDien * 1200.0)*0.1 ;

                }else{
                     tienDien = intSoDien * 1500.0+(intSoDien * 1500.0)*0.1 ;

                }
            }else{
                if(intSoDien<50){
                    tienDien = intSoDien * 800.0 ;
                }else if(intSoDien>=50 && intSoDien<=100){
                    tienDien = intSoDien * 1200.0 ;

                }else{
                    tienDien = intSoDien * 1500.0;

                }
            }
            intent1.putExtra("tienDien", tienDien);
            setResult(RESULT_OK,intent1);
            finish();
        });

    }
    public void init(){
        textViewTen = findViewById(R.id.textViewTen);
        textViewSoDien = findViewById(R.id.textViewSoDien);
        textViewLoaiHinh = findViewById(R.id.textViewLoaiHinh);
        buttonQuayLai = findViewById(R.id.buttonQuayLai);

    }
}