//package com.example.ejemplo;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.EditText;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class registro extends AppCompatActivity {
//
//    private static final String TAG = "RegistroUsuario";
//    private static final String URL = "http://172.21.59.155:8080/registrar"; // Cambiar a la URL del endpoint de registro
//
//    private EditText nombreEditText;
//    private EditText apellidoEditText;
//   // private EditText urll;
//    private EditText telefono1;
//    private EditText usernameEditText;
//    private EditText passwordEditText;
//    //private Button registrarButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_registro);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        // Inicializar EditTexts y el botón
//        nombreEditText = findViewById(R.id.nombreEditText);
//        apellidoEditText = findViewById(R.id.apellidoEditText);
//        telefono1 = findViewById(R.id.telefonoEditText);
//        usernameEditText = findViewById(R.id.usernameEditText);
//        passwordEditText = findViewById(R.id.passwordEditText);
//        View registrarButton = findViewById(R.id.registrarButton);
//
//
//        registrarButton.setOnClickListener(v -> enviarRegistro());
//    }
//
//
//    private void enviarRegistro() {
//            // Obtener los datos del formulario
//            String nombre = nombreEditText.getText().toString();
//            String apellido = apellidoEditText.getText().toString();
//            String telefono = telefono1.getText().toString();
//            String email = usernameEditText.getText().toString();
//            String password = passwordEditText.getText().toString();
//
//            // Crear la cola de solicitudes
//            RequestQueue queue = Volley.newRequestQueue(this);
//
//            // Crear el objeto JSON con los datos a enviar
//            JSONObject jsonObject = new JSONObject();
//            try {
//                jsonObject.put("nombre", nombre);
//                jsonObject.put("apellido", apellido);
//                jsonObject.put("telefono", telefono);
//                jsonObject.put("email", email); // Agregar nombre de usuario al JSON
//                jsonObject.put("password", password); // Agregar contraseña al JSON
//            } catch (JSONException e) {
//                Log.e(TAG, "Error al crear JSON: " + e.getMessage());
//                return; // Salir si hay un error al crear el JSON
//            }
//
//            // Crear la solicitud POST con JsonObjectRequest
//            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject,
//                    response -> {
//                        // Manejar la respuesta del servidor
//                        Log.d(TAG, "Usuario registrado exitosamente: " + response.toString());
//                    },
//                    error -> {
//                        // Manejar el error
//                        Log.e(TAG, "Error en el registro: " + error.toString());
//                    });
//
//            // Agregar la solicitud a la cola
//            queue.add(jsonObjectRequest);
//        }
//    }
//
