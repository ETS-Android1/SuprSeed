package com.cruntchy.suprseed.MainView.GameProcessor.Render.Graphics;

import android.graphics.Canvas;

import com.cruntchy.suprseed.ErrorLogger.ErrorType;
import com.cruntchy.suprseed.ErrorLogger.Logable;
import com.cruntchy.suprseed.MainView.GameProcessor.Render.Coordinates.CoordinateProcessor;

public class RenderProcessor implements RenderHandler {

    // The hardware accelerated canvas provided by a view
    private Canvas canvas;

    // Dependencies
    private Logable logger;
    private CoordinateProcessor coordinateHandler;



    // TODO: This should belong to the 'ImagePreprocessor'
    // The ratio to scale sprites when they are loaded
    private float spriteImageScaleRatio;
    // The scaled size of the canvas
    private float scaledCanvasWidth;
    private float scaledCanvasHeight;


    // The original size of the screen
    private float originalCanvasWidth = 0;
    private float originalCanvasHeight = 0;



    // Constructor
    public RenderProcessor(Logable logger, CoordinateProcessor coordinateHandler){

        // Dependency injection
        this.logger = logger;
        this.coordinateHandler = coordinateHandler;
    }



    @Override
    public void setCanvasSize(int w, int h){

        originalCanvasWidth = w;
        originalCanvasHeight = h;

        logger.logMessage(ErrorType.INFO, "The canvas dimensions have been set...");
    }


    @Override
    public void setCanvas(Canvas canvas){

        // Set the canvas if it is null
        if(this.canvas == null){

            this.canvas = canvas;

            logger.logMessage(ErrorType.INFO, "The canvas has been set...");
        }
    }


    @Override
    public void drawSprite(/*ImageSprite sprite*/){

        // Show warning if canvas is not set
        if(this.canvas == null){

            logger.logMessage(ErrorType.WARNING, "The canvas has not been initialized!");

            return;
        }

        if(this.originalCanvasWidth == 0 || this.originalCanvasHeight == 0){

            logger.logMessage(ErrorType.WARNING, "The canvas dimensions have not been initialized!!");

            return;
        }


        // TODO: Draw a sprite here
        /*

        float[] spriteLoc = {sprite.getX(), sprite.getY()};

        // Get drawing location of sprite
        float[] finalLoc = coordinateHandler.parseFinalLocation(spriteLoc);

        // Draw the sprite at the final location
        canvas.drawBitmap(
            sprite.getImage(),
            finalLoc[0],
            finalLoc[1],
            paint
        );*/
    }


    @Override
    public CoordinateProcessor getCoordinateHandler(){
        return coordinateHandler;
    }



}