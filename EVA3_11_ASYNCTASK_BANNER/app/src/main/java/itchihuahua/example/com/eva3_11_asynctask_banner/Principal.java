package itchihuahua.example.com.eva3_11_asynctask_banner;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
    ImageView imgV_mostrar;
    int iImagen = 1;
    Boolean bDetener = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imgV_mostrar = (ImageView) findViewById(R.id.imgV_mostrar);
        MiClaseAsincrona miClaseAsincrona=new MiClaseAsincrona();
        miClaseAsincrona.execute(500);
    }

    class MiClaseAsincrona extends AsyncTask<Integer, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            imgV_mostrar.setImageResource(R.drawable.sunny);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            switch (iImagen) {
                case 1:
                    imgV_mostrar.setImageResource(R.drawable.sunny);
                    break;
                case 2:
                    imgV_mostrar.setImageResource(R.drawable.rainy);
                    break;
                case 3:
                    imgV_mostrar.setImageResource(R.drawable.light_rain);
                    break;
            }
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int iTiempo = integers[0];
            while (true) {
                try {
                    Thread.sleep(iTiempo);
                    iImagen++;
                    if (iImagen>3){
                        iImagen=1;
                    }
                    publishProgress(iImagen);
                    if (bDetener) {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
