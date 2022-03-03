package com.cruntchy.suprseed.Engine.MainView.GameProcessor.Render;

import com.cruntchy.suprseed.Engine.ErrorLogger.CentralLogger;
import com.cruntchy.suprseed.Engine.ErrorLogger.ErrorType;

public class CanvasData {

    // TODO: Make this a proper singleton!
    // TODO: Make this an observer pattern

    private final float scaledWidth = 100;
    private float originalHeight;
    private float originalWidth;
    private float scaledHeight;
    private float spriteScaleRatio;

    // Default target resolution
    private float targetResolution = 1080;

    // VERIFY: is this correct?
    public static CanvasData getInstance() {
        return CanvasData.CanvasDataSingleton.INSTANCE;
    }

    // For client
    public void setTargetResolution(float targetResolutionWidth) {
        this.targetResolution = targetResolutionWidth;
    }

    // For engine
    public void setDimensions(float height, float width) {

        this.originalHeight = height;
        this.originalWidth = width;

        CentralLogger.logMessage(ErrorType.INFO, "The canvas dimensions have been set...");

        setSpriteScale();

        scaleDimensions();
    }

    private void setSpriteScale() {

        spriteScaleRatio = originalWidth / targetResolution;
    }

    private void scaleDimensions() {

        scaledHeight = (originalHeight / originalWidth) * 100;
    }

    // This upscales a value from 0 to 100 to the canvas' size
    public float formatCoordinateToCanvas(float input) {

        // Converts a given value to scale to the same point on a given canvas
        /*
        Example: sprite has x set to 25. This will be converted to (canvas width * 0.25).
         */

        return ((input / 100f) * CanvasData.getInstance().getOriginalWidth());
    }

    // This downscales a value from the canvas to 0 to 100
    public float formatCanvasToCoordinate(float input) {

        return (input / getOriginalWidth()) * 100;
    }

    public float getOriginalHeight() {
        return originalHeight;
    }

    public float getOriginalWidth() {
        return originalWidth;
    }

    public float getScaledHeight() {
        return scaledHeight;
    }

    public float getScaledWidth() {
        return scaledWidth;
    }

    public float getSpriteScaleRatio() {
        return spriteScaleRatio;
    }

    // VERIFY: is this correct?
    private static class CanvasDataSingleton {
        private static final CanvasData INSTANCE = new CanvasData();
    }


}
