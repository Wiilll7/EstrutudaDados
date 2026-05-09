package EstruturasLineares.Fila;

import EstruturasLineares.Nodo;
import EstruturasLineares.pilha.PilhaDinamica;

public class FilaDinamica implements IFila {

	private Nodo inicio;
	private Nodo fim;
	
	
	//Contrutor
	public FilaDinamica() {
		inicio = null;
		fim = null;
	}

	
	//Metodos
	public void enqueue(int dado) {
		Nodo novoNodo = new Nodo(dado);
		
		if (vazia()) {
			inicio = novoNodo;
			fim = novoNodo;
			return;
		}
		
		fim.setProx(novoNodo);
		fim = novoNodo;
	}

	public int dequeue() {
		
		if (vazia()){
			System.out.println("Lista vazia");
			return -1;
		}
		
		int valorRemovido = inicio.getDado();
		inicio = inicio.getProx();
		
		if (inicio == null) {
			fim = null;
		}
		
		return valorRemovido;
	}

	public int peek() {
		
		if (vazia()) {
			System.out.println("Lista Vazia");
			return -1;
		}
		
		return inicio.getDado();
	}

	public boolean vazia() {
		return inicio == null;
	}

	public void mostrarFila() {
		
		if (vazia()) {
			System.out.println("Fila vazia");
			return;
		}
		
		Nodo aux = inicio;
		System.out.print("Frente ->");
		
		while (aux != null) {
			System.out.println(aux.getDado() + " ");
			aux = aux.getProx();
		}
		
		System.out.println("<- Fim");
	}

	public void inverterFila(IFila fila) {
		
		PilhaDinamica pilha = new PilhaDinamica();
		Nodo aux = inicio;
		
		while (aux != fim) {
			pilha.push(fila.dequeue());
			aux = aux.getProx();
		}
		
		
	}
	
}
