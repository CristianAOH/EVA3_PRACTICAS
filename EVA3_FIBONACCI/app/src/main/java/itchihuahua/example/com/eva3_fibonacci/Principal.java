package itchihuahua.example.com.eva3_fibonacci;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    private static int REQUEST=10;
    EditText edtxt_v1, edtxt_v2;
    Button btn_lanzar;
    TextView txtV_sumatoria;
    Intent inLanzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        edtxt_v1=(EditText)findViewById(R.id.edtxt_v1);
        edtxt_v2=(EditText)findViewById(R.id.edtxt_v2);
        btn_lanzar=(Button)findViewById(R.id.btn_lanzar);
        txtV_sumatoria=(TextView)findViewById(R.id.txtV_sumatoria);
        inLanzar=new Intent(this,Secundaria.class);
    }

    public void onClick(View v){
        int valor1=0,valor2=0;
        valor1=Integer.parseInt(edtxt_v1.getText().toString());
        valor2=Integer.parseInt(edtxt_v2.getText().toString());
        Bundle bundle=new Bundle();
        bundle.putInt("v1",valor1);
        bundle.putInt("v2",valor2);
        inLanzar.putExtras(bundle);
        txtV_sumatoria.setText("Sumatoria: ");
        startActivityForResult(inLanzar,REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST){
            if (resultCode== Activity.RESULT_OK){
                String numero=data.getExtras().getString("TOTAL");
                //Toast.makeText(this,numero,Toast.LENGTH_SHORT).show();
                txtV_sumatoria.append(numero);
            }
        }
    }
}
