package ordenacao_dados.bubble_sort;

public class MetricasOrdenacao {

	private int comparacoes = 0;
	private int trocas = 0;
	private long tempoInicial = 0;
	private long tempoFinal = 0;
	
	
	public int getComparacoes() {
		return comparacoes;
	}
	public void addComparacoes() {
		this.comparacoes++;
	}
	public int getTrocas() {
		return trocas;
	}
	public void addTrocas() {
		this.trocas++;
	}
	public void setTempoInicial() {
		tempoInicial = System.currentTimeMillis();
	}
	public void setTempoFinal() {
		tempoFinal = System.currentTimeMillis();
	}
	public long getTempoTotal() {
		return tempoFinal - tempoInicial;
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
