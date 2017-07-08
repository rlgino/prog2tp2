package prog2.tp2_2017a;

public class Digitos implements Alfabeto<Character>
{
	@Override
	public int tam() { return 10; }

	@Override
	public int indice(Character c) {
		// Se implementa bas�ndose en el valor ASCII de char.
		// Los caracteres '0' a '9' son adyacentes en la tabla
		// ASCII, por lo que sus valores son contiguos.
		if (c >= '0' && c <= '9')
			return c - '0';

		throw new RuntimeException("digito no v�lido: " + c);
	}

	@Override
	public Character caracter(int i) {
		if (i >= '0' && i <= '9')
			return (char) (i + '0');

		throw new RuntimeException("digito no v�lido: " + i);
	}
}
