package GerenciamentoAeroporto;

public class Aviao {

	// atributos
	private int id;
	private int combustivel;
	private int horaChegada;
	
	// construtor
	public Aviao(int id, int combustivel, int horaChegada) {
		this.id = id;
		this.combustivel = combustivel;
		this.horaChegada = horaChegada;
	}
	
	// set e get
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}
	public int getHoraChegada() {
		return horaChegada;
	}
	public void setHoraChegada(int horaChegada) {
		this.horaChegada = horaChegada;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aviao {[id=");
		builder.append(id);
		builder.append("], [combustivel=");
		builder.append(combustivel);
		builder.append("], [horaChegada=");
		builder.append(horaChegada);
		builder.append("]}");
		return builder.toString();
	}
	
}
