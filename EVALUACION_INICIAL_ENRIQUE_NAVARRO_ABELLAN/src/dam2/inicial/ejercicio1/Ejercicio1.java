package dam2.inicial.ejercicio1;

public class Ejercicio1 {

	public static void main(String[] args) {
//		Ejercicio 1. 
//		Los profesores de la escuela hemos tenido un problema a la hora de exportar los listados
//		de los alumnos y cada uno de ellos se ha duplicado en cada línea. 
//		Suponiendo la lectura de un fichero, línea a línea (podemos crear una variable de tipo Cadena para
//		almacenar una supuesta línea errónea y probar con ella). Ayúdanos a generar el listado correcto,
//		mostrándolo corregido por pantalla.
//		Tomando como ejemplo la lectura de una línea de un supuesto fichero proporcionado
//		“Tomás Pérez CamposTomás Pérez Campos”, como resultado debería generarse una línea con “Tomás Pérez Campos”,
//		es decir, habrá que hacer el correspondiente tratamiento de cadenas para que se corrija cualquier cadena
//		con dicho error (fíjate bien en el formato de entrada y en el de salida deseado).

		String cadena = "Tomás Pérez CamposTomás Pérez Campos";
		
		String cadena_corregida = corregirCadenaRepetida(cadena);
		
		System.out.println(cadena_corregida);
		
	}

	private static String corregirCadenaRepetida(String cadena) {
		if (cadena.length()%2 == 0) {
			int longitud = cadena.length()/2;
			String mitad1 = cadena.substring(0, longitud);
			String mitad2 = cadena.substring(longitud, cadena.length());
			if (mitad1.equals(mitad2)) {
				cadena = mitad1;
			}
		}
		
		return cadena;
	}
}
