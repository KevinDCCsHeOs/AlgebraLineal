package Unidad2;

public class Matriz {
	
	private int[][] matrizBidi;
	
	public Matriz(int filas, int columnas) {
		
		this.matrizBidi = new int[filas][columnas];
		
	}
	
	public void setElemento(int fila, int columna, int valor) {
        matrizBidi[fila][columna] = valor;
    }
	
	public int getElemento(int fila, int columna) {
		return matrizBidi[fila][columna];
	}
	
	public int getFilas() {
		return matrizBidi.length;
	}
	
	public int getColumnas() {
		return matrizBidi[0].length;
	}

}
