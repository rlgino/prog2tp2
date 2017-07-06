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
		if(this == null || o == null)
			return this == o;
		
		if (o.getClass() != this.getClass()) {
			return false;
		}
		Nodo<?> n = (Nodo<?>) o;
		boolean ret = this.val == n.val;
		
		for(int x = 0; x < hijos.length && ret ; x++){
			//Verifico si tiene definido los hijos, para evitar un null pointer
			if(this.hijos[x] == null || n.hijos[x] == null)
				return (this.hijos[x] == null && n.hijos[x] == null);
			ret = ret && this.hijos[x].equals(n.hijos[x]);
		}
		return ret;
	}
}
