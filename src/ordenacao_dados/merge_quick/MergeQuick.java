package ordenacao_dados.merge_quick;

import java.util.Arrays;

public class MergeQuick {

	public static void mergeSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		mergeSortRecursivo(array, 0, array.length-1);
	}
	
	private static void mergeSortRecursivo(int[] array, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			// Divisao: ordena recursivamente o subarray esquerdo e direito
			mergeSortRecursivo(array, inicio, meio);
			mergeSortRecursivo(array, meio+1, fim);

			// Conquista: intercala os dois subarrays previamente ordenados
			merge(array, inicio, meio, fim);
		}
	}
	
	private static void merge(int[] array, int inicio, int meio, int fim) {
		
		// 1. Determinacao dos tamanhos dos subarrays
		int tamanhoEsq = meio - inicio + 1;
		int tamanhoDir = fim - meio;
		
		int[] vetorEsq = new int[tamanhoEsq];
		int[] vetorDir = new int[tamanhoDir];
		
		// 2. Copia dos elementos do vetor principal para os auxiliares
		for (int i = 0; i < tamanhoEsq; i++) {
			vetorEsq[i] = array[inicio + i];
		}
		
		for (int j = 0; j < tamanhoDir; j++) {
			vetorDir[j] = array[meio + 1 + j];
		}
		
		// 3. Processo de intercalacao (merge)
		int i = 0; // Ponteiro de leitura do subarray esquerdo
		int j = 0; // Ponteiro de leitura do subarray direito
		int k = inicio; // Ponteiro de gravacao no array original
		
		// Compara os elementos e insere o menor no array original
		while (i < tamanhoEsq && j < tamanhoDir) {
			if (vetorEsq[i] <= vetorDir[j]) {
				array[k] = vetorEsq[i];
				i++;
			} else {
				array[k] = vetorDir[j];
				j++;
			}
			k++;
		}
		
		// 4. Transferencia dos elementos remanescentes (se houver)
		while (i < tamanhoEsq) {
			array[k] = vetorEsq[i];
			i++;
			k++;
		}
		
		while (j < tamanhoDir) {
			array[k] = vetorDir[j];
			j++;
			k++;
		}
	}
	
	public static void quickSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		quickSortRecursivo(array, 0, array.length-1);
	}
	
	private static void quickSortRecursivo(int[] array, int inicio, int fim) {
		if (inicio < fim) {
			// Posiciona os elementos em relacao ao pivo e obtem o indice de corte
			int pontoDeCorte = particao(array, inicio, fim);
			
			quickSortRecursivo(array, inicio, pontoDeCorte);
			quickSortRecursivo(array, pontoDeCorte+1, fim);
		}
	}
	
	private static int particao(int[] array, int inicio, int fim) {
		// 1, Definicao do pivo
		int meio = (inicio + fim) / 2;
		int pivo = array[meio];
		
		int i = inicio;
		int j = fim;
		
		// 2. Inicializacao do ponteiro nas extremidades do escopo atual
		while(true) {
			// Avalia o ponteiro 'i' ate encontrar um elemento igual ou maior ao pivo
			while (array[i] < pivo) {
				i++;
			}
			
			// Recua o ponteiro 'j' ate encontrar um elemento menor ou igual ao pivo
			while (array[j] > pivo) {
				j--;
			}
			
			if (i >= j) {
				return j;
			}
			
			// 3. Operacao de troca para readequar os elementos mal posicionados
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			
			// Incremento para evitar laco infinito apos troca de elementos iguais ao pivo
			i++;
			j--;
		}
	}
	
	public static void main(String[]args) {
		int[] arrayOriginal = {64, 34, 25, 12, 22, 11, 90, 5, 42, 8};
		System.out.println("Array original: "+Arrays.toString(arrayOriginal));
		
		int[] arrayMerge = arrayOriginal.clone();
		
		long inicioMerge = System.nanoTime();
		mergeSort(arrayMerge);
		long fimMerge = System.nanoTime();
		
		System.out.println("Array ordenado merge: "+Arrays.toString(arrayMerge));
		System.out.println("Tempo de execucao: "+(fimMerge - inicioMerge));
		
		int[] arrayQuick = arrayOriginal.clone();
		
		long inicioQuick = System.nanoTime();
		quickSort(arrayQuick);
		long fimQuick = System.nanoTime();
		
		System.out.println("Array ordenado Quick: "+Arrays.toString(arrayQuick));
		System.out.println("Tempo de execucao: "+(fimQuick - inicioQuick));
		
	}
	
}
