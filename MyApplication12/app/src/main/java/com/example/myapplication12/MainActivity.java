package com.example.myapplication12;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
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

        final String[] kyTu= new String[]{
                "A","B","C","D","E","F","G","A","B","C",
                "D","E","F","G","A","B","C","D","E","F",
                "G","A","B","C","D","E","F","G"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,kyTu);
        gridView.setNumColumns(3);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this,kyTu[position],Toast.LENGTH_SHORT).show();

        });

    }
    public void init(){
        gridView = (GridView) findViewById(R.id.GridView);
    }
}


