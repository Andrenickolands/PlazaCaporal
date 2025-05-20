package com.example.ejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class pantallaHome  extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Asegúrate de que es el XML correcto

        drawerLayout = findViewById(R.id.drawer_layout);
        ImageButton menuButton = findViewById(R.id.menuButton);
        ImageButton nav_cart = findViewById(R.id.nav_cart);
        Button btnPedido = findViewById(R.id.btnPedido); //se llaman los botones

        // Abrir y cerrar el menú lateral al tocar el botón
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(findViewById(R.id.navigationView))) {
                    drawerLayout.closeDrawer(findViewById(R.id.navigationView));
                } else {
                    drawerLayout.openDrawer(findViewById(R.id.navigationView));
                }
            }
        });

        //boton redirige a la pagina
        btnPedido.setOnClickListener(v -> {
            Intent intent = new Intent(pantallaHome.this, pantallaMarket.class);
            startActivity(intent);
        });

        //boton redirige a la pagina
        nav_cart.setOnClickListener(v -> {
            Intent intent = new Intent(pantallaHome.this, pantallaMarket.class);
            startActivity(intent);
        });
    }

}
