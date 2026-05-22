package TabelaHash.HashEncadeamento;

public class ListaEncadeada {

	// Classe Nodo interna
	private class Nodo {
		String chave;
		String valor;
		Nodo prox;
		
		public Nodo(String chave, String valor) {
			this.chave = chave;
			this.valor = valor;
			this.prox = null;
		}
	}
	
	
	// Atributos
	private Nodo inicio;
	
	
	// Construtor
	public ListaEncadeada(String chave, String valor) {
		this.inicio = new Nodo(chave, valor);
	}
	
	
	// Metodos
	public void atualizarOuAdicionar(String chave, String valor) {
		Nodo aux = inicio;
		
		while (aux != null) {
			// Se encontra a chave na lista, Atualiza o Valor
			if (aux.chave.equals(chave)) {
				aux.valor = valor;
				return;
			}
			aux = aux.prox;
		}
		
		// Se nao achou, adiciona no Inicio
		Nodo novoNodo = new Nodo(chave, valor);
		novoNodo.prox = inicio;
		inicio = novoNodo;
	}
	
	public String buscaPorChave(String chave) {
		Nodo aux = inicio;
		
		while (aux != null) {
			// Se encontra a chave na lista, retorna o valor
			if (aux.chave.equals(chave)) {
				return aux.valor;
			}
			aux = aux.prox;
		}
		
		return null;
	}
	
	public void removerChave(String chave) {
		if (inicio == null) return;
		
		// Se o valor for o peimeiro da lista
		if (inicio.chave.equals(chave)) {
			inicio = inicio.prox;
			return;
		}
		
		Nodo aux = inicio;
		
		while (aux.prox != null) {
			if (aux.prox.chave.equals(chave)) {
				aux.prox = aux.prox.prox;
				return;
			}
			aux = aux.prox;
		}
	}
	
	public void mostrarLista() {
		Nodo aux = inicio;
		
		while (aux != null) {
			System.out.print("{"+aux.chave+"} -> ");
			aux = aux.prox;
		}
		
		System.out.println("null");
	}
	
}
