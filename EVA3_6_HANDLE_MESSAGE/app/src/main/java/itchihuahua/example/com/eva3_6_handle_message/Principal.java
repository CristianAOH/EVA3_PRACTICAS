package itchihuahua.example.com.eva3_6_handle_message;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtV_mostrar;
    Handler hManejador=new Handler(){
        //Cada vez queenviemos un mensaje aqui se procesa
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String sMensa=(String)msg.obj;
            txtV_mostrar.append(sMensa);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtV_mostrar=(TextView)findViewById(R.id.txtV_mostrar);
        MiHilo miHilo= new MiHilo();
        miHilo.start();

    }
    class MiHilo extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i=0; i<50; i++){
                try{
                    //AQUI VAMOS A ENVIAR EL MENSAJE
                    //txtV_mostrar.append(i+" - ");
                    Message msg=hManejador.obtainMessage(1,i+" - ");
                    Thread.sleep(500);
                    hManejador.sendMessage(msg);
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        }
    }

}
