package com.example.wiktor_lutowski_intencja;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Summary extends AppCompatActivity {

    private TextView nazwaText;
    private TextView wiekText;
    private TextView plecText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.summary), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nazwaText = findViewById(R.id.nazwaText);
        wiekText = findViewById(R.id.wiekText);
        plecText = findViewById(R.id.plecText);

        String imie = getIntent().getStringExtra("imie");
        String nazwisko = getIntent().getStringExtra("nazwisko");
        int wiek = getIntent().getIntExtra("wiek", 1);
        boolean czyKobieta = getIntent().getBooleanExtra("czyKobieta", false);

        nazwaText.setText(imie + " " + nazwisko);
        wiekText.setText(wiek + " lat");

        if(czyKobieta)
            plecText.setText("Kobieta");
        else
            plecText.setText("Mężczyzna");
    }
}