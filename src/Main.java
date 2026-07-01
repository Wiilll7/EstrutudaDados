
public class Main {

	public static void main(String[] args) {
int total = 100; // Total de etapas do processo
        
        System.out.println("Iniciando processo...");

        for (int i = 0; i <= total; i++) {
            // Calcula a porcentagem atual
            int percent = (i * 100) / total;
            
            // Cria a representação visual da barra
            StringBuilder barra = new StringBuilder("\r[");
            for (int j = 0; j < 50; j++) {
                if (j < percent / 2) {
                    barra.append("=");
                } else {
                    barra.append(" ");
                }
            }
            barra.append("] " + percent + "%");

            // Imprime a barra na mesma linha
            System.out.print(barra.toString());

            // Simula o tempo de execução de uma tarefa
            try {
                Thread.sleep(50); // 50 milissegundos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\nProcesso concluído com sucesso!");
	}

}
