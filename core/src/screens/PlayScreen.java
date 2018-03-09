package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.metroidproyect.game.SuperMetroid;

import Personaje.Samus;
import Util.B2WorldCreator;
import hud.Hud;

public class PlayScreen implements Screen {
	private Hud hud;
	private SuperMetroid game;
	private OrthographicCamera camera;
	private Viewport myViewPort;
	private Samus player;

	// tiled variables
	private TmxMapLoader mapLoader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;

	//private Music music;

	// Box2D Variables
	World world;
	Box2DDebugRenderer b2dr;

	public PlayScreen(SuperMetroid game) {
		this.game = game;
		camera = new OrthographicCamera();
		myViewPort = new FitViewport(SuperMetroid.VIRTUAL_WIDTH / SuperMetroid.PPM,
				SuperMetroid.VIRTUAL_HEIGHT / SuperMetroid.PPM, camera);
		hud = new Hud(game.getBatch());

		mapLoader = new TmxMapLoader();
		map = mapLoader.load("mapa/mapabueno.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1 / SuperMetroid.PPM);
		camera.position.set(myViewPort.getWorldWidth() / 2, myViewPort.getWorldHeight() / 2, 0);

		world = new World(new Vector2(0, -20), true);
		player = new Samus(world,game.getBatch());
		b2dr = new Box2DDebugRenderer();

		new B2WorldCreator(world, map);

		// MUSICA

		// music = SuperMetroid.manager.get("assets/musica/fondoDos.mp3", Music.class);
		// music.setLooping(true);
		// music.setVolume(0.3f);
		// music.play();
	}

	@Override
	public void show() {

	}



	private void update(float delta) {
	//	this.handleInput(delta);
		world.step(1 / 60f, 6, 2);
		camera.position.x = player.b2body.getPosition().x;
		camera.update();
		renderer.setView(camera);
		player.act(delta);
	}

	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderer.render();

		b2dr.render(world, camera.combined);

		game.getBatch().setProjectionMatrix(hud.stage.getCamera().combined);
		hud.stage.draw();
		player.draw(game.getBatch(), 1);

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
		map.dispose();
		renderer.dispose();
		world.dispose();
		b2dr.dispose();
		hud.dispose();
	}

}