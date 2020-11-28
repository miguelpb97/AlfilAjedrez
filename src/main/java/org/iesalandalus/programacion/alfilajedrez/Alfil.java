package org.iesalandalus.programacion.alfilajedrez;

public class Alfil {

	private Posicion posicion;
	private Color color;
	
	public Alfil() {
		color = Color.NEGRO;
		posicion = new Posicion(8,'f');
	}
	
	public Alfil(Color color) {
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
		if (color == Color.NEGRO) {
			color = Color.NEGRO;
			posicion = new Posicion(8,'f');
		} else if (color == Color.BLANCO) {
			color = Color.BLANCO;
			posicion = new Posicion(1,'f');}
		setColor(color);	
	}
	
	public Alfil(Color color, char columna) {
		if (columna < 'a' || columna > 'h') {
			throw new IllegalArgumentException ("ERROR: Columna no válida.");
		}
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
		if (color == Color.BLANCO) {
			this.color = color;
			posicion = new Posicion(1,columna);
		} else if(color == Color.NEGRO){
			this.color = color;
			posicion = new Posicion(8,columna);
		}
	}

	public Posicion getPosicion() {
		return posicion;
	}
	
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public Color getColor() {
		return color;
	}
	
	private void setColor(Color color) {
		this.color = color;
	}
	
}
