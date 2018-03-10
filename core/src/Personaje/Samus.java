package Personaje;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.metroidproyect.game.SuperMetroid;

import actores.Elemento;
import interfaces.Moveable;
import interfaces.Pintable;

public class Samus extends Elemento implements Moveable, Pintable{
	public World world;
	public Body b2body;
	private Texture textura;
	private Batch batch;
	
	public Samus(World world,Batch batch) {
		super(world);
		this.world = world;
		this.batch = batch;
		defineSamus();
	}

	public void defineSamus() {
		BodyDef bdef = new BodyDef();
		// Define la posición del personaje
		bdef.position.set(42 / SuperMetroid.PPM, 42 / SuperMetroid.PPM);
		bdef.type = BodyDef.BodyType.DynamicBody;
		b2body = world.createBody(bdef);
		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		// Define el tamaño del personaje
		shape.setRadius(16 / SuperMetroid.PPM);
		fdef.shape = shape;
		b2body.createFixture(fdef);
		textura = new Texture(Gdx.files.internal("imagenes/hugo.png"));		
	}

	@Override
	public void pintar(SpriteBatch batch, float f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(float sentido) {

			if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && this.b2body.getPosition().y <= 0.7) {
				this.b2body.applyLinearImpulse(new Vector2(0, 4f), this.b2body.getWorldCenter(), true);
			}
			if (Gdx.input.isKeyPressed(Input.Keys.D) && this.b2body.getLinearVelocity().x <= 2) {
				this.b2body.applyLinearImpulse(new Vector2(0.1f, 0), this.b2body.getWorldCenter(), true);
			}
			if (Gdx.input.isKeyPressed(Input.Keys.A) && this.b2body.getLinearVelocity().x >= -2) {
				this.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), this.b2body.getWorldCenter(), true);
				
			}	
		
	}
	
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		mover(delta);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		super.draw(batch, parentAlpha);
		System.out.println("HOLAAA");
	//	batch.end();
		batch.begin();
		batch.draw(textura,this.b2body.getPosition().x + 150, this.b2body.getPosition().y + 100 ,10,10 );
		batch.end();
	}
	
	
	
	
}
