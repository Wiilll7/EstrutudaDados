package TabelaHash;

public class Main {

	public static void main(String[]args) {
		
		HashTable1 table = new HashTable1(5);

		table.inserir("UVA", "R$8.00");
		table.inserir("MACA", "R$5.00");
		
		table.mostrarTabela();

		System.out.println(table.recuperar("UVA"));
		
	}
}
