package com.cruntchy.suprseed.Engine.InputHandler.TouchInput;

import android.view.MotionEvent;

import com.cruntchy.suprseed.Engine.ErrorLogger.CentralLogger;
import com.cruntchy.suprseed.Engine.ErrorLogger.ErrorType;
import com.cruntchy.suprseed.Engine.SpriteObjects.SpriteExtensions.Resetable;
import com.cruntchy.suprseed.Engine.SpriteObjects.System.Layerable;
import com.cruntchy.suprseed.Engine.SpriteObjects.System.LayerableQueueComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InputManager implements InputHandler, Resetable {

    // TODO: Make this a singleton

    // Dependency injection
    private final Comparator<Layerable> layerComparer;
    private final List<InputProcessor> inputs;
    private final List<InputListener> listeners;


    // Constructor
    public InputManager() {
        inputs = new ArrayList<>();
        listeners = new ArrayList<>();
        this.layerComparer = new LayerableQueueComparator();
    }


    // VERIFY: is this correct?
    public static InputManager getInstance() {
        return InputSingleton.INSTANCE;
    }

    @Override
    public void processInput(MotionEvent event) {

        // Check if any processors exist
        if (inputs.size() == 0) {

            CentralLogger.logMessage(ErrorType.WARNING, "There are no input processors to handle the given input!");

            return;
        }

        // Get action performed
        for (InputProcessor ih : inputs) {

            ih.processEvent(listeners, event);
        }
    }

    @Override
    public void addInputHandler(InputProcessor inputMethod) {
        inputs.add(inputMethod);
    }

    @Override
    public void registerListener(InputListener listener) {

        // Add the listener
        listeners.add(listener);

        // Resort the listener based on layer depth
        listeners.sort(layerComparer);
    }

    @Override
    public void resetState() {

        listeners.clear();
    }

    // VERIFY: is this correct?
    private static class InputSingleton {
        private static final InputManager INSTANCE = new InputManager();
    }
}