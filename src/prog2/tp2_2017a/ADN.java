package prog2.tp2_2017a;

public class ADN implements Alfabeto<Character>{

	@Override
	public int tam() {
		return 4;
	}

	@Override
	public int indice(Character c) {
		switch(c){
		case 'A':
			return Base.DatoA.getValor();
		case 'C' :
			return Base.DatoC.getValor();
		case 'G':
			return Base.DatoG.getValor();
		case 'T' :
			return Base.DatoT.getValor();
		}
		throw new RuntimeException("digito no v�lido: " + c);
	}

	@Override
	public Character caracter(int i) {
		switch(i){
		case 0:
			return Base.DatoA.getKey().toCharArray()[0];
		case 1:
			return Base.DatoC.getKey().toCharArray()[0];
		case 2:
			return Base.DatoG.getKey().toCharArray()[0];
		case 3:
			return Base.DatoT.getKey().toCharArray()[0];
		}
		throw new RuntimeException("indice no v�lido: " + i);
	}

}
