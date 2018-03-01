package com.metroidproyect.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.PlayScreen;

public class SuperMetroid extends Game {
	// Public para poder acceder desde los otros niveles, solo utilizaremos un batch
	public SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();
		// SetScreen carga el nivel que le pasemos, en este caso PlayScreen y le
		// pasamos el juego en sí (supermetroid)
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render() {
		//Delegamos el render a playScreen
		super.render();
	}

}
