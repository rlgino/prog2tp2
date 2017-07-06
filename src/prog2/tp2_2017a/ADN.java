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

}
