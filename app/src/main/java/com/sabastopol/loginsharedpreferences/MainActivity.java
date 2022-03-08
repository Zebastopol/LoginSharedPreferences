package com.sabastopol.loginsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.sebastopol.loginsharedpreferences.R;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtCorreo, txtContraseña;
    Button btnGuardar, btnRegistrar;
    CheckBox chkRecordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtContraseña = findViewById(R.id.txtContraseña);
        btnGuardar = findViewById(R.id.btnGuardar);
        chkRecordar= findViewById(R.id.chkRecordar);
        btnRegistrar= findViewById(R.id.btnRegistrar);

        SharedPreferences preferences = getSharedPreferences("almacenamiento_sp", Context.MODE_PRIVATE);
        txtNombre.setText(preferences.getString("sp_nombre", ""));
        txtCorreo.setText(preferences.getString("sp_correo", ""));
        txtContraseña.setText(preferences.getString("sp_contraeña",""));

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chkRecordar.isChecked()) {

                    String correo = txtCorreo.getText().toString();
                    String contraseña =txtContraseña.getText().toString();


                    SharedPreferences preferences = getSharedPreferences("almacenamiento_sp", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString("sp_correo", correo);
                    editor.putString("sp_contraseña", contraseña);
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Cuenta almacenada",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Cuenta no almacenada",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Espere un momento...", Toast.LENGTH_LONG).show();
            }
        });
    }
}