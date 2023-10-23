package Unidad2;

public class PruebaMatriz {

	public static void main(String[] args) {
		
		capturaMatriz();

	}
	
	public static void capturaMatriz() {
		
		Matriz a = null, b = null, c = null;
		String sel = "";
		
		int matricesACrear = Integer.parseInt(Tools.Desplegable("Cuantas matrices vas a crear?", "2,3"));
		int filasa = 0, columnasa = 0;
		int filasb = 0, columnasb = 0;
		int filasc = 0, columnasc = 0;
		
		do {
			sel = Tools.Desplegable("Selecciona alguna opcion para las matrices", "Agregar valor a la matriz,Ver Matriz,Suma de matrices,Resta de matrices,Salir");
			switch(sel) {
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Agregar valor a la matriz":
				if((matricesACrear == 2 || matricesACrear == 3) && a == null) {
					Tools.imprimeSalida("Vamos a comenzar capturando la matriz a");
					filasa = Tools.leerEntero("Dame el tamaño de las filas de la matriz");
					columnasa = Tools.leerEntero("Dame el tamaño de las columnas de la matriz");
					a = new Matriz(filasa, columnasa);
					a = CapturaDatosMatriz(filasa , columnasa);
				} else if((matricesACrear == 2 || matricesACrear == 3) && b == null) {
					Tools.imprimeSalida("Vamos a comenzar capturando la matriz b");
					filasb = Tools.leerEntero("Dame el tamaño de las filas de la matriz");
					columnasb = Tools.leerEntero("Dame el tamaño de las columnas de la matriz");
					b = new Matriz(filasb, columnasb);
					b = CapturaDatosMatriz(filasb , columnasb);
				}else if (matricesACrear == 3 && c == null) {
					Tools.imprimeSalida("Vamos a comenzar capturando la matriz c");
					filasc = Tools.leerEntero("Dame el tamaño de las filas de la matriz");
					columnasc = Tools.leerEntero("Dame el tamaño de las columnas de la matriz");
					c = new Matriz(filasc, columnasc);
					c = CapturaDatosMatriz(filasc , columnasc);
				} else 
					Tools.imprimeSalida("Ya has llenado las " + matricesACrear + " matrices");
				break;
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Ver Matriz":
				if (a != null) {
					String cad = "";
					cad += ImprimeMatrices(filasa, columnasa, a);
					if (b != null) {
						cad += "\n" + ImprimeMatrices(filasb, columnasb, b);
						if (c != null)
							cad += "\n" + ImprimeMatrices(filasc, columnasc, c);
					}
					Tools.imprimeSalida("Matrices capturadas: \n\n" + cad);
				} else {
					Tools.imprimeSalida("Aun no se han capturado las matrices");
				}
				break;
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Suma de matrices":
				if (a != null && b != null && c != null) {
					String seleccionaMatrizSum = Tools.Desplegable("Selecciona la primera matriz", "a,b,c");
					switch(seleccionaMatrizSum) {
					case "a":
						String seleccionaMatriz2a = Tools.Desplegable("Selecciona la segunda matriz", "b,c");
						switch(seleccionaMatriz2a) {
						case "b":
							Matriz resab;
							resab = sumaMatrices(a, b);
							Tools.imprimeSalida(ImprimeMatrices(resab.getFilas(), resab.getColumnas(), resab));
							break;
						case "c":
							Matriz resac;
							resac = sumaMatrices(a, c);
							Tools.imprimeSalida(ImprimeMatrices(resac.getFilas(), resac.getColumnas(), resac));
							break;
						}
						break;
					case "b":
						String seleccionaMatriz2b = Tools.Desplegable("Selecciona la segunda matriz", "a,c");
						switch(seleccionaMatriz2b) {
						case "a":
							Matriz resba;
							resba = sumaMatrices(b, a);
							Tools.imprimeSalida(ImprimeMatrices(resba.getFilas(), resba.getColumnas(), resba));
							break;
						case "c":
							Matriz resbc;
							resbc = sumaMatrices(b, c);
							Tools.imprimeSalida(ImprimeMatrices(resbc.getFilas(), resbc.getColumnas(), resbc));
							break;
						}
						break;
					case "c":
						String seleccionaMatriz2c = Tools.Desplegable("Selecciona la segunda matriz", "a,b");
						switch(seleccionaMatriz2c) {
						case "a":
							Matriz resca;
							resca = sumaMatrices(c, a);
							Tools.imprimeSalida(ImprimeMatrices(resca.getFilas(), resca.getColumnas(), resca));
							break;
						case "c":
							Matriz rescb;
							rescb = sumaMatrices(b, c);
							Tools.imprimeSalida(ImprimeMatrices(rescb.getFilas(), rescb.getColumnas(), rescb));
							break;
						}
						break;
					case "Suma todas":
						Matriz resabc;
						resabc = sumaMatrices(a , b);
						resabc = sumaMatrices(c, resabc);
						Tools.imprimeSalida(ImprimeMatrices(resabc.getFilas(), resabc.getColumnas(), resabc));
						break;
					}
				}else if (a != null && b != null) {
					Tools.imprimeSalida("Solamente tenemos capuradas la matriz a y b, asi que seran sumadas");
					Matriz res2;
					res2 = sumaMatrices(a, b);
					Tools.imprimeSalida(ImprimeMatrices(res2.getFilas(), res2.getColumnas(), res2));
				}else if(a != null || b != null || c != null) {
					Tools.imprimeSalida("Solamente hay una matriz capturada.");
				}else 
					Tools.imprimeSalida("No hay matrices capturadas.");
				break;
				
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Resta de matrices":
				if (a != null && b != null && c != null) {
					String seleccionaMatrizRes = Tools.Desplegable("Selecciona la primera matriz", "a,b,c");
					switch(seleccionaMatrizRes) {
					case "a":
						String seleccionaMatriz2a = Tools.Desplegable("Selecciona la matriz a restar", "b,c");
						switch(seleccionaMatriz2a) {
						case "b":
							Matriz resab;
							resab = restaMatrices(a, b);
							Tools.imprimeSalida(ImprimeMatrices(resab.getFilas(), resab.getColumnas(), resab));
							break;
						case "c":
							Matriz resac;
							resac = restaMatrices(a, c);
							Tools.imprimeSalida(ImprimeMatrices(resac.getFilas(), resac.getColumnas(), resac));
							break;
						}
						break;
					case "b":
						String seleccionaMatriz2b = Tools.Desplegable("Selecciona la matriz a restar", "a,c");
						switch(seleccionaMatriz2b) {
						case "a":
							Matriz resba;
							resba = restaMatrices(b, a);
							Tools.imprimeSalida(ImprimeMatrices(resba.getFilas(), resba.getColumnas(), resba));
							break;
						case "c":
							Matriz resbc;
							resbc = restaMatrices(b, c);
							Tools.imprimeSalida(ImprimeMatrices(resbc.getFilas(), resbc.getColumnas(), resbc));
							break;
						}
						break;
					case "c":
						String seleccionaMatriz2c = Tools.Desplegable("Selecciona la matriz a restar", "a,b");
						switch(seleccionaMatriz2c) {
						case "a":
							Matriz resca;
							resca = restaMatrices(c, a);
							Tools.imprimeSalida(ImprimeMatrices(resca.getFilas(), resca.getColumnas(), resca));
							break;
						case "c":
							Matriz rescb;
							rescb = restaMatrices(b, c);
							Tools.imprimeSalida(ImprimeMatrices(rescb.getFilas(), rescb.getColumnas(), rescb));
							break;
						}
						break;
					}
				}else if (a != null && b != null) {
					Tools.imprimeSalida("Solamente tenemos capuradas la matriz a y b, asi que seran sumadas");
					Matriz res2;
					res2 = sumaMatrices(a, b);
					Tools.imprimeSalida(ImprimeMatrices(res2.getFilas(), res2.getColumnas(), res2));
				}else if(a != null || b != null || c != null) {
					Tools.imprimeSalida("Solamente hay una matriz capturada.");
				}else 
					Tools.imprimeSalida("No hay matrices capturadas.");
				break;
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Salir":
				Tools.imprimeSalida("Saliendo del programa...");
				break;
			}
		}while(!sel.equalsIgnoreCase("Salir"));
		
	}
	
	public static Matriz CapturaDatosMatriz(int f, int c) {
		Matriz x = new Matriz(f,c);
		
		for(int i = 0; i < f ; i++) {
			for(int j = 0; j < c ; j++) {
				int valor = Tools.leerInt("Dame el valor en la posicion " + (i+1) + "x" + (j+1));
	            x.setElemento(i, j, valor);
			}
		}
		
		return x;
		
	}
	
	public static String ImprimeMatrices(int filas, int columnas, Matriz x) {
		
		String cad = "     ";
		for (int i = 0; i < columnas; i++) {
			cad += (i+1) + "     ";
		}
		cad += "\n";
		for (int i = 0; i < filas ; i++) {
			cad+= (i+1) + " ";
			for(int j = 0; j < columnas ; j++) {
	            cad += "|" + x.getElemento(i, j) + "| ";
			}
			cad += "\n";
		}
		
		return cad;
		
	}
	
	public static Matriz sumaMatrices(Matriz x, Matriz z) {
		Matriz r = new Matriz(x.getFilas(), x.getColumnas());
		for(int i = 0; i < r.getFilas(); i++) {
			for(int j = 0; j < r.getColumnas(); j++) {
				r.setElemento(i, j, (x.getElemento(i, j) + z.getElemento(i, j)));
			}
		}
		return r;
	}
	
	public static Matriz restaMatrices(Matriz x, Matriz z) {
		Matriz r = new Matriz(x.getFilas(), x.getColumnas());
		for(int i = 0; i < r.getFilas(); i++) {
			for(int j = 0; j < r.getColumnas(); j++) {
				r.setElemento(i, j, (x.getElemento(i, j) - z.getElemento(i, j)));
			}
		}
		return r;
	}

}
