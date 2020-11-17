package com.coursera.usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NOMBRE = "com.coursera.usuario.extra.nombre";
    public static final String EXTRA_FECHA_NACIMIENTO = "com.coursera.usuario.extra.fecha_nacimiento";
    public static final String EXTRA_TELEFONO = "com.coursera.usuario.extra.telefono";
    public static final String EXTRA_EMAIL = "com.coursera.usuario.extra.email";
    public static final String EXTRA_DESCRIPCION = "com.coursera.usuario.extra.descripcion";


    private EditText mNombre;
    private DatePicker mFechaNacimiento;
    private EditText mTelefono;
    private EditText mEmail;
    private EditText mDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepararIU();
    }

    private void prepararIU() {
        mNombre = ((TextInputLayout) findViewById(R.id.texto_nombre)).getEditText();
        mFechaNacimiento = findViewById(R.id.fecha_nacimiento);
        mTelefono = ((TextInputLayout) findViewById(R.id.telefono)).getEditText();
        mEmail = ((TextInputLayout) findViewById(R.id.email)).getEditText();
        mDescripcion = ((TextInputLayout) findViewById(R.id.descripcion)).getEditText();
    }

    public void confirmar(View boton) {
        Intent i = new Intent(this, ConfirmActivity.class);
        i.putExtra(EXTRA_NOMBRE, mNombre.getText().toString());
        i.putExtra(EXTRA_FECHA_NACIMIENTO, generarFecha(mFechaNacimiento));
        i.putExtra(EXTRA_TELEFONO, mTelefono.getText().toString());
        i.putExtra(EXTRA_EMAIL, mEmail.getText().toString());
        i.putExtra(EXTRA_DESCRIPCION, mDescripcion.getText().toString());
        startActivity(i);
    }

    public String generarFecha(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar c = Calendar.getInstance();
        c.set(year, month, day);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        return sdf.format(c.getTime());
    }
}