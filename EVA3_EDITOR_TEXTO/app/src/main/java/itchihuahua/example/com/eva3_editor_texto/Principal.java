package itchihuahua.example.com.eva3_editor_texto;

import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Principal extends AppCompatActivity {
    EditText edtxt_texto;
    TextView txtV_palabra, txtV_error;
    private int espacios=0,errores=0;
    boolean bBandera=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        edtxt_texto=(EditText)findViewById(R.id.edtxt_texto);
        txtV_palabra=(TextView)findViewById(R.id.txtV_palabra);
        txtV_error=(TextView)findViewById(R.id.txtV_error);

        /*
        LeerPalabras leerPalabras=new LeerPalabras();
        leerPalabras.executeOnExecutor();
        Contador contador=new Contador();
        contador.execute();*/
        LeerPalabras leerPalabras=new LeerPalabras();
        Contador contador=new Contador(); // First
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) // Above Api Level 13
        {
            contador.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            leerPalabras.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        else // Below Api Level 13
        {
            contador.execute();
            leerPalabras.execute();
        }

    }

    class Contador extends AsyncTask<Integer,Integer,Integer> {

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int cant=values[0];
            txtV_palabra.setText("Número de palabras: "+cant);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            while (bBandera){
                Log.wtf("CONTADOR","HILO 1");
                try {
                    if (!TextUtils.isEmpty(edtxt_texto.getText().toString())){
                        //Log.wtf("NO EMPTY","El EditText no esta vacio");
                        String ultimoCaracter;
                        //ultimoCaracter=edtxt_texto.getText().toString().substring(edtxt_texto.length()-1);
                        int cantidad=edtxt_texto.getText().toString().split(" ").length;
                        publishProgress(cantidad);
                        Thread.sleep(200);
                    }else{
                        //Log.wtf("EMPTY","El EditText está vacio");
                        Thread.sleep(500);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bBandera=false;
    }

    class LeerPalabras extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int iError=values[0];
            txtV_error.setText("Número de errores: "+iError);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            while (bBandera){
                Log.wtf("ERROR","HILO 2");
                try {
                    if (!TextUtils.isEmpty(edtxt_texto.getText().toString())){
                        //Log.wtf("KEY","NO entra nada");
                        String ultimo;
                        if (edtxt_texto.getText().toString().length()>=4){
                            ultimo=edtxt_texto.getText().toString().substring(edtxt_texto.length()-4);
                            if(ultimo.equals("cion")){
                                errores++;
                                //Log.wtf("TERMINACION","Termina con cion");
                                publishProgress(errores);
                                Thread.sleep(2000);
                            }else{
                               // Log.wtf("NO TERMINACION","no termina con cion");
                            }
                        }else{
                            //Log.wtf("MINIMO","no cumple con lineamientos");
                        }

                    }else{
                        //Log.wtf("HEY","VACIO Man");
                        Thread.sleep(2000);
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
