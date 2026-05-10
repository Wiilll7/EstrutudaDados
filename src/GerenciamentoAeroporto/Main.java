package GerenciamentoAeroporto;

import java.util.Random;

public class Main {

	static Random random = new Random();

	// cria um novo aviao
	public static Aviao criarAviao(int id, int tempo) {
		int combustivel;
		
		if (id % 2 == 0) {
			combustivel = 999;
		} else {
			combustivel = random.nextInt(1, 21);
		}
		
		return new Aviao(id, combustivel, tempo);
	}
	
	// pega e da prioridade para o aviao com emergencia
	public static Aviao pegarEmergencia(FilaDinamica pouso) {
		FilaDinamica aux = new FilaDinamica();
		Aviao aviaoRemovido = null;
		
		// percorre a lista vendo se o aviao de cima esta em estado de emergencia
		// se nao estiver ele coloca em uma lista aux
		// se estiver ele remove da lista para realizar o pouso
		while (pouso.peek() != null) {
			
			if (pouso.peek().getCombustivel() <= 5 && aviaoRemovido == null) {
				aviaoRemovido = pouso.dequeue();
			} else {
				aux.enqueue(pouso.dequeue());
			}
			
		}
		
		// volta da lista aux para a lista normal
		while (aux.peek() != null) {
			if (!aux.vazia()) {
				pouso.enqueue(aux.dequeue());
			}
		}
		return aviaoRemovido;
	}
	
	// verifica se tem algum aviao em emergencia na fila
	public static boolean temEmergencia(FilaDinamica pouso) {
		FilaDinamica aux = new FilaDinamica();
		boolean emergencia = false;
		
		// percorre a lista vendo se existe algum aviao com combustivel <= 5 
		// adiciona em uma lista aux
		while (pouso.peek() != null) {
			if (pouso.peek().getCombustivel() <= 5) {
				emergencia = true;
			}
			aux.enqueue(pouso.dequeue());
		}
		
		// volta da lista aux para a lista normal
		while (aux.peek() != null) {
			if (!aux.vazia()) {
				pouso.enqueue(aux.dequeue());
			}
		}
		
		return emergencia;
	}
	
	// tira uma unidade de combustivel de todos os avioes
	public static void tirarCombustivel(FilaDinamica pouso) {
		FilaDinamica aux = new FilaDinamica();
		
		// percorre a lista alterando o combustivel e adicionando a uma lista aux
		while (pouso.peek() != null) {
			Aviao aviao = pouso.dequeue();
			aviao.setCombustivel(aviao.getCombustivel()-1);
			aux.enqueue(aviao);
		}
		
		// volta da lista aux para a lista padrao
		while (aux.peek() != null) {
			if (!aux.vazia()) {
				pouso.enqueue(aux.dequeue());
			}
		}
	}
	
	public static void main(String[] args) {
		
		// inicialização das Filas
		FilaDinamica pouso1 = new FilaDinamica();
		FilaDinamica decolagem1 = new FilaDinamica();
		
		FilaDinamica pouso2 = new FilaDinamica();
		FilaDinamica decolagem2 = new FilaDinamica();
		
		// variaveis para controle de dados e Tempo
		int tempo = 0;
		double mediaDecolagem = 0;
		double mediaPouso = 0;
		int qntDecolagem = 0;
		int qntPouso = 0;
		int qntPousoEmergencia = 0;
		
		// variavel para a criação de ID dos aviões
		int idPouso = 1;
		int idDecolagem = 0;
		
		// loop para os ciclos de tempo
		while (true) {
			try {
				// criação aleatoria de avioes para pouso/decolagem
				int pousar = random.nextInt(0, 3);
				int decolar = random.nextInt(0, 3);
				
				
				
				for (int i = 0; i < pousar; i++) {
					Aviao aviao = criarAviao(idPouso, tempo);
					
					if (pouso1.getTamanho() < pouso2.getTamanho()) {
						pouso1.enqueue(aviao);
					} else {
						pouso2.enqueue(aviao);
					}
					idPouso += 2;
				}
				
				
				for (int i = 0; i < decolar; i++) {
					Aviao aviao = criarAviao(idDecolagem, tempo);
					idDecolagem += 2;
					
					if (decolagem1.getTamanho() < decolagem2.getTamanho()) {
						decolagem1.enqueue(aviao);
					} else {
						decolagem2.enqueue(aviao);
					}
				}
				
				// exibe as informações na tela
				System.out.println("\n"
								+ "\n"
								+ "\n"
								+ "Unidade de Tempo: "+tempo);
				System.out.println("===================================================");
				System.out.println("Vão Pousar: "+pousar);
				System.out.println("Vão Decolar: "+decolar);
				System.out.println("---------------------------------------------------");
				System.out.println("Pista 1:");
				System.out.println("Decolagem: ");
				decolagem1.mostrarFila();
				System.out.println("Pouso: ");
				pouso1.mostrarFila();
				System.out.println("---------------------------------------------------");
				System.out.println("Pista 2:");
				System.out.println("Decolagem: ");
				decolagem2.mostrarFila();
				System.out.println("Pouso: ");
				pouso2.mostrarFila();
				System.out.println("---------------------------------------------------");
				if (qntDecolagem == 0) {
					System.out.println("Tempo médio de Decolagem: 0");
				} else {
					System.out.println("Tempo médio de Decolagem: "+(mediaDecolagem / qntDecolagem));
				}
				if (qntPouso == 0) {
					System.out.println("Tempo médio de Pouso: 0");
				} else {
					System.out.println("Tempo médio de Pouso: "+(mediaPouso / qntPouso));
				}
				System.out.println("Numero de aviões que pousaram em Emergencia: "+qntPousoEmergencia);
				
				
				// verifica se nao tem avioes em emergencias e nem muitos pousos pendentes na pista 1
				if (!temEmergencia(pouso1) && pouso1.getTamanho() < decolagem1.getTamanho()) {
					
					// decola um aviao
					if (decolagem1.getTamanho() > 0) {
						mediaDecolagem += tempo - decolagem1.dequeue().getHoraChegada();
						qntDecolagem++;
					}
					
				// pousa um aviao
				} else {
					// verifica se existe uma emergencia para pousar
					if (temEmergencia(pouso1)) {
						// pousa um aviao com emergencia
						mediaPouso += tempo - pegarEmergencia(pouso1).getHoraChegada();
						qntPouso++;
						qntPousoEmergencia++;
						
					} else {
						// pousa o aviao na frente da fila
						if (pouso1.getTamanho() > 0) {
							mediaPouso += tempo - pouso1.dequeue().getHoraChegada();
							qntPouso++;
						}
					}
				}
				
				// verifica se nao tem avioes em emergencias e nem muitos pousos pendentes na pista 2
				// mesma logica do anterior
				if (!temEmergencia(pouso2) && pouso2.getTamanho() < decolagem2.getTamanho()) {
					
					if (decolagem2.getTamanho() > 0) {
						mediaDecolagem += tempo - decolagem2.dequeue().getHoraChegada();
						qntDecolagem++;
					}
					
				} else {
					if (temEmergencia(pouso2)) {
						mediaPouso += tempo - pegarEmergencia(pouso2).getHoraChegada();
						qntPouso++;
						qntPousoEmergencia++;
						
					} else {
						if (pouso2.getTamanho() > 0) {
							mediaPouso += tempo - pouso2.dequeue().getHoraChegada();
							qntPouso++;
						}
					}
				}
				
				// remove uma unidade de combustivel de ambas as pistas
				tirarCombustivel(pouso1);
				tirarCombustivel(pouso2);
				
				tempo++;
				Thread.sleep(10000);
			} catch (Exception e) {
				System.out.println("Algo deu errado");
				e.printStackTrace();
			}
		}

	}

}
