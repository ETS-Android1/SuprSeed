package com.cruntchy.suprseed.Client.Z_ClientTest_Active.GameCode.Assets;

import com.cruntchy.suprseed.Engine.AssetLoader.AssetLoader;
import com.cruntchy.suprseed.Engine.AssetLoader.FolderParser;
import com.cruntchy.suprseed.Engine.AssetLoader.Streamable;
import com.cruntchy.suprseed.Engine.Images.ImageCollectionAnimator;
import com.cruntchy.suprseed.Engine.Images.ImageSingle;
import com.cruntchy.suprseed.Engine.SpriteObjects.System.SpriteSystem;

public class AssetScriptTest extends AssetLoader {


    public AssetScriptTest(Streamable assetStreamer, FolderParser folderParser){
        super(assetStreamer, folderParser);
    }


    @Override
    public void loadAssets() {

        // CLIENT CODE GOES HERE!!!

        //ImageSingle hero = new ImageSingle("Images/Hero/frog_jump_fullframe.png", 10, assetStreamer);
        //images.put("hero", hero);

        ImageCollectionAnimator hero = new ImageCollectionAnimator("Images/Hero", 10, assetStreamer, folderParser, 2, true);
        animations.put("hero", hero);
        SpriteSystem.getInstance().registerAnimationImage(hero);


        ImageSingle background = new ImageSingle("Images/Grassy_Mountains_preview_fullcolor.png", 11f, assetStreamer);
        images.put("background", background);


        //ImageSingle hero = new ImageSingle("path/to/image.png", 1, assetStreamer);

        //ImageSingle enemies = new ImageSingle("path/to/image.png", 1, assetStreamer);

        //ImageCollection enemy = new ImageCollection("path/to/folder", 1, assetStreamer, folderParser);

        //ImageCollectionAnimator bullets = new ImageCollectionAnimator("some/folder/path", 1, assetStreamer, folderParser, 20, true);
    }

}
