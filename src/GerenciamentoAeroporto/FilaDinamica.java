package GerenciamentoAeroporto;

public class FilaDinamica {

	private Nodo inicio;
	private Nodo fim;
	int tamanho = 0;
	
	//Contrutor
	public FilaDinamica() {
		inicio = null;
		fim = null;
	}

	//Metodos
	public void enqueue(Aviao aviao) {
		
		Nodo novoNodo = new Nodo(aviao);
		tamanho++;
		
		if (vazia()) {
			inicio = novoNodo;
			fim = novoNodo;
			return;
		}
		
		fim.setProx(novoNodo);
		fim = novoNodo;
	}

	public Aviao dequeue() {
		
		if (vazia()){
			System.out.println("Lista vazia");
			return null;
		}
		
		Aviao valorRemovido = inicio.getAviao();
		inicio = inicio.getProx();
		
		if (inicio == null) {
			fim = null;
		}
		
		tamanho--;
		return valorRemovido;
	}
	
	public void mostrarFila() {
		
		if (vazia()) {
			System.out.println("Fila vazia");
			return;
		}
		
		Nodo aux = inicio;
		
		while (aux != null) {
			System.out.println(aux.getAviao() + " ");
			aux = aux.getProx();
		}
	}

	public Aviao peek() {
		
		if (vazia()) {
			return null;
		}
		
		return inicio.getAviao();
	}

	public boolean vazia() {
		return inicio == null;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
}
