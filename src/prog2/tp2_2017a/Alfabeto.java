package prog2.tp2_2017a;

public interface Alfabeto<T>
{
	/**
	 * Devuelve k: n�mero de s�mbolos en el alfabeto.
	 */
	int tam();

	/**
	 * Devuelve el �ndice correspondiente a un s�mbolo.
	 *
	 * Debe tener complejidad O(1). Lanza RuntimeException
	 * si el s�mbolo no es v�lido.
	 */
	int indice(T elem);
}
