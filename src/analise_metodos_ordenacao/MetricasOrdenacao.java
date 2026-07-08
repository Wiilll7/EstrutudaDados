package analise_metodos_ordenacao;

public class MetricasOrdenacao {

	private long comparacoes = 0;
	private long trocas = 0;
	private long tempoInicial = 0;
	private long tempoFinal = 0;
	
	
	public long getComparacoes() {
		return comparacoes;
	}
	public void addComparacoes() {
		this.comparacoes++;
	}
	public long getTrocas() {
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
