package ordenacao_dados.bubble_sort;

public class MetricasOrdenacao {

	private int comparacoes = 0;
	private int trocas = 0;
	
	
	public int getComparacoes() {
		return comparacoes;
	}
	public void setComparacoes(int comparacoes) {
		this.comparacoes = comparacoes;
	}
	public int getTrocas() {
		return trocas;
	}
	public void setTrocas(int trocas) {
		this.trocas = trocas;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MetricasOrdenacao [comparacoes=");
		builder.append(comparacoes);
		builder.append(", trocas=");
		builder.append(trocas);
		builder.append("]");
		return builder.toString();
	}
	
}
