package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = MyGame.TITLE;
        config.width = MyGame.V_WIDTH * MyGame.SCALE;
        config.height = MyGame.V_HEIGHT * MyGame.SCALE;
		new LwjglApplication(new MyGame(), config);
	}
}
