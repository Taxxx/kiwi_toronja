package com.epicness.game;

import com.badlogic.gdx.Game;
import com.epicness.helpers.AssetLoader;
import com.epicness.screens.SplashScreen;

public class KTGame extends Game {

    public KTGame() {

    }

    @Override
    public void create() {
        AssetLoader.load();
        setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
