package com.example.tugas1;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Ambil referensi ke semua EditText
        EditText editTextBahasaIndonesia = findViewById(R.id.editTextBahasaIndonesia);
        EditText editTextBahasaInggris = findViewById(R.id.editTextBahasaInggris);
        EditText editTextSeniBudaya = findViewById(R.id.editTextSeniBudaya);
        EditText editTextMatematika = findViewById(R.id.editTextMatematika);
        EditText editTextIPS = findViewById(R.id.editTextIPS);
        EditText editTextIPA = findViewById(R.id.editTextIPA);

        // Ambil referensi ke tombol submit
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nilai dari setiap EditText
                double nilaiBahasaIndonesia = Double.parseDouble(editTextBahasaIndonesia.getText().toString());
                double nilaiBahasaInggris = Double.parseDouble(editTextBahasaInggris.getText().toString());
                double nilaiSeniBudaya = Double.parseDouble(editTextSeniBudaya.getText().toString());
                double nilaiMatematika = Double.parseDouble(editTextMatematika.getText().toString());
                double nilaiIPS = Double.parseDouble(editTextIPS.getText().toString());
                double nilaiIPA = Double.parseDouble(editTextIPA.getText().toString());

                // Hitung nilai rata-rata
                double rataRata = (nilaiBahasaIndonesia + nilaiBahasaInggris + nilaiSeniBudaya + nilaiMatematika + nilaiIPS + nilaiIPA) / 6;

                // Tentukan nilai huruf berdasarkan nilai rata-rata
                String nilaiHuruf;
                if (rataRata > 80) {
                    nilaiHuruf = "A";
                } else if (rataRata > 60) {
                    nilaiHuruf = "B";
                } else if (rataRata > 30) {
                    nilaiHuruf = "C";
                } else {
                    nilaiHuruf = "D";
                }

                // Buat Intent untuk berpindah ke HasilActivity dan sertakan data nilai
                Intent intent = new Intent(DetailActivity.this, HasilActivity.class);
                intent.putExtra("RATA_RATA", rataRata);
                intent.putExtra("NILAI_HURUF", nilaiHuruf);
                startActivity(intent);
            }
        });

    }
}