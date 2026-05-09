package EstruturasLineares;

public class TesteListaEncadeada {

	public static void main(String[] args) {
		
		ListaEncadeada lista1 = new ListaEncadeada();
		

		lista1.inserirInicio(8);
		lista1.inserirInicio(2);
		lista1.inserirInicio(3);
		
		lista1.inserirFinal(5);
		
		lista1.mostrarLista();
		
		lista1.removerValor(8);
		
		System.out.println("----------------------------");
		
		lista1.mostrarLista();
		
	}

}
