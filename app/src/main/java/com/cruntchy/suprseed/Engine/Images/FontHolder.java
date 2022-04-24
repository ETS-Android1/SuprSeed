package com.cruntchy.suprseed.Engine.Images;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.cruntchy.suprseed.Engine.MainView.GameProcessor.Render.CanvasData;

public class FontHolder extends FontPaintRoller implements FontRetriever<String> {

    private final Typeface loadedFont;
    private final float fontSize;
    private final String fontId;
    private final FontPaintRoller fontPainter;

    // Constructor
    public FontHolder(int fontResourceId, String fontId, float fontSize, Context context, FontPaintRoller fontPainter) {

        this.loadedFont = context.getResources().getFont(fontResourceId);

        this.fontSize = CanvasData.getInstance().formatCoordinateToCanvas(fontSize);

        this.fontId = fontId;

        this.fontPainter = fontPainter;

        fontPainter.setFontHolder(this);
    }

    public FontHolder(int fontResourceId, float fontSize, Context context, FontPaintRoller fontPainter) {

        this.loadedFont = context.getResources().getFont(fontResourceId);

        this.fontSize = CanvasData.getInstance().formatCoordinateToCanvas(fontSize);

        this.fontId = "";

        this.fontPainter = fontPainter;

        fontPainter.setFontHolder(this);
    }



    /*
    Getters
     */

    @Override
    public Typeface getFont(){

        return loadedFont;
    }

    @Override
    public float getFontSize() {

        return fontSize;
    }

    @Override
    public String getFontId() {
        return fontId;
    }

    @Override
    public void updatePaint(Paint paint) {

        fontPainter.updatePaint(paint);
    }
}
