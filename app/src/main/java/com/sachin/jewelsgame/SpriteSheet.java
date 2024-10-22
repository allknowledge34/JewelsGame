package com.sachin.jewelsgame;
import static com.sachin.jewelsgame.Constants.*;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

public class SpriteSheet {
    public Bitmap topBG;
    public Bitmap bottomBG;
    public Bitmap bg_middle;
    public Bitmap green;
    public Bitmap blue;
    public Bitmap violet;
    public Bitmap pink;
    public Bitmap yellow;
    public Bitmap red;

    public SpriteSheet (Context context){
        AssetManager assetManager = context.getAssets();

        try{
            InputStream istr = assetManager.open("playbg_top.jpg");
            topBG = BitmapFactory.decodeStream(istr);
            topBG = Bitmap.createBitmap(topBG,0,0,topBG.getWidth(),topBG.getHeight());
            topBG = Bitmap.createScaledBitmap(topBG,screenWidth,cellWidth*5,false);
            istr = assetManager.open("playbg_bottom.jpg");
            bottomBG = BitmapFactory.decodeStream(istr);
            bottomBG = Bitmap.createBitmap(bottomBG,0,0,bottomBG.getWidth(),bottomBG.getHeight());
            bottomBG = Bitmap.createScaledBitmap(bottomBG,screenWidth,bottomBG.getHeight(),false);
            istr = assetManager.open("bg_middle.png");
            bg_middle = BitmapFactory.decodeStream(istr);
            bg_middle = Bitmap.createBitmap(bg_middle,0,0,bg_middle.getWidth(),bg_middle.getHeight());
            bg_middle = Bitmap.createScaledBitmap(bg_middle,screenWidth,cellWidth*9,false);
            istr = assetManager.open("green_jewel.png");
            green = BitmapFactory.decodeStream(istr);
            green = Bitmap.createBitmap(green,0,0,51,51);
            green = Bitmap.createScaledBitmap(green,cellWidth,cellWidth,false);
            istr = assetManager.open("blue.png");
            blue = BitmapFactory.decodeStream(istr);
            blue = Bitmap.createBitmap(blue,0,0,51,51);
            blue = Bitmap.createScaledBitmap(blue,cellWidth,cellWidth,false);
            istr = assetManager.open("violet.png");
            violet = BitmapFactory.decodeStream(istr);
            violet = Bitmap.createBitmap(violet,0,0,51,51);
            violet = Bitmap.createScaledBitmap(violet,cellWidth,cellWidth,false);
            istr = assetManager.open("red.png");
            red = BitmapFactory.decodeStream(istr);
            red = Bitmap.createBitmap(red,0,0,51,51);
            red = Bitmap.createScaledBitmap(red,cellWidth,cellWidth,false);
            istr = assetManager.open("yellow.png");
            yellow = BitmapFactory.decodeStream(istr);
            yellow = Bitmap.createBitmap(yellow,0,0,51,51);
            yellow = Bitmap.createScaledBitmap(yellow,cellWidth,cellWidth,false);
            istr = assetManager.open("pink.png");
            pink = BitmapFactory.decodeStream(istr);
            pink = Bitmap.createBitmap(pink,0,0,51,51);
            pink = Bitmap.createScaledBitmap(pink,cellWidth,cellWidth,false);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
