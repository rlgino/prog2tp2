package prog2.tp2_2017a;

public class ADN implements Alfabeto<Character>{

	@Override
	public int tam() {
		return 4;
	}

	@Override
	public int indice(Character c) {
		switch(c){
		case 'a':
			return Base.DatoA.getValor();
		case 'c' :
			return Base.DatoC.getValor();
		case 'g':
			return Base.DatoG.getValor();
		case 't' :
			return Base.DatoT.getValor();
		}
		throw new RuntimeException("digito no v�lido: " + c);
	}

}
