package com.cruntchy.suprseed.Engine.SpriteObjects.SpriteBase;

import com.cruntchy.suprseed.Engine.MainView.GameProcessor.Render.Graphics.RenderHandler;
import com.cruntchy.suprseed.Engine.SpriteObjects.SpriteExtensions.Renderable;

public abstract class Sprite implements Renderable {

    private float x;
    private float y;

    private float xVel;
    private float yVel;

    private boolean enabled;
    private boolean show;

    // Dependency
    private ImageHandler imageHandler;


    // Constructor that takes one sprite image set
    protected Sprite(ImageHandler imageHandler) {

        // Dependency injection
        this.imageHandler = imageHandler;
    }



    // Getters / setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getxVel() {
        return xVel;
    }

    public void setxVel(float xVel) {
        this.xVel = xVel;
    }

    public float getyVel() {
        return yVel;
    }

    public void setyVel(float yVel) {
        this.yVel = yVel;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public ImageHandler getImageHandler() {
        return imageHandler;
    }

    public void setImageHandler(ImageHandler imageHandler) {
        this.imageHandler = imageHandler;
    }

    @Override
    public void draw(RenderHandler renderer){

        renderer.drawSprite(this);
    }

}