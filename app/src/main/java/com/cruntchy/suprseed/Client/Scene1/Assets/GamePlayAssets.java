package com.cruntchy.suprseed.Client.Scene1.Assets;

import com.cruntchy.suprseed.Engine.AssetLoader.AssetLoader;
import com.cruntchy.suprseed.Engine.AssetLoader.FolderParser;
import com.cruntchy.suprseed.Engine.AssetLoader.Streamable;
import com.cruntchy.suprseed.Engine.Images.ImageCollectionAnimator;
import com.cruntchy.suprseed.Engine.Images.ImageSingle;
import com.cruntchy.suprseed.Engine.Scenes.SceneHeirarchy.BaseScene;

public class GamePlayAssets extends AssetLoader {


    public GamePlayAssets(BaseScene parentScene, Streamable assetStreamer, FolderParser folderParser){
        super(parentScene, assetStreamer, folderParser);
    }


    @Override
    public void loadAssets(BaseScene parentScene) {

        // Client can load sprites images here


        // Hero
        ImageCollectionAnimator hero = new ImageCollectionAnimator(parentScene,"Images/Hero", 10, assetStreamer, folderParser, 2, true);
        animations.put("hero", hero);


        // Background
        ImageSingle background = new ImageSingle("Images/Background/Grassy_Mountains_preview_fullcolor.png", 11f, assetStreamer);
        images.put("background", background);



        // Enemies
        int enemyAnimationSpeed = 15;

        ImageCollectionAnimator bat = new ImageCollectionAnimator(parentScene,"Images/Enemies/bat", 7, assetStreamer, folderParser, enemyAnimationSpeed, true);
        animations.put("bat", bat);

        ImageCollectionAnimator bee = new ImageCollectionAnimator(parentScene,"Images/Enemies/bee", 7, assetStreamer, folderParser, enemyAnimationSpeed, true);
        animations.put("bee", bee);

        ImageCollectionAnimator bird = new ImageCollectionAnimator(parentScene,"Images/Enemies/bird", 7, assetStreamer, folderParser, enemyAnimationSpeed, true);
        animations.put("bird", bird);

        ImageCollectionAnimator duck = new ImageCollectionAnimator(parentScene,"Images/Enemies/duck", 7, assetStreamer, folderParser, enemyAnimationSpeed, true);
        animations.put("duck", duck);

        ImageCollectionAnimator ghost = new ImageCollectionAnimator(parentScene,"Images/Enemies/ghost", 7, assetStreamer, folderParser, enemyAnimationSpeed, true);
        animations.put("ghost", ghost);



        // User interface
        ImageSingle pause = new ImageSingle("Images/UI/pause_button.png", 1f, assetStreamer);
        images.put("pause_button", pause);

        ImageSingle pauseText = new ImageSingle("Images/UI/pause_text.png", 1f, assetStreamer);
        images.put("pause_text", pauseText);
    }

}
