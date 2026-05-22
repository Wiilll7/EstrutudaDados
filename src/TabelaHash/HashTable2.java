package TabelaHash;

public class HashTable2 {

	// subclasse de entrada de dados
	private class Entrada {
		String chave;
		String valor;
		
		public Entrada(String chave, String valor) {
			this.chave = chave;
			this.valor = valor;
		}
	}
		
	private final double fatorCarga = 0.7;
	
	private Entrada[] array;
	private int tamAtual;
	
	// construtor
	public HashTable2(int capacidadeInicial) {
		this.array = new Entrada[capacidadeInicial];
		this.tamAtual = 0;
	}
	
	private int hash(String chave) {
		int hashCode = 0;
		
		for (byte b: chave.getBytes()) {
			hashCode += b;
		}
		
		return hashCode % array.length;
	}
	
	public void inserir(String chave, String valor) {
		
		if ((double) tamAtual / array.length >= fatorCarga) {
			System.out.println("Fator de carga excedido. Redimencionar...");
			redimensionar();
		}
		
		int indiceBase = hash(chave);
		int indice = indiceBase;
		int colisoes = 0;	
		
		while (array[indice] != null && !array[indice].chave.equals(chave)) {
			colisoes++;
			System.out.println("Colisao. Tratamento de Colisoes ativado.");
			System.out.println("Tentativa: "+colisoes);
			indice = (indiceBase + colisoes) % array.length;
		}
		
		if (array[indice] == null) {
			tamAtual++;
		}
		
		array[indice] = new Entrada(chave, valor);
	}
	
	public String recuperar(String chave) {
		int indiceBase = hash(chave);
		int indice = indiceBase;
		int colisoes = 0;
		
		while (array[indice] != null) {

			if (array[indice].chave.equals(chave)) {
				return array[indice].valor;
			}
			
			colisoes++;
			indice = (indiceBase + colisoes) % array.length;
		}
		
		return "Chave nao Encontrada";
	}
	
	private void redimensionar() {
		Entrada[] antigoArray = array;
		
		array = new Entrada[antigoArray.length * 2];
		tamAtual = 0;
		
		System.out.println("-> Nova capacidade do Array:"+ array.length);
		
		for (Entrada e: antigoArray) {
			if (e != null) {
				inserir(e.chave, e.valor);
			}
		}
	}
	
	public void mostrarTabela() {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				System.out.println("Indice ["+ i +"] -> [VAZIO]");
			} else {
				System.out.println("Indice ["+ i +"] -> Chave: ["+ array[i].chave +"] Valor: ["+ array[i].valor +"]");
			}
		}
	}
	
}
