package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import comun.Posicion;
import comun.Rectangulo;

public abstract class Elemento extends Actor {
	public Posicion posicion;
	public Texture imagen;
	public Rectangulo cuerpo;
	public TextureRegion textureRegion;

	public Elemento(String imagen, Posicion posicion, int rotacion, int largo, int ancho) {
		super();
		this.imagen = new Texture(Gdx.files.internal(imagen));
		this.posicion = posicion;
		this.setX(posicion.x);
		this.setY(posicion.y);
		this.cuerpo = new Rectangulo(posicion, rotacion, largo, ancho);
	}

	public Elemento(String imagen, Posicion posicion) {
		super();
		this.imagen = new Texture(Gdx.files.internal(imagen));
		this.posicion = posicion;
		this.setX(posicion.x);
		this.setY(posicion.y);
		this.cuerpo = new Rectangulo(posicion, 0, this.imagen.getWidth(), this.imagen.getHeight());
	}

	public Elemento(Posicion posicion, TextureRegion region) {
		super();
		this.posicion = posicion;
		this.textureRegion = region;
		this.setX(posicion.x);
		this.setY(posicion.y);
		this.cuerpo = new Rectangulo(posicion, 0, 0, 0);
	}
	
	public Elemento(Posicion posicion, Rectangle rectangle, int rotacion) {
		super();
		this.posicion = posicion;
		this.setX(posicion.x);
		this.setY(posicion.y);
		this.cuerpo = new Rectangulo(posicion, rotacion, (int)rectangle.width, (int)rectangle.height);
	}
	
	public Elemento(Posicion posicion,Rectangle rectangle) {
		super();
		this.posicion = posicion;
		this.setX(posicion.x);
		this.setY(posicion.y);
		this.cuerpo = new Rectangulo(posicion, (int)rectangle.width, (int)rectangle.height);
	}

}
