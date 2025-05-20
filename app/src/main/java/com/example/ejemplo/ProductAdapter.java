package com.example.ejemplo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import com.example.ejemplo.models.ProductoModel;
import com.squareup.picasso.Picasso;
import java.util.List;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductAdapter extends ArrayAdapter<ProductoModel> {
    private final Context context;

    public ProductAdapter(Context context, List<ProductoModel> productos) {
        super(context, 0, productos);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Verificar si la vista es nula, si es así, inflar el layout
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false);
        }

        // Obtener la referencia al TextView y ImageView desde el layout
        TextView nombreTextView = convertView.findViewById(R.id.nombreTextView);
        TextView descripcionTextView = convertView.findViewById(R.id.descripcionTextView);
        TextView precioTextView = convertView.findViewById(R.id.precioTextView);
        TextView categoriaTextView = convertView.findViewById(R.id.categoriaTextView);
        ImageView imageView = convertView.findViewById(R.id.imageView); // Asegúrate de que este ID sea correcto

        // Verificar que las vistas no sean null
        if (nombreTextView == null || descripcionTextView == null || precioTextView == null ||  categoriaTextView == null || imageView == null) {
            throw new IllegalStateException("TextView or ImageView cannot be null");
        }

        // Obtener la persona actual
        ProductoModel producto = getItem(position);

        // Configurar los valores
        if (producto != null) {
            nombreTextView.setText(producto.getNombre());
            descripcionTextView.setText(producto.getDescripcion());
            precioTextView.setText(String.valueOf(producto.getPrecio()));
            categoriaTextView.setText(producto.getCategoria());

            // Cargar la imagen usando Picasso
            Picasso.get()
                    .load(producto.getImagen())
                    // .placeholder(R.drawable.placeholder) // Imagen mientras carga
                    .error(R.drawable.error) // Imagen en caso de error
                    .into(imageView);
        }

        return convertView;
    }
}