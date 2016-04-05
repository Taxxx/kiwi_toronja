package com.epicness.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.epicness.game.Renderer;
import com.epicness.game.GunRunWorld;

public class MainMenuScreen extends ScreenAdapter {

    private GunRunWorld gunRunWorld;
    private Renderer renderer;
    private float runTime;

    public MainMenuScreen() {
        gunRunWorld = new GunRunWorld();
        //Gdx.input.setInputProcessor(new InputHandler());
        renderer = new Renderer(gunRunWorld);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        runTime += delta;
        gunRunWorld.update(delta);
        renderer.render(delta, runTime);
    }

}
