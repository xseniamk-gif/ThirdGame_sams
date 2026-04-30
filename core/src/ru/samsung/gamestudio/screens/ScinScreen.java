package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.GameResources;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.parts.ButtonView;
import ru.samsung.gamestudio.parts.ImageView;
import ru.samsung.gamestudio.parts.MovingBackgroundView;

public class ScinScreen extends ScreenAdapter {


    MyGdxGame myGdxGame;

    MovingBackgroundView background;
    ButtonView sh1;
    ButtonView sh2;
    ButtonView sh3;
    ButtonView buttonSettings;
    ButtonView sh4, bu;
    ImageView ship1, ship2, ship3, ship4;

    int gamePoints;
    public String color = "blue";

    public ScinScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        sh1 = new ButtonView(50, 200, 100, 40);
        sh2 = new ButtonView(500, 200, 100, 40);
        sh3 = new ButtonView(50, 400, 100, 40);
        sh4 = new ButtonView(500, 400, 100, 40);
        buttonSettings = new ButtonView(860, 300, 100, 40);
        background = new ButtonView("textures/background_top.png");
        ship1 = new ImageView(30, 30, GameResources.SHIP_IMG_PATH1);
        ship2 = new ImageView(30, 40, GameResources.SHIP_IMG_PATH2);
        ship3 = new ImageView(30, 50, GameResources.SHIP_IMG_PATH3);
        ship4 = new ImageView(30, 60, GameResources.SHIP_IMG_PATH4);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.justTouched()) {

            Vector3 touch = myGdxGame.camera.unproject(
                    new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0)
            );

            if (sh1.isHit((int) touch.x, (int) touch.y)) {
                color = "red";
            }
            if (sh2.isHit((int) touch.x, (int) touch.y)) {
                color = "green";
            }
            if (sh3.isHit((int) touch.x, (int) touch.y)) {
                color = "yellow";
            }
            if (buttonBlue.isHit((int) touch.x, (int) touch.y)) {
                color = "blue";

            }
            if (buttonMenu.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.setScreen(myGdxGame.screenMenu);
            }
        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        background.draw(myGdxGame.batch);
        buttonBlue.draw(myGdxGame.batch);
        buttonRed.draw(myGdxGame.batch);
        buttonYellow.draw(myGdxGame.batch);
        buttonGreen.draw(myGdxGame.batch);
        buttonMenu.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();

    }
}