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

}
