package ejercicios.ejercicio01;

import java.util.ArrayList;
import java.util.Iterator;

public class Estilo {
	
//	// EJERCICIO 1: ArrayList con valor 3 MAL
////	public ArrayList<String> arr = new ArrayList<String>();
//	
//	public static void main (String[] args) {
//////		this.arr.add("3"); 
//////		//Se queja, desde un método estático no puedo hacer uso de un atributo que no sea estático.
//////		//Debemos crear un objeto de tipo Estilo, y a partir de this acceder al array
//////		System.out.println(this.arr.toString());
//////
//////
//// 		// EJERCICIO 1.2: ArrayList con valor 3 REGULAR
////		Estilo ejemplo = new Estilo();
////		ejemplo.arr.add("3"); 
////		System.out.println(ejemplo.arr.toString());
////
////
//		// EJERCICIO 1.3: ArrayList con valor 3 MEJOR.
//		// Se evita el "ejemplo.". Array se convierte en variable local	
//		ArrayList<String> arr = new ArrayList<String>();
//		arr.add("3"); 
//		System.out.println(arr.toString());
//	}
	
		
//	// EJERCICIO 2: Insertar 50 valores del 1 al 50
//	// Se evita el "ejemplo.". Array se convierte en variable local
//	public static void main (String[] args) {
//		ArrayList<String> arr = new ArrayList<String>();
//
////////		for (int i = 0; i < 50; i++) {
////////			arr.add(i); //Se queja, arr es array de String y yo inserto un int
////////		}
////////		System.out.println(arr.toString());
//////		
//////		
//////		//EJERCICIO 2.2
//////		//Solución: Lo convertimos a String con valueOf
//////		for (int i = 0; i < 50; i++) {
//////			arr.add(String.valueOf(i));
//////		}
//////		System.out.println(arr.toString());
//////		
//////		
//		//EJERCICIO 2.3
//		//Quiero valores positivos o negativos con probabilidad del 50%
//		for (int i = 0; i < 50; i++) {
//			if (Math.random() < .5) {
//				arr.add(String.valueOf(i));
//			} else {
//				arr.add(String.valueOf(-i));
//			}
//		}
//		System.out.println(arr.toString());
//	}
	
	
	//EJERCICIO 3
	//Quiero valores positivos o negativos con probabilidad del 50%
	//Mejora de If else
	// USANDO 3 FORMAS DE RECORRER ESTRUCTURA
	public static void main (String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		
		for (int i = 0; i < 50; i++) {
			arr.add(String.valueOf(Math.random() < 0.5 ? i : -i));
		}
		
		//Ahora que está la estructura, hay que recorrerla para contar número de negativos
		int numNegativos = 0;
		
//		//Forma 1: FOR
//		for (int i = 0; i < arr.size(); i++) {
////			if(arr.get(i) < 0) numNegativos++; //Se queja, get de i da un string, se convierte con Integer
//			if(Integer.valueOf(arr.get(i)) < 0) numNegativos++;
//		}
		
//		//Forma 2: ITERATOR
//		Iterator<String> it = arr.iterator();
//		while (it.hasNext()) {
//			if(Integer.valueOf(it.next()) < 0) numNegativos++;
//			
//		}
		
		//Forma 3: FOREACH
		Iterator<String> it = arr.iterator();
		for (String str : arr) {
			if ((Integer.valueOf(str)) < 0) numNegativos++;
		}
		System.out.println("El número de elementos negativos es: " + numNegativos);
		System.out.println(arr.toString());
		
		
		//MIN 23 DE VIDEO
	}
}