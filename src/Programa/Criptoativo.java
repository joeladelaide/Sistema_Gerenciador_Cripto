package Programa;

public class Criptoativo extends Criptomoeda {
	
	private static int contador = 1;
	
	protected int idCriptoativo;
	protected Criptomoeda criptomoeda;
	protected Double quantidade = 0.0;
	
	public Criptoativo(Criptomoeda criptomoeda, String nome, String sigla, String exchange) {
		super(nome, sigla, exchange);
		this.idCriptoativo = contador;
		this.criptomoeda = criptomoeda;
		contador += 1;
	}
	
	// Getter para obter o identificador da criptomoeda
	public int getIdCriptoativo() {
		return idCriptoativo;
	}
	// Setter para definir o identificador da criptomoeda
	public void setIdCriptoativo(int idCriptoativo) {
		this.idCriptoativo = idCriptoativo;
	}

	// Getter para obter a criptomoeda associada ao criptoativo
	public Criptomoeda getCriptomoeda() {
		return criptomoeda;
	}

	// Setter para definir a criptomoeda associada ao criptoativo
	public void setCriptomoeda(Criptomoeda criptomoeda) {
		this.criptomoeda = criptomoeda;
	}

	// Getter para obter a quantidade do criptoativo
	public Double getQuantidade() {
		return quantidade;
	}

	// Setter para definir a quantidade do criptoativo
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	public String toString() {
		return 	 "\nNome: " + this.criptomoeda.getNome() + 
				"\nSigla: " + this.criptomoeda.getSigla() +
				"\nExchange: " + this.criptomoeda.getExchange() +
				"\nSaldo: " + this.getQuantidade();
	}

	// Realiza um depósito na quantidade do criptoativo
    public void depositar(Double valor) {
        if(valor > 0) {
        	setQuantidade(getQuantidade()+valor);
            System.out.println("Seu depósito foi realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

	// Realiza um saque na quantidade do criptoativo
    public void sacar(Double valor) {
        if(valor > 0 && this.getQuantidade() >= valor) {
            setQuantidade(getQuantidade() - valor);
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }
	

}
