package ru.samsung.gamestudio.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.MyGdxGame;

public class GameScreen implements Screen {

    final int pointCounterMarginTop = 60;
    final int pointCounterMarginRight = 400;

    MyGdxGame myGdxGame;


    int gamePoints;
    boolean isGameOver;
    boolean ifPause = false;
    int c = 1;

    public GameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;


    }


    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {


    }

    @Override
    public void dispose() {

    }

}


