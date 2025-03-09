package com.example.dekiemtra;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextTen;
    EditText editTextSoDien;
    EditText editTextTienDien;
    CheckBox checkBoxKinhDoanh;
    CheckBox checkBoxGiaDinh;
    Button buttonGui;


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
        buttonGui.setOnClickListener(view -> {
            Intent intent= new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("ten", editTextTen.getText().toString());
            intent.putExtra("soDien", editTextSoDien.getText().toString());
//            intent.putExtra("tienDien", editTextTienDien.getText().toString());
            if(checkBoxKinhDoanh.isChecked()){
                intent.putExtra("loaiHinh", "Kinh doanh");
            }else{
                intent.putExtra("loaiHinh", "Gia đình");
            }
            startActivityForResult(intent,101);

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = getIntent();
        if(requestCode==101 && resultCode==RESULT_OK){
            Double tienDien = data.getDoubleExtra("tienDien", 0.0);
            String textTienDien=tienDien.toString();
            intent.putExtra("ienDien", textTienDien);
            Toast.makeText(this, "Tiền điện: "+textTienDien, Toast.LENGTH_SHORT).show();
        }

    }

    public void init(){
        editTextTen = findViewById(R.id.editTextTen);
        editTextSoDien = findViewById(R.id.editTextSoDien);
        editTextTienDien = findViewById(R.id.editTextTienDien);
        checkBoxKinhDoanh = findViewById(R.id.checlBoxKinhDoanh);
        checkBoxGiaDinh = findViewById(R.id.checkBoxGiaDinh);
        buttonGui = findViewById(R.id.buttonGui);


    }
}