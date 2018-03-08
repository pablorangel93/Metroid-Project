package Personaje;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.metroidproyect.game.SuperMetroid;

public class Samus extends Sprite {
	public World world;
	public Body b2body;

	public Samus(World world) {
		this.world = world;
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
	}
}
