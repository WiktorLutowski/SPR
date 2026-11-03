package com.example.wiktor_lutowski_intencja;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText imieEdit;
    private EditText nazwiskoEdit;
    private NumberPicker wiekPicker;
    private CheckBox kobietaCheck;
    private Button dalejButton;

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

        imieEdit = findViewById(R.id.imieEdit);
        nazwiskoEdit = findViewById(R.id.nazwiskoEdit);
        wiekPicker = findViewById(R.id.wiekPicker);
        kobietaCheck = findViewById(R.id.kobietaCheck);
        dalejButton = findViewById(R.id.dalejButton);

        wiekPicker.setMinValue(1);
        wiekPicker.setMaxValue(100);

        dalejButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Summary.class);

                intent.putExtra("imie", imieEdit.getText().toString());
                intent.putExtra("nazwisko", nazwiskoEdit.getText().toString());
                intent.putExtra("wiek", wiekPicker.getValue());
                intent.putExtra("czyKobieta", kobietaCheck.isChecked());

                startActivity(intent);
            }
        });


    }
}