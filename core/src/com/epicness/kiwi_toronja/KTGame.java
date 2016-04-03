package com.epicness.kiwi_toronja;

import com.badlogic.gdx.Game;
import com.epicness.helpers.AssetLoader;
import com.epicness.screens.SplashScreen;

public class KTGame extends Game {

    @Override
    public void create() {
        AssetLoader.load();
        setScreen(new SplashScreen());
    }
}
