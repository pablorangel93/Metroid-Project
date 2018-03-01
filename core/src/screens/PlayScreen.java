package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.metroidproyect.game.SuperMetroid;

import hud.Hud;

public class PlayScreen implements Screen {
	private Hud hud;
	private SuperMetroid game;
	Texture texture;
	private OrthographicCamera camera;
	private Viewport myViewPort;

	public PlayScreen(SuperMetroid game) {
		this.game = game;
		// texture = new Texture("badlogic.jpg");
		camera = new OrthographicCamera();
		myViewPort = new FitViewport(SuperMetroid.V_WIDTH, SuperMetroid.V_HEIGHT, camera);
		hud = new Hud(game.batch);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
		hud.stage.draw();
		game.batch.begin();
		// game.batch.draw(texture, 0, 0);
		game.batch.end();

	}

	@Override
	public void resize(int width, int height) {
		myViewPort.update(width, height);

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}