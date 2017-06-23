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
	 * @param Trie
	 * @return true = si es igual, false = si no es igual
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null || this == null) 
			return obj == null && this == null;// si ambos so
		TrieChar<V> t2 = (TrieChar<V>) obj; // daunwarning, perono
											// sepuedehacernada!// faltan los
											// casos técnicos, como null//falta
											// comparar el alfabeto
		boolean ret = t2.claves.size() == claves.size();
		if (ret) {
			for (String clavet2 : t2.claves) {
				ret = ret && t2.obtener(clavet2).equals(obtener(clavet2));
			}
		}
		return ret;
	}
}
