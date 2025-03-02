package com.example.buoi4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText editTextName;
    RadioButton radioButtonNam;
    RadioButton radioButtonNu;
    CheckBox checkBoxTheThao;
    CheckBox checkBoxDuLich;
    CheckBox checkBoxLuHanh;
    String hoten="";
    String gioitinh="Giới tính: ";
    String SoThich="";

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

        btnSubmit.setOnClickListener(View->{
            String name = editTextName.getText().toString();
            if(radioButtonNam.isChecked()==true) {
                gioitinh +=  radioButtonNam.getText().toString() ;
            }
            else if(radioButtonNu.isChecked()==true) {
                gioitinh+= radioButtonNu.getText().toString();
            }
            if(checkBoxTheThao.isChecked()==true) {
                SoThich+=checkBoxTheThao.getText().toString()+", ";
            }
            if(checkBoxDuLich.isChecked()==true) {
                SoThich+=checkBoxDuLich.getText().toString()+", ";
            }
            if(checkBoxLuHanh.isChecked()==true) {
                SoThich+=checkBoxLuHanh.getText().toString()+", ";
            }


        });
        String thongtin = hoten+gioitinh+SoThich;
        editTextName.setText(thongtin);
    }
    void init(){
        Button btnSubmit = findViewById(R.id.btnSubmit);
        EditText editTextName = findViewById(R.id.editTextName);
        RadioButton radioButtonNam = findViewById(R.id.radioButtonNam);
        RadioButton radioButtonNu = findViewById(R.id.radioButtonNu);
        CheckBox checkBoxTheThao = findViewById(R.id.checkBoxTheThao);
        CheckBox checkBoxDuLich = findViewById(R.id.checkBoxDuLich);
        CheckBox checkBoxLuHanh = findViewById(R.id.checkBoxLuHanh);

    }
}