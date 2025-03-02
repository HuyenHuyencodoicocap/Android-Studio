package com.example.listviewnangcao;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewSV;
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



    }


    public void init(){
        listViewSV= (ListView) findViewById(R.id.listViewSV);
        ArrayList <SinhVien>arraySV=new ArrayList<SinhVien>();
        arraySV.add(new SinhVien("Huyen",2004));
        arraySV.add(new SinhVien("Thuong",2002));
        sinhVienAdapter adapter= new sinhVienAdapter(MainActivity.this,R.layout.sinhvien,arraySV);
        listViewSV.setAdapter(adapter);
        listViewSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SinhVien sv= (SinhVien) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,arraySV.get(position).hoTen,Toast.LENGTH_LONG).show();
            }
        });
    }
}