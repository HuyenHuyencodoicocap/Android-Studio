package com.example.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewMonHoc;
    ArrayList<String> listMonHoc = new ArrayList<>();
    EditText editTextName;
    RadioButton radioButtonNam;
    RadioButton radioButtonNu;
    CheckBox checkBoxDuLich;
    CheckBox checkBoxTheThao;
    CheckBox checkBoxLuHanh;
    Button btnSubmit;
    TextView ViewInfornation;
    Spinner spinnerQuocTich;
    ArrayList<String> listQuocTich = new ArrayList<>();
    String ten, gioiTinh,SoThich,MonHoc,QuocTich;
    EditText editMonHoc;
    Button btnUpdate;
    Button btnAdd;
    int index;
    Button btnDelete;
    ArrayAdapter adapter;

    private void xacNhanXoa(int index){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Bạn có muốn xóa môn học này không?");
        alertDialog.setTitle("Thông báo");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setPositiveButton("Có", (dialog, which) -> {
            listMonHoc.remove(index);
            adapter.notifyDataSetChanged();
        });
        alertDialog.setNegativeButton("Không", (dialog, which) -> {
            dialog.dismiss();
        });


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.MainActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();


        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listMonHoc);
        listViewMonHoc.setAdapter(adapter);
        listViewMonHoc.setOnItemClickListener((parent, view, position, id) -> {
            MonHoc = listMonHoc.get(position).toString();
            Toast.makeText(this,MonHoc,Toast.LENGTH_SHORT).show();
            editMonHoc.setText(MonHoc);
            index=position;


        });


        btnSubmit.setOnClickListener(v -> {

            ten=editTextName.getText().toString();

            if(radioButtonNam.isChecked()){
                gioiTinh=radioButtonNam.getText().toString();
            }else
                gioiTinh=radioButtonNu.getText().toString();
            if(checkBoxDuLich.isChecked()==true){
                SoThich+=checkBoxDuLich.getText().toString();
            }
            if(checkBoxTheThao.isChecked()==true){
                SoThich+=checkBoxTheThao.getText().toString();
            }
            if(checkBoxLuHanh.isChecked()==true){
                SoThich+=checkBoxLuHanh.getText().toString();
            }
            String thongTin= ten+" "+gioiTinh+ " "+SoThich+" "+MonHoc +" "+QuocTich;

            ViewInfornation.setText(thongTin);
            thongTin="";

        });

        btnAdd.setOnClickListener(v -> {
            String mh=editMonHoc.getText().toString();
            if(listMonHoc.contains(mh)){
                Toast.makeText(this,"Môn học đã tồn tại",Toast.LENGTH_SHORT).show();
                return;
            }else{
                listMonHoc.add(mh);
                adapter.notifyDataSetChanged();
            }


        });
        btnUpdate.setOnClickListener(v -> {
            String updateMonHoc=editMonHoc.getText().toString();
            if(listMonHoc.contains(updateMonHoc)){
                Toast.makeText(this,"Môn học đã tồn tại",Toast.LENGTH_SHORT).show();
                return;
            }else{
                int position=index;
                listMonHoc.set(index,updateMonHoc);
                adapter.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(v -> {
            int i=index;
            String mh=listMonHoc.get(i);
            editMonHoc.setText(mh);
            listMonHoc.remove(i);
            editMonHoc.setText("");
            Toast.makeText(this,"Xóa thành công môn học "+ mh,Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();

        });

        listViewMonHoc.setOnItemLongClickListener((parent, view, position, id) -> {

            xacNhanXoa(position);
                    return false;
                }

        );

    }

    void init(){
        ViewInfornation = findViewById(R.id.ViewInfornation);
        editTextName = findViewById(R.id.editTextName);
        radioButtonNam = findViewById(R.id.radioButtonNam);
        radioButtonNu = findViewById(R.id.radioButtonNu);
        checkBoxDuLich = findViewById(R.id.checkBoxDuLich);
        checkBoxTheThao = findViewById(R.id.checkBoxTheThao);
        checkBoxLuHanh = findViewById(R.id.checkBoxLuHanh);
        btnSubmit = findViewById(R.id.btnSubmit);
        listViewMonHoc = findViewById(R.id.listViewMonHoc);
        listMonHoc.add("Java");
        listMonHoc.add("game Programing");
        listMonHoc.add("Thuật Toán");
        listMonHoc.add("android studio");
        listMonHoc.add("AI");

        ViewInfornation.setText("");
        radioButtonNam.setChecked(false);
        radioButtonNu.setChecked(false);
        checkBoxDuLich.setChecked(false);
        checkBoxTheThao.setChecked(false);
        checkBoxLuHanh.setChecked(false);

        editMonHoc = findViewById(R.id.editMonHoc);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete=findViewById(R.id.btnDelete);




    }
}