package Unidad2;

import javax.swing.JOptionPane;

public class PruebaMatriz2 {

	public static void main(String[] args) {
		
		CapturaMatrices();

	}
	
	public static void CapturaMatrices() {
		
		Matriz[] matrices = new Matriz[10];
		byte cont = 0;
		String sel = "";
		
		do {
			
			sel = Tools.Desplegable("Selecciona la opcion que mas te guste para manipular las matrices",
					"Agregar matriz,Ver matriz especifica,Sumar matrices,Restar matrices,Producto escalar,"
					+ "Productos escalares de dos vectores,Productos escalares de varios vectores,"
					+ "Producto de 2 matrices,Salir");
			switch(sel) {
//---------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Agregar matriz":
				if (cont < matrices.length) {
					matrices[cont] = capturaValoresEnMatriz(
							Tools.leerEntero("Dame el tamaño de filas para esta matriz"),
							Tools.leerEntero("Dame el tamaño de columnas para esta matriz"));
					cont++;
				} else 
					Tools.salidaError("Has guardado la maxima cantidad de matrices");
				break;
//---------------------------------------------------------------------------------------------------------------------------------------------------------				
			case "Ver matriz especifica":
				if(cont > 0) {
					if(cont == 1) {
						Tools.imprimeSalida("Matriz registrada: \n" + ImprimeMatrices(matrices[0]));
					} else {
						String cadNum = "";
						for(int i = 0; i < cont; i++) {
							if(i != cont-1)
								cadNum += (i + 1) + ",";
							else 
								cadNum += (i + 1);
						}
						int seleccionaMatriz = Integer.parseInt(Tools.Desplegable( "Selecciona la matriz que deseas visualizar" , cadNum));
						Tools.imprimeSalida( "Matriz seleccionada: \n" + ImprimeMatrices(matrices[seleccionaMatriz-1]) );
					}
				} else 
					Tools.salidaError("Aun no has registrado ninguna matriz");
				break;
//---------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Sumar matrices":
				if(cont < 2) 
					Tools.salidaError("No has registrado al menos dos matrices");
				else if (cont == 2) {
					if(mismoTamaño(matrices[0],matrices[1])) {
						Matriz res = new Matriz(matrices[0].getFilas(), matrices[0].getColumnas());
						res = sumaMatrices(matrices[0], matrices[1]);
						Tools.imprimeSalida("La matriz resultante es: \n" + ImprimeMatrices(res));
						if (cont != matrices.length - 1) {
							if (Tools.Desplegable("¿Deseas guardar esa matriz?", "Si,No") == "Si") {
								matrices[cont] = res;
								cont++;
							}
						}
					} 
				} else {
					String cadNum = "";
					for(int i = 0; i < cont; i++) {
						if(i != cont-1)
							cadNum += (i + 1) + ",";
						else 
							cadNum += (i + 1);
					}
					int seleccionaMatriz1sum = Integer.parseInt(Tools.Desplegable( "Selecciona la primera matriz que deseas sumar" , cadNum));
					for(int i = 0; i < cont; i++) {
						if (i != seleccionaMatriz1sum) {
							if(i != cont-1)
								cadNum += (i + 1) + ",";
							else 
								cadNum += (i + 1);
						}
					}
					int seleccionaMatriz2sum = Integer.parseInt(Tools.Desplegable( "Selecciona la segunda matriz que deseas sumar" , cadNum));
					
					if(mismoTamaño(matrices[seleccionaMatriz1sum], matrices[seleccionaMatriz2sum])) {
							
						Matriz res = new Matriz(matrices[0].getFilas(), matrices[0].getColumnas());
						res = sumaMatrices(matrices[0], matrices[1]);
						Tools.imprimeSalida("La matriz resultante es: \n" + ImprimeMatrices(res));
						do {
							sel = Tools.Desplegable("Selecciona alguna opcion", "Sumar otra matriz a la resultante,Guardar la matriz actual,Ninguna");
							switch(sel) {
							case "Sumar otra matriz a la resultante":
								
								for(int i = 0; i < cont; i++) {
									if (i != seleccionaMatriz1sum && i != seleccionaMatriz2sum) {
										if(i != cont-1)
											cadNum += (i + 1) + ",";
										else 
											cadNum += (i + 1);
									}
								}
								int seleccionaSiguienteMatriz = Integer.parseInt(Tools.Desplegable( "Selecciona la siguiente matriz que deseas sumar" , cadNum));
								if(mismoTamaño(res, matrices[seleccionaSiguienteMatriz])) {
									res = sumaMatrices(res, matrices[seleccionaSiguienteMatriz - 1]);
									Tools.imprimeSalida("La matriz resultante es: \n" + ImprimeMatrices(res));
								} else {
									Tools.salidaError("Las matrices no se pueden sumar");
								}
								break;
							case "Guardar la matriz actual":
								if (cont < matrices.length) {
									matrices[cont] = res;
									cont++;
								} else
									Tools.salidaError("Ya no puedes guardar mas matrices");
								break;
							case "Ninguna":
								break;
							}
						}while(!sel.equalsIgnoreCase("Ninguna") && !sel.equalsIgnoreCase("Guardar la matriz actual"));
					} else {
						Tools.salidaError("No se pueden sumar estas matrices");
					}
				}
			break;
//---------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Restar matrices":
				if(cont < 2) 
					Tools.salidaError("No has registrado al menos dos matrices");
				else if (cont == 2) {
					if(mismoTamaño(matrices[0],matrices[1])) {
						Matriz res = new Matriz(matrices[0].getFilas(), matrices[0].getColumnas());
						sel = Tools.Boton("Selecciona la primera matriz", "1,2");
						switch(sel) {
						case "1":
							res = restaMatrices(matrices[0], matrices[1]);
							Tools.imprimeSalida("La matriz resultante es: \n" + ImprimeMatrices(res));
							break;
						case "2":
							res = restaMatrices(matrices[1], matrices[0]);
							Tools.imprimeSalida("La matriz resultante es: \n" + ImprimeMatrices(res));
							break;
						}
						if (cont != matrices.length - 1) {
							if (Tools.Desplegable("¿Deseas guardar esa matriz?", "Si,No") == "Si") {
								matrices[cont] = res;
								cont++;
							}
						}
					} 
				}else {
					String cadNum = "";
					for(int i = 0; i < cont; i++) {
						if(i != cont-1)
							cadNum += (i + 1) + ",";
						else 
							cadNum += (i + 1);
					}
					int seleccionaMatriz1res = Integer.parseInt(Tools.Desplegable( "Selecciona la primera matriz" , cadNum));
					for(int i = 0; i < cont; i++) {
						if (i != seleccionaMatriz1res) {
							if(i != cont-1)
								cadNum += (i + 1) + ",";
							else 
								cadNum += (i + 1);
						}
					}
					int seleccionaMatriz2res = Integer.parseInt(Tools.Desplegable( "Selecciona la segunda matriz, la cual sera restada a la primera" , cadNum));
					
					if(mismoTamaño(matrices[seleccionaMatriz1res], matrices[seleccionaMatriz2res])) {
							
						Matriz res = new Matriz(matrices[0].getFilas(), matrices[0].getColumnas());
						res = restaMatrices(matrices[0], matrices[1]);
						Tools.imprimeSalida("La matriz resultante es: \n" + ImprimeMatrices(res));
						do {
							sel = Tools.Desplegable("Selecciona alguna opcion", "Restar otra matriz a la resultante,Matriz menos resultante,Guardar la matriz actual,Ninguna");
							switch(sel) {
							case "Restar otra matriz a la resultante":
								
								for(int i = 0; i < cont; i++) {
									if (i != seleccionaMatriz1res && i != seleccionaMatriz2res) {
										if(i != cont-1)
											cadNum += (i + 1) + ",";
										else 
											cadNum += (i + 1);
									}
								}
								int seleccionaSiguienteMatriz = Integer.parseInt(Tools.Desplegable( "Selecciona la siguiente matriz que deseas restar" , cadNum));
								if(mismoTamaño(res, matrices[seleccionaSiguienteMatriz])) {
									res = restaMatrices(res, matrices[seleccionaSiguienteMatriz - 1]);
									Tools.imprimeSalida("La matriz resultante es: \n" + ImprimeMatrices(res));
								} else {
									Tools.salidaError("Las matrices no se pueden restar");
								}
								break;
							case "Matriz menos resultante":
								for(int i = 0; i < cont; i++) {
									if (i != seleccionaMatriz1res && i != seleccionaMatriz2res) {
										if(i != cont-1)
											cadNum += (i + 1) + ",";
										else 
											cadNum += (i + 1);
									}
								}
								int seleccionaSiguienteMatriz2 = Integer.parseInt(Tools.Desplegable( "Selecciona la siguiente matriz que deseas sumar" , cadNum));
								if(mismoTamaño(res, matrices[seleccionaSiguienteMatriz2])) {
									res = restaMatrices(matrices[seleccionaSiguienteMatriz2], res);
									Tools.imprimeSalida("La matriz resultante es: \n" + ImprimeMatrices(res));
								} else {
									Tools.salidaError("Las matrices no se pueden restar");
								}
								break;
							case "Guardar la matriz actual":
								if (cont < matrices.length) { 
									matrices[cont] = res;
									cont++;
								} else
									Tools.salidaError("Ya no puedes guardar mas matrices");
								break;
							case "Ninguna":
								break;
							}
						}while(!sel.equalsIgnoreCase("Ninguna") && !sel.equalsIgnoreCase("Guardar la matriz actual"));
					} else {
						Tools.salidaError("No se pueden restar");
					}
				}
				break;
//---------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Producto escalar":
				if (cont != 0) {
					String cadNum= "";
					for(int i = 0; i < cont; i++) {
						if(i != cont-1)
							cadNum += (i + 1) + ",";
						else 
							cadNum += (i + 1);
					}
					int matrizSelec = Integer.parseInt(Tools.Desplegable("Selecciona una matriz", cadNum));
					Matriz res = calculaProductoEscalar(matrices[matrizSelec - 1], Tools.leerDouble("Dame el valor por el cual se multiplicara cada elemento de la matriz"));
					Tools.imprimeSalida("La matriz resultante es: " + ImprimeMatrices(res));
					if(cont < matrices.length) {
						if(Tools.Desplegable("¿Deseas guardar esta matriz?","Si,No").equals("Si") ) {
							matrices[cont] = res;
							cont++;
						}
					} 
				}
				break;
//---------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Productos escalares de dos vectores":
				if (cont > 1) {
					String cadNum= "";
					for(int i = 0; i < cont; i++) {
						if(i != cont-1)
							cadNum += (i + 1) + ",";
						else 
							cadNum += (i + 1);
					}
					int matrizSelec1 = Integer.parseInt(Tools.Desplegable("Selecciona una matriz", cadNum));
					Matriz res1 = calculaProductoEscalar(matrices[matrizSelec1 - 1], Tools.leerDouble("Dame el valor por el cual se multiplicara cada elemento de la matriz"));
					int matrizSelec2 = Integer.parseInt(Tools.Desplegable("Selecciona una matriz", cadNum));
					Matriz res2 = calculaProductoEscalar(matrices[matrizSelec2 - 1], Tools.leerDouble("Dame el valor por el cual se multiplicara cada elemento de la matriz"));
					if (mismoTamaño(res1, res2)) {
						Matriz resF = new Matriz(matrices[matrizSelec1].getFilas(),matrices[matrizSelec1].getColumnas());
						sel = Tools.Desplegable("¿Qué operación quieres realizar?", "Suma,Resta");
						switch(sel) {
						case "Suma":
							resF = sumaMatrices(res1, res2);
							break;
						case "Resta":
							if(Tools.Desplegable("Selecciona la matriz que sera negativa","primera,segunda").equals("primera")) 
								resF = restaMatrices(res2, res1);
							else 
								resF = restaMatrices(res1, res2);
						}
						if(cont < matrices.length) {
							if(Tools.Desplegable("¿Deseas guardar esta matriz?","Si,No").equals("Si")) {
								matrices[cont] = resF;
								cont++;
							}
						} 
					} else 
						Tools.salidaError("No se pueden sumar o restar, puesto que no son del mismo tamaño");
				} else 
					Tools.salidaError("No se han registrado al menos dos matrices");
				break;
//---------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Productos escalares de varios vectores":
				if (cont > 1) {
					String cadNum= "";
					for(int i = 0; i < cont; i++) {
						if(i != cont - 1)
							cadNum += (i + 1) + ",";
						else 
							cadNum += (i + 1);
					}
					int matrizSelec1 = Integer.parseInt(Tools.Desplegable("Selecciona una matriz", cadNum));
					Matriz res1 = calculaProductoEscalar(matrices[matrizSelec1 - 1], Tools.leerDouble("Dame el valor por el cual se multiplicara cada elemento de la matriz"));
					int matrizSelec2 = Integer.parseInt(Tools.Desplegable("Selecciona una matriz", cadNum));
					Matriz res2 = calculaProductoEscalar(matrices[matrizSelec2 - 1], Tools.leerDouble("Dame el valor por el cual se multiplicara cada elemento de la matriz"));
					if (mismoTamaño(res1, res2)) {
						Matriz resF = new Matriz(matrices[matrizSelec1].getFilas(),matrices[matrizSelec2].getColumnas());
						sel = Tools.Desplegable("¿Qué operación quieres realizar?", "Suma,Resta");
						switch(sel) {
						case "Suma":
							resF = sumaMatrices(res1, res2);
							break;
						case "Resta":
							if(Tools.Desplegable("Selecciona la matriz que sera negativa","primera,segunda").equals("primera")) 
								resF = restaMatrices(res2, res1);
							else 
								resF = restaMatrices(res1, res2);
							break;
						}
						String sel2 = "";
						do {
							int matrizSelecx = Integer.parseInt(Tools.Desplegable("Selecciona una matriz", cadNum));
							Matriz resx = calculaProductoEscalar(matrices[matrizSelecx - 1], Tools.leerDouble("Dame el valor por el cual se multiplicara cada elemento de la matriz"));
							if (mismoTamaño(resF,resx)) {
								resF = new Matriz(matrices[matrizSelec1].getFilas(),matrices[matrizSelec2].getColumnas());
								sel = Tools.Desplegable("¿Qué operación quieres realizar?", "Suma,Resta,Guardar matriz,Ninguna");
								switch(sel) {
								case "Suma":
									resF = sumaMatrices(resF, resx);
									break;
								case "Resta":
									if(Tools.Desplegable("Selecciona la matriz que sera negativa","primera,segunda") == "primera") 
										resF = restaMatrices(resF, resx);
									else 
										resF = restaMatrices(resx, resF);
									break;
								case "Guardar matriz":
									if(cont < matrices.length) {
											matrices[cont] = resF;
											cont++;
									} else
										Tools.salidaError("No se puede guardar, puesto que ya no hay espacio");
									break;
								case "Ninguna":
									break;
								}
							}else 
								Tools.salidaError("No se puede sumar o restar, puesto que no son del mismo tamaño");
						}while(!sel2.equalsIgnoreCase("Guardar matriz"));
					} else
						Tools.salidaError("No se pueden sumar o restar, puesto que no son del mismo tamaño");
				} else 
					Tools.salidaError("No se han registrado aun al menos 3 matrices");
				break;
//---------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Producto de 2 matrices":
				if(cont > 1) {
					String op = "";
					for(int i = 0; i < cont; i++) {
						if (i != cont - 1)
							op += (i + 1) + ",";
						else 
							op += (i + 1);
					}
					int selecMatriz1 = Integer.parseInt(Tools.Desplegable("Selecciona la primera matriz a multiplicar", op));
					Matriz matrizSelec1 = matrices[selecMatriz1 - 1];
					int selecMatriz2 = Integer.parseInt(Tools.Desplegable("Selecciona la primera matriz a multiplicar", op));
					Matriz matrizSelec2 = matrices[selecMatriz2 - 1];
					if (matrizSelec1.getColumnas() == matrizSelec2.getFilas()) {
						Matriz res = calculaProductoMatrices(matrizSelec1, matrizSelec2);
						Tools.imprimeSalida("La matriz resultante es: " + ImprimeMatrices(res));
						if(cont != matrices.length - 1) {
							if(Tools.Desplegable("¿Deseas guardar esta matriz?", "Si,No").equals("Si")) {
								matrices[cont] = res;
								cont++;
							}
						}
					} else if (matrizSelec2.getColumnas() == matrizSelec1.getFilas()) {
						Matriz res = calculaProductoMatrices(matrizSelec2, matrizSelec1);
						Tools.imprimeSalida("La matriz resultante es: " + ImprimeMatrices(res));
						if(cont != matrices.length - 1) {
							if(Tools.Desplegable("¿Deseas guardar esta matriz?", "Si,No").equals("Si")) {
								matrices[cont] = res;
								cont++;
							}
						}
					} else 
						Tools.salidaError("No se pueden multiplicar estas dos matrices");
				} else {
					Tools.salidaError("Aun no se han registrado al menos 2 matrices");
				}
				break;
//---------------------------------------------------------------------------------------------------------------------------------------------------------
			case "Salir":
				Tools.imprimeSalida("Saliendo del porgrama...");
				break;
			}
		}while(!sel.equalsIgnoreCase("Salir"));
		
	}
	
	public static Matriz capturaValoresEnMatriz(int f, int c) {
		Matriz x = new Matriz(f,c);
		
		for(int i = 0; i < f ; i++) {
			for(int j = 0; j < c ; j++) {
				int valor = Tools.leerInt("Dame el valor en la posicion " + (i+1) + "x" + (j+1));
	            x.setElemento(i, j, valor);
			}
		}
		
		return x;
	}
	
	public static String ImprimeMatrices( Matriz x ) {
		
		String cad = "     ";
		
		for (int i = 0; i < x.getColumnas(); i++) {
			cad += (i+1) + "     ";
		}
		
		cad += "\n";
		
		for (int i = 0; i < x.getFilas() ; i++) {
			cad+= (i+1) + " ";
			for(int j = 0; j < x.getColumnas() ; j++) {
	            cad += "|" + x.getElemento(i, j) + "| ";
			}
			cad += "\n";
		}
		
		return cad;
		
	}
	
	public static boolean mismoTamaño(Matriz a, Matriz b) {
		return (a.getFilas() == b.getFilas() && a.getColumnas() == b.getColumnas());
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
	
	public static Matriz calculaProductoEscalar(Matriz x, double y) {
		
		Matriz r = new Matriz(x.getFilas(), x.getColumnas());
		
		for(int i = 0; i < r.getFilas(); i++) {
			for(int j = 0; j < r.getColumnas(); j++) {
				r.setElemento(i, j, (int) ( y * x.getElemento(i, j) ));
			}
		}
		
		return r;
	}
	
	public static Matriz calculaProductoMatrices(Matriz a, Matriz b) {
		Matriz x = new Matriz(a.getFilas(), b.getColumnas());
		
		for (int i = 0; i < x.getFilas(); i++) {
	        for (int j = 0; j < x.getColumnas(); j++) {
	            int producto = 0;
	            for (int k = 0; k < a.getColumnas(); k++) {
	                producto += a.getElemento(i, k) * b.getElemento(k, j);
	            }
	            x.setElemento(i, j, producto);
	        }
	    }
		
		return x;
	}

}
