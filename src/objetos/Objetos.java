package objetos;

public class Objetos {

	int[] custo = new int[4];

	private int quantidadeSandalia;
	private int quantidadeSapatoMasculino;
	private int quantidadeBotasFemininas;
	private int quantidadeSapatosFemininos;
	
	private int tempoDeCriacao;
	private int custoDeCriacao;
	private int quantidadeMaterial;
	private int beneficioTotal;
	
	private String indice="";
	
	private String individuo="";
	
	public int[] Sandalia() {

		custo[0] = 1;
		custo[1] = 100;
		custo[2] = 20;
		custo[3] = 60;

		return custo;

	}

	public int[] SapatoMasculino() {

		custo[0] = 1;
		custo[1] = 120;
		custo[2] = 30;
		custo[3] = 80;

		return custo;

	}

	public int[] BotasFemininas() {

		custo[0] = 1;
		custo[1] = 150;
		custo[2] = 25;
		custo[3] = 60;

		return custo;
	}

	public int[] SapatosFemininos() {

		custo[0] = 1;
		custo[1] = 120;
		custo[2] = 28;
		custo[3] = 50;

		return custo;
	}

	public int getQuantidadeSandalia() {
		return quantidadeSandalia;
	}

	public void setQuantidadeSandalia(int quantidadeSandalia) {
		this.quantidadeSandalia = quantidadeSandalia;
	}

	public int getQuantidadeSapatoMasculino() {
		return quantidadeSapatoMasculino;
	}

	public void setQuantidadeSapatoMasculino(int quantidadeSapatoMasculino) {
		this.quantidadeSapatoMasculino = quantidadeSapatoMasculino;
	}

	public int getQuantidadeBotasFemininas() {
		return quantidadeBotasFemininas;
	}

	public void setQuantidadeBotasFemininas(int quantidadeBotasFemininas) {
		this.quantidadeBotasFemininas = quantidadeBotasFemininas;
	}

	public int getQuantidadeSapatosFemininos() {
		return quantidadeSapatosFemininos;
	}

	public void setQuantidadeSapatosFemininos(int quantidadeSapatosFemininos) {
		this.quantidadeSapatosFemininos = quantidadeSapatosFemininos;
	}

	public int getTempoDeCriacao() {
		return tempoDeCriacao;
	}

	public void setTempoDeCriacao(int tempoDeCriacao) {
		this.tempoDeCriacao = tempoDeCriacao;
	}

	public int getCustoDeCriacao() {
		return custoDeCriacao;
	}

	public void setCustoDeCriacao(int custoDeCriacao) {
		this.custoDeCriacao = custoDeCriacao;
	}

	public int getQuantidadeMaterial() {
		return quantidadeMaterial;
	}

	public void setQuantidadeMaterial(int quantidadeMaterial) {
		this.quantidadeMaterial = quantidadeMaterial;
	}

	public int getBeneficioTotal() {
		return beneficioTotal;
	}

	public void setBeneficioTotal(int beneficioTotal) {
		this.beneficioTotal = beneficioTotal;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice += indice;
	}

	public String getIndividuo() {
		return individuo;
	}

	public void setIndividuo(String individuo) {
		this.individuo += individuo;
	}

	
	
}
