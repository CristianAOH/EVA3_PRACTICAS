package itchihuahua.example.com.eva3_13_servicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {
    Intent inServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inServicio=new Intent(this,ServicioDemo.class);
    }

    public void onClick(View v){
        startService(inServicio);
    }

    public void Detener(View v){
        stopService(inServicio);
    }
}
