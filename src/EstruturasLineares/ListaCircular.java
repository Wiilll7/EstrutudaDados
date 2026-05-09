package EstruturasLineares;

public class ListaCircular {

	private Nodo inicio;
	private Nodo fim;
	
	
	public ListaCircular() {
		this.inicio = null;
		this.fim = null;
	}


	public Nodo getInicio() {
		return inicio;
	}
	public Nodo getFim() {
		return fim;
	}	
	
	
	public boolean vazia() {
		return inicio == null;
	}
	
	public void inserirInicio(int valor) {
		Nodo novoNodo = new Nodo(valor);
		
		if (vazia()) {
			inicio = novoNodo;
			fim = novoNodo;
			fim.setProx(inicio);
			return;
		}
		
		novoNodo.setProx(inicio);
		inicio = novoNodo; // Atualiza Inicio
		fim.setProx(inicio); // Fim aponta para o Novo Inicio
		
		
	}
	
	public void inserirFim(int valor) {
		
		if (vazia()) {
			inserirInicio(valor);
			return;
		}
		
		Nodo novoNodo = new Nodo(valor);
		
		fim.setProx(novoNodo);
		fim = novoNodo;
		fim.setProx(inicio);
		
	}
	
	public void mostrarLista() {
		
		if (vazia()) {
			System.out.println("Lista Vazia.");
			return;
		}
		
		Nodo aux = inicio;
		
		do {
			
			System.out.println(aux.getDado());
			aux = aux.getProx();
			
		} while(aux != inicio);
		
	}
	
	public void removerValor(int valor) {
		
		if (vazia()) return;
		
		//Caso 1: Valor esta no inicio 
		if (inicio.getDado() == valor) {
			
			//Se for o unico elemento da lista
			if (inicio == fim) {
				inicio = null;
				fim = null;
				return;
			}
			
			inicio = inicio.getProx();
			fim.setProx(inicio);
			return;
			
		}
		
		//Caso 2: Se o elemento esta no meio ou no fim
		Nodo aux = inicio;
		while(aux.getProx() != inicio){
			
			if (aux.getProx().getDado() == valor) {
				
				//Se o valor que vamos remover for o ultimo
				if (aux.getProx() == fim) {
					fim = aux;
					fim.setProx(inicio);
				} else {
					//Remover no meio
					aux.setProx(aux.getProx().getProx());
				}
				
				return;
			}
			
			aux = aux.getProx();
		}
		
	}
	
	public int tamanho() {
		
		if (vazia()) {
			return 0;
		}
		
		Nodo aux = inicio;
		int i = 0;
		
		do {
			i++;
			aux = aux.getProx();
			
		} while(aux != inicio);
		
		return i;
	}

	public void imprimirMeio() {
		
		if (vazia()) {
			System.out.println("Lista Vazia.");
			return;
		}
		
		Nodo aux = inicio;
		Nodo aux2 = inicio;
		
		do {
			aux2 = aux2.getProx();
			
			if (aux2 == inicio) {
				break;
			}

			aux = aux.getProx();
			aux2 = aux2.getProx();
			
		} while(aux2 != inicio);
		
		System.out.println(aux.getDado());
		
		return;
	}
	
}