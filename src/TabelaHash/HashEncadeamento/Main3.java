package TabelaHash.HashEncadeamento;

public class Main3 {
	
	public static double calcularRaizQuadrada(double n, double precisao) {
        // Estimativa inicial
        double x = n / 2;
        
        // Laço de repetição do Método de Newton
        while (true) {
            // Próxima aproximação: x_1 = x_0 - f(x_0) / f'(x_0)
            double proximoX = (x + n / x) / 2;
            
            // Calcula o erro absoluto
            double erro = Math.abs(x - proximoX);
            
            // Se a diferença for menor que a precisão, chegamos ao resultado
            if (erro < precisao) {
                break;
            }
            
            x = proximoX;
        }
        
        return x;
    }
	
	public static void main (String[]args) {
		
		HashTable3 table = new HashTable3(4);
		
		table.inserir("ANA", "(47) 99999-1111");
		table.inserir("ALICE", "(47) 99999-2222");
		table.inserir("CELIA", "(47) 99999-3333");
		table.inserir("BRUNO", "(47) 99999-4444");
		
		table.remover("CELIA");
		
		table.mostrarTabela();
		
		while (true) {
			double numero = 23.0; // Número para calcular a raiz
	        double precisao = 0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000001; // Margem de erro desejada

	        double raiz = calcularRaizQuadrada(numero, precisao);
	        System.out.println(raiz);
	        break;
		}
	}
}
