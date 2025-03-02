package com.example.intentplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    Button send;
    String checkTen;
    String ns;

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
        Intent intentTong= getIntent();
        int soA= intentTong.getIntExtra("SoA",0);
        int soB= intentTong.getIntExtra("SoB",0);
        int tong= soA+soB;

//        intentTong.getExtra("SoA",)
//        Intent intentBundle= getIntent();
//        Bundle bundle= intentBundle.getBundleExtra("myBundle");
//        checkTen= bundle.getString("HoTen");
//        ns= bundle.getInt("Ns")+" ";
//        tv1.setText("Họ tên: "+checkTen);
//        tv2.setText(ns);
//        ArrayList<sinhVien> listSv = new ArrayList<>();
//        listSv.add(new sinhVien("Nguyen Van A", 2000));
//        listSv.add(new sinhVien("Nguyen Van B", 2001));
//        listSv.add(new sinhVien("Nguyen Van C", 2002));
//        Intent intent2 = getIntent();
//        String sv= intent2.getStringExtra("HoTen");
//         checkTen= sv;

//        for (int i = 0; i < listSv.size(); i++) {
//            if (checkTen.equalsIgnoreCase(listSv.get(i).getHoTen())) {
//                ns= listSv.get(i).getNs()+" ";
//                break;
//            }else{
//                ns="Khong co sinh vien nay";
//            }
//
//        }

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("Tong",tong);
                setResult(33,intent);
                finish();

//                startActivity(intent);

            }
        });
    }


    public void init() {
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        send = findViewById(R.id.button);

    }
}