package ru.samsung.gamestudio.screens;

import ru.samsung.gamestudio.GameResources;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.parts.MovingBackgroundView;

public class MenuScreen extends ScreenAdapter {

    MyGdxGame myGdxGame;
    MovingBackgroundView backgroundView;

    public MenuScreen (MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        backgroundView = new MovingBackgroundView(GameResources.BACKGROUND_IMG_PATH);
    }

}