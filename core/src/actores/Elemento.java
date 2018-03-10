package actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import comun.Posicion;
import comun.Rectangulo;

public abstract class Elemento extends Actor {
	public Posicion posicion;
	public Texture imagen;
	public Rectangulo cuerpo;
	public TextureRegion textureRegion;

	public Elemento(World world) {
		super();

	}


}
