package TabelaHash.HashTableQuadratica;

public class Main {

	public static void main(String[] args) {
			
		HashTableQuadratica table = new HashTableQuadratica(52);
		
		table.inserir("ANA", "(47) 99999-1111");
		table.inserir("ALICE", "(47) 99999-2222");
		
		table.inserir("CELIA", "(47) 99999-3333");
		table.inserir("BRUNO", "(47) 99999-4444");
		
		table.mostrarTabela();

	}

}