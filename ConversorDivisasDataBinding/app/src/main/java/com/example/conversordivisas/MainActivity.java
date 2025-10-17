package com.example.conversordivisas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import com.example.conversordivisas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity { //Versión con databinding
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );

        //Declaro los botones y sus listeners

        binding.dolaresBoton.setOnClickListener(v -> {
                    binding.dineroconvertido.setText(convertirDolares()+"$");
        });
        binding.librasBoton.setOnClickListener(v -> {
                binding.dineroconvertido.setText(convertirLibras()+"£");
        });
        binding.yuanesBoton.setOnClickListener(v -> {
                binding.dineroconvertido.setText(convertirYuanes()+"¥");
        });

    }

    protected double convertirDolares(){
        //Declaro las variables necesarias para los datos
        EditText cantidadDinero = findViewById(R.id.cantidad_dinero);
        String cantidadIntroducida = cantidadDinero.getText().toString();
        if (!cantidadIntroducida.isEmpty()){
            double euros = Double.parseDouble(cantidadIntroducida);

            double dolares;

            dolares = euros * 1.09;

            return dolares;
        } else return 0;

    }

    protected double convertirLibras(){
        //Declaro las variables necesarias para los datos
        EditText cantidadDinero = findViewById(R.id.cantidad_dinero);
        String cantidadIntroducida = cantidadDinero.getText().toString();
        if (!cantidadIntroducida.isEmpty()){
            double euros = Double.parseDouble(cantidadIntroducida);
            double libras;

            libras = euros * 0.87;

            return libras;
        } else return 0;

    }

    protected double convertirYuanes(){
        //Declaro las variables necesarias para los datos
        EditText cantidadDinero = findViewById(R.id.cantidad_dinero);
        String cantidadIntroducida = cantidadDinero.getText().toString();
        if (!cantidadIntroducida.isEmpty()){
            double euros = Double.parseDouble(cantidadIntroducida);

            double yuanes;

            yuanes = euros * 8.30;

            return yuanes;
        } else return 0;

    }
}