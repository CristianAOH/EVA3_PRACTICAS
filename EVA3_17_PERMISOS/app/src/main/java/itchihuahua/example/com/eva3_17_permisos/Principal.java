package itchihuahua.example.com.eva3_17_permisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends AppCompatActivity {
    EditText edtxt_numero;
    Button btn_llamar;
    Intent inLlamar;
    private static final int PERMISO_LLAMAR=10;
    private boolean bBande=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        edtxt_numero=(EditText)findViewById(R.id.edtxt_numero);
        btn_llamar=(Button)findViewById(R.id.btn_llamar);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            // No explanation needed, we can request the permission.

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PERMISO_LLAMAR);

        }else{
            bBande=true;
        }

        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==PERMISO_LLAMAR){
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // permission was granted, yay! Do the
                // contacts-related task you need to do.
                bBande=true;
            } else {

                // permission denied, boo! Disable the
                // functionality that depends on this permission.
                finish();
            }
        }
    }

    public void onClick(View v){
        if(bBande){
            String num="tel:"+edtxt_numero.getText().toString();
            inLlamar=new Intent(Intent.ACTION_CALL, Uri.parse(num));
            startActivity(inLlamar);
        }
    }
}
