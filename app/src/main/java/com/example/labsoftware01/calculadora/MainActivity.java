package com.example.labsoftware01.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public MainActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Double numero1,numero2,resultado;
    String operador;


    public void igual(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;

        numero2 = Double.parseDouble(tv.getText().toString());

        if(operador.equals("+"))
        {
            resultado= numero1+numero2;
        }
        else if(operador.equals("-"))
        {
            resultado= numero1-numero2;
        }
        else if(operador.equals("*"))
        {
            resultado= numero1*numero2;
        }
        else if(operador.equals("/"))
        {
            resultado= numero1/numero2;
        }
        tv.setText(resultado.toString());
    }

    public void sumar(View miView)
    {
        operador="+";
        onClickOperacionCapturaNumero1(miView);
    }
    public void restar(View miView)
    {
        operador="-";
        onClickOperacionCapturaNumero1(miView);
    }
    public void multiplicar(View miView)
    {
        operador="*";
        onClickOperacionCapturaNumero1(miView);
    }
    public void dividir(View miView)
    {
        operador="/";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickOperacionCapturaNumero1(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        numero1 = Double.parseDouble(tv.getText().toString());
        tv.setText("");
    }

    public void borrar(View miView)
    {
        numero1=0.0;
        numero2=0.0;
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        tv.setText("");
    }

    public void btn1(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        tv.setText(tv.getText() + "1");
    }
    public void btn2(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        tv.setText(tv.getText() + "2");
    }
    public void btn3(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        tv.setText(tv.getText() + "3");
    }
    public void btn4(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        tv.setText(tv.getText() + "4");
    }
    public void btn5(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        tv.setText(tv.getText() + "5");
    }
    public void btn6(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        tv.setText(tv.getText() + "6");
    }
    public void btn7(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        tv.setText(tv.getText() + "7");
    }
    public void btn8(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        tv.setText(tv.getText() + "8");
    }
    public void btn9(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        tv.setText(tv.getText() + "9");
    }
    public void btn0(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.txtnumero) ;
        tv.setText(tv.getText() + "0");
    }



}
