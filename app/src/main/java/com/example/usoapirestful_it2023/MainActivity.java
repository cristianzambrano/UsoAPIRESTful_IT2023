package com.example.usoapirestful_it2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity
        extends AppCompatActivity
        implements Asynchtask {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickLogin(View v){
        Map<String, String> datos = new HashMap<String, String>();
        EditText txtUsr = findViewById(R.id.txtUsuario);
        EditText txtClave = findViewById(R.id.txtClave);

        WebService ws= new WebService(
                "https://revistas.uteq.edu.ec/ws/login.php?usr=" +
                        txtUsr.getText().toString() +
                        "&pass=" + txtClave.getText().toString(),
                datos,
                MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        TextView txtRespuesta = findViewById(R.id.txtResp);
        if(result.equals("Login Correcto!")){
            //Agregar las funciones de Validación
            //startActivity(Actividad2.java);
        }else {
            txtRespuesta.setText(result);
        }
    }
}