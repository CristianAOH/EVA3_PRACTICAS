package itchihuahua.example.com.eva3_3_hilos_uops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {

    boolean bBandera=false;

    @Override
    protected void onStop() {
        super.onStop();
        bBandera=true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        while(true) {
            Thread thOtroHilo = new Thread() {
                @Override
                public void run() {
                    super.run();
                    for (int i = 0; i < 20; i++) {
                        try {
                            Thread.sleep(500);
                            Log.wtf("Hilo Clase Anonima", "Hola!");
                            if(bBandera){
                                break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            thOtroHilo.start();
        }//Finaliza el while
    }
}
