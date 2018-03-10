package com.metroidproyect.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.PlayScreen;

public class SuperMetroid extends Game {
	// Public para poder acceder desde los otros niveles, solo utilizaremos un
	// batch
	private SpriteBatch batch;
	public static final int VIRTUAL_WIDTH = 400;
	public static final int VIRTUAL_HEIGHT = 206;
	public static final float PPM = 100;

	public static AssetManager manager;

	@Override
	public void create() {
		batch = new SpriteBatch();

		// manager = new AssetManager();
		// manager.load("assets/musica/fondoDos.mp3", Music.class);
		//
		// manager.finishLoading();

		// SetScreen carga el nivel que le pasemos, en este caso PlayScreen y le
		// pasamos el juego en s� (supermetroid)
		setScreen(new PlayScreen(this));

	}

	@Override
	public void render() {
		// Delegamos el render a playScreen
		super.render();
	}

	public SpriteBatch getBatch() {
		return batch;
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}

	
	
}
