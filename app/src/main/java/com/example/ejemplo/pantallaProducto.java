package com.example.ejemplo;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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

//        inicalizadores
        TextView appNombreProducto = findViewById(R.id.appNombreProducto);
        TextView appPrecio = findViewById(R.id.appPrecio);
        TextView appDescription = findViewById(R.id.appDescription);
        ImageView ImgProduct = findViewById(R.id.ImgProduct);

        productosList = new ArrayList<>();
        adapter = new ProductAdapter(this, productosList);
        ListaProductos.setAdapter(adapter);

        getDatos();

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    private void getDatos() {
        String url = "http://192.168.100.109:8080/productos";

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                this::onResponse,
                error -> Log.e("Volley", "Error al obtener los datos: " + error.toString()));

        queue.add(jsonArrayRequest);
    }

    private void onResponse(JSONArray response) {
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject jsonObject = response.getJSONObject(i);
                String nombre = jsonObject.getString("nombre");
                String descripcion = jsonObject.getString("descripcion");
                Double precio = jsonObject.getDouble("precio");
                String categoria = jsonObject.getString("categoria");
                String imagen = jsonObject.getString("imagen");

                productosList.add(new ProductoModel(nombre, descripcion, precio, categoria, imagen));
            }

            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            Log.e("JSONException", "Error al parsear el JSON: " + e.toString());
        }
    }
}
