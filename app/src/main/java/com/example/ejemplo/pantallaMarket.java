package com.example.ejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class pantallaMarket extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        ImageButton btnProduct0 = findViewById(R.id.btnProduct0);

        //boton redirige a la pagina de pedidos
        btnProduct0.setOnClickListener(v -> {
            Intent intent = new Intent(pantallaMarket.this, pantallaProducto.class);
            startActivity(intent);
        });
    }
}
