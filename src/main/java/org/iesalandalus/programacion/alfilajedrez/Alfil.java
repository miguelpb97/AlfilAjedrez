package org.iesalandalus.programacion.alfilajedrez;

public class Alfil {

	private Posicion posicion;
	private Color color;
	
	public Alfil() {
		color = Color.NEGRO;
		posicion = new Posicion(8,'f');
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
