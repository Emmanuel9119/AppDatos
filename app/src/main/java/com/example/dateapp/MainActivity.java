package com.example.dateapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.DateTimeKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre,  telefono, email, descripcion;
    String Nnombre, Nfecha, Ntelefono, Nemail, Ndescripcion;
    DatePicker fechaNacimiento;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.etNombre);
        fechaNacimiento = findViewById(R.id.Nacimiento);
        telefono = findViewById(R.id.etTelefono);
        email = findViewById(R.id.etEmail);
        descripcion = findViewById(R.id.etdescription);
        next = findViewById(R.id.btnNext);

       /* if(snombre.length() > 0)
        {
            nombre.setText(snombre);
            //fechaNacimiento.set;
            telefono.setText(stelefono);
            email.setText(sEmail);
            descripcion.setText(sDesciption);
        }*/



        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Nnombre = nombre.getText().toString();
                Nfecha = String.valueOf(fechaNacimiento.getDayOfMonth() + "/" +
                        String.valueOf(fechaNacimiento.getMonth() + 1) + "/" +
                        String.valueOf(fechaNacimiento.getYear()));
                Ntelefono = telefono.getText().toString();
                Nemail = email.getText().toString();
                Ndescripcion = descripcion.getText().toString();

                if(Nnombre.length() > 0 && Nfecha.length() > 0 && Ntelefono.length() > 0
                && Nemail.length() > 0 && Ndescripcion.length() >0)
                {
                    Intent intent = new Intent(MainActivity.this, DetalleRegistro.class);
                    intent.putExtra(getResources().getString(R.string.Nname), Nnombre);
                    intent.putExtra(getResources().getString(R.string.Ndate), Nfecha);
                    intent.putExtra(getResources().getString(R.string.Nphone), Ntelefono);
                    intent.putExtra(getResources().getString(R.string.Nmail), Nemail);
                    intent.putExtra(getResources().getString(R.string.Ndescription), Ndescripcion);
                    startActivity(intent);
                    /*nombre.setText("");
                    fechaNacimiento.clearAnimation();
                    telefono.setText("");
                    email.setText("");
                    descripcion.setText("");*/

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Favor de llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}