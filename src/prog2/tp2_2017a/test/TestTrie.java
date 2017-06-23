package prog2.tp2_2017a.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import prog2.tp2_2017a.Digitos;
import prog2.tp2_2017a.Palabras;
import prog2.tp2_2017a.TrieChar;

@RunWith(Enclosed.class)
public class TestTrie
{
	/**
	 * Tests b�sicos con ISBN y t�tulo.
	 */
	public static class TestBasico
	{
		private List<String> busq;
		private TrieChar<String> libros;

		public TestBasico() {
			libros = new TrieChar<>(new Digitos());
		}

		@Test
		public void vacio() {
			assertNull(libros.obtener("978123"));
			assertTrue(libros.busqueda("9").isEmpty());
			assertTrue(libros.busqueda("978").isEmpty());
		}

		@Test
		public void ejemploConsigna() {
			libros.agregar("9785267006323", "Cien a�os de soledad");
			libros.agregar("9788490093795", "El amor de tu vida");
			libros.agregar("9785423113601", "El amor en los tiempos del c�lera");

			assertEquals("El amor de tu vida", libros.obtener("9788490093795"));
			System.out.println(libros.toString());
			busq = libros.busqueda("9785");
			assertEquals(2, busq.size());
			assertTrue(busq.contains("Cien a�os de soledad"));
			assertTrue(busq.contains("El amor en los tiempos del c�lera"));
		}

		/**
		 * Obtiene todos los valores usando la cadena vac�a como prefijo.
		 */
		@Test
		public void buscarTodos() {
			libros.agregar("123", "A");
			libros.agregar("3948", "B");
			libros.agregar("3888", "C");
			libros.agregar("537214", "D");

			busq = libros.busqueda("");

			assertEquals(4, busq.size());
			assertTrue(busq.contains("A"));
			assertTrue(busq.contains("B"));
			assertTrue(busq.contains("C"));
			assertTrue(busq.contains("D"));

			assertNull(libros.obtener("53721"));
		}
	}

	/**
	 * Guarda en el trie valores de tipo Libro (una clase propia).
	 */
	public static class TestGenerico
	{
		private TrieChar<Libro> libros;

		public TestGenerico() {
			libros = new TrieChar<>(new Digitos());
		}

		@Test
		public void claseLibro() {
			libros.agregar("9876", Libro.orwell);
			libros.agregar("9867", Libro.murakami);

			List<Libro> busq = libros.busqueda("98");
			assertEquals(2, busq.size());
			assertTrue(busq.contains(Libro.orwell));
			assertTrue(busq.contains(Libro.murakami));
		}

		private static class Libro
		{
			String titulo, autor;

			Libro(String a, String t) {
				autor = a;
				titulo = t;
			}

			static final Libro orwell = new Libro("George Orwell", "1984");
			static final Libro murakami = new Libro("Haruki Murakami", "1Q84");
		}
	}

	/**
	 * Tests adicionales usando el alfabeto Palabras una vez implementado.
	 */
	public static class TestPalabras
	{
		private TrieChar<Object> palabras;

		public TestPalabras() {
			palabras = new TrieChar<>(new Palabras());
		}

		/**
		 * Comprueba qu� pasa cuando hay huecos en los prefijos.
		 */
		@Test
		public void intermediosVacio() {
			Object obj[] = {new Object(), new Object(), new Object(), new Object()};

			palabras.agregar("antiguo", new Object());
			palabras.agregar("antecesor", obj[0]);
			palabras.agregar("antecedente", obj[1]);
			palabras.agregar("antecesores", obj[2]);
			palabras.agregar("antecedentes", obj[3]);

			List<Object> busq = palabras.busqueda("ante");

			assertEquals(obj.length, busq.size());

			for (Object o : obj)
				assertTrue(busq.contains(o));
		}
	}
}
