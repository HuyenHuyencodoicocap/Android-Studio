package com.example.de1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextTen;
    EditText editTextNamSinh;
    RadioButton radioButtonNam;
    RadioButton radioButtonNu;
    Spinner spinnerQuocTich;
    Button button;
    int getPosition;

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
        ArrayList<String> listQuocTich= new ArrayList<>();
        listQuocTich.add("Việt Nam");
        listQuocTich.add("Mỹ");
        listQuocTich.add("Anh");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listQuocTich);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuocTich.setAdapter(adapter);
//        spinnerQuocTich.setOnItemClickListener( (adapterView, view, i, l) -> {
//            getPosition = i;
//            String quocTich = adapterView.getItemAtPosition(i).toString();
//            Toast.makeText(this, quocTich, Toast.LENGTH_SHORT).show();
//        });
        button.setOnClickListener(view -> {
            String ten = editTextTen.getText().toString();
            int namSinh = Integer.parseInt(editTextNamSinh.getText().toString());
            String quocTich = spinnerQuocTich.getSelectedItem().toString();

            if(quocTich.equals("Việt Nam") && namSinh>1999){
                Toast.makeText(this, "Duyệt", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("ten", ten);
                intent.putExtra("namSinh", namSinh);
                intent.putExtra("gioiTinh", radioButtonNam.isChecked() ? "Nam" : "Nữ");
                intent.putExtra("quocTich", quocTich);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Không Duyệt", Toast.LENGTH_SHORT).show();
            }

        });

    }
    public void init(){
        editTextTen = findViewById(R.id.editTextTen);
        editTextNamSinh = findViewById(R.id.editTextNamSinh);
        radioButtonNam = findViewById(R.id.radioButtonNam);
        radioButtonNu = findViewById(R.id.radioButtonNu);
        spinnerQuocTich = findViewById(R.id.spinnerQuocTich);
        button = findViewById(R.id.button);


    }
}