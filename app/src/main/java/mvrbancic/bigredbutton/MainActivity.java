package mvrbancic.bigredbutton;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.redButton);

        button.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Potrebno je kg mesa", Toast.LENGTH_LONG).show();
                AssetFileDescriptor afd = null;
                try {
                    afd = getAssets().openFd("mixmix.mp3");
                    MediaPlayer player = new MediaPlayer();
                    player.setDataSource(afd.getFileDescriptor());
                    player.prepare();
                    player.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });
    }

}
