package com.example.de2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewTen;
    TextView textViewSanPham;
    TextView textViewGiamGia;
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
        Intent intent = getIntent();
        String tenKhachHang = intent.getStringExtra("tenKhachHang");
        String sanPham = intent.getStringExtra("sanPham");
        String giamGia = intent.getStringExtra("giamGia");
        textViewTen.setText(tenKhachHang);
        textViewSanPham.setText(sanPham);
        textViewGiamGia.setText(giamGia);
        buttonBack.setOnClickListener(view -> {
            Intent intent1= new Intent(MainActivity2.this,MainActivity.class);
            intent1.putExtra("tenKhachHang",tenKhachHang);
            intent1.putExtra("sanPham",sanPham);
            intent1.putExtra("giamGia",giamGia);
            setResult(RESULT_OK,intent1);
            finish();
        });

    }



    public void init(){
        textViewTen = findViewById(R.id.textViewTen);
        textViewSanPham = findViewById(R.id.textViewSanPham);
        textViewGiamGia = findViewById(R.id.textViewGiamGia);
        buttonBack = findViewById(R.id.buttonBack);

    }
}