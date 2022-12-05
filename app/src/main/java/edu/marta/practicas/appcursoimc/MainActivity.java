package edu.marta.practicas.appcursoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    private NumberPicker npEstatura;
    private NumberPicker npPeso;
    private EditText etNombre;

    /**
     *
     *
     * Genere una “Calculadora de IMC” que almacene los datos del paciente, calcule el IMC y muestre en otra pantalla el resultado.
     *
     * Deberá contener un botón para aceptar o un botón de recalcular que vuelva a pedir los datos.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.npEstatura = findViewById(R.id.estaturapicker);
        this.npPeso = findViewById(R.id.pesopicker);
        this.etNombre = findViewById(R.id.nombreimc);

        this.npEstatura.setMaxValue(250);//fijamos valro máximo de la altura
        this.npEstatura.setMinValue(120);//minimo
        this.npEstatura.setValue(160);//y visible por defecto

        this.npPeso.setMaxValue(250);//igual para el peso
        this.npPeso.setMinValue(20);
        this.npPeso.setValue(80);


    }

    public void calcularIMC(View view) {
        int estatura = this.npEstatura.getValue();
        int peso = this.npPeso.getValue();

        //pasamos de entero a decimal (float)
        float festatura = estatura;
        //dividmos entre 100 para pasar de cm a m
        festatura = festatura/100;

        //hacemos el cálculo
        float imc = peso/(festatura*festatura);
        int imc_redondeado = Math.round(imc);

        Log.d("IMC_CALCULADORA" ,"IMC decimal = " + imc);
        Log.d("IMC_CALCULADORA" ,"IMC redondeado = " + imc_redondeado);

        //pasamos los datos a la actividad resultado
        //que son el nombre, y el imc_redondeado
        String nombre = etNombre.getText().toString();

        //preparamos el intent - de tipo Expícito - sabemos la clase destino
        Intent intent = new Intent(this, ActividadResultado.class);
        //guardamos esa información en el intentn: nombre y resultado
        intent.putExtra("NOMBRE", nombre);
        intent.putExtra("IMC", imc_redondeado);
        //lo lanzamos (vamos a la otra pantalla)
        startActivity(intent);
    }

    public void limpiarFormulario(View view) {
    }
}