package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    Button prev, next;
    int position = 0;
    int [] imgs = {R.drawable.ic, R.drawable.mer, R.drawable.zani, R.drawable.mat};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = findViewById(R.id.imgswitcher);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });

        imageSwitcher.setImageResource(imgs[position]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position<imgs.length-1){
                    position++;
                    imageSwitcher.setImageResource(imgs[position]);
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position>0){
                    position--;
                    imageSwitcher.setImageResource(imgs[position]);
                }
            }
        });




    }
}