package com.sachin.jewelsgame;

import android.graphics.Canvas;

public class DrawThread extends Thread{

    private GameView view;
    public static int fps;
    public static int ups;
    private boolean running;

    public DrawThread(GameView gameView){
        this.view = gameView;
    }
    public void setRunning(boolean run){
        running = run;
    }

    @Override
    public void run() {
        final int MAX_FPS = 60;
        final int MAX_UPS = 60;

        final double fOPTIMAL_TIME = (double) 1000000000 / MAX_FPS;
        final double uOPTIMAL_TIME = (double) 1000000000 / MAX_UPS;

        double uDeltaTime = 0, fDelaTime = 0;
        int frame = 0,updates= 0;
        long startTime = System.nanoTime();
        long timer = System.currentTimeMillis();

        while (running){
            long currentTime = System.nanoTime();
            uDeltaTime += (currentTime - startTime);
            fDelaTime += (currentTime - startTime);
            startTime = currentTime;

            if (uDeltaTime >= uOPTIMAL_TIME){
                view.update();
                updates ++;
                uDeltaTime -= uOPTIMAL_TIME;
            }
            if (fDelaTime > fOPTIMAL_TIME){
                Canvas canvas = view.getHolder().lockCanvas(null);
                if (canvas!=null){
                    synchronized (view.getHolder()){
                        view.draw(canvas);
                    }
                    view.getHolder().unlockCanvasAndPost(canvas);
                }
                frame++;
                fDelaTime -= fOPTIMAL_TIME;
            }
            if (System.currentTimeMillis() - timer >= 1000){
                fps = frame;
                ups = updates;
                updates = 0;
                frame = 0;
                timer += 1000;
            }
        }
    }
}
