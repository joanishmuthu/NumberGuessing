package com.example.basic_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class MainActivity extends AppCompatActivity {
    EditText text1;
    KonfettiView kv;
    Button check;
    int random;
    Random random1;
    Shape.DrawableShape drawableShape = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=findViewById(R.id.number);
        check=findViewById(R.id.button);
        random1=new Random();
        random=random1.nextInt(100);
        kv=findViewById(R.id.konfettiView);

    }
    public void click(View v){
        final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), androidx.constraintlayout.widget.R.drawable.abc_ab_share_pack_mtrl_alpha);
        drawableShape = new Shape.DrawableShape(drawable, true, true);
        EmitterConfig emitterConfig = new Emitter(5L, TimeUnit.SECONDS).perSecond(50);
        Party party = new PartyFactory(emitterConfig)
                .angle(270)
                .spread(90)
                .setSpeedBetween(1f, 5f)
                .timeToLive(2000L)
                .shapes(new Shape.Rectangle(0.2f), drawableShape)
                .sizes(new Size(12, 5f, 0.2f))
                .position(0.0, 0.0, 1.0, 0.0)
                .build();
        kv.start(party);
    }
    public void check(View view){
        if(Integer.parseInt(text1.getText().toString())==random){
            random=random1.nextInt(100);
            Toast.makeText(MainActivity.this, "The value is correct", Toast.LENGTH_SHORT).show();
            click(view);
        }
        else{
            if(random>Integer.parseInt(text1.getText().toString())){
                Toast.makeText(this, "The random number is greater "+random, Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "The random number is smaller "+random, Toast.LENGTH_SHORT).show();
            }
        }
    }

}