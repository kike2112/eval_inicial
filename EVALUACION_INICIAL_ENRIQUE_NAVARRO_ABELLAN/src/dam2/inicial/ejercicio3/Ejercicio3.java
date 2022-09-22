package dam2.inicial.ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
//		Ejercicio 3.
//		Crea una agenda de contactos con las funcionalidades de leer, añadir y borrar contactos haciendo uso
//		de un ArrayList de tipo Contacto (se debe crear dicha clase con los atributos necesarios) para
//		almacenar los contactos de dicha agenda. Constará de un menú en la función main que llamará a las
//		funciones correspondientes para cada acción. Dicho menú deberá mostrarse indefinidamente una vez
//		realizada cada acción, pudiendo salir del programa cuando se introduzca el valor ‘s’ (el programa
//		únicamente lo tendrá en cuenta si el carácter se ha introducido en minúsculas, en caso contrario
//		o si la opción del menú introducida no existe, deberá indicar que la opción no es válida,
//		informando de ello al usuario, volviendo a solicitar la introducción de una opción válida de
//		manera indefinida).
		Scanner scan = new Scanner(System.in);
		ArrayList<Contacto> agenda= new ArrayList<Contacto>();
		
		Boolean menu = true;
		do {
			pintaAgenda(agenda);
			pintaMenu("LEER", "AÑADIR", "BORRAR", "s", "SALIR");
			String opcion = scan.nextLine();
			if (opcion.equals("1")) {
				leerContacto(agenda);	
			} else if (opcion.equals("2")) {	
				addContacto(crearContacto(), agenda);
			} else if (opcion.equals("3")) {
				borrarContacto(agenda);
			} else if (opcion.equals("s")) {
				menu = false;
			} else {
				System.out.println("Introduce opción válida");
			}	
		} while (menu);
		System.out.println("Programa cerrado");		
	}
	
	
	
	private static void borrarContacto(ArrayList<Contacto> agenda) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce Id.:");
		String id = scan.nextLine();
		if (isNumeric(id)) {
			if (existeId(Integer.parseInt(id),agenda)) {
				deleteContactoById(getContacto(Integer.parseInt(id), agenda), agenda);
			} else {
				System.out.println("Introduce opción válida");
			}	
		}		
	}
	private static void leerContacto(ArrayList<Contacto> agenda) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce Id.:");
		String id = scan.nextLine();
		if (isNumeric(id)) {
			if (existeId(Integer.parseInt(id),agenda)) {
				leerContactoById(getContacto(Integer.parseInt(id), agenda), agenda);
			} else {
				System.out.println("Introduce opción válida");
			}	
		}	
	}
	private static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
            System.out.println("Introduce opción válida");
        }
        return resultado;
	}
	private static boolean existeId(int id, ArrayList<Contacto> agenda) {
		boolean existe = false;
		for (int i = 0; i < agenda.size(); i++) {
			if (id==agenda.get(i).getId()) {
				existe = true;
			}
		}
		return existe;
	}
	private static void deleteContactoById(Contacto contacto, ArrayList<Contacto> agenda) {
		agenda.remove(contacto);
	}
	private static Contacto crearContacto() {
		Scanner scan =new Scanner(System.in);
		System.out.println("Introduce Nombre:");
		String nombre = scan.nextLine();
		System.out.println("Introduce Email:");
		String email = scan.nextLine();
		System.out.println("Introduce Teléfono:");
		String telefono = scan.nextLine();
		Contacto contacto = new Contacto(nombre, email, telefono);
		return contacto;
	}
	private static void pintaMenu(String string, String string2, String string3, String string4, String string5) {
		System.out.println(" [1] "+string+"     [2] "+string2+"     [3] "+string3+"     ["+string4+"] "+string5);
	}
	private static void addContacto(Contacto contacto, ArrayList<Contacto> agenda) {
		asignarIdAContacto(contacto, agenda);
		agenda.add(contacto);
	}
	private static void pintaAgenda(ArrayList<Contacto> agenda) {
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|                              MI AGENDA                                |");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("| Id.| Nombre                   | Email                   | Teléfono    |");
		System.out.println("+-----------------------------------------------------------------------+");
		for (int i = 0; i < agenda.size(); i++) {
			System.out.println("   "+agenda.get(i).getId()+"\t"+agenda.get(i).getNombre()+"\t\t"+agenda.get(i).getEmail()+"\t\t"+agenda.get(i).getTelefono());
		}	
	}
	private static void leerContactoById(Contacto contacto, ArrayList<Contacto> agenda) {
		System.out.println(contacto.getId()+"\t"+contacto.getNombre()+"\t"+contacto.getEmail()+"\t"+contacto.getTelefono());	
	}
	private static Contacto getContacto(int id, ArrayList<Contacto> agenda) {
		Contacto contacto = null;
		int id_contacto = -1;
		for (int i = 0; i < agenda.size(); i++) {
			id_contacto = agenda.get(i).getId();
			if (id_contacto == id) {
				contacto = agenda.get(i);
			} 
		}
		return contacto;
	}
	private static void asignarIdAContacto(Contacto contacto, ArrayList<Contacto> agenda) {
		int ultimo_id = 0;
		int id_nuevo = 1;
		
		if (agenda.size()>0) {
			for (int i = 0; i < agenda.size(); i++) {
				ultimo_id = agenda.get(i).getId();
				if (ultimo_id >= id_nuevo) {
					ultimo_id++;
					id_nuevo = ultimo_id;
				} 
			}
		}
		contacto.setId(id_nuevo);
	}
}
