package org.iesalandalus.programacion.alfilajedrez;

import javax.naming.OperationNotSupportedException;

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
			posicion = new Posicion(1,'f');
		}
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
	
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Color getColor() {
		return color;
	}
	
	private void setColor(Color color) {
		this.color = color;
	}
	
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException  {
		if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		if (pasos <= 0) {
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
		}
		switch(direccion) {
			case ARRIBA_DERECHA: {
				try {
					int fila = posicion.getFila();
					char columna = posicion.getColumna();
					if ( columna < 'a' || columna > 'h') {
						throw new IllegalArgumentException("ERROR: Columna no válida.");
					}
					for (int i = 0; i <= pasos - 1 ;i++){
						fila++;
						columna++;
					}
					posicion =new Posicion(fila, columna);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
				break;
			}
			case ABAJO_DERECHA: {
				try {
					int fila = posicion.getFila();
					char columna = posicion.getColumna();
					for (int i = 0; i <= pasos - 1 ;i++){
						fila--;
						columna++;
					}
					posicion =new Posicion(fila, columna);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
				break;
			}
			case ABAJO_IZQUIERDA: {
				try {
					int fila = posicion.getFila();
					char columna = posicion.getColumna();
					for (int i = 0; i <= pasos - 1 ;i++){
						fila--;
						columna--;
					}
					posicion =new Posicion(fila, columna);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
				break;
			}
			case ARRIBA_IZQUIERDA: {
				try {
					int fila = posicion.getFila();
					char columna = posicion.getColumna();
					for (int i = 0; i <= pasos - 1 ;i++){
						fila++;
						columna--;
					}
					posicion =new Posicion(fila, columna);
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
				break;
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alfil other = (Alfil) obj;
		if (color != other.color)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return posicion + ", color=" + color;
	}
	
}