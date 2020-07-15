package com.offlineprogrammer.randomimagedisplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button random_button = findViewById(R.id.random_button);
        final ImageView random_imageview = findViewById(R.id.random_imageview);

        random_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monsterImageResourceName = getResources().getResourceEntryName(pickMonster());

                random_imageview.setImageResource(getResources().getIdentifier(monsterImageResourceName,
                        "drawable",
                        getPackageName()));
            }
        });

    }

    private int pickMonster(){
        final TypedArray imgs;
        imgs = getResources().obtainTypedArray(R.array.randomMonsters);
        final Random rand = new Random();
        final int rndInt = rand.nextInt(imgs.length());
        return imgs.getResourceId(rndInt, 0);
    }


}