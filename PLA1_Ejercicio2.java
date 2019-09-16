import java.lang.reflect.Array;
import java.util.Scanner;

/*En los teléfonos móviles antiguos cada número tenía tres letras asociadas. La cosa era así:

 2 ABC  
 3 DEF  
 4 GHI  
 5 JKL 
 6 MNO 
 7 PRS 
 8 TUV 
 9 WXY
Hemos encontrado un grupo de espías que utilizan esto para codificar sus mensajes. Si quieren enviar "HOLA" envían lo siguiente:
4652

Vamos a realizar un programa que sirva para codificar y para decodificar. Para codificar introduciremos una palabra y nos devolverá el número que 
le toque (como en el ejemplo anterior 'hola'->4652 'misil'->64745). Para decodificar tenemos un problema, porque un mismo número tiene diferentes 
interpretaciones. Realizaremos un programa que, dado un número, nos muestre todas las posibles combinaciones.*/


public class PLA1_Ejercicio2 {
	public static void main(String args[]) {
		String palabra;
		String codificacion = "";
		String decodificar = "";
		String letras[];
		String aux1, aux2, aux3;
		
		// CODIFICACIÓN MENSAJES
		
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
		System.out.println("La codificación es: " + codificacion);
		
		
		// DECODIFICACIÓN MENSAJES
		
		System.out.print("Introduzca mensaje a decodificar: ");
		decodificar = sc.nextLine();
		sc.close();
		letras = new String[decodificar.length()]; // letras contiene la longitud del código a decodificar.
		for (int i = 0; i < decodificar.length(); i++) {
			for (int j = 0; j < 8; j++) {		
				if (asignacion[j][0].indexOf(decodificar.charAt(i)) != -1) { // Verificamos con qué índice corresponde la cifra i introducida y así obtenemos las letras que le corresponden.
					letras[i] = asignacion[j][1];
				}
			}
		}	
 
		System.out.println("---------------------------------------------------------");
		
		// Muestra la combinación que corresponde al dígito introducido.  
		if (letras.length == 1) {
			System.out.println("Las posibles combinaciones del mensaje decodificado son:");
			for (int l = 0; l < 3; l++) { 
				aux1 = String.valueOf(Array.get(letras, 0).toString().charAt(l));
				System.out.println(aux1);
			}
		}
		
		// Muestra las combinaciones posibles para un mensaje codificado de 2 dígitos.  
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
		
		// Muestra las combinaciones posibles para un mensaje codificado de 3 dígitos.  
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

