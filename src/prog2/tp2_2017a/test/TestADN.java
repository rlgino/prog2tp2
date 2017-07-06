package prog2.tp2_2017a.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import prog2.tp2_2017a.ADN;
import prog2.tp2_2017a.TrieChar;

@RunWith(Enclosed.class)
public class TestADN {
	/**
	 * Tests basicos de ADN
	 */
	public static class TestBasicoADN {

		@Test
		public void ejemploConsigna() {
			TrieChar<String> jurasicPark1 = new TrieChar<String>(new ADN());
			TrieChar<String> jurasicPark2= new TrieChar<String>(new ADN());
			TrieChar<String> jurasicPark3= new TrieChar<String>(new ADN());
			
			jurasicPark1.agregar("AA", "RANA");
			jurasicPark1.agregar("AAC", "VELOCIRAPTOR");
			jurasicPark1.agregar("AGG", "TIRANOSAURIO");
			
			System.out.println(jurasicPark1);// Notar que invoca a toString de TrieChar
			
			jurasicPark2.agregar("AA", "RANA");
			jurasicPark2.agregar("AAC", "VELOCIRAPTOR");
			jurasicPark2.agregar("AGG", "TIRANOSAURIO");
			
			jurasicPark3.agregar("AA", "RANA");
			jurasicPark3.agregar("AAC", "VELOCIRAPTOR");
			jurasicPark3.agregar("AGG", "ARGENTINOSAURIO");
			
			System.out.println(jurasicPark3);
			
			System.out.println("Obtener..."); 
			assertNull(jurasicPark1.obtener("AG"));  // null
			assertEquals(jurasicPark1.obtener("AGG"),"TIRANOSAURIO"); // "TIRANOSAURIO"
			
			System.out.println("equals..."); 
			assertTrue(jurasicPark1.equals(jurasicPark2)); // true
			assertFalse(jurasicPark2.equals(jurasicPark3)); // false
			
			System.out.println("eliminar...");
			jurasicPark2.eliminar("AA");// elimina por clave completa,no por prefijo!
			
			assertNotEquals(jurasicPark1,jurasicPark2);//False
		}
	}
}
