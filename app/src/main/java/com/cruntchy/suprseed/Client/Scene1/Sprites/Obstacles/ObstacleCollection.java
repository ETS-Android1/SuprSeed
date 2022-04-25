package com.cruntchy.suprseed.Client.Scene1.Sprites.Obstacles;

import com.cruntchy.suprseed.Client.Scene1.Data.BounceData;
import com.cruntchy.suprseed.Client.Scene1.Data.GameOverData;
import com.cruntchy.suprseed.Engine.Core.MainView.GameProcessor.Render.Graphics.RenderHandler;
import com.cruntchy.suprseed.Engine.Core.Scenes.SceneHeirarchy.BaseScene;
import com.cruntchy.suprseed.Engine.Core.SpriteObjects.DefaultComponents.Component;
import com.cruntchy.suprseed.Engine.Core.SpriteObjects.DefaultComponents.ResetableComponent;
import com.cruntchy.suprseed.Engine.Core.SpriteObjects.SpriteBase.ImageHandler;
import com.cruntchy.suprseed.Engine.Core.SpriteObjects.SpriteBase.Sprite;
import com.cruntchy.suprseed.Engine.Core.System.Logic;
import com.cruntchy.suprseed.Engine.Core.System.RenderableAndLayerable;
import com.cruntchy.suprseed.Engine.Lib.AssetLoader.AssetLoader;
import com.cruntchy.suprseed.Engine.Lib.Images.SpriteImage;
import com.cruntchy.suprseed.Engine.Lib.SoundPlayer.SoundMixer;

import java.util.ArrayList;
import java.util.Random;

public class ObstacleCollection implements Logic, RenderableAndLayerable {


    private final ArrayList<Sprite> obstacleSprites;
    private final ArrayList<ImageHandler> obstacleImages;

    private final int maxObstacles = 15;

    private final Random rand = new Random();


    // Dependencies
    private final Component obstacleCollision;
    private final ResetableComponent obstacleSpawner;
    private final Component obstacleMovement;
    private final GameOverData gameOverData;


    public ObstacleCollection(BaseScene parentScene, AssetLoader assets, BounceData heroBounceData, Sprite hero, SoundMixer<String> soundEngine, GameOverData gameOverData) {

        this.gameOverData = gameOverData;

        obstacleSprites = new ArrayList<>();
        obstacleImages = new ArrayList<>();

        // TODO: actually load images in asset loader!!!
        // Load images here
        obstacleImages.add(new ImageHandler("bat", (SpriteImage) assets.getAnimation("bat")));
        obstacleImages.add(new ImageHandler("bee", (SpriteImage) assets.getAnimation("bee")));
        obstacleImages.add(new ImageHandler("bird", (SpriteImage) assets.getAnimation("bird")));
        obstacleImages.add(new ImageHandler("duck", (SpriteImage) assets.getAnimation("duck")));
        obstacleImages.add(new ImageHandler("ghost", (SpriteImage) assets.getAnimation("ghost")));

        // Initialize obstacle sprites here
        for(int i = 0; i < maxObstacles; i++){

            obstacleSprites.add(new ObstacleSprite(parentScene, obstacleImages.get(rand.nextInt(obstacleImages.size()))));
        }


        // Initialize obstacle components
        obstacleCollision = new ObstacleCollisionComponent(hero, obstacleSprites, soundEngine, gameOverData);
        obstacleSpawner = new ObstacleSpawnerComponent(obstacleSprites, obstacleImages);
        obstacleMovement = new ObstacleMovementComponent(heroBounceData, obstacleSprites, hero);


        // Set starting state of obstacles
        obstacleSpawner.resetState();


        // Register this with the parent
        parentScene.logicRegister.registerObject(this);
        parentScene.imageRegister.registerObject(this);
    }




    @Override
    public void runLogic() {

        // Stop logic if hero dies
        if (!gameOverData.isGameOver()) {
            obstacleSpawner.update();
            obstacleMovement.update();
            obstacleCollision.update();
        }
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public int getLayerDepth() {
        return 0;
    }

    @Override
    public void draw(RenderHandler renderer) {

        for (Sprite s : obstacleSprites) {
            s.draw(renderer);
        }
    }

    @Override
    public boolean isDrawable() {
        return true;
    }

    public void resetState() {
        obstacleSpawner.resetState();
    }
}
