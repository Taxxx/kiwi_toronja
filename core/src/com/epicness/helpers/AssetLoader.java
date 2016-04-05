package com.epicness.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AssetLoader {

    public static Texture splash;
    public static BitmapFont font;

    public static void load() {
        splash = new Texture(Gdx.files.internal("splash.png"));
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
    }

    public static void dispose() {

    }
}
