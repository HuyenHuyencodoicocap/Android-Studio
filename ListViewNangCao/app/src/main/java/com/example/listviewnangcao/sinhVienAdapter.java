package com.example.listviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class sinhVienAdapter extends ArrayAdapter<SinhVien> {
    public sinhVienAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v= convertView;
        if(v==null){
            LayoutInflater vi= LayoutInflater.from(getContext());
            v=vi.inflate(R.layout.sinhvien,null);

        }
        SinhVien sv= getItem(position);
        if(sv!=null){
            TextView tv1= (TextView)v.findViewById(R.id.editName);
            TextView namsinh= (TextView)v.findViewById(R.id.editNamSinh);
            tv1.setText(sv.hoTen);
            namsinh.setText(String.valueOf(sv.namSinh));

        }
    return v;
    }

    public sinhVienAdapter(@NonNull Context context, int resource, @NonNull List<SinhVien> objects) {
        super(context, resource, objects);
    }
}
