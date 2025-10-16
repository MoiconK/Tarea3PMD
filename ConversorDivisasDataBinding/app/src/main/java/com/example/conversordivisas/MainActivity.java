package com.example.conversordivisas;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Declaro las variables para establecer el texto de resultado
        TextView resultadoDinero = findViewById(R.id.dineroconvertido);

        //Declaro los botones y sus listeners
        Button botonDolares = (Button)findViewById(R.id.dolares_boton);
        botonDolares.setOnClickListener(v -> {
                    resultadoDinero.setText(convertirDolares()+"$");
        });
        Button botonLibras = (Button)findViewById(R.id.libras_boton);
        botonLibras.setOnClickListener(v -> {
            resultadoDinero.setText(convertirLibras()+"£");
        });
        Button botonYuanes = (Button)findViewById(R.id.yuanes_boton);
        botonYuanes.setOnClickListener(v -> {
            resultadoDinero.setText(convertirYuanes()+"¥");
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