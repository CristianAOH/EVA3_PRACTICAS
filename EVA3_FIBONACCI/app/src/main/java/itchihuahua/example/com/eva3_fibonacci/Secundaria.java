package itchihuahua.example.com.eva3_fibonacci;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Secundaria extends AppCompatActivity {
    private boolean bBandera=true;
    private int num1,num2,total,total2=0;
    TextView txtV_mostrar;
    Intent inDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        txtV_mostrar=(TextView)findViewById(R.id.txtV_mostrar);
        Bundle bundle=new Bundle();
        bundle=getIntent().getExtras();
        num1=bundle.getInt("v1");
        num2=bundle.getInt("v2");
        inDatos=getIntent();
        total2=num1+num2;
        ClaseAsincrona claseAsincrona=new ClaseAsincrona();
        claseAsincrona.execute(num1,num2);

    }

    class ClaseAsincrona extends AsyncTask<Integer,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtV_mostrar.setText("Serie: "+num1+"- "+num2+"- ");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtV_mostrar.append(values[0]);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int iValor1=integers[0];
            int iValor2=integers[1];
            while(bBandera){
                try {
                    Thread.sleep(1000);
                    total=num1+num2;
                    total2=total2+total;
                    publishProgress(total+"- ");
                    num1=num2;
                    num2=total;
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

    public void detener(View v){
        bBandera=false;
        Bundle b=new Bundle();
        String sCade=String.valueOf(total2);
        b.putString("TOTAL",sCade);
        inDatos.putExtras(b);
        //Toast.makeText(this,sCade,Toast.LENGTH_SHORT).show();
        setResult(Activity.RESULT_OK,inDatos);
        finish();

    }
}
