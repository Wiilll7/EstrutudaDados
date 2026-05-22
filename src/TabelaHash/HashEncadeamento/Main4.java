package TabelaHash.HashEncadeamento;

public class Main4 {

	public static void main(String[]args) {
		
		HashTable3 table = new HashTable3(10000);
		
		long antes = System.currentTimeMillis();
		
		for (int i = 0; i < 10000; i++) {
			
			table.inserir("chave_"+i, "ABC");
			
		}
		
		long dps = System.currentTimeMillis();
		
		System.out.println(dps - antes);
	}
	
}
