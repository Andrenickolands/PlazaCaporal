package com.example.ejemplo;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ejemplo.models.ProductoModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class pantallaProducto extends AppCompatActivity {

    private ProductAdapter adapter;
    private List<ProductoModel> productosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_producto);

        // inicializar
        TextView nombreTextView = findViewById(R.id.nombreTextView);
        TextView descripcionTextView = findViewById(R.id.descripcionTextView);
        TextView precioTextView = findViewById(R.id.precioTextView);
        TextView categoriaTextView = findViewById(R.id.categoriaTextView);
        ImageView imageView = findViewById(R.id.imageView);

        productosList = new ArrayList<>();
        adapter = new ProductAdapter(this, productosList);
        nombreTextView.setText("nombre");
        descripcionTextView.setText("descripción");
        precioTextView.setText("precio");
        categoriaTextView.setText("categoria");
        imageView.setImageURI(Uri.parse("imagen"));

        // Llamar al metodo para recibir los datos
        recibirDatos();
    }


    private void recibirDatos() {
        // URL del servidor
        String url = "http://192.168.100.109:8082/productos";

        // Crear la cola de solicitudes con Volley
        RequestQueue queue = Volley.newRequestQueue(this);

        // Crear la solicitud JSON
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                this::onResponse,
                error -> Log.e("Volley", "Error en la solicitud: " + error.toString()));

        // Agregar la solicitud a la cola
        queue.add(jsonArrayRequest);
    }

    private void onResponse(JSONArray response) {
        try {
            // Itera sobre los datos JSON y agrega a la lista
            for (int i = 0; i < response.length(); i++) {
                JSONObject jsonObject = response.getJSONObject(i);
                String nombre = jsonObject.getString("nombre");
                String descripcion = jsonObject.getString("descripcion");
                Double precio = jsonObject.getDouble("precio");
                String categoria = jsonObject.getString("categoria");
                String imagen = jsonObject.getString("imagen");


                // Agregar a la lista
                productosList.add(new ProductoModel(nombre, descripcion, precio, categoria, imagen));
            }

            // Notificar al adaptador que los datos han cambiado
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            //e.printStackTrace();
        }
    }
}
