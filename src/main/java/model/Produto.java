package model;

public class Produto {
	private int quant;
	private String nome;
	private int valorUnitario;
	
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Produto(String nome, int quant, int valorUnitario) {
		super();
		this.nome = nome;
		this.quant = quant;
		this.valorUnitario = valorUnitario;
	}
}
