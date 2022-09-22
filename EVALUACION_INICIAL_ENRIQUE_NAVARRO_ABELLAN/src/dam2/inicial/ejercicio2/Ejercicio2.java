package dam2.inicial.ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
//		Ejercicio 2.
//		Desarrolla un programa que lea una serie de valores numéricos enteros desde el teclado y los guarde
//		en un ArrayList de tipo Integer. La lectura de números terminará cuando se introduzca el valor -1.
//		Este valor no se almacenará en el ArrayList.
//		A continuación el programa mostrará por pantalla el número de valores que se han leído, su suma y
//		su media. Por último se mostrarán todos los valores leídos, indicando cuántos de ellos son mayores
//		que la media.
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> lista = new ArrayList<Integer>();

		int entrada = 0;
		do {
			System.out.println("\n\nIntroduce un número.\t[-1] PARA SALIR");
			entrada = scan.nextInt();
			if (entrada!= -1) {
				lista.add(entrada);
				System.out.println("VALORES ENTRADOS:");
				for (int i = 0; i < lista.size(); i++) {
					if (i+1 == lista.size()) {
						System.out.print(lista.get(i));
					} else {
						System.out.print(lista.get(i)+", ");
					}
				}
				System.out.println("\nLA SUMA DE ELLOS ES:");
				int total = 0;
				for (int i = 0; i < lista.size(); i++) {
					total = total + lista.get(i);
				}
				System.out.println(total);
				System.out.println("LA MEDIA DE ELLOS ES:");
				System.out.println(total / lista.size());
				System.out.println("NÚMEROS INTRODUCIDOS MAYORES QUE LA MEDIA SON LOS SIGUIENTES:");
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i) > total / lista.size()) {
						System.out.print(lista.get(i)+", ");
					}
				}
			}
		} while (entrada != -1);
		System.out.println("Programa cerrado");
	}
}
