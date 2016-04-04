package com.epicness.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {

    public static Texture splash;

    public static void load() {
        splash = new Texture(Gdx.files.internal("splash.png"));
    }

    public static void dispose() {

    }
}
