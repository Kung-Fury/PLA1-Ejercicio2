import java.lang.reflect.Array;
import java.util.Scanner;

/*En los tel�fonos m�viles antiguos cada n�mero ten�a tres letras asociadas. La cosa era as�:

 2 ABC  
 3 DEF  
 4 GHI  
 5 JKL 
 6 MNO 
 7 PRS 
 8 TUV 
 9 WXY
Hemos encontrado un grupo de esp�as que utilizan esto para codificar sus mensajes. Si quieren enviar "HOLA" env�an lo siguiente:
4652

Vamos a realizar un programa que sirva para codificar y para decodificar. Para codificar introduciremos una palabra y nos devolver� el n�mero que 
le toque (como en el ejemplo anterior 'hola'->4652 'misil'->64745). Para decodificar tenemos un problema, porque un mismo n�mero tiene diferentes 
interpretaciones. Realizaremos un programa que, dado un n�mero, nos muestre todas las posibles combinaciones.*/


public class PLA1_Ejercicio2 {
	public static void main(String args[]) {
		String palabra;
		String codificacion = "";
		String decodificar = "";
		String letras[];
		String aux1, aux2, aux3;
		
		// CODIFICACI�N MENSAJES
		
		String asignacion[][] = {{"2", "ABC"}, 
								{"3", "DEF"},
								{"4", "GHI"},
								{"5", "JKL"},
								{"6", "MNO"},
								{"7", "PRS"},
								{"8", "TUV"},
								{"9", "WXY"}};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca la palabra a codificar: ");
		palabra = sc.nextLine();
		palabra = palabra.toUpperCase();
		
		for (int i = 0; i < palabra.length(); i++) {
			for (int j = 0; j < 8; j++) {
				if (asignacion[j][1].indexOf(palabra.charAt(i)) != -1) {
					codificacion += asignacion[j][0].toString();
				}
			}
		}
		System.out.println("La codificaci�n es: " + codificacion);
		
		
		// DECODIFICACI�N MENSAJES
		
		System.out.print("Introduzca mensaje a decodificar: ");
		decodificar = sc.nextLine();
		sc.close();
		letras = new String[decodificar.length()]; // letras contiene la longitud del c�digo a decodificar.
		for (int i = 0; i < decodificar.length(); i++) {
			for (int j = 0; j < 8; j++) {		
				if (asignacion[j][0].indexOf(decodificar.charAt(i)) != -1) { // Verificamos con qu� �ndice corresponde la cifra i introducida y as� obtenemos las letras que le corresponden.
					letras[i] = asignacion[j][1];
				}
			}
		}	
 
		System.out.println("---------------------------------------------------------");
		
		// Muestra la combinaci�n que corresponde al d�gito introducido.  
		if (letras.length == 1) {
			System.out.println("Las posibles combinaciones del mensaje decodificado son:");
			for (int l = 0; l < 3; l++) { 
				aux1 = String.valueOf(Array.get(letras, 0).toString().charAt(l));
				System.out.println(aux1);
			}
		}
		
		// Muestra las combinaciones posibles para un mensaje codificado de 2 d�gitos.  
		if (letras.length == 2) {
			System.out.println("Las posibles combinaciones del mensaje decodificado son:");
			for (int l = 0; l < 3; l++) { 
				aux1 = String.valueOf(Array.get(letras, 0).toString().charAt(l));
				for (int m = 0; m < 3; m++) { 
					aux2 = String.valueOf(Array.get(letras, 1).toString().charAt(m));
					System.out.println(aux1+aux2);
				}
			}
		}
		
		// Muestra las combinaciones posibles para un mensaje codificado de 3 d�gitos.  
		if (letras.length == 3) {
			System.out.println("Las posibles combinaciones del mensaje decodificado son:");
			for (int l = 0; l < 3; l++) { 
				aux1 = String.valueOf(Array.get(letras, 0).toString().charAt(l));
				for (int m = 0; m < 3; m++) { 
					aux2 = String.valueOf(Array.get(letras, 1).toString().charAt(m));
					for (int n = 0; n < 3; n++) {
						aux3 = String.valueOf(Array.get(letras, 2).toString().charAt(n));
						System.out.println(aux1+aux2+aux3);
					}
				}
			}
		}
	}
}

