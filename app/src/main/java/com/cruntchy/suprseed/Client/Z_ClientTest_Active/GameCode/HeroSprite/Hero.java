package com.cruntchy.suprseed.Client.Z_ClientTest_Active.GameCode.HeroSprite;

import com.cruntchy.suprseed.Engine.SpriteObjects.SpriteBase.ImageHandler;
import com.cruntchy.suprseed.Engine.SpriteObjects.SpriteBase.Sprite;
import com.cruntchy.suprseed.Engine.SpriteObjects.SpriteExtensions.Logic;
import com.cruntchy.suprseed.Engine.SpriteObjects.SpriteExtensions.Movable;

public class Hero extends Sprite implements Logic, Movable {



    public Hero(ImageHandler imageHandler) {
        super(imageHandler);

        // Register this to the system
        spriteSystem.registerLogicSprite(this);
        spriteSystem.registerMovingSprite(this);

        // Initialize starting state
        this.setX(50); // This should be half the width of the screen
        this.setY(50); // This should be half the width of the screen from the top

        this.setxVel(0.4f); // This should move from the left side of the screen to the right in about 4 seconds
        this.setyVel(0.1f);
    }

    @Override
    public void runLogic() {

        // The image width should be scaled within 100
        //float width = getImageHandler().getSelectedImage().getImage().getWidth();


        if(this.getX() > 100){ // This should see if the sprite moves off the right side of the screen

            setxVel(-getxVel());
        }

        if(this.getY() > 100){

            setyVel(-getyVel());
        }


        /*

        //This should work

        if(this.getX() + width > 100){

            setX(-width);
        }

         */

    }

    @Override
    public void move() {

        // Update location based on velocity
        setX(getX() + getxVel());
        setY(getY() + getyVel());
    }
}
