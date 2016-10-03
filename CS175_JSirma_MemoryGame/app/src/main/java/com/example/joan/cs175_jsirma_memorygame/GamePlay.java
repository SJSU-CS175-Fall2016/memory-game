package com.example.joan.cs175_jsirma_memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Joan on 10/1/16.
 *
 */

// need to add the code to play actual game
public class GamePlay extends AppCompatActivity {
    class pair{
        ImageButton loadbutton;
        int buttonLocation;

        pair(ImageButton ImageButtons, int location){
            loadbutton = ImageButtons;
            buttonLocation= location;
        }

    }

    ArrayList<Integer> images;
    ArrayList<Integer> imageList = new ArrayList<>();
    pair loadBtn;

    // counter for flipped button
    int count = 0;
    //counter for images gone
    int imgCounter ;
    //list for matched images
    ArrayList<Integer> list;
    //store all the images
    ImageButton[] img_Buttons;
    //points
    int points;


  @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_gameplay);

      img_Buttons = new ImageButton[20];
      images=new ArrayList<>();
      imgCounter=0;
      loadImages();
      imageToButton();

      for (int i=0;i<20;i++){
          Log.v("id",imageList.get(i).toString());

      }

      loadBtn = null;

      list = new ArrayList<>();

      img_Buttons[0]=(ImageButton) (findViewById(R.id.imageButton1));
      img_Buttons[1]=(ImageButton) (findViewById(R.id.imageButton2));
      img_Buttons[2]=(ImageButton) (findViewById(R.id.imageButton3));
      img_Buttons[3]=(ImageButton) (findViewById(R.id.imageButton4));
      img_Buttons[4]=(ImageButton) (findViewById(R.id.imageButton5));
      img_Buttons[5]=(ImageButton) (findViewById(R.id.imageButton6));
      img_Buttons[6]=(ImageButton) (findViewById(R.id.imageButton7));
      img_Buttons[7]=(ImageButton) (findViewById(R.id.imageButton8));
      img_Buttons[8]=(ImageButton) (findViewById(R.id.imageButton9));
      img_Buttons[9]=(ImageButton) (findViewById(R.id.imageButton10));
      img_Buttons[10]=(ImageButton) (findViewById(R.id.imageButton11));
      img_Buttons[11]=(ImageButton) (findViewById(R.id.imageButton12));
      img_Buttons[12]=(ImageButton) (findViewById(R.id.imageButton13));
      img_Buttons[13]=(ImageButton) (findViewById(R.id.imageButton14));
      img_Buttons[14]=(ImageButton) (findViewById(R.id.imageButton15));
      img_Buttons[15]=(ImageButton) (findViewById(R.id.imageButton16));
      img_Buttons[16]=(ImageButton) (findViewById(R.id.imageButton17));
      img_Buttons[17]=(ImageButton) (findViewById(R.id.imageButton18));
      img_Buttons[18]=(ImageButton) (findViewById(R.id.imageButton19));
      img_Buttons[19]=(ImageButton) (findViewById(R.id.imageButton20));
      for (int i = 0; i < 20; i++) {
          img_Buttons[i].setVisibility(View.VISIBLE);
      }

    }

    public void checkCards(String str){
        String btnNum = str.substring(11);
        int btn_num = Integer.parseInt(btnNum) - 1;
        img_Buttons[btn_num].setImageResource(imageList.get(btn_num));
        Log.v("Button Clicked", String.valueOf(btn_num));
        img_Buttons[btn_num].setTag(imageList.get(btn_num));

        if (loadBtn== null || img_Buttons[btn_num] != loadBtn.loadbutton)
            count++;
        if (count == 1) {
            loadBtn = new pair(img_Buttons[btn_num], btn_num);
            YoYo.with(Techniques.Wobble)
                    .duration(2000)
                    .playOn(img_Buttons[btn_num]);
        }
        if (count == 2) {
            count = 0;
            if (img_Buttons[btn_num].getTag().equals(loadBtn.loadbutton.getTag())) {
                YoYo.with(Techniques.Wobble)
                        .duration(2000)
                        .playOn(img_Buttons[btn_num]);
                img_Buttons[btn_num].setVisibility(View.INVISIBLE);
                loadBtn.loadbutton.setVisibility(View.INVISIBLE);

                list.add(imageList.get(btn_num));
                list.add(imageList.get(loadBtn.buttonLocation));

                imgCounter += 2;
                points++;
                updatePoints();
            } else {
                img_Buttons[btn_num].setImageResource(R.drawable.icon);
                YoYo.with(Techniques.Wobble)
                        .duration(2000)
                        .playOn(img_Buttons[btn_num]);
                loadBtn.loadbutton.setImageResource(R.drawable.icon);
                loadBtn.loadbutton = null;
            }
        }
    }

    public void updatePoints() {
        TextView tv =(TextView)(findViewById(R.id.points));
        tv.setText(String.valueOf(points));

    }

    public void onClick(View view){
        String str = " ";
        switch (view.getId()){
            case R.id.imageButton1:
                str = getResources().getResourceEntryName(R.id.imageButton1);
                checkCards(str);
                break;
            case R.id.imageButton2:
                str = getResources().getResourceEntryName(R.id.imageButton2);
                checkCards(str);
                break;

            case R.id.imageButton3:
                str = getResources().getResourceEntryName(R.id.imageButton3);
                checkCards(str);
                break;

            case R.id.imageButton4:
                str = getResources().getResourceEntryName(R.id.imageButton4);
                checkCards(str);
                break;

            case R.id.imageButton5:
                str = getResources().getResourceEntryName(R.id.imageButton5);
                checkCards(str);
                break;

            case R.id.imageButton6:
                str = getResources().getResourceEntryName(R.id.imageButton6);
                checkCards(str);
                break;

            case R.id.imageButton7:
                str = getResources().getResourceEntryName(R.id.imageButton7);
                checkCards(str);
                break;

            case R.id.imageButton8:
                str = getResources().getResourceEntryName(R.id.imageButton8);
                checkCards(str);
                break;

            case R.id.imageButton9:
                str = getResources().getResourceEntryName(R.id.imageButton9);
                checkCards(str);
                break;

            case R.id.imageButton10:
                str = getResources().getResourceEntryName(R.id.imageButton11);
                checkCards(str);
                break;

            case R.id.imageButton12:
                str = getResources().getResourceEntryName(R.id.imageButton12);
                checkCards(str);
                break;

            case R.id.imageButton13:
                str = getResources().getResourceEntryName(R.id.imageButton13);
                checkCards(str);
                break;
            case R.id.imageButton14:
                str = getResources().getResourceEntryName(R.id.imageButton14);
                checkCards(str);
                break;

            case R.id.imageButton15:
                str = getResources().getResourceEntryName(R.id.imageButton15);
                checkCards(str);
                break;

            case R.id.imageButton16:
                str = getResources().getResourceEntryName(R.id.imageButton16);
                checkCards(str);
                break;

            case R.id.imageButton17:
                str = getResources().getResourceEntryName(R.id.imageButton17);
                checkCards(str);
                break;

            case R.id.imageButton18:
                str = getResources().getResourceEntryName(R.id.imageButton18);
                checkCards(str);
                break;

            case R.id.imageButton19:
                str = getResources().getResourceEntryName(R.id.imageButton19);
                checkCards(str);
                break;

            case R.id.imageButton20:
                str = getResources().getResourceEntryName(R.id.imageButton20);
                checkCards(str);
                break;


        }
    }

    public void imageToButton() {
        imageList.addAll(images);
        imageList.addAll(images);
        Collections.shuffle(imageList);

    }

    public void loadImages(){
        images.add(R.drawable.card1);
        images.add(R.drawable.card2);
        images.add(R.drawable.card3);
        images.add(R.drawable.card4);
        images.add(R.drawable.card5);
        images.add(R.drawable.card6);
        images.add(R.drawable.card7);
        images.add(R.drawable.card8);
        images.add(R.drawable.card9);
        images.add(R.drawable.card10);
        Collections.shuffle(images);

    }

    public boolean onCreateOptionMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;


    }

    public boolean onOptionSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.new_game:
                finish();
                Intent intent = new Intent(this, GamePlay.class);
                startActivity(intent);
                return true;

            case R.id.action_shuffle:
                count = 0;
                loadBtn = null;
                shuffle();
        }

        return true;


    }
    public void shuffle(){

        for(int i = 0; i < list.size(); i++){
            imageList.remove(new Integer(list.get(i)));
        }

        list = new ArrayList<>();
        Log.d("List Size", String.valueOf(imageList.size()));
        Collections.shuffle(imageList);

        newOrder();

    }
    public void newOrder(){
        for(int i = 0; i < 20 - imgCounter; i++){
            img_Buttons[i].setVisibility(View.VISIBLE);
            img_Buttons[i].setImageResource(R.drawable.icon);

        }
        for(int i = 0; i < imgCounter; i++){
            img_Buttons[20 - imgCounter + i].setVisibility(View.INVISIBLE);
        }


    }
}
