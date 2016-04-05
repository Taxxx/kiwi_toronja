package com.epicness.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderer {

    private SpriteBatch batch;
    private GunRunWorld gunRunWorld;

    public Renderer(GunRunWorld gunRunWorld) {
        this.gunRunWorld = gunRunWorld;
        batch = new SpriteBatch();
    }

    public void render(float delta, float runTime) {
        batch.begin();
        gunRunWorld.draw(batch);
        batch.end();
    }
}
