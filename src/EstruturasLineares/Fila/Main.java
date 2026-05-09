package EstruturasLineares.Fila;

public class Main {

	public static void main(String[] args) {
		/*
		System.out.println("Testando Fila Dinamica");
		IFila filaDinamica = new FilaDinamica();
		
		filaDinamica.enqueue(55);
		filaDinamica.enqueue(66);
		filaDinamica.enqueue(77);
		filaDinamica.enqueue(88);
		filaDinamica.mostrarFila();
		
		System.out.println("Desenfileirando " + filaDinamica.dequeue());
		
		filaDinamica.mostrarFila();
		*/
		
		System.out.println("Testando Fila Estatica");
		IFila filaEstatica = new FilaEstatica(3);
		
		filaEstatica.enqueue(10);
		filaEstatica.enqueue(20);
		filaEstatica.enqueue(30);
		filaEstatica.mostrarFila();
		filaEstatica.enqueue(40);
		
		System.out.println("Desenfileirando " + filaEstatica.dequeue());
		
		filaEstatica.mostrarFila();
	}

}
