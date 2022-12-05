package edu.marta.practicas.appcursoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActividadResultado extends AppCompatActivity {

    private TextView textViewNombre;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_resultado);

        this.textViewNombre = findViewById(R.id.textViewNombre);
        this.textViewResultado = findViewById(R.id.textViewResultado);


        Intent intent = getIntent();//cogemos el Intent
        //y sacamos los datos en él
        String nombre = intent.getStringExtra("NOMBRE");
        int imc = intent.getIntExtra("IMC", 18);

        String imc_nominal = calcularIMCNominal(imc);

        String nombre_resultado = nombre + ", SU IMC ES";
        String imc_resultado = imc + " (" + imc_nominal + ")";

        this.textViewResultado.setText(imc_resultado);
        this.textViewNombre.setText(nombre_resultado);

    }

    private String calcularIMCNominal(int imc) {
        String imc_nominal = null;

            if (imc < 16) {
                imc_nominal = "DESNUTRIDO";
            } else if ((imc >= 16) && (imc < 18)) {
                imc_nominal = "DELGADO";
            } else if ((imc >= 18) && (imc < 25)) {
                imc_nominal = "IDEAL";
            } else if ((imc >= 25) && (imc < 31)) {
                imc_nominal = "SOBREPESO";
            } else {
                imc_nominal = "OBESO";
            }

        return imc_nominal;
    }

    public void volver(View view) {
        this.finish();//cierro esta pantalla y volvemos
    }

    public void aceptar(View view) {
        Toast toast = Toast.makeText(this, "CUIDE SU SALUD, MIDA SU IMC REGULARMENTE", Toast.LENGTH_LONG);
        toast.show();
    }
}