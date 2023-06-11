package Programa;

public class Criptomoeda {
	
	private static int contador = 1;
	
	private int idCriptomoeda;
	private String nome;
	private String sigla;
	private String exchange;
	
	public Criptomoeda( String nome, String sigla, String exchange  ) {
		this.idCriptomoeda = contador;
		this.nome = nome;
		this.sigla = sigla;
		this.exchange = exchange;
		contador += 1;
	}

	// Getter para obter o nome da criptomoeda
	public String getNome() {
		return nome;
	}

	// Setter para definir o nome da criptomoeda
	public void setNome(String nome) {
		this.nome = nome;
	}

	// Getter para obter a sigla da criptomoeda
	public String getSigla() {
		return sigla;
	}

	// Setter para definir a sigla da criptomoeda
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	// Getter para obter a exchange da criptomoeda
	public String getExchange() {
		return exchange;
	}

	// Setter para definir a exchange da criptomoeda
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	
	// Sobrescrita do método toString() para retornar as informações da criptomoeda
	public String toString() {
		return  "\nNome: " + this.getNome() +
				"\nSigla: " + this.getSigla() +
				"\nExchange: " + this.getExchange();
	}
	
}
