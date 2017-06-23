package prog2.tp2_2017a;

public enum Base {
	DatoA("a", 0), 
	DatoC("c", 1), 
	DatoG("g", 2), 
	DatoT("t", 3);

	// Campos tipo constante
	private final String key; // Color de la madera
	private final int valor; // Peso específico de la madera

	Base(String color, int pesoEspecifico) {
		this.key = color;
		this.valor = pesoEspecifico;
	}

	public String getKey() {
		return key;
	}

	public int getValor() {
		return valor;
	}
}
