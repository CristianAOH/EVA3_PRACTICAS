package itchihuahua.example.com.eva3_2_hilos_2_thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        MiHilo mhl=new MiHilo();
        mhl.start();
        //mhl.run(); ejecuta el metodo run y no lo hace en segundo plano

        Thread thOtroHilo=new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i=0;i<20;i++){
                    try{
                        Thread.sleep(500);
                        Log.wtf("Hilo Clase Anonima","Hola!");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
        thOtroHilo.start();
    }
}
