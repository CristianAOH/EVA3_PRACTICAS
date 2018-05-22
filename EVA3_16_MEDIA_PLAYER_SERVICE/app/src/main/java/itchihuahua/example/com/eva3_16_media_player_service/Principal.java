package itchihuahua.example.com.eva3_16_media_player_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {
    Intent inServicioRep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inServicioRep=new Intent(this,ServicioSong.class);
    }

    public void inicio(View v){
        startService(inServicioRep);
    }

    public void detener(View v){
        stopService(inServicioRep);
    }
}
