package com.epicness.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.ui.SimpleButton;

public class World {

    private SimpleButton buttonA, buttonB;
    private String text;

    public World() {
        Texture tex = new Texture(Gdx.files.internal("badlogic.jpg"));
        buttonA = new SimpleButton(
                0,
                0,
                100,
                50,
                new TextureRegion(tex,100,100),
                null
        );
        buttonA = new SimpleButton(
                200,
                0,
                100,
                50,
                new TextureRegion(tex,100,100),
                null
        );
    }

    public void update() {

    }

    public void draw(SpriteBatch batch) {
        buttonA.draw(batch);
    }
}
