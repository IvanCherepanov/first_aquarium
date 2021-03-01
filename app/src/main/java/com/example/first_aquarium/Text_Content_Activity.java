package com.example.first_aquarium;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    private TextView text_content;
    private Typeface face1;
    private ImageView iContent;
    private int category=0;
    private int position=0;
    private int[] array_fish = {R.string.fish1,R.string.fish2,R.string.fish3,R.string.fish4};
    private int[] array_fish_image = {R.drawable.guppy,R.drawable.mechenoseth,R.drawable.barbus,R.drawable.danio};
    private int[] array_plant = {R.string.plant1,R.string.plant2,R.string.plant3,R.string.plant4};
    private int[] array_equipment = {R.string.equipment_1,R.string.equipment_2,R.string.equipment_3,R.string.equipment_4,R.string.equipment_5,R.string.equipment_6};
    private int[] array_introduction = {R.string.introduction_1,R.string.introduction_2,R.string.introduction_3,R.string.introduction_4};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        receiveIntent();
    }
    private  void receiveIntent(){
        Intent i = getIntent();
        if (i!=null){
            category = i.getIntExtra("category",0);
            position = i.getIntExtra("position",0);
        }
        switch (category){
            case 0:
                //iContent.setImageResource(array_fish_image[position]);
                text_content.setText(array_introduction[position]);
                break;
            case 1:
                iContent.setImageResource(array_fish_image[position]);
                text_content.setText(array_fish[position]);
                break;
            case 2:
                //iContent.setImageResource(array_fish_image[position]);
                text_content.setText(array_plant[position]);
                break;
            case 3:
                //iContent.setImageResource(array_fish_image[position]);
                text_content.setText(array_equipment[position]);
                break;
        }
    }
    private void init(){
        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.image_content);
        face1 = Typeface.createFromAsset(this.getAssets(), "fonts/Lobster-Regular.ttf");
        text_content.setTypeface(face1);
    }
}
