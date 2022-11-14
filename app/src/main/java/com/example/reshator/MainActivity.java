package com.example.reshator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;

    private TextView textView_x1;
    private TextView textView_x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.edit_text_a);
        editTextB = findViewById(R.id.edit_text_b);
        editTextC = findViewById(R.id.edit_text_c);
        textView_x1 = findViewById(R.id.text_view_x1);
        textView_x2 = findViewById(R.id.text_view_x2);
    }

    private int GetValue(EditText editText){
        if (editText.getText().toString().isEmpty()){
            Toast.makeText(this,"Поля не могут быть пустыми!", Toast.LENGTH_SHORT).show();
        }
        return Integer.parseInt(editText.getText().toString());
    }
    private int get_discriminant(){
        int a = GetValue(editTextA);
        int b = GetValue(editTextB);
        int c = GetValue(editTextC);
        return b * b - 4 * a * c;
    }
    private void click(View view){
        int a = GetValue(editTextA);
        int b = GetValue(editTextB);
        if(editTextA.toString().equals("0")){
            Toast.makeText(this, "Деление на ноль невозможно!", Toast.LENGTH_SHORT).show();
        }
        if(get_discriminant() < 0){
            textView_x1.setText("Уравнение не имеет корней");
        }
        if (get_discriminant() == 0){
            double x =  (double) -b / 2 * a;
            textView_x1.setText(String.format("%.2f", x));
        }
        if (get_discriminant() > 0){
            double x1 = (-b - Math.sqrt(get_discriminant())) / 2 * a;
            double x2 = (-b + Math.sqrt(get_discriminant())) / 2 * a;
            textView_x1.setText(String.format("%.2f", x1));
            textView_x2.setText(String.format("%.2f", x2));
        }
    }
}