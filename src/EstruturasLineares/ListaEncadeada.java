package EstruturasLineares;

public class ListaEncadeada {

	private Nodo inicio;

	public ListaEncadeada() {
		this.inicio = null;
	}
	
	public Nodo getInicio() {
		return inicio;
	}
	
	public boolean listaVazia() {
		return inicio == null;
	}
	
	public void inserirInicio(int dado) {
		Nodo novoNodo = new Nodo(dado);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
	}
	
	public void inserirFinal(int dado) {
		if (listaVazia()) {
			inserirInicio(dado);
			return;
		}
		
		Nodo novoNodo = new Nodo(dado);
		Nodo aux = inicio;
		
		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		
		aux.setProx(novoNodo);
		
	}
	
	public void removerValor(int valor) {
		if (listaVazia()) return;
		
		if (inicio.getDado() == valor) {
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		
		while (aux.getProx() != null) {
			
			if (aux.getProx().getDado() == valor) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			
			aux = aux.getProx();
			
		}
	}
	
	public void mostrarLista() {
		if (listaVazia()) {
			System.out.println("Lista esta vazia");
			return;
		}
		
		Nodo aux = inicio;
		
		while (aux.getProx() != null) {
			System.out.println(aux.getDado());
			aux = aux.getProx();
		}
		System.out.println(aux.getDado());
	}
	
	public void transformarEmCircular() {
		
		
		
	}
	
}
