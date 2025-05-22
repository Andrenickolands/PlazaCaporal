package com.example.ejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class pantallaLogin extends AppCompatActivity {

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        //boton redirige a la pagina de pedidos
        loginButton = findViewById(R.id.loginButton); // Asegúrate de que el ID del botón en tu XML sea "loginButton"
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(pantallaLogin.this, pantallaMarket.class);
            startActivity(intent);
            finish();
        });
    }
}