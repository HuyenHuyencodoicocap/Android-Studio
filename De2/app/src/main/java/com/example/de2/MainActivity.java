package com.example.de2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextKhachHang;
    ListView listViewSanPham;
    CheckBox checkBoxGiamGia;
    Button buttonGui;
    String selectedItem="";



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
        ArrayList<String> listSP= new ArrayList<>();
        listSP.add("Hoa hồng");
        listSP.add("Hoa lan");
        listSP.add("Hoa đào");
        listSP.add("Tuyết mai");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listSP);
        listViewSanPham.setAdapter(adapter);
        listViewSanPham.setOnItemClickListener((adapterView, view, i, l) -> {
            selectedItem = (String) adapterView.getItemAtPosition(i);
        });
        buttonGui.setOnClickListener(view -> {
            String giamGia="";
            if(checkBoxGiamGia.isChecked()){
                giamGia="Có";
            }
            else {
                giamGia="Không";
            }
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("tenKhachHang",editTextKhachHang.getText().toString());
            intent.putExtra("sanPham",selectedItem);
            intent.putExtra("giamGia",giamGia);
            startActivityForResult(intent,101);


        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==101 && resultCode==RESULT_OK){


            String giamGia = data.getStringExtra("giamGia");
            if(giamGia.equals("Có")){
                Toast.makeText(this,"Đã giảm giá",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Chưa giảm giá",Toast.LENGTH_SHORT).show();
            }


        }
    }
    public void init(){
        editTextKhachHang = findViewById(R.id.editTextKhachHang);
        listViewSanPham = findViewById(R.id.listViewSanPham);
        checkBoxGiamGia = findViewById(R.id.checkBoxGiamGia);
        buttonGui = findViewById(R.id.buttonGui);

    }
}