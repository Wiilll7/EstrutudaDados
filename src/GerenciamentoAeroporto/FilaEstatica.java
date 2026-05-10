package GerenciamentoAeroporto;

public class FilaEstatica {

	//Atributos
	private Aviao[] avioes;
	private int inicio;
	private int fim;
	private int tamanho;
	private int capacidade;
	
	
	//Construtor
	public FilaEstatica(int capacidade) {
		this.capacidade = capacidade;
		avioes = new Aviao[capacidade];
		inicio = 0;
		fim = -1;
		tamanho = 0;
	}
	
	
	//Metodos
	public void enqueue(Aviao aviao) {
		if (cheia()) {
			System.out.println("Lista Cheia");
			return;
		}
		
		//Se o fim for 4 e a capacidade for 5: (4 + 1) % 5 = 0
		fim = (fim + 1) % capacidade;
		avioes[fim] = aviao;
		tamanho++;
	}

	public Aviao dequeue() {
		if (vazia()) {
			System.out.println("A lista esta Vazia");
			return null;
		}
		
		Aviao valorRemovido = avioes[inicio];
		inicio = (inicio + 1) % capacidade;
		tamanho--;
		
		return valorRemovido;
	}

	public Aviao peek() {
		if (vazia()) {
			System.out.println("A lista esta Vazia");
			return null;
		}
		return avioes[inicio];
	}

	public boolean vazia() {
		return tamanho == 0;
	}
	
	public boolean cheia() {
		return tamanho == capacidade;
	}

	public void mostrarFila() {
		if (vazia()) {
			System.out.println("A fila esta Vazia");
			return;
		}
		
		System.out.print("Frente ->");
		int cont = 0;
		int i = inicio;
		
		while (cont < tamanho) {
			System.out.print(avioes[i] + " ");
			i = (i + 1) % capacidade; //Caminha de forma circular
			cont++;
		}
		
		System.out.print("<- Final");
	}
	
	public int getTamanho() {
		return tamanho;
	}
}
