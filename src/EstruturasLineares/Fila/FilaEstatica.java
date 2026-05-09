package EstruturasLineares.Fila;

public class FilaEstatica implements IFila {

	//Atributos
	private int[] dados;
	private int inicio;
	private int fim;
	private int tamanho;
	private int capacidade;
	
	
	//Construtor
	public FilaEstatica(int capacidade) {
		this.capacidade = capacidade;
		dados = new int[capacidade];
		inicio = 0;
		fim = -1;
		tamanho = 0;
	}
	
	
	//Metodos
	public void enqueue(int dado) {
		if (cheia()) {
			System.out.println("Lista Cheia");
			return;
		}
		
		//Se o fim for 4 e a capacidade for 5: (4 + 1) % 5 = 0
		fim = (fim + 1) % capacidade;
		dados[fim] = dado;
		tamanho++;
	}

	public int dequeue() {
		if (vazia()) {
			System.out.println("A lista esta Vazia");
			return -1;
		}
		
		int valorRemovido = dados[inicio];
		inicio = (inicio + 1) % capacidade;
		tamanho--;
		
		return valorRemovido;
	}

	public int peek() {
		if (vazia()) {
			System.out.println("A lista esta Vazia");
			return -1;
		}
		return dados[inicio];
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
			System.out.print(dados[i] + " ");
			i = (i + 1) % capacidade; //Caminha de forma circular
			cont++;
		}
		
		System.out.print("<- Final");
	}

}
