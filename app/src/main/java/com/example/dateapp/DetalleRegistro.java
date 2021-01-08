package com.example.dateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleRegistro extends AppCompatActivity {

    private TextView tvNombre, tvFecha, tvTel, tvEmail, tvDes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_registro);

        Bundle parameters = getIntent().getExtras();
         String nombre = parameters.getString(getResources().getString(R.string.Nname));
         String fecha = parameters.getString(getResources().getString(R.string.Ndate));
         String telefono = parameters.getString(getResources().getString(R.string.Nphone));
         String Email = parameters.getString(getResources().getString(R.string.Nmail));
         String Desciption = parameters.getString(getResources().getString(R.string.Ndescription));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDes = (TextView) findViewById(R.id.tvDes);
        Button back = (Button) findViewById((R.id.btnBack));

        tvNombre.setText(nombre);
        tvFecha.setText("Fecha Nacimiento: " +fecha);
        tvTel.setText("Tél: " + telefono);
        tvEmail.setText("Email: " + Email);
        tvDes.setText("Descripcion: " +Desciption);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleRegistro.this, MainActivity.class);
                startActivity(intent);
            }
            });




    }
}