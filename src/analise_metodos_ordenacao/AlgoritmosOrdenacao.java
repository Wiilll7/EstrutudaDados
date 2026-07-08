package analise_metodos_ordenacao;

import ordenacao_dados.bubble_sort.MetricasOrdenacao;

public class AlgoritmosOrdenacao {

	// 1. Bubble Sort
	public void bubbleSort(int[] array, MetricasOrdenacao mo) {
		mo.setTempoInicial();
		int n = array.length;
		boolean trocou;
		
		for (int i = 0; i < n - 1; i++) {
			trocou = false;
			
			for (int j = 0; j < n-1-i; j++) {
				// Compara elementos adjacentes
				if (array[j] > array[j+1]) {
					// Realiza a troca dos elementos
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					trocou = true;
					mo.addTrocas();	
				}
				mo.addComparacoes();
			}
			
			if (!trocou) {
				break;
			}
		}
		mo.setTempoFinal();
	}
	
	public void selectionSort(int[] vetor, MetricasOrdenacao mo) {
        // Inicialização de métricas
        mo.setTempoInicial();
        
        int k = vetor.length;

        int temp;
        int menor;

        // Para cada valor do array (certeza de ordenação)
        for (int i = 0; i < k-1; i++) {
            menor = i;

            // Para cada valor do array
            for (int j = i; j < k; j++) {

                // Coleta o menor valor
                mo.addComparacoes();
                if (vetor[menor] > vetor[j]) {
                    menor = j;
                }
            }

            // Testa se o valor é menor que o i atual
            if (i != menor) {
                // Troca se necessário
                mo.addTrocas();
                temp = vetor[i];
                vetor[i] = vetor[menor];
                vetor[menor] = temp;
            }

        }

        // Fechamento e retorno de métricas
        mo.setTempoFinal();
    }
	
	
	// 3. Insertion Sort
	public void insertionSort(int[] array, MetricasOrdenacao mo) {
		mo.setTempoInicial();
		int n = array.length;
		
		for (int i = 0; i < n; i++) {
			int chave = array[i];
			int j = i-1;
			
			// Compara o elemento chave com os elementos anteriores ja ordenados
			while (j>=0 && array[j] > chave) {
				// Arrasta o elemento maior para a direita
				array[j+1] = array[j];
				j--;
				mo.addComparacoes();
				mo.addTrocas();
			}
			mo.addComparacoes();
			mo.addTrocas();
			
			// Insere a chave na sua posicao final correta
			array[j+1] = chave;
		}
		mo.setTempoFinal();
	}
	
	// 4. Merge Sort
	public void mergeSort(int[] array, MetricasOrdenacao mo) {
		mo.setTempoInicial();
		if (array == null || array.length <= 1) {
			return;
		}
		mergeSortRecursivo(array, 0, array.length-1, mo);
		mo.setTempoFinal();
	}
	
	private void mergeSortRecursivo(int[] array, int inicio, int fim, MetricasOrdenacao mo) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			// Divide o problema pela metade e ordena recursivamente o subarray esquerdo e direito
			mergeSortRecursivo(array, inicio, meio, mo);
			mergeSortRecursivo(array, meio+1, fim, mo);

			// Intercala os dois subarrays previamente ordenados em um unico array
			merge(array, inicio, meio, fim, mo);
		}
	}
	
	private void merge(int[] array, int inicio, int meio, int fim, MetricasOrdenacao mo) {
        
        // 1. Tamanhos dos subarrays
        int tamanhoEsq = meio - inicio + 1;
        int tamanhoDir = fim - meio;
        
        int[] vetorEsq = new int[tamanhoEsq];
        int[] vetorDir = new int[tamanhoDir];
        
        // 2. Copia para arrays auxiliares
        for (int i = 0; i < tamanhoEsq; i++) {
            vetorEsq[i] = array[inicio + i];
        }
        
        for (int j = 0; j < tamanhoDir; j++) {
            vetorDir[j] = array[meio + 1 + j];
        }
        
        // 3. Processo de intercalação (merge)
        int i = 0; // Ponteiro do subarray esquerdo
        int j = 0; // Ponteiro do subarray direito
        int k = inicio; // Ponteiro do array original
        
        // Compara e insere o menor no array original
        while (i < tamanhoEsq && j < tamanhoDir) {
            mo.addComparacoes();
            
            // Compara o topo do subarray esquerdo com o topo do subarray direito
            if (vetorEsq[i] <= vetorDir[j]) {
            	// Movimentacao do elemento da esquerda para o array principal
                array[k] = vetorEsq[i];
                i++;
            } else {
            	// Movimentacao do elemento da direita para o array principal
                array[k] = vetorDir[j];
                j++;
            }
            mo.addTrocas();
            k++;
        }
        
        // 4. Copia os elementos restantes da esquerda (se houver)
        while (i < tamanhoEsq) {
            array[k] = vetorEsq[i];
            mo.addTrocas();
            i++;
            k++;
        }
        
        // 5. Copia os elementos restantes da direita (se houver)
        while (j < tamanhoDir) {
            array[k] = vetorDir[j];
            mo.addTrocas();
            j++;
            k++;
        }
    }
	
	// 5. Quick Sort
	public void quickSort(int[] array, MetricasOrdenacao mo) {
		mo.setTempoInicial();
		if (array == null || array.length <= 1) {
			return;
		}
		quickSortRecursivo(array, 0, array.length-1, mo);
		mo.setTempoFinal();
	}
	
	private void quickSortRecursivo(int[] array, int inicio, int fim, MetricasOrdenacao mo) {
		if (inicio < fim) {
			// Posiciona os elementos em relacao ao pivo e obtem o indice de corte
			int pontoDeCorte = particao(array, inicio, fim, mo);
			
			// Chamada recursiva para ordenar a divisao esquerda e direita
			quickSortRecursivo(array, inicio, pontoDeCorte, mo);
			quickSortRecursivo(array, pontoDeCorte+1, fim, mo);
		}
	}
	
	private int particao(int[] array, int inicio, int fim, MetricasOrdenacao mo) {
        // 1. Definicao do pivo
        int meio = (inicio + fim) / 2;
        int pivo = array[meio];
        
        int i = inicio;
        int j = fim;
        
        // 2. Inicializacao dos ponteiros nas extremidades
        while(true) {
            
            // Avanca 'i' ate encontrar um elemento maior ou igual ao pivo
            mo.addComparacoes();
            while (array[i] < pivo) {
                i++;
                mo.addComparacoes();
            }
            
            // Recua 'j' ate encontrar um elemento menor ou igual ao pivo
            mo.addComparacoes();
            while (array[j] > pivo) {
                j--;
                mo.addComparacoes();
            }
            
            // Se os ponteiros se cruzarem, a particao terminou
            if (i >= j) {
                return j;
            }
            
            // Troca os elementos mal posicionados em relacao ao pivo
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            
            mo.addTrocas();
            i++;
            j--;
        }
    }
	
	// 6. Heap Sort
    public void heapSort(int[] array, MetricasOrdenacao mo) {
    	mo.setTempoInicial();
        int n = array.length;

        // Constroi o max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, mo);
        }

        // Extrai os elementos um a um
        for (int i = n - 1; i > 0; i--) {
            // Troca a raiz para o fim do array
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            mo.addTrocas();

            // Reajusta o heap reduzido
            heapify(array, i, 0, mo);
        }
        mo.setTempoFinal();
    }

    // Ajusta a subarvore a partir do no i
    private void heapify(int[] array, int n, int i, MetricasOrdenacao mo) {
        int largest = i;        // Raiz como maior valor
        int left = 2 * i + 1;   // Filho esquerdo
        int right = 2 * i + 2;  // Filho direito

        // Compara para verificar se o filho esquerdo e maior que a raiz
        if (left < n) {
            mo.addComparacoes();
            if (array[left] > array[largest]) {
                largest = left;
            }
        }

        // Compara para verificar se o filho direito e maior que o maximo atual
        if (right < n) {
            mo.addComparacoes();
            if (array[right] > array[largest]) {
                largest = right;
            }
        }

        // Troca se a raiz nao for a maior e continua
        if (largest != i) {
        	// Realiza a troca do maior elemento com a raiz
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            
            mo.addTrocas();

            // Ajusta a subarvore afetada recursivamente dividindo o problema para o proximo nivel
            heapify(array, n, largest, mo);
        }
    }
    
    // 7. Shell Sort
    public void shellSort(int[] array, MetricasOrdenacao mo) {
    	mo.setTempoInicial();
        int n = array.length;

        // Comeca com um intervalo grande e vai reduzindo pela metade
        for (int step = n / 2; step > 0; step /= 2) {
            
            // Aplica o Insertion Sort adaptado para o step atual
            for (int i = step; i < n; i++) {
                int temp = array[i];
                int j = i;

                // Percorre os elementos saltando de step em step
                while (j >= step) {
                    mo.addComparacoes();
                    
                    // Compara o elemento atual com o elemento com a distancia step
                    if (array[j - step] > temp) {
                    	// Movimenta o elemento comparado para a posicao 'j'
                        array[j] = array[j - step];
                        mo.addTrocas();
                        j -= step;
                    } else {
                        break; // Se nao for maior, para de procurar
                    }
                }
                
                // Movimenta o elemento temporario para a sua posicao final neste passo
                array[j] = temp;
                mo.addTrocas();
            }
        }
        mo.setTempoFinal();
    }
    
}