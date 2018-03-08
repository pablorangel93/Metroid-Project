package com.metroidproyect.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.PlayScreen;

public class SuperMetroid extends Game {
	// Public para poder acceder desde los otros niveles, solo utilizaremos un
	// batch
	public SpriteBatch batch;
	public static final int VIRTUAL_WIDTH = 400;
	public static final int VIRTUAL_HEIGHT = 206;
	
	public static AssetManager manager;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		
//		manager = new AssetManager();
//		manager.load("assets/musica/fondoDos.mp3", Music.class);
//		
//		manager.finishLoading();
		
		// SetScreen carga el nivel que le pasemos, en este caso PlayScreen y le
		// pasamos el juego en sí (supermetroid)
		setScreen(new PlayScreen(this));

	}

	@Override
	public void render() {
		// Delegamos el render a playScreen
		super.render();
	}

}
