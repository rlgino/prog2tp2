package prog2.tp2_2017a;

public class Palabras implements Alfabeto<Character>{

	@Override
	public int tam() {
		// TODO Auto-generated method stub
		return 26;
	}

	@Override
	public int indice(Character c) {
		if (c >= 'a' && c <= 'z')
			return c - 'a';

		throw new RuntimeException("digito no v�lido: " + c);
	}

	@Override
	public Character caracter(int i) {
		int indice = i + 'a';
		if (indice >= 'a' && indice <= 'z')
			return (char) indice;

		throw new RuntimeException("indice no v�lido: " + i);
	}

}
