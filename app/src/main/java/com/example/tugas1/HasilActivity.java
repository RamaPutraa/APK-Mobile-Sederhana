package com.example.tugas1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hasil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ambil data yang dikirim dari DetailActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            double rataRata = extras.getDouble("RATA_RATA");
            String nilaiHuruf = extras.getString("NILAI_HURUF");

            // Temukan TextView untuk menampilkan hasil
            TextView tvRataRata = findViewById(R.id.tvRataRata);
            TextView tvNilaiHuruf = findViewById(R.id.tvNilaiHuruf);

            // Tampilkan hasil nilai rata-rata dan nilai huruf di TextView
            tvRataRata.setText("Nilai Rata-Rata Anda: " + rataRata);
            tvNilaiHuruf.setText("Nilai Huruf Anda: " + nilaiHuruf);
        }
    }
}
