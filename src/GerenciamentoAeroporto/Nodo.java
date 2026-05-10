package GerenciamentoAeroporto;

public class Nodo {
	
	// atributos
	private Aviao aviao;
	private Nodo prox;
	
	// construtor
	public Nodo(Aviao aviao) {
		this.aviao = aviao;
		this.prox = null;
	}
	
	// set e get
	public Aviao getAviao() {
		return aviao;
	}
	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}
	public Nodo getProx() {
		return prox;
	}
	public void setProx(Nodo prox) {
		this.prox = prox;
	}
	
}
