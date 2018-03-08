package comun;

public class Rectangulo {
	public Posicion posicion;
	public int ancho, alto;
	public int arriba, derecha, izquierda, abajo;
	int rotacion;

	public Rectangulo(Posicion posicion, int rotacion, int ancho, int alto) {
		super();
		this.posicion = posicion;
		this.rotacion = rotacion;
		if (rotacion == 1) {
			this.ancho = ancho;
			this.alto = alto;
			this.posicion.y -= alto;
		} else {
			this.ancho = alto;
			this.alto = ancho;
		}

	}

	public Rectangulo(Posicion posicion, int ancho, int alto) {
		super();
		this.posicion = posicion;
		this.ancho = ancho;
		this.alto = alto;
	}



}
