package com.mygdx.state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGame;
import com.mygdx.handlers.GameStateManager;

/**
 * Created by Murat on 13.12.2014.
 */
public abstract class GameState {

    protected GameStateManager manager;
    protected MyGame game;

    protected SpriteBatch sb;
    protected OrthographicCamera cam;
    protected OrthographicCamera hudCam;

    public GameState(GameStateManager gsm){
        manager = gsm;
        game = manager.getGame();
        sb = game.getBatch();
        cam = game.getCam();
        hudCam = game.getHudCam();
    }

    public abstract void handleInput();

    public abstract void dispose();

    public abstract void udpate(float dt);

    public abstract void render();
}
