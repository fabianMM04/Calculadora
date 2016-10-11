package com.example.labsoftware01.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public MainActivity() throws IOException {
    }

    TextView tv;
    Button btn;
    String op = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.txtnumero);
        btn = (Button) findViewById(R.id.btn_api);
        btn.setOnClickListener(this);
    }

    Double numero1, numero2, resultado;
    String operador;

    public void apiResult() {
        numero2 = Double.parseDouble(tv.getText().toString());

        Log.e("num1", Double.toString(numero1));
        Log.e("num2", Double.toString(numero2));

        if (operador.equals("+")) {
            op = "sum";
        } else {
            if (operador.equals("-")) {
                op = "res";
            } else {
                if (operador.equals("*")) {
                    op = "mul";
                } else {
                    op = "div";
                }
            }
        }

        Log.e("operador", op);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://162.243.64.94/dm.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tv.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("asdasdsa", error.toString());

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();


                params.put("o", op);
                params.put("a", Double.toString(numero1));
                params.put("b", Double.toString(numero2));

                return params;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);

    }


    public void igual(View miView) {


        numero2 = Double.parseDouble(tv.getText().toString());

        if (operador.equals("+")) {
            resultado = numero1 + numero2;
        } else if (operador.equals("-")) {
            resultado = numero1 - numero2;
        } else if (operador.equals("*")) {
            resultado = numero1 * numero2;
        } else if (operador.equals("/")) {
            resultado = numero1 / numero2;
        }
        tv.setText(resultado.toString());
    }

    public void sumar(View miView) {
        operador = "+";
        onClickOperacionCapturaNumero1(miView);
    }

    public void restar(View miView) {
        operador = "-";
        onClickOperacionCapturaNumero1(miView);
    }

    public void multiplicar(View miView) {
        operador = "*";
        onClickOperacionCapturaNumero1(miView);
    }

    public void dividir(View miView) {
        operador = "/";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickOperacionCapturaNumero1(View miView) {

        numero1 = Double.parseDouble(tv.getText().toString());
        tv.setText("");

    }

    public void borrar(View miView) {
        numero1 = 0.0;
        numero2 = 0.0;

        tv.setText("");
    }

    public void btn1(View miView) {

        tv.setText(tv.getText() + "1");
    }

    public void btn2(View miView) {

        tv.setText(tv.getText() + "2");
    }

    public void btn3(View miView) {

        tv.setText(tv.getText() + "3");
    }

    public void btn4(View miView) {

        tv.setText(tv.getText() + "4");
    }

    public void btn5(View miView) {

        tv.setText(tv.getText() + "5");
    }

    public void btn6(View miView) {

        tv.setText(tv.getText() + "6");
    }

    public void btn7(View miView) {

        tv.setText(tv.getText() + "7");
    }

    public void btn8(View miView) {

        tv.setText(tv.getText() + "8");
    }

    public void btn9(View miView) {

        tv.setText(tv.getText() + "9");
    }

    public void btn0(View miView) {

        tv.setText(tv.getText() + "0");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_api:
                apiResult();
                break;
        }
    }
}
