package main.java;

import java.util.*;

//Desarrollo de aplicación de gestión de lista de la compra. Por Antonio Duarte

/* Contribución de Sergio Pérez: Quitar las ñ a los métodos de añadir por si acaso. 
Añadir un método opcional para mostrar la lista vacía */

/*Contribución de Antonio: Integrar la nueva función propuesta por Sergio
  para mostrar la lista vacía, pero manteniendo las ñ. */


/** Clase Main que contiene el código para la aplicación de la lista de la compra. */
public class ListaCompraMain {

	/** Array de String para productos.
	 Public Static para ser accesible en todas las funciones. */
	public static String[] lista = new String[50];

	/** Contador de productos. Public static para que sea accesible en todas las funciones. */
	public static int numProductos = 0;

	/** El main del código. Con esto se mostrará por pantalla el menú de las opciones
	 de la aplicación para pedir al usuario que seleccione una, ya sea para 
	 introducir, eliminar o realizar otras operaciones con los productos que desee
	 gestionar, así como una opción para salir del menú y de la aplicación
	 cuando ya haya terminado. */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		System.out.println("=== Lista de la Compra === ");

		//Menú de opciones
		int opcion = 0;
		do {
			System.out.println("1. Añadir producto ");
			System.out.println("2. Eliminar producto ");
			System.out.println("3. Buscar producto ");
			System.out.println("4. Mostrar lista completa ");
			System.out.println("5. Vaciar lista ");
			System.out.println("6. Salir ");
			System.out.print("Elija una opción: ");

			//Depuración
			try {
				opcion = Integer.parseInt(scan.nextLine());
				while (opcion < 1 || opcion > 6) {
					System.out.println("Introduzca una opción válida, entre 1 y 6 ");
				}
			}catch(NumberFormatException e) {
				System.err.println("Error. Introduzca una opción correcta ");
			}

			switch (opcion) {
			case 1:
				System.out.print("Introduzca el producto a añadir: ");
				String añadido = scan.nextLine();
				if (añadirProducto(añadido)) {
					System.out.println("Producto añadido correctamente.");
				} else {
					System.out.println("No se pudo añadir. Lista llena.");
				}
				break;

			case 2:
				System.out.print("Introduzca el producto a eliminar: ");
				String eliminado = scan.nextLine();
				if (eliminarProducto(eliminado)) {
					System.out.println("Producto eliminado.");
				} else {
					System.out.println("Producto no encontrado.");
				}
				break;

			case 3:
				System.out.print("Introduzca el producto a buscar: ");
				String buscado = scan.nextLine();
				int posicion = buscarProducto(buscado);
				if (posicion >= 0) {
					System.out.println("Encontrado en la posición " + posicion);
				} else {
					System.out.println("Producto no encontrado.");
				}
				break;

			case 4:
				mostrarLista();
				break;

			case 5:
				vaciarLista();
				System.out.println("Lista vaciada. ");
				break;

			case 6:
				System.out.println("¡Hasta luego! ");
				break;

			default:
				System.out.println("Opción no válida. ");
			}

		} while (opcion != 6);

		scan.close();
	}

	//Funciones para cada opción

	/** Función para añadir producto 
	 @param producto recibe el elemento que introduce el usuario para añadir 
	 un producto al elegir opción 1.
	 @return false si la lista está llena o el producto ya está en la lista.
	true si el producto se puede añadir y fue correctamente incorporado a la lista. */
	public static boolean añadirProducto(String producto) {
		if (numProductos >= 50) return false;
		if (buscarProducto(producto) != -1) return false;

		lista[numProductos] = producto;
		numProductos++;
		return true;
	}

	/** Función para eliminar producto 
	 @param producto recibe el elemento que introduce el usuario para eliminar
	 de la lista al elegir opción 2. 
	  @return false si el producto no está en la lista.
	true si el producto está en la lista y fue correctamente eliminado de la misma. */
	public static boolean eliminarProducto(String producto) {
		int pos = buscarProducto(producto);
		if (pos == -1) return false;

		//Desplazar elementos hacia la izquierda
		for (int i = pos; i < numProductos - 1; i++) {
			lista[i] = lista[i + 1];
		}
		numProductos--;
		return true;
	}
	/** Función para buscar producto
	 @param producto recibe el elemento que introdujo el usuario para buscarlo 
	 en la lista al elegir la opción 3.
	 @return posición en la que se encuentra el elemento que buscó el usuario. 
	 Si no está en la lista, devuelve -1. */
	public static int buscarProducto(String producto) {
		for (int i = 0; i < numProductos; i++) {
			if (lista[i].equalsIgnoreCase(producto)) {
				return i;
			}
		}
		return -1;
	}
	/** Función para mostrar la lista
	 @param numProductos recibe el número de productos que introdujo el usuario. 
	 Es decir, la longitud del array que llenó el usuario y por tanto de la lista
	 que habrá que mostrar por pantalla.
	 lista recibe la lista de productos (cadenas de caracteres) que introdujo 
	 el usuario y que por tanto será el contenido de la lista que se mostrará, ya que
	 eligió la opción 4. 
	 @return lista mostrada, al mostrar el array que ha ido llenando el usuario. */

	public static String[] mostrarLista() {
		String[] mostrada = new String[numProductos];
		for (int i = 0; i < numProductos; i++) {
			mostrada[i] = lista[i];
		}
		return mostrada;
	}
	/** Función para vaciar la lista.
	  @param numProductos es el número de productos que introdujo el usuario. 
	 Es decir, la longitud del array que compone la lista. Al ser una función void,
	 no devuelve nada, simplemente su parámetro numProductos se iguala a 0 para 
	 resetear el contador de productos y dejar la lista a 0,
	 cumpliendo la petición del usuario de vaciarla cuando eligió la opción 5. */
	public static void vaciarLista() {
		numProductos = 0; // Resetear el contador
	}

	//Método para mostrar la lista vacía. Antonio Duarte y Sergio Pérez
	public static void listaVacia() {

		if (numProductos == 0) {
			System.out.println("La lista está vacía. ");
			return;
		}

		System.out.println("--- Lista de productos --- ");
		for (int i = 0; i < numProductos; i++) {
			System.out.println((i + 1) + ". " + lista[i]);
		}
	}

}

