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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	
	public String toString() {
		return  "\nNome: " + this.getNome() +
				"\nSigla: " + this.getSigla() +
				"\nExchange: " + this.getExchange();
	}
	
}
