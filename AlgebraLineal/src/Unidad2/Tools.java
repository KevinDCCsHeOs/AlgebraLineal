package Unidad2;

import javax.swing.JOptionPane;

public class Tools {
	
	public static void imprimeSalida(String msje) {
		JOptionPane.showMessageDialog(null,msje,"Salida de datos",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void salidaError(String msje) {
		JOptionPane.showMessageDialog(null, msje,"",JOptionPane.ERROR_MESSAGE);
	}
	
	public static short leerShort(String msje) {
		return (Short.parseShort(JOptionPane.showInputDialog(null,msje,"Dato de entrada",JOptionPane.INFORMATION_MESSAGE)));
	}
	
	public static byte leerByte(String msje) {
		return (Byte.parseByte(JOptionPane.showInputDialog(null,msje,"Dato de entrada",JOptionPane.INFORMATION_MESSAGE)));
	}
	
	public static int leerInt(String msje) {
		return (Integer.parseInt(JOptionPane.showInputDialog(null,msje,"Dato de entrada",JOptionPane.INFORMATION_MESSAGE)));
	}
	
	public static long leerLong(String msje) {
		return (Long.parseLong(JOptionPane.showInputDialog(null,msje,"Dato de entrada",JOptionPane.INFORMATION_MESSAGE)));
	}
	
	public static float leerFloat(String msje) {
		return (Float.parseFloat(JOptionPane.showInputDialog(null,msje,"Dato de entrada",JOptionPane.INFORMATION_MESSAGE)));
	}
	
	public static char leerChar(String msje) {
		return (JOptionPane.showInputDialog(null,msje,"Dato de entrada",JOptionPane.INFORMATION_MESSAGE).charAt(0));
	}
	
	public static String leerString(String msje) {
		return(JOptionPane.showInputDialog(null,msje,"Dato de entrada",JOptionPane.INFORMATION_MESSAGE));
	}
	
	public static double leerDouble(String msje) {
		return (Double.parseDouble(JOptionPane.showInputDialog(null,msje,"Dato de entrada",JOptionPane.INFORMATION_MESSAGE)));
	}
	
	public static int seguirSino() {
		return JOptionPane.showConfirmDialog(null,"Deseas continuar","Capturando datos",JOptionPane.YES_NO_OPTION);
	}
	
	public static int leerEntero(String msje) {
		return (Integer.parseInt(JOptionPane.showInputDialog(null,msje,"Lectura int: ",JOptionPane.INFORMATION_MESSAGE)));
	}
	
	//Menu Desplegable
	public static String Desplegable(String menu) {
			String valores[]=menu.split(",");
			String res=(String)JOptionPane.showInputDialog(null,"M E N U","SELECCIONA ALGUNA OPCION: ",
					JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
			return res;
		}
		
	//Menu de Botones
	public static String Boton(String menu) {
			String valores[]=menu.split(",");
			int n;
			n=JOptionPane.showOptionDialog(null, "M E N U","Seleccione dando clic",JOptionPane.NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
			return valores[n];
		}
	
	public static String Desplegable(String cad, String menu) {
		String valores[]=menu.split(",");
		String res=(String)JOptionPane.showInputDialog(null,cad,"M E N U",
				JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return res;
	}
	
	public static String Boton(String cad, String menu) {
		String valores[]=menu.split(",");
		int n;
		n=JOptionPane.showOptionDialog(null, cad ,"M E N U", JOptionPane.NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return valores[n];
	}
}
