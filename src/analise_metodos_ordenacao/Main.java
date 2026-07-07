package analise_metodos_ordenacao;

import java.util.Random;

import ordenacao_dados.bubble_sort.MetricasOrdenacao;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Random random = new Random();
		MetricasOrdenacao mo = new MetricasOrdenacao();
		int[] array = new int[1000000];
		
		for (int i = 0; i < 1000000; i++) {
			array[i] = random.nextInt(1, 999999);
		}

		AlgoritmosOrdenacao ao = new AlgoritmosOrdenacao();
		
		int[] arrayBubble = array.clone();
		
		ao.bubbleSort(arrayBubble, mo);
		
		System.out.println(mo.getTempoTotal());
		
		
		
		
	}

}
