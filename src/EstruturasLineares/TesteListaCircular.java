package EstruturasLineares;

public class TesteListaCircular {
	public static void main(String[]Args) {
		
		ListaCircular lista1 = new ListaCircular();
		
		lista1.inserirInicio(8);
		lista1.inserirInicio(2);
		lista1.inserirInicio(3);
		
		lista1.inserirFim(5);
		lista1.inserirFim(7);
		
		lista1.mostrarLista();
		
		System.out.println("\n--------------------------------------\n");
		
		
		lista1.imprimirMeio();
	}
}
