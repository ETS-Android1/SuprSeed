package com.cruntchy.suprseed.Engine.SpriteObjects.System;

import com.cruntchy.suprseed.Engine.SpriteObjects.Register.UpdatableRegister;

public class LogicSystem implements UpdatableRegister<Logic> {

    private UpdatableRegister<Logic> objectRegister;

    // Eager loading singleton
    private static final LogicSystem INSTANCE = new LogicSystem();


    // Constructor
    // Private to prevent client use of 'new' keyword
    private LogicSystem() {
        objectRegister = new ObjectLogicizer();
    }

    public static LogicSystem getInstance() {
        return INSTANCE;
    }


    @Override
    public void registerObject(Logic sprite) {

        objectRegister.registerObject(sprite);
    }

    @Override
    public void removeObject(Logic sprite) {
        objectRegister.removeObject(sprite);
    }


    // Run logic for all registered sprites
    @Override
    public void update() {
        objectRegister.update();
    }

    // Clear currently registered sprites
    @Override
    public void removeAllObjects() {
        objectRegister.removeAllObjects();
    }
}
