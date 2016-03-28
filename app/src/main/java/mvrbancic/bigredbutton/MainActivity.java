package mvrbancic.bigredbutton;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private String path = "audio";

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
                String name = listAssetFiles(path);
                try {
                    afd = getAssets().openFd(path + "/" + name);
                    MediaPlayer player = new MediaPlayer();
                    player.setDataSource(afd.getFileDescriptor());
                    if(player.isPlaying()) {
                        player.stop();
                    }
                    player.prepare();
                    player.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });
    }

    private String listAssetFiles(String path) {

        String [] list;
        String name = "mixmix.mp3";
        try {
            list = getAssets().list(path);
            if (list.length > 0) {
                // This is a folder
                Random r = new Random();
                int i1 = r.nextInt(list.length - 1) + 1;

                name = list[i1-1];
            } else {
                // This is a file
                // TODO: add file name to an array list
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), (CharSequence) e, Toast.LENGTH_LONG).show();
        }

        return name;
    }

}
