package itchihuahua.example.com.eva3_15_media_player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal extends AppCompatActivity {
    MediaPlayer mpReproductor=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        mpReproductor=MediaPlayer.create(getApplicationContext(),R.raw.figure_8);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mpReproductor!=null){
            mpReproductor.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mpReproductor!=null){
            mpReproductor.stop();
            mpReproductor.release();
        }
    }
}
