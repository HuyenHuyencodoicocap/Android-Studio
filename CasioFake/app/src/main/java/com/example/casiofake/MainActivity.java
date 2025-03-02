package com.example.casiofake;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String txtCurrentInput = "";
    String firstInput = "";
    EditText viewInput;
    TextView viewResult;
    Double result = 0.0;
    String operator = "";

    int[] buttonList = {
            R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4, R.id.btnNum5,
            R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9, R.id.btnComma,
            R.id.btnPlus, R.id.btnMinus, R.id.btnMul, R.id.btnDiv,
            R.id.btnEqual, R.id.btnAC, R.id.btnX, R.id.btnPercent,R.id.btnAmDuong
    };

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

    private void init() {
        viewInput = findViewById(R.id.txtInputCaculation);
        viewInput.setText(firstInput + operator + txtCurrentInput);
        viewResult = findViewById(R.id.resultEqual);
        for (int id : buttonList) {
            findViewById(id).setOnClickListener(v -> {
                Button button = (Button) v;
                String input = button.getText().toString();
                handleButtonInput(input);
            });
        }
    }


    public void handleButtonInput(String input) {
        switch (input) {
            case "AC":
                firstInput = "";
                txtCurrentInput = "";
                result = 0.0;
                operator = "";
                viewInput.setText("");
                viewResult.setText("");
                break;
            case "Delete":
                if (!txtCurrentInput.isEmpty()) {
                    txtCurrentInput = txtCurrentInput.substring(0, txtCurrentInput.length() - 1);
                }
                break;
            case "+/_":
                Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
                if (!txtCurrentInput.isEmpty()) {
                    Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
                    Double value = Double.parseDouble(txtCurrentInput) ;
                    value *= -1;
                    viewInput.setText(String.valueOf(value));
                    viewResult.setText(String.valueOf(value));
                    txtCurrentInput = String.valueOf(value);
                }
                break;

            case "%":
                if (!txtCurrentInput.isEmpty()) {
                    double value = Double.parseDouble(txtCurrentInput) / 100;
                    viewResult.setText(String.valueOf(value));
                    txtCurrentInput = String.valueOf(value);
                }
                break;

            case ",":
                txtCurrentInput = txtCurrentInput.replace(",", ".");
                if (!txtCurrentInput.contains(".")) {
                    txtCurrentInput += ".";
                    viewResult.setText(txtCurrentInput);
                }
                break;

            case "=":
                submit();
                break;
            case "+":
            case "-":
            case "x":
            case "/":
                submit();
                if (!txtCurrentInput.isEmpty()) {
                    firstInput = txtCurrentInput;
                    operator = input;
                    txtCurrentInput = "";
                }
                break;

            default:
                txtCurrentInput += input;
                break;
        }
        viewInput.setText(firstInput + operator + txtCurrentInput);
    }
    void submit(){
        if (!txtCurrentInput.isEmpty() && !firstInput.isEmpty()) {
            switch (operator) {
                case "+":
                    result = Double.parseDouble(firstInput) + Double.parseDouble(txtCurrentInput);
                    viewResult.setText(String.valueOf(result));
                    break;
                case "-":
                    result = Double.parseDouble(firstInput) - Double.parseDouble(txtCurrentInput);
                    viewResult.setText(String.valueOf(result));
                    break;
                case "x":
                    result = Double.parseDouble(firstInput) * Double.parseDouble(txtCurrentInput);
                    viewResult.setText(String.valueOf(result));
                    break;

            }
            if (operator.equals("/")){
                if (!txtCurrentInput.equals("0")) {
                    result = Double.parseDouble(firstInput) / Double.parseDouble(txtCurrentInput);
                    viewResult.setText(String.valueOf(result));
                    txtCurrentInput = String.valueOf(result);
                    firstInput = "";
                    operator = "";
                } else {
                    Toast.makeText(this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                    viewInput.setText(firstInput+ operator+ txtCurrentInput);
                }
            }else{
                txtCurrentInput = String.valueOf(result);
                firstInput = "";
                operator = "";
            }
        }
    }

}
