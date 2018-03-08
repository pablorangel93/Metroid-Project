package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
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

	private TmxMapLoader mapLoader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;

	public PlayScreen(SuperMetroid game) {
		this.game = game;
		camera = new OrthographicCamera();
		myViewPort = new FitViewport(SuperMetroid.V_WIDTH, SuperMetroid.V_HEIGHT, camera);
		hud = new Hud(game.batch);

		mapLoader = new TmxMapLoader();
		map = mapLoader.load("mapa/mapa.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		camera.position.set(myViewPort.getWorldWidth() / 2, myViewPort.getWorldHeight() / 2, 0);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	public void handleInput(float dt) {
		if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) {
			camera.position.x -= 100 * dt;
		}

		if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) {
			camera.position.x += 100 * dt;
		}
	}

	private void update(float dt) {
		this.handleInput(dt);
		camera.update();
		renderer.setView(camera);
	}

	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderer.render();

		game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
		hud.stage.draw();
		// game.batch.begin();
		// game.batch.draw(texture, 0, 0);
		// game.batch.end();

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