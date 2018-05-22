package itchihuahua.example.com.eva3_7_banner_handle_message;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
    ImageView imgV_mostrar;
    int iImagen=1;
    boolean bDetener=false;
    Handler hManejador=new Handler(){
        //Cada vez queenviemos un mensaje aqui se procesa
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (iImagen){
                case 1:
                    imgV_mostrar.setImageResource(R.drawable.cloudy);
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
                    Message msg=hManejador.obtainMessage(1,"");
                    Thread.sleep(1000);
                    hManejador.sendMessage(msg);
                    if(bDetener){
                        break;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        bDetener=true;
    }
}
