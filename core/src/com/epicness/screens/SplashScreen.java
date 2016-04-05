package com.epicness.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.KTGame;
import com.epicness.helpers.AssetLoader;
import com.epicness.tweenaccessors.SpriteAccessor;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

public class SplashScreen extends ScreenAdapter {

    // We need a manager for tween engine stuff
    private TweenManager manager;
    private SpriteBatch batch;
    private Sprite sprite;
    private KTGame game;

    public SplashScreen(KTGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        sprite = new Sprite(AssetLoader.splash);

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        // We want the sprite to occupy 70% of the width
        float desiredWidth = width * .7f;
        // The scale factor
        float scale = desiredWidth / sprite.getWidth();

        sprite.setColor(1, 1, 1, 0);
        sprite.setSize(sprite.getWidth() * scale, sprite.getHeight() * scale);
        sprite.setPosition((width / 2) - (sprite.getWidth() / 2), (height / 2)
                - (sprite.getHeight() / 2));

        setupTween();
        batch = new SpriteBatch();
    }

    private void setupTween() {
        Tween.registerAccessor(Sprite.class, new SpriteAccessor());
        manager = new TweenManager();

        // What happens when the tweening ends?
        TweenCallback cb = new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
                // We go to the main menu :D
                game.setScreen(new MainMenuScreen());
            }
        };

        // Tweens the sprite's alpha in .8 seconds, the target alpha is 1
        Tween.to(sprite, SpriteAccessor.ALPHA, .8f).target(1)
                // We want this to use a quadratic interpolation
                // Repeat once as a Yoyo (with .4 seconds between the repetition).
                .ease(TweenEquations.easeInOutQuad).repeatYoyo(1, .4f)
                // We tell the tween to use our callback when the tweening is complete
                .setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE)
                // We specify the manager that will do the work
                .start(manager);
    }

    @Override
    public void render(float delta) {
        // We need to update the manager
        manager.update(delta);
        // Always clear the screen
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // We need to call begin and end when we want to draw using a sprite batch
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

}
