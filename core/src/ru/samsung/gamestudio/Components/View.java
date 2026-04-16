package ru.samsung.gamestudio.Components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public abstract class View implements Disposable {

    float x;
    float y;

    float width;
    float height;
    public View(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public abstract void draw(SpriteBatch batch);

    @Override
    public void dispose() {
    }
}