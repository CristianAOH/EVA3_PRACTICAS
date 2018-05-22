package itchihuahua.example.com.eva3_10_asyntask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtV_mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtV_mostrar=(TextView)findViewById(R.id.txtV_mostrar);
        MiClaseAsincrona miClaseAsincrona=new MiClaseAsincrona();
        miClaseAsincrona.execute(50,500);
    }

    class MiClaseAsincrona extends AsyncTask<Integer,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtV_mostrar.setText("");
            txtV_mostrar.append("INICIANDO: \n");
        }

        //AQUI NO SE PUEDE CAMBIAR LA INTERFAZ
        @Override
        protected String doInBackground(Integer... integers) {
            int iCont=integers[0];
            int iTiempo= integers[1];
            for(int i=0; i<iCont; i++){
                try {
                    Thread.sleep(iTiempo);
                    publishProgress(i+"-");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Termino exitosamente";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtV_mostrar.append(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtV_mostrar.append("\n"+s);
        }

    }

}
