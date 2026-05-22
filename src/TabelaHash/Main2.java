package TabelaHash;

public class Main2 {

	public static void main (String[]args) {
		
		HashTable2 table = new HashTable2(4);
		
		table.inserir("ANA", "(47) 99999-1111");
		table.inserir("ALICE", "(47) 99999-2222");
		
		table.mostrarTabela();
		
		table.inserir("CELIA", "(47) 99999-3333");
		
		table.mostrarTabela();
		
		table.inserir("BRUNO", "(47) 99999-4444");
		
		table.mostrarTabela();
	}
	
}
