package com.cruntchy.suprseed.Engine.Images;

public class GlobalFrameStepper {

    // Eager loading singleton
    private static final GlobalFrameStepper INSTANCE = new GlobalFrameStepper();
    // Global frame stepper
    // Tracks which frame in an animation should be in
    private final int startingFrame = 1;
    private final int frameTime = 60;
    private int frameStep = startingFrame;


    // Constructor
    // Private to prevent client use of 'new' keyword
    private GlobalFrameStepper() {

    }

    public static GlobalFrameStepper getInstance() {
        return INSTANCE;
    }

    // Cycles through 60 frames of animation
    public void moveToNextFrame() {


        //Log.d("ImageAnimator", "NEXT FRAME QUEUED!");

        if (frameStep <= frameTime) {

            frameStep++;
        } else {

            frameStep = startingFrame;
        }

    }


    public int getFrameStep() {
        return frameStep;
    }

    public int getFrameTime() {
        return frameTime;
    }
}
