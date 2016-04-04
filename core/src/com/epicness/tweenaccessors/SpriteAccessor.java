package com.epicness.tweenaccessors;

import com.badlogic.gdx.graphics.g2d.Sprite;

import aurelienribon.tweenengine.TweenAccessor;

public class SpriteAccessor implements TweenAccessor<Sprite> {

    public static final int ALPHA = 1;

    @Override
    public int getValues(Sprite target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case ALPHA:
                // We store the values from our target that we want to change in an array
                returnValues[0] = target.getColor().a;
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public void setValues(Sprite target, int tweenType, float[] newValues) {
        switch (tweenType) {
            case ALPHA:
                // We receive the modified values and set them in our target
                target.setColor(1, 1, 1, newValues[0]);
                break;
        }
    }

}
