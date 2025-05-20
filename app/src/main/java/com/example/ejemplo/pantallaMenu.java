package com.example.ejemplo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class pantallaMenu extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu); // Asegúrate de que sea el XML correcto

        drawerLayout = findViewById(R.id.drawer_layout);
        ImageButton menuButton = findViewById(R.id.menuButton);

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
    }
}
