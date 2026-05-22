package TabelaHash;

public class HashTable1 {
	
	// subclasse de entrada de dados
	private class Entrada {
		@SuppressWarnings("unused")
		String chave;
		String valor;
		
		public Entrada(String chave, String valor) {
			this.chave = chave;
			this.valor = valor;
		}
	}
	
	// atributos
	private int tamArray;
	private Entrada[] array;
	
	// construtor
	public HashTable1(int tamArray) {
		this.tamArray = tamArray;
		this.array = new Entrada[tamArray];
	}
	
	private int hash(String chave) {
		byte[] bytesChave = chave.getBytes();
		int hashCode = 0;
		
		for (int i = 0; i < bytesChave.length; i++) {
			hashCode += bytesChave[i];
		}
		
		return hashCode % tamArray;
	}
	
	public void inserir(String chave, String valor) {
		int indiceArray = hash(chave);
		array[indiceArray] = new Entrada(chave, valor);
	}
	
	public String recuperar(String chave) {
		int indiceArray = hash(chave);
		
		if (array[indiceArray] == null) {
			return "Vazio (nenhum dado encontrado)";
		} else {
			return array[indiceArray].valor;
		}
	}
	
	public void mostrarTabela() {
		for (int i = 0; i < tamArray; i++) {
			if (array[i] == null) {
				System.out.println("Indice ["+i+"] -> [VAZIO]");
			} else {
				System.out.println("Indice ["+i+"] -> ["+array[i].valor+"]");
			}
		}
	}
	
}
