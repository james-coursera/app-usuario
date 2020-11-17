package com.coursera.usuario;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmActivity extends AppCompatActivity {

    private TextView mNombre;
    private TextView mFechaNacimiento;
    private TextView mTelefono;
    private TextView mEmail;
    private TextView mDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            throw new RuntimeException("El ejemplo requiere un envío de parámetros");
        }

        prepararIU();
        cargarDatos(extras);
    }

    private void prepararIU() {
        mNombre = findViewById(R.id.texto_nombre);
        mFechaNacimiento = findViewById(R.id.texto_fecha_nacimiento);
        mTelefono = findViewById(R.id.texto_telefono);
        mEmail = findViewById(R.id.texto_email);
        mDescripcion = findViewById(R.id.texto_descripcion);
    }

    private void cargarDatos(Bundle extras) {
        String nombre = extras.getString(MainActivity.EXTRA_NOMBRE);
        String nacimiento = extras.getString(MainActivity.EXTRA_FECHA_NACIMIENTO);
        String telefono = extras.getString(MainActivity.EXTRA_TELEFONO);
        String email = extras.getString(MainActivity.EXTRA_EMAIL);
        String descripcion = extras.getString(MainActivity.EXTRA_DESCRIPCION);

        mNombre.setText(nombre);
        mFechaNacimiento.setText(getString(R.string.texto_fecha_nacimiento, nacimiento));
        mTelefono.setText(getString(R.string.texto_telefono, telefono));
        mEmail.setText(getString(R.string.texto_email, email));
        mDescripcion.setText(getString(R.string.texto_descripcion, descripcion));
    }

    public void editar(View boton) {
        finish();
    }
}