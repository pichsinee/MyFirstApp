package comsci.alice.myfirstapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AboutMe extends AppCompatActivity {

    //Explicit
    MediaPlayer mediaPlayer;
    int soundID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        //Toast onClick
        ImageView clickImageView = (ImageView) findViewById(R.id.imvMyPic);
        clickImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Hello! My name is Alice" , Toast.LENGTH_SHORT).show();

                //Show sound1 when click image
                soundID = R.raw.sound01;
                playSound(soundID);

            }
        });


        //Toast onLongClick
        ImageView longClickImageView = (ImageView) findViewById(R.id.imvMyPic);
        longClickImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(getApplicationContext(), "Thanks Guys!\nHope you like the My First App", Toast.LENGTH_SHORT).show();
                //Show sound1 when click image
                soundID = R.raw.sound02;
                playSound(soundID);

                return true;
            }
        });


        //link to facebook
        TextView fbTextView = (TextView) findViewById(R.id.txtFacebook);
        fbTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fbIntent = new Intent(Intent.ACTION_VIEW);
                fbIntent.setData(Uri.parse("https://www.facebook.com/Aj.Aom"));
                startActivity(fbIntent);
            }
        });

    }//main method

    private void playSound(int soundID) {


        mediaPlayer = MediaPlayer.create(getApplicationContext(), soundID);
        mediaPlayer.start();
    }

    public void onClickBack(View view){
        finish();
    }
}   //Main Class
