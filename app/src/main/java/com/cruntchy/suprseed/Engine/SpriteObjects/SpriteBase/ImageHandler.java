package com.cruntchy.suprseed.Engine.SpriteObjects.SpriteBase;

import com.cruntchy.suprseed.Engine.Images.ImageType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ImageHandler {

    private Map<String, ImageType> spriteImage;
    private String selectedImage;


    // Constructor that takes one sprite image set
    public ImageHandler(String name, ImageType spriteImageSet) {

        if (name != null && spriteImageSet != null) {

            spriteImage = new HashMap<>();
            spriteImage.put(name, spriteImageSet);

            selectedImage = getFirstImageId();
        }

    }

    // Constructor that takes multiple sprite image sets
    public ImageHandler(Map<String, ImageType> sprites) {

        if (sprites != null) {

            this.spriteImage = sprites;

            selectedImage = getFirstImageId();
        }

    }



    public ImageType getSpriteImage(String imageName) {

        verifySpriteList();

        if (spriteImage.containsKey(imageName)) {

            return spriteImage.get(imageName);
        }

        throw new NullPointerException("Image with key: '" + imageName + "' does not exist!");
    }

    public ImageType getSelectedImage() {

        verifySpriteList();

        return spriteImage.get(selectedImage);
    }

    public void setSelectedImage(String selected) {

        // Verify id exists
        if (spriteImage.containsKey(selected)) {

            selectedImage = selected;
            return;
        }

        throw new NullPointerException("Image with key: '" + selected + "' does not exist!");
    }

    private String getFirstImageId() {

        verifySpriteList();

        // Get the first key
        Optional<String> firstKey = spriteImage.keySet().stream().findFirst();

        // Verify key exists
        if (firstKey.isPresent()) {

            return firstKey.get();
        }

        throw new NullPointerException("Could not get image id! Verify sprite list is initialized!");
    }

    public void addImageSet(String name, ImageType spriteSet) {

        verifySpriteList();

        spriteImage.put(name, spriteSet);
    }



    public void verifySpriteList() {

        if (spriteImage == null || spriteImage.size() <= 0) {

            throw new NullPointerException("No sprites are in the image set!");
        }
    }

}