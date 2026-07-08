package analise_metodos_ordenacao;

import ordenacao_dados.bubble_sort.MetricasOrdenacao;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Random random = new Random();
		MetricasOrdenacao mo = new MetricasOrdenacao();
		AlgoritmosOrdenacao ao = new AlgoritmosOrdenacao();
		
		int[] arrayMenorOrdenado = new int[100000];
		int[] arrayMaiorOrdenado = new int[1000000];
		
		int[] arrayMenorInverso = new int[100000];
		int[] arrayMaiorInverso = new int[1000000];
		
		int[] arrayMenorAleatorio = new int[100000];
		int[] arrayMaiorAleatorio = new int[1000000];
		
		int j = 99999;
		
		for (int i = 0; i < 100000; i++) {
			arrayMenorOrdenado[i] = i;
			arrayMenorAleatorio[i] = random.nextInt(0, 100000);
			arrayMenorInverso[i] = j;
			j--;
		}
		
		j = 999999;
		
		for (int i = 0; i < 1000000; i++) {
			arrayMaiorOrdenado[i] = i;
			arrayMaiorAleatorio[i] = random.nextInt(0, 1000000);
			arrayMaiorInverso[i] = j;
			j--;
		}
		
		System.out.println("=============================================\n");
		System.out.println("Testes com Array de tamanho 100000: \n");
		
		System.out.println("\nArray Ordenado: \n");
		int[] arrayMenorOrdenadoBubble = arrayMenorOrdenado.clone();
		ao.bubbleSort(arrayMenorOrdenadoBubble, mo);
		System.out.println("Bubble Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorOrdenadoSelection = arrayMenorOrdenado.clone();
		ao.selectionSort(arrayMenorOrdenadoSelection, mo);
		System.out.println("Selection Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorOrdenadoInsertion = arrayMenorOrdenado.clone();
		ao.insertionSort(arrayMenorOrdenadoInsertion, mo);
		System.out.println("Insertion Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorOrdenadoMerge = arrayMenorOrdenado.clone();
		ao.mergeSort(arrayMenorOrdenadoMerge, mo);
		System.out.println("Merge Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorOrdenadoQuick = arrayMenorOrdenado.clone();
		ao.quickSort(arrayMenorOrdenadoQuick, mo);
		System.out.println("Quick Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorOrdenadoHeap = arrayMenorOrdenado.clone();
		ao.heapSort(arrayMenorOrdenadoHeap, mo);
		System.out.println("Heap Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorOrdenadoShell = arrayMenorOrdenado.clone();
		ao.shellSort(arrayMenorOrdenadoShell, mo);
		System.out.println("Shell Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		System.out.println("\n-------------------------------------------------");
		
		System.out.println("\nArray Inverso: \n");
		mo = new MetricasOrdenacao();
		int[] arrayMenorInversoBubble = arrayMenorInverso.clone();
		ao.bubbleSort(arrayMenorInversoBubble, mo);
		System.out.println("Bubble Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorInversoSelection = arrayMenorInverso.clone();
		ao.selectionSort(arrayMenorInversoSelection, mo);
		System.out.println("Selection Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorInversoInsertion = arrayMenorInverso.clone();
		ao.insertionSort(arrayMenorInversoInsertion, mo);
		System.out.println("Insertion Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorInversoMerge = arrayMenorInverso.clone();
		ao.mergeSort(arrayMenorInversoMerge, mo);
		System.out.println("Merge Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorInversoQuick = arrayMenorInverso.clone();
		ao.quickSort(arrayMenorInversoQuick, mo);
		System.out.println("Quick Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorInversoHeap = arrayMenorInverso.clone();
		ao.heapSort(arrayMenorInversoHeap, mo);
		System.out.println("Heap Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorInversoShell = arrayMenorInverso.clone();
		ao.shellSort(arrayMenorInversoShell, mo);
		System.out.println("Shell Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		System.out.println("\n-------------------------------------------------");
		
		System.out.println("\nArray Aleatorio: \n");
		mo = new MetricasOrdenacao();
		int[] arrayMenorAleatorioBubble = arrayMenorAleatorio.clone();
		ao.bubbleSort(arrayMenorAleatorioBubble, mo);
		System.out.println("Bubble Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorAleatorioSelection = arrayMenorAleatorio.clone();
		ao.selectionSort(arrayMenorAleatorioSelection, mo);
		System.out.println("Selection Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorAleatorioInsertion = arrayMenorAleatorio.clone();
		ao.insertionSort(arrayMenorAleatorioInsertion, mo);
		System.out.println("Insertion Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorAleatorioMerge = arrayMenorAleatorio.clone();
		ao.mergeSort(arrayMenorAleatorioMerge, mo);
		System.out.println("Merge Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorAleatorioQuick = arrayMenorAleatorio.clone();
		ao.quickSort(arrayMenorAleatorioQuick, mo);
		System.out.println("Quick Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorAleatorioHeap = arrayMenorAleatorio.clone();
		ao.heapSort(arrayMenorAleatorioHeap, mo);
		System.out.println("Heap Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMenorAleatorioShell = arrayMenorAleatorio.clone();
		ao.shellSort(arrayMenorAleatorioShell, mo);
		System.out.println("Shell Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		System.out.println("\n=============================================\n");
		System.out.println("Testes com Array de tamanho 1000000: \n");
		
		System.out.println("\nArray Ordenado: \n");
		mo = new MetricasOrdenacao();
		int[] arrayMaiorOrdenadoBubble = arrayMaiorOrdenado.clone();
		ao.bubbleSort(arrayMaiorOrdenadoBubble, mo);
		System.out.println("Bubble Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorOrdenadoSelection = arrayMaiorOrdenado.clone();
		ao.selectionSort(arrayMaiorOrdenadoSelection, mo);
		System.out.println("Selection Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorOrdenadoInsertion = arrayMaiorOrdenado.clone();
		ao.insertionSort(arrayMaiorOrdenadoInsertion, mo);
		System.out.println("Insertion Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorOrdenadoMerge = arrayMaiorOrdenado.clone();
		ao.mergeSort(arrayMaiorOrdenadoMerge, mo);
		System.out.println("Merge Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorOrdenadoQuick = arrayMaiorOrdenado.clone();
		ao.quickSort(arrayMaiorOrdenadoQuick, mo);
		System.out.println("Quick Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorOrdenadoHeap = arrayMaiorOrdenado.clone();
		ao.heapSort(arrayMaiorOrdenadoHeap, mo);
		System.out.println("Heap Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorOrdenadoShell = arrayMaiorOrdenado.clone();
		ao.shellSort(arrayMaiorOrdenadoShell, mo);
		System.out.println("Shell Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		System.out.println("\n-------------------------------------------------");
		
		System.out.println("\nArray Inverso: \n");
		mo = new MetricasOrdenacao();
		int[] arrayMaiorInversoBubble = arrayMaiorInverso.clone();
		ao.bubbleSort(arrayMaiorInversoBubble, mo);
		System.out.println("Bubble Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorInversoSelection = arrayMaiorInverso.clone();
		ao.selectionSort(arrayMaiorInversoSelection, mo);
		System.out.println("Selection Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorInversoInsertion = arrayMaiorInverso.clone();
		ao.insertionSort(arrayMaiorInversoInsertion, mo);
		System.out.println("Insertion Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorInversoMerge = arrayMaiorInverso.clone();
		ao.mergeSort(arrayMaiorInversoMerge, mo);
		System.out.println("Merge Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorInversoQuick = arrayMaiorInverso.clone();
		ao.quickSort(arrayMaiorInversoQuick, mo);
		System.out.println("Quick Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorInversoHeap = arrayMaiorInverso.clone();
		ao.heapSort(arrayMaiorInversoHeap, mo);
		System.out.println("Heap Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorInversoShell = arrayMaiorInverso.clone();
		ao.shellSort(arrayMaiorInversoShell, mo);
		System.out.println("Shell Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		System.out.println("\n-------------------------------------------------");
		
		System.out.println("\nArray Aleatorio: \n");
		mo = new MetricasOrdenacao();
		int[] arrayMaiorAleatorioBubble = arrayMaiorAleatorio.clone();
		ao.bubbleSort(arrayMaiorAleatorioBubble, mo);
		System.out.println("Bubble Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorAleatorioSelection = arrayMaiorAleatorio.clone();
		ao.selectionSort(arrayMaiorAleatorioSelection, mo);
		System.out.println("Selection Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorAleatorioInsertion = arrayMaiorAleatorio.clone();
		ao.insertionSort(arrayMaiorAleatorioInsertion, mo);
		System.out.println("Insertion Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorAleatorioMerge = arrayMaiorAleatorio.clone();
		ao.mergeSort(arrayMaiorAleatorioMerge, mo);
		System.out.println("Merge Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorAleatorioQuick = arrayMaiorAleatorio.clone();
		ao.quickSort(arrayMaiorAleatorioQuick, mo);
		System.out.println("Quick Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorAleatorioHeap = arrayMaiorAleatorio.clone();
		ao.heapSort(arrayMaiorAleatorioHeap, mo);
		System.out.println("Heap Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
		mo = new MetricasOrdenacao();
		int[] arrayMaiorAleatorioShell = arrayMaiorAleatorio.clone();
		ao.shellSort(arrayMaiorAleatorioShell, mo);
		System.out.println("Shell Sort: Comparações: "+mo.getComparacoes()+", Trocas: "+mo.getTrocas()+", Tempo: "+mo.getTempoTotal()+" ms");
		
	}

}
