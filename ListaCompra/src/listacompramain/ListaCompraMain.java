package listacompramain;

import java.util.*;

//Código para la aplicación gestora de lista de la compra. Por Antonio Duarte

public class ListaCompraMain {

	// Array de String para productos. Static para ser accesible en todas las funciones
	static String[] lista = new String[50];

	// Contador de productos. Static para que sea accesible en todas las funciones
	static int numProductos = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		System.out.println("=== Lista de la Compra ===");

		//Menú de opciones
		int opcion;
		do {
			System.out.println("1. Añadir producto");
			System.out.println("2. Eliminar producto");
			System.out.println("3. Buscar producto");
			System.out.println("4. Mostrar lista completa");
			System.out.println("5. Vaciar lista");
			System.out.println("6. Salir");
			System.out.print("Elige una opción: ");

			opcion = Integer.parseInt(scan.nextLine()); 

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
				System.out.println("Lista vaciada.");
				break;

			case 6:
				System.out.println("¡Hasta luego!");
				break;

			default:
				System.out.println("Opción no válida.");
			}

		} while (opcion != 6);

		scan.close();
	}

	//Funciones para cada opción

	//Función para añadir producto
	static boolean añadirProducto(String producto) {
		if (numProductos >= 50) return false; //Caso de lista llena

		//Evitar que se duplique un mismo producto
		if (buscarProducto(producto) != -1) return false;

		lista[numProductos] = producto;
		numProductos++;
		return true;
	}
	//Función para eliminar producto
	static boolean eliminarProducto(String producto) {
		int pos = buscarProducto(producto);
		if (pos == -1) return false;

		//Desplazar elementos hacia la izquierda
		for (int i = pos; i < numProductos - 1; i++) {
			lista[i] = lista[i + 1];
		}
		numProductos--;
		return true;
	}
	//Función para buscar producto
	static int buscarProducto(String producto) {
		for (int i = 0; i < numProductos; i++) {
			if (lista[i].equalsIgnoreCase(producto)) {
				return i;
			}
		}
		return -1;
	}
	//Función para mostrar la lista
	static String[] mostrarLista() {
		String[] mostrada = new String[numProductos];
		for (int i = 0; i < numProductos; i++) {
			mostrada[i] = lista[i];
		}
		return mostrada;
	}
	//Función para vaciar la lista
	static void vaciarLista() {
		numProductos = 0; // Resetear el contador
	}



}
