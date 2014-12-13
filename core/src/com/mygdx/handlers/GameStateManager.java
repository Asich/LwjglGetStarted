package com.mygdx.handlers;

import com.badlogic.gdx.Game;
import com.mygdx.game.MyGame;
import com.mygdx.state.GameState;
import com.mygdx.state.Play;

import java.util.Stack;

/**
 * Created by Murat on 13.12.2014.
 */
public class GameStateManager {
    private MyGame game;
    private Stack<GameState> gameStates;
    public static final int PLAY = 972323;

    public GameStateManager(MyGame game) {
        this.game = game;
        gameStates = new Stack<GameState>();
        pushState(PLAY);
    }

    public MyGame getGame() {
        return game;
    }

    private GameState getGameState(int state){
        if(state == PLAY) return new Play(this);
        return null;
    }

    public void setState(int state){
        popState();
        pushState(state);
    }

    public void pushState(int state){
        gameStates.push(getGameState(state));
    }

    public void popState(){
        GameState g = gameStates.pop();
        g.dispose();
    }

    public void render(){
        gameStates.peek().render();
    }

    public void update(float dt){
        gameStates.peek().udpate(dt);
    }

}
