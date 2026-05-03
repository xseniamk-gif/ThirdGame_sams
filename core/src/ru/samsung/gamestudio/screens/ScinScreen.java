package ru.samsung.gamestudio.screens;

import static ru.samsung.gamestudio.managers.MemoryManager.loadIsSoundOn;
import static ru.samsung.gamestudio.managers.MemoryManager.saveSoundSettings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

import ru.samsung.gamestudio.GameResources;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.managers.MemoryManager;
import ru.samsung.gamestudio.managers.SkinManager;
import ru.samsung.gamestudio.parts.ButtonView;
import ru.samsung.gamestudio.parts.ImageView;
import ru.samsung.gamestudio.parts.MovingBackgroundView;
import ru.samsung.gamestudio.parts.TextView;

public class ScinScreen extends ScreenAdapter {


    MyGdxGame myGdxGame;

    MovingBackgroundView background;
    ButtonView sh1;
    ButtonView sh2;
    ButtonView sh3;
    ButtonView buttonSettings;
    ButtonView sh4;
    ImageView ship1, ship2, ship3, ship4;
    SkinManager skinManager;
    int gamePoints;
    TextView selectedTextView;
    public String ship = GameResources.SHIP_IMG_PATH1;
    Texture texture;

    public ScinScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;


        background = new MovingBackgroundView(GameResources.BLACKOUT_MIDDLE_IMG_PATH);

        // Кнопки выбора скинов с правильными позициями
        sh1 = new ButtonView(100, 1100, 200, 60, myGdxGame.commonBlackFont,
                GameResources.BUTTON_SHORT_BG_IMG_PATH, "Ship 1");
        sh2 = new ButtonView(100, 900, 200, 60, myGdxGame.commonBlackFont,
                GameResources.BUTTON_SHORT_BG_IMG_PATH, "Ship 2");
        sh3 = new ButtonView(100, 700, 200, 60, myGdxGame.commonBlackFont,
                GameResources.BUTTON_SHORT_BG_IMG_PATH, "Ship 3");
        sh4 = new ButtonView(100, 500, 200, 60, myGdxGame.commonBlackFont,
                GameResources.BUTTON_SHORT_BG_IMG_PATH, "Ship 4");
        selectedTextView = new TextView(myGdxGame.commonWhiteFont, 100, 450,
                "Selected: " + getSkinName(SkinManager.selectedSkin));


        buttonSettings = new ButtonView(280, 350, 160, 70, myGdxGame.commonBlackFont,
                GameResources.BUTTON_SHORT_BG_IMG_PATH, "Back");


        ship1 = new ImageView(350, 1100, GameResources.SHIP_IMG_PATH1, 100, 100);
        ship2 = new ImageView(350, 900, GameResources.SHIP_IMG_PATH2, 100, 100);
        ship3 = new ImageView(350, 700, GameResources.SHIP_IMG_PATH3, 100, 100);
        ship4 = new ImageView(350, 500, GameResources.SHIP_IMG_PATH4, 100, 100);}

    private String getSkinName(String path) {
        if (path.equals(GameResources.SHIP_IMG_PATH1)) return "Ship 1";
        if (path.equals(GameResources.SHIP_IMG_PATH2)) return "Ship 2";
        if (path.equals(GameResources.SHIP_IMG_PATH3)) return "Ship 3";
        if (path.equals(GameResources.SHIP_IMG_PATH4)) return "Ship 4";
        return "Unknown";
    }




    void handleInput() {

        if (Gdx.input.justTouched()) {

            Vector3 touch = myGdxGame.camera.unproject(
                    new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0)
            );

            if (sh1.isHit((int) touch.x, (int) touch.y)) {
                skinManager.selectedSkin = GameResources.SHIP_IMG_PATH1;
                MemoryManager.saveSelectedSkin(GameResources.SHIP_IMG_PATH1);  // сохраняем
                selectedTextView.setText("Selected: Ship 1");
            }
            if (sh2.isHit((int) touch.x, (int) touch.y)) {
                skinManager.selectedSkin = GameResources.SHIP_IMG_PATH2;
                MemoryManager.saveSelectedSkin(GameResources.SHIP_IMG_PATH3);
                selectedTextView.setText("Selected: Ship 2");
            }
            if (sh3.isHit((int) touch.x, (int) touch.y)) {
                skinManager.selectedSkin = GameResources.SHIP_IMG_PATH3;
                MemoryManager.saveSelectedSkin(GameResources.SHIP_IMG_PATH3);
                selectedTextView.setText("Selected: Ship 3");
            }
            if (sh4.isHit((int) touch.x, (int) touch.y)) {
                skinManager.selectedSkin = GameResources.SHIP_IMG_PATH4;
                MemoryManager.saveSelectedSkin(GameResources.SHIP_IMG_PATH4);
                selectedTextView.setText("Selected: Ship 4");
            }
            if (buttonSettings.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.setScreen(myGdxGame.settingsScreen);
            }
        }
    }
    @Override
    public void render(float delta) {

        handleInput();

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();


        background.draw(myGdxGame.batch);
        sh1.draw(myGdxGame.batch);
        sh2.draw(myGdxGame.batch);
        sh3.draw(myGdxGame.batch);
        sh4.draw(myGdxGame.batch);
        buttonSettings.draw(myGdxGame.batch);
        ship1.draw(myGdxGame.batch);
        ship2.draw(myGdxGame.batch);
        ship3.draw(myGdxGame.batch);
        ship4.draw(myGdxGame.batch);
        selectedTextView.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }


    @Override
    public void dispose() {
        background.dispose();
        ship1.dispose();
        ship2.dispose();
        ship3.dispose();
        ship4.dispose();
        selectedTextView.dispose();

    }
}