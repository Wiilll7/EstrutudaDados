package TabelaHash.HashEncadeamento;

public class HashTable3 {

	// Metodos
	private int tamArray;
	private ListaEncadeada[] array;
	
	
	// Construtor
	public HashTable3(int tamArray) {
		this.tamArray = tamArray;
		this.array = new ListaEncadeada[tamArray];
	}
	
	
	// Metodos
	private int hash(String chave) {
		int hashCode = 0;
		
		for (byte b: chave.getBytes()) {
			hashCode += b;
		}
		
		return hashCode % tamArray;
	}
	
	public void inserir(String chave, String valor) {
		int indice = hash(chave);
		
		if (array[indice] == null) {
			array[indice] = new ListaEncadeada(chave, valor);
		} else {
			array[indice].atualizarOuAdicionar(chave, valor);
		}
	}
	
	public String buscar(String chave) {
		int indice = hash(chave);
		
		if (array[indice] == null) {
			return null;
		}
		
		return array[indice].buscaPorChave(chave);
	}
	
	public void remover(String chave) {
		int indice = hash(chave);
		
		if (array[indice] != null) {
			array[indice].removerChave(chave);
		}	
	}
	
	public void mostrarTabela() {
		
		for (int i = 0; i < tamArray; i++) {
			System.out.print("Indice ["+i+"] -> ");
			
			if (array[i] == null) {
				System.out.println("[Vazio]");
			} else {
				array[i].mostrarLista();
			}
		}
	}
	
}
