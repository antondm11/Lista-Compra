package test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import main.java.ListaCompraMain;

/** Clase de Test para realizar las pruebas unitarias con JUnit. */
public class ListaCompraTest {

	//Sesiones de test para cada método

	@Test
	void testAñadir () {
		//Comprobar que añade producto
		//En este caso de ejemplo, se añade arroz, que si es cierto, devolverá true
		boolean añadir = ListaCompraMain.añadirProducto("Arroz ");
		assertTrue (añadir, "Producto añadido ");
	}

	@Test
	void testEliminar() {
		//Comprobar que elimina producto
		//En este caso, se elimina arroz y si es cierto devuelve true
		boolean eliminar = ListaCompraMain.eliminarProducto("Arroz ");
		assertTrue(eliminar, "Producto eliminado ");
	}

	@Test
	void testBuscar () {
		//Comprobar que busca producto
		//En este caso, se busca en qué posición de la lista está el producto introducido
		//Devuelve la posición de dicho producto
		int posicion = ListaCompraMain.buscarProducto("Arroz ");
		assertEquals(1, posicion, "Posición de Arroz "); //Devuelve posición de Arroz
	}

	@Test
	void testMostrar () {
		//Comprobar que muestra la lista
		//En este caso, se muestra una lista que contenga el producto que se introdujo
		//Para el ejemplo, se prueba una lista predefinada que ya contiene Arroz
		String[] mostrada = ListaCompraMain.mostrarLista();
		assertArrayEquals(new String[]{"Arroz"}, mostrada, "Arroz ");
	}

	@Test
	void testVaciar () {
		//Comprobar que se vacía la lista
		 ListaCompraMain.vaciarLista();
		 //Si se vacía, la longitud del array debe ser 0
	        assertEquals(0, ListaCompraMain.numProductos, "numProductos = 0");
	}
}
