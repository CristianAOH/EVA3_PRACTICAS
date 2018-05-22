package itchihuahua.example.com.eva3_14_servicios_broadcast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MiServicio extends Service {
    Intent inDatos;
    public MiServicio() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("Servicio","onCreate");
        inDatos=new Intent("MI_SERVICIO");
        inDatos.putExtra("MI_CADENA","onCreate");
        sendBroadcast(inDatos);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("Servicio","onStart");
        inDatos=new Intent("MI_SERVICIO");
        inDatos.putExtra("MI_CADENA","onStart");
        sendBroadcast(inDatos);

        final Thread thread=new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i=0; i<60; i++){
                    try {
                        Thread.sleep(1000);
                        Log.wtf("Servicio",i+"...");

                        inDatos=new Intent("MI_SERVICIO");
                        inDatos.putExtra("MI_CADENA",i+"...");
                        sendBroadcast(inDatos);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("Servicio","onDestroy");
        inDatos=new Intent("MI_SERVICIO");
        inDatos.putExtra("MI_CADENA","onDestroy");
        sendBroadcast(inDatos);
    }
}
