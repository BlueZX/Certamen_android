package com.example.certamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.DoubleBuffer;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnGenerarN;
    private Button btnMas;
    private Button btnMenos;
    private Button btnC;
    private Button btnX;
    private Button btnDivision;
    private Button btnResultadoPar;
    private Button getBtnResultadoPrimo;

    private TextView tvPrimerNumero;
    private TextView tvSegundoNumero;
    private TextView tvOperacion;
    private TextView tvResultado;
    private TextView tvResultadoText;

    private Random rnd;
    private int a = 0;
    private int b = 0;
    private double c = 0.0;
    private boolean generado;
    String resText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGenerarN = (Button) findViewById(R.id.generarNumero);
        btnMas = (Button) findViewById(R.id.sumar);
        btnMenos = (Button) findViewById(R.id.restar);
        btnC = (Button) findViewById(R.id.resetear);
        btnX = (Button) findViewById(R.id.multiplicar);
        btnDivision = (Button) findViewById(R.id.dividir);
        btnResultadoPar = (Button) findViewById(R.id.resultadoPar);
        getBtnResultadoPrimo = (Button) findViewById(R.id.resultadoPrimo);

        tvPrimerNumero = (TextView) findViewById(R.id.primerNro);
        tvSegundoNumero = (TextView) findViewById(R.id.segundoNro);
        tvOperacion = (TextView) findViewById(R.id.operacion);
        tvResultado = (TextView) findViewById(R.id.resultado);
        tvResultadoText = (TextView) findViewById(R.id.resultadoText);

        tvPrimerNumero.setText(" ");
        tvSegundoNumero.setText(" ");
        tvOperacion.setText("?");
        tvResultado.setText(" ");
        tvResultadoText.setText(" - ");

        rnd = new Random();

        generado = false;

        btnGenerarN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = rnd.nextInt(100);
                b = rnd.nextInt(100);
                c = 0.0;

                tvPrimerNumero.setText(String.valueOf(a));
                tvSegundoNumero.setText(String.valueOf(b));
                tvOperacion.setText("?");
                tvResultado.setText(" ");
                tvResultadoText.setText(" - ");
                resText = "";

                generado = true;

            }
        });

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(generado){
                    tvOperacion.setText("+");

                    c = Double.valueOf(a + b);

                    tvResultado.setText(String.valueOf(c));
                    tvResultadoText.setText(" - ");
                    resText = "";
                }
                else{
                    a = b = 0;
                    tvPrimerNumero.setText(" ");
                    tvSegundoNumero.setText(" ");
                    tvOperacion.setText("?");
                    tvResultado.setText("Error");
                    tvResultadoText.setText(" - ");
                    resText = "";
                    c = 0.0;
                }

            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvPrimerNumero.setText(" ");
                tvSegundoNumero.setText(" ");
                tvOperacion.setText("?");
                tvResultado.setText(" ");
                a = b = 0;
                c = 0.0;
                generado = false;
                tvResultadoText.setText(" - ");
                resText = "";
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(generado){
                    c = Double.valueOf(a - b);

                    tvOperacion.setText("-");
                    tvResultado.setText(String.valueOf(c));
                    tvResultadoText.setText(" - ");
                    resText = "";
                }
                else{
                    tvPrimerNumero.setText(" ");
                    tvSegundoNumero.setText(" ");
                    c = 0.0;
                    tvOperacion.setText("?");
                    tvResultado.setText("Error");
                    tvResultadoText.setText(" - ");
                    resText = "";
                }
            }
        });

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(generado){
                    c = Double.valueOf(a * b);
                    tvOperacion.setText("X");
                    tvResultado.setText(String.valueOf(c));
                    tvResultadoText.setText(" - ");
                    resText = "";
                }
                else{
                    tvPrimerNumero.setText(" ");
                    tvSegundoNumero.setText(" ");
                    c = 0.0;
                    tvOperacion.setText("?");
                    tvResultado.setText("Error");
                    tvResultadoText.setText(" - ");
                    resText = "";
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(generado){
                    c = Double.valueOf(a) / Double.valueOf(b);
                    tvOperacion.setText("/");
                    tvResultado.setText(String.valueOf(c));
                    tvResultadoText.setText(" - ");
                    resText = "";
                }
                else{
                    tvPrimerNumero.setText(" ");
                    tvSegundoNumero.setText(" ");
                    tvOperacion.setText("?");
                    c = 0.0;
                    tvResultado.setText("Error");
                    tvResultadoText.setText(" - ");
                    resText = "";
                }
            }
        });

        btnResultadoPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(c%2 == 0 ){
                    resText = "ES PAR";
                }else{
                    resText = "ES IMPAR";
                }

                if(generado){
                    tvResultadoText.setText(resText);
                }else{
                    tvResultadoText.setText(" - ");

                }

                if(c == 0){
                    tvResultadoText.setText(" - ");
                }
            }
        });

        getBtnResultadoPrimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int d = (int)c;

                int esPrimo = 0;
                if(d < 0){
                    d *= -1;
                }

                for(int i=1;i<=d;i++){
                    if(d%i == 0){
                        esPrimo++;
                    }
                }

                if(esPrimo == 2){
                    resText = "ES PRIMO";
                }
                else{
                    resText = "NO ES PRIMO";
                }

                if(generado){
                    tvResultadoText.setText(resText);
                }else{
                    tvResultadoText.setText(" - ");

                }

                if(c == 0){
                    tvResultadoText.setText(" - ");
                }
            }
        });





    }
}
