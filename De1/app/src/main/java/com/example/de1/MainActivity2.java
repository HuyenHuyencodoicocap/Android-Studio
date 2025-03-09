package com.example.de1;

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
    TextView textView5Ten;
    TextView textView6NamSinh;
    TextView textView7GioiTinh;
    TextView textView8QuocTich;
    Button buttonBack;

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
        Intent intentView= getIntent();
        String ten = intentView.getStringExtra("ten");
        int namSinh = intentView.getIntExtra("namSinh", 0);
        String gioiTinh = intentView.getStringExtra("gioiTinh");
        String quocTich = intentView.getStringExtra("quocTich");
        textView5Ten.setText(ten);
        textView6NamSinh.setText(String.valueOf(namSinh));
        textView7GioiTinh.setText(gioiTinh);
        textView8QuocTich.setText(quocTich);
        buttonBack.setOnClickListener(view -> {
            finish();
        });

    }
    public void init(){
        textView5Ten = findViewById(R.id.textView5);
        textView6NamSinh = findViewById(R.id.textView6);
        textView7GioiTinh = findViewById(R.id.textView7);
        textView8QuocTich = findViewById(R.id.textView8);
        buttonBack = findViewById(R.id.buttonBack);


    }
}