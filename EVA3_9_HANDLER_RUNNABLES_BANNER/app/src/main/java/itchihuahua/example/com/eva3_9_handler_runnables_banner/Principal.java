package itchihuahua.example.com.eva3_9_handler_runnables_banner;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
    int iImagen=1;
    ImageView imgV_mostrar;
    Boolean bDetener=false;
    Handler hnManejador=new Handler();
    Runnable rnInteractuaUI=new Runnable() {
        @Override
        public void run() {
            switch (iImagen){
                case 1:
                    imgV_mostrar.setImageResource(R.drawable.sunny);
                    iImagen++;
                    break;
                case 2:
                    imgV_mostrar.setImageResource(R.drawable.rainy);
                    iImagen++;
                    break;
                case 3:
                    imgV_mostrar.setImageResource(R.drawable.light_rain);
                    iImagen=1;
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imgV_mostrar=(ImageView)findViewById(R.id.imgV_mostrar);
        MiHilo miHilo=new MiHilo();
        miHilo.start();
    }

    class MiHilo extends Thread{
        @Override
        public void run() {
            super.run();
            while(true){
                try{
                    //AQUI VAMOS A ENVIAR EL MENSAJE
                    hnManejador.post(rnInteractuaUI);
                    Thread.sleep(1000);
                    if(bDetener){
                        break;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }//Termina ciclo
        }//Termina Metodo RUN
    }//TERMINA CLASE MiHilo

    @Override
    protected void onStop() {
        super.onStop();
        bDetener=true;
    }
}
