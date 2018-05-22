package itchihuahua.example.com.eva3_13_servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ServicioDemo extends Service {
    private boolean bBandera;
    public ServicioDemo() {
        bBandera=false;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("ServicioDemo","onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("ServicioDemo", "onStart");
        Thread thHilo = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    try {
                        Thread.sleep(1000);
                        Log.wtf("ServicioDemo", "Trabajando...");
                        if(bBandera)
                            break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thHilo.run();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("ServicioDemo","onStop");
        bBandera=true;
    }
}
