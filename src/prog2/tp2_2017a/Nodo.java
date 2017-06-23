package prog2.tp2_2017a;

/**
 * Nodo de un trie.
 *
 * El n�mero de hijos se decide en el constructor.
 */
class Nodo<V> {
	V val;
	private Nodo<V> hijos[];

	@SuppressWarnings("unchecked")
	Nodo(int tam) {
		hijos = new Nodo[tam];
	}

	Nodo<V> hijo(int i) {
		return hijos[i];
	}

	void setHijo(int i, Nodo<V> hijo) {
		hijos[i] = hijo;
	}

	public boolean equals(Object o) {
		if (o.getClass() != this.getClass()) {
			return false;
		}
		Nodo<?> n = (Nodo<?>) o;
		return this.val == n.val;
	}
}
