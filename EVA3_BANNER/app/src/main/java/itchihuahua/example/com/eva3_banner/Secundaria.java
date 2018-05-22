package itchihuahua.example.com.eva3_banner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Secundaria extends AppCompatActivity {
    ImageView imgV_grande;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        imgV_grande=(ImageView)findViewById(R.id.imgV_grande);
        Bundle bundle=new Bundle();
        bundle=getIntent().getExtras();
        int img=bundle.getInt("IMAGEN");
        imgV_grande.setImageResource(img);
    }
}
