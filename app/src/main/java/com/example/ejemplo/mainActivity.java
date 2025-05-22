package com.example.ejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class mainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Asegúrate de que el layout se llama así

        // Mostrar pantalla de carga por 3 segundos antes de ir a LoginActivity
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(mainActivity.this, pantallaLogin.class);
            startActivity(intent);
            finish(); // Cierra esta actividad para que no vuelva al presionar "atrás"
        }, 3000); // 3000 ms = 3 segundos
    }
}
