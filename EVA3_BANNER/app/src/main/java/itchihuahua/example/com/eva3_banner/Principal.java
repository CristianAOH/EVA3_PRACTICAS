package itchihuahua.example.com.eva3_banner;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    TextView txtV_modo;
    RadioButton rb_auto,rb_manual;
    ImageView imgV_mostrar;
    EditText edtxt_tiempo;
    Button btn_atras,btn_siguiente,btn_mostrar;
    RadioGroup rgp_modos;
    int imagenes[]={
            R.drawable.clc,
            R.drawable.gidle,
            R.drawable.bts,
            R.drawable.exid,
            R.drawable.stray
    };
    String nombres[]={"CLC","(G)-IDLE","BTS","EXID","STRAY KIDS"};
    int numero;
    boolean bBandera=true;
    Intent inLanzar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtV_modo=(TextView)findViewById(R.id.txtV_modo);
        rb_auto=(RadioButton)findViewById(R.id.rb_auto);
        rb_manual=(RadioButton)findViewById(R.id.rb_manual);
        imgV_mostrar=(ImageView)findViewById(R.id.imgV_mostrar);
        edtxt_tiempo=(EditText)findViewById(R.id.edtxt_tiempo);
        btn_atras=(Button)findViewById(R.id.btn_atras);
        btn_siguiente=(Button)findViewById(R.id.btn_siguiente);
        btn_mostrar=(Button)findViewById(R.id.btn_mostrar);
        rgp_modos=(RadioGroup)findViewById(R.id.rgp_modos);

        rgp_modos.setOnCheckedChangeListener(this);
        btn_atras.setEnabled(false);
        txtV_modo.setText("Modo: CLC");
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId==R.id.rb_auto){
            edtxt_tiempo.setEnabled(false);
            btn_atras.setEnabled(false);
            btn_siguiente.setEnabled(false);
            int tiempo=Integer.parseInt(edtxt_tiempo.getText().toString());
            ClaseAsincrona claseAsincrona=new ClaseAsincrona();
            claseAsincrona.execute(tiempo);
            bBandera=true;

        }else if(checkedId==R.id.rb_manual){
            bBandera=false;
            edtxt_tiempo.setEnabled(true);
            btn_atras.setEnabled(true);
            btn_siguiente.setEnabled(true);
        }
    }

    public void siguiente(View v){
        numero++;
        switch (numero){
            case 0:
                imgV_mostrar.setImageResource(imagenes[numero]);
                txtV_modo.setText("CLC");
                btn_atras.setEnabled(true);
                btn_siguiente.setEnabled(true);
                break;
            case 1:
                imgV_mostrar.setImageResource(imagenes[numero]);
                txtV_modo.setText("(G)-IDLE");
                btn_atras.setEnabled(true);
                btn_siguiente.setEnabled(true);
                break;
            case 2:
                imgV_mostrar.setImageResource(imagenes[numero]);
                txtV_modo.setText("BTS");
                btn_atras.setEnabled(true);
                btn_siguiente.setEnabled(true);
                break;
            case 3:
                imgV_mostrar.setImageResource(imagenes[numero]);
                txtV_modo.setText("EXID");
                btn_atras.setEnabled(true);
                btn_siguiente.setEnabled(true);
                break;
            case 4:
                imgV_mostrar.setImageResource(imagenes[numero]);
                txtV_modo.setText("STRAY KIDS");
                btn_atras.setEnabled(true);
                btn_siguiente.setEnabled(false);
                break;
        }
    }
    public void atras(View v){
        numero--;
        switch (numero){
            case 0:
                imgV_mostrar.setImageResource(imagenes[numero]);
                txtV_modo.setText("CLC");
                btn_atras.setEnabled(false);
                btn_siguiente.setEnabled(true);
                break;
            case 1:
                imgV_mostrar.setImageResource(imagenes[numero]);
                txtV_modo.setText("(G)-IDLE");
                btn_atras.setEnabled(true);
                btn_siguiente.setEnabled(true);
                break;
            case 2:
                imgV_mostrar.setImageResource(imagenes[numero]);
                txtV_modo.setText("BTS");
                btn_atras.setEnabled(true);
                btn_siguiente.setEnabled(true);
                break;
            case 3:
                imgV_mostrar.setImageResource(imagenes[numero]);
                txtV_modo.setText("EXID");
                btn_atras.setEnabled(true);
                btn_siguiente.setEnabled(true);
                break;
            case 4:
                imgV_mostrar.setImageResource(imagenes[numero]);
                txtV_modo.setText("STRAY KIDS");
                btn_atras.setEnabled(true);
                btn_siguiente.setEnabled(true);
                break;
        }
    }

    public void mostrar(View v){
        inLanzar=new Intent(this,Secundaria.class);
        Bundle bundle=new Bundle();
        bundle.putInt("IMAGEN",imagenes[numero]);
        inLanzar.putExtras(bundle);
        startActivity(inLanzar);
    }





    class ClaseAsincrona extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            imgV_mostrar.setImageResource(values[0]);
            txtV_modo.setText(nombres[numero]);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int iTiempo=integers[0];
            while (bBandera){
                try {
                    Thread.sleep(iTiempo);
                    numero++;
                    publishProgress(imagenes[numero]);
                    if (numero==4){
                        publishProgress(imagenes[0]);
                        numero=0;
                    }
                    if (bBandera==false){
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

    }
}
