package itchihuahua.example.com.eva3_14_servicios_broadcast_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txt_mostrar;
    BroadcastReceiver brMiReceptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txt_mostrar=(TextView)findViewById(R.id.txt_mostrar);

        IntentFilter ifMiFiltro=new IntentFilter("MI_SERVICIO");
        brMiReceptor=new MiReceptor();
        registerReceiver(brMiReceptor,ifMiFiltro);
    }

    public class MiReceptor extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            txt_mostrar.append("\n");
            String sCade=intent.getStringExtra("MI_CADENA");
            txt_mostrar.append(sCade);
        }
    }
}
