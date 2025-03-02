package com.example.huyenintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonsend;
    EditText editText,editText2,s1,s2;
    TextView tonga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonsend =(Button) findViewById(R.id.buttonsend);
        editText=(EditText) findViewById(R.id.editTextText);
        editText2=(EditText) findViewById(R.id.editTextText2);
        s1=(EditText) findViewById(R.id.editTextText3);
        s2=(EditText) findViewById(R.id.editTextText4);
        tonga=(TextView) findViewById(R.id.textView5);

        Intent intent2 =getIntent();
        int tong =intent2.getIntExtra("tong",0);
        tonga.setText("kết quả"+tong);

        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                String ht =editText.getText().toString();
                Integer ns=Integer.parseInt(editText2.getText().toString());

                Integer so1=Integer.parseInt(s1.getText().toString());
                Integer so2=Integer.parseInt(s2.getText().toString());

                intent.putExtra("hoten",ht);
                intent.putExtra("namsinh",ns);
                intent.putExtra("so1",so1);
                intent.putExtra("so2",so2);
                startActivity(intent);
            }
        });

    }
}