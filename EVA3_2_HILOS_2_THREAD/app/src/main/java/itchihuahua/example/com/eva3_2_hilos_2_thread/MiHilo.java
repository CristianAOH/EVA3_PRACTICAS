package itchihuahua.example.com.eva3_2_hilos_2_thread;

import android.util.Log;

/**
 * Created by Cristian on 16/04/2018.
 */

public class MiHilo extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i=0;i<20;i++){
            try{
                Thread.sleep(500);
                Log.wtf("Hilo con thread","Hola mundo!");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
