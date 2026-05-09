package EstruturasLineares.Fila;

public interface IFila {
	
	void enqueue(int data);
	int dequeue();
	int peek();
	boolean vazia();
	void mostrarFila();
	
}
