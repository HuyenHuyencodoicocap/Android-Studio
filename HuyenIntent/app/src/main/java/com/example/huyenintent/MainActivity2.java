package com.example.huyenintent;

import static com.example.huyenintent.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button buttonback,cal;
    TextView textView,textView2,s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main2);
        buttonback=(Button) findViewById(R.id.buttonback);
        cal=(Button) findViewById(id.buttontinh);
        textView=(TextView) findViewById(R.id.textView2);
        textView2=(TextView) findViewById(R.id.textView);
        s1=(TextView) findViewById(R.id.textView3);
        s2=(TextView) findViewById(R.id.textView4);


        Intent intent1=getIntent();
        String ht=intent1.getStringExtra("hoten");
        int ns =intent1.getIntExtra("namsinh",0);
        int ss1 =intent1.getIntExtra("so1",0);
        int ss2 =intent1.getIntExtra("so2",0);
        int tong =ss1+ss2;
        textView.setText("xin chao "+ht);
        textView2.setText("namsinh "+ns);
        s1.setText("số thứ nhất "+ss1);
        s2.setText("số thứ hai"+ss2);

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity2.this,MainActivity.class);

                startActivity(intent);
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2= new Intent(MainActivity2.this,MainActivity.class);
                intent2.putExtra("tong",tong);
                startActivity(intent2);
            }
        });
    }
}