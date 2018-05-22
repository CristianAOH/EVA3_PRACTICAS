package com.example.arturor.eva3_7_handler_runnable;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
TextView txtDatos;
    Handler hnMajenador = new Handler();
    int ival = 0;
    Runnable rnInteractuaUI = new Runnable() {

        @Override
        public void run() {
           mgV txtDatos.append((ival++ )+ " - ");
            
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtDatos = (TextView)findViewById(R.id.txtDatos);
        MiHilo mhHilo = new MiHilo();
        mhHilo.start();
    }

    class MiHilo extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i= 0; i < 50; i++){
             try {
                 hnMajenador.post(rnInteractuaUI);
                 Thread.sleep(500);
             }catch (Exception e){
                 e.printStackTrace();
             }
            }
        }
    }
}
