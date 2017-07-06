package prog2.tp2_2017a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TrieChar<V> {
	private Nodo<V> raiz;
	private Alfabeto<Character> alf;
	private HashSet<String> claves;

	public TrieChar(Alfabeto<Character> alf) {
		this.alf = alf;
		claves = new HashSet<String>();
	}

	/**
	 * Agrega una cadena a la estructura, asoci�ndole un determinado valor.
	 *
	 * Si la clave ya exist�a, se reemplaza su valor asociado.
	 */
	public void agregar(String clave, V valor) {
		if (raiz == null)
			raiz = new Nodo<V>(alf.tam());
		int i = 0;
		Nodo<V> nodo = raiz;
		char[] aClave = clave.toCharArray();
		for (i = 0; i < clave.length(); i++) {
			if (nodo.hijo(alf.indice(aClave[i])) == null)
				nodo.setHijo(alf.indice(aClave[i]), new Nodo<V>(alf.tam()));
			nodo = nodo.hijo(alf.indice(aClave[i]));
		}
		nodo.val = valor;
		claves.add(clave);
	}

	/**
	 * Devuelve el valor asociado a una clave, o null si no existe.
	 */
	public V obtener(String clave) {
		int i = 0;
		Nodo<V> nodo = raiz;
		char[] aClave = clave.toCharArray();
		for (i = 0; i < clave.length(); i++) {
			if (nodo == null)
				return null;
			nodo = nodo.hijo(alf.indice(aClave[i]));
		}
		if (nodo == null)
			return null;

		return nodo.val;
	}

	/**
	 * Devuelve una lista con todos los valores cuyas claves empiezan por un
	 * determinado prefijo.
	 */

	public List<V> busqueda(String prefijo) {
		List<V> lista = new ArrayList<V>();
		if (raiz == null)
			return lista;
		int i = 0;
		Nodo<V> nodo = raiz;
		char[] aClave = prefijo.toCharArray();
		for (i = 0; i < prefijo.length(); i++) {
			if (nodo.hijo(alf.indice(aClave[i])) == null)
				return lista;
			nodo = nodo.hijo(alf.indice(aClave[i]));
		}
		busqueda(nodo, lista);
		return lista;
	}

	private void busqueda(Nodo<V> nodo, List<V> lista) {
		if (nodo == null)
			return;
		if (nodo.val != null)
			lista.add(nodo.val);
		for (int x = 0; x < alf.tam(); x++)
			busqueda(nodo.hijo(x), lista);
	}

	/**
	 * Metodo que devuelve el Trie convertido en String
	 */

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();

		for (String clave : claves)
			st.append(clave + " " + obtener(clave) + "\n");

		return st.toString();
	}

	/**
	 * Verifica que el trie pasado por parametro sea igual
	 * 
	 * @param Obj  a comparar
	 * @return true = si es igual, false = si no es igual
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		// Si alguno es nulo, no vale la pena seguir verificando
		if (obj == null || this == null) 
			// si ambos son nulos devuelve true
			return obj == null && this == null;
		
		if (this.getClass() != obj.getClass()) return false;
		
		TrieChar<V> t2 = (TrieChar<V>) obj;
		
		// comparar el alfabeto
		if(t2.alf.getClass() != this.alf.getClass()) return false;
		
		// COMPARACION DE CLAVES
		boolean ret = t2.claves.size() == claves.size();
		if (ret) {
			for (String clavet2 : t2.claves) {
				ret = ret && t2.obtener(clavet2).equals(obtener(clavet2));
			}
			ret = ret && this.raiz.equals(t2.raiz);
		}

		return ret;
	}

	public void eliminar(String clave) {
		int i = 0;
		Nodo<V> nodo = raiz;
		char[] aClave = clave.toCharArray();
		for (i = 0; i < clave.length(); i++) {
			if (nodo == null)
				throw new RuntimeException("No se encontro la clave");
			nodo = nodo.hijo(alf.indice(aClave[i]));
		}
		if (nodo == null)
			throw new RuntimeException("No se encontro la clave");

		nodo.val = null;		
		claves.remove(clave);
	}
}
