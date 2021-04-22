package principal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import objetos.Objetos;

public class Main {

	static int[] gene = { 0, 1, 0, 1 };

	static int[][] geracao = new int[4][4];

	static int[] objetos = new int[4];

	static boolean primeira = true;

	static int tempoMaximo = 10000;

	static int custoMaximo = 50000;

	static int materialMaximo = 400;

	static int quantidade = 0;

	static double[] calculoFitness = new double[4];

	static int[][] novaGeracao = new int[4][4];

	static ArrayList<Objetos> objt = new ArrayList<Objetos>();

	static String individuo = "";

	// --------------------------------------

	static int melhorGeracacao = 0;

	static boolean melhor = true;

	static String melhorIndividuo = "";

	static Objetos melhorObjetosGeral = new Objetos();

	public static void main(String[] args) {
		GeraGeracoes();
	}

	public static void GeraGeracoes() {

		int somaB = 0;
		int somaC = 0;
		int somaT = 0;
		int somaM = 0;

		Objetos obj = new Objetos();

		if (primeira) {

			System.out.println("----primeira geração ----");

			Random random = new Random();

			for (int i = 0; i < geracao.length; i++) {
				for (int j = 0; j < geracao.length; j++) {

					int indice = random.nextInt(3);

					ObjetoSelecionado(indice, obj);

					if (gene[indice] == 1) {

						for (int k = 0; k < quantidade; k++) {
							somaB += objetos[3];
							somaC += objetos[2];
							somaT += objetos[1];
							somaM++;
						}
					}

					geracao[i][j] = gene[indice];// nomes dos individuos
					individuo += gene[indice];
				}

				obj.setIndividuo(individuo);
				obj.setTempoDeCriacao(somaT);
				obj.setBeneficioTotal(somaB);
				obj.setCustoDeCriacao(somaC);
				obj.setQuantidadeMaterial(somaM);

				objt.add(obj);

				obj = new Objetos();

				somaB = 0;
				somaC = 0;
				somaT = 0;
				somaM = 0;
				individuo = "";
			}
			Fitness();

		} else {

			melhor = true;
			
			int passada = 0;

			for (int i = 0; i < objt.size(); i++) {

				if (melhorGeracacao < objt.get(i).getBeneficioTotal()) {

					melhorGeracacao = objt.get(i).getBeneficioTotal();

					melhorIndividuo = objt.get(i).getIndividuo();
					
					melhor = false;
				}
			}

			for (int i = 0; i < objt.size(); i++) {

				if (melhorGeracacao == objt.get(i).getBeneficioTotal()) {

					melhorObjetosGeral.setIndividuo(objt.get(i).getIndividuo());
					melhorObjetosGeral.setBeneficioTotal(objt.get(i).getBeneficioTotal());
					melhorObjetosGeral.setCustoDeCriacao(objt.get(i).getCustoDeCriacao());
					melhorObjetosGeral.setQuantidadeMaterial(objt.get(i).getQuantidadeMaterial());
					melhorObjetosGeral.setTempoDeCriacao(objt.get(i).getTempoDeCriacao());
					melhorObjetosGeral.setQuantidadeBotasFemininas(objt.get(i).getQuantidadeBotasFemininas());
					melhorObjetosGeral.setQuantidadeSandalia(objt.get(i).getQuantidadeSandalia());
					melhorObjetosGeral.setQuantidadeSapatoMasculino(objt.get(i).getQuantidadeSapatoMasculino());
					melhorObjetosGeral.setQuantidadeSapatosFemininos(objt.get(i).getQuantidadeSapatosFemininos());
				}
			}

			if (melhor) {
				System.out.println("melhor");
				System.out.println();
				System.out.println("individuo " + melhorObjetosGeral.getIndividuo());
				System.out.println();
				System.out.println("custo " + melhorObjetosGeral.getCustoDeCriacao());
				System.out.println("tempo " + melhorObjetosGeral.getTempoDeCriacao());
				System.out.println("material " + melhorObjetosGeral.getQuantidadeMaterial());
				System.out.println("beneficio " + melhorObjetosGeral.getBeneficioTotal());
				System.out.println();
				System.out.println("sandalias " + melhorObjetosGeral.getQuantidadeSandalia());
				System.out.println("sapatoMasculino " + melhorObjetosGeral.getQuantidadeSapatoMasculino());
				System.out.println("botasFemininas " + melhorObjetosGeral.getQuantidadeBotasFemininas());
				System.out.println("sapatosFemininas " + melhorObjetosGeral.getQuantidadeSapatosFemininos());
				System.out.println();
				
			} else {

				passada = melhorGeracacao;
				
				System.out.println("----nova geração ----");
				
				objt.clear();

				somaB = 0;
				somaC = 0;
				somaT = 0;
				somaM = 0;

				obj = new Objetos();

				Random random = new Random();

				for (int i = 0; i < novaGeracao.length; i++) {
					for (int j = 0; j < novaGeracao.length; j++) {

						int indice = random.nextInt(3);

						ObjetoSelecionado(indice, obj);

						if (novaGeracao[i][j] == 1) {
							for (int k = 0; k < quantidade; k++) {
								somaB += objetos[3];
								somaC += objetos[2];
								somaT += objetos[1];
								somaM++;
							}
						}
					}

					obj.setTempoDeCriacao(somaT);
					obj.setBeneficioTotal(somaB);
					obj.setCustoDeCriacao(somaC);
					obj.setQuantidadeMaterial(somaM);

					objt.add(obj);

					obj = new Objetos();

					somaB = 0;
					somaC = 0;
					somaT = 0;
					somaM = 0;
				}
				Fitness();
			}
		}

	}

	public static void Fitness() {

		int fitnessTotal = 0;

		int menor = 9999999;

		Penalidade();

		for (int i = 0; i < geracao.length; i++) {

			if (menor > calculoFitness[i]) {

				menor = (int) calculoFitness[i];
			}
		}

		for (int i = 0; i < calculoFitness.length; i++) {

			calculoFitness[i] = (calculoFitness[i] - menor);

			fitnessTotal += calculoFitness[i];
		}

		for (int i = 0; i < calculoFitness.length; i++) {

			calculoFitness[i] /= fitnessTotal;
		}

		if (primeira) {

			for (int i = 0; i < geracao.length; i++) {
				for (int j = 0; j < geracao.length; j++) {
					System.out.print(geracao[i][j] + "\t");
				}
				System.out.print("  " + (int) (calculoFitness[i] * 100) + "%");
				System.out.println();
			}
		} else {

			for (int i = 0; i < novaGeracao.length; i++) {
				for (int j = 0; j < novaGeracao.length; j++) {

					System.out.print(novaGeracao[i][j] + "\t");
				}
				System.out.print("  " + (int) (calculoFitness[i] * 100) + "%");
				System.out.println();
			}
		}

		System.out.println();

		// MostraObjetosProduzidos();

		SelecaoDosPais();
	}

	public static void SelecaoDosPais() {

		int[] porcentagem = new int[100];

		int[] selecionados = new int[4];

		int individuo = 0;

		int atual = 0;

		int ultimo = 0;

		for (int i = 0; i < calculoFitness.length; i++) {
			calculoFitness[i] *= 100;
		}

		for (int i = 0; i < geracao.length; i++) {

			if ((int) calculoFitness[i] == 0) {
				individuo++;
			} else {

				atual += (int) calculoFitness[i];

				if (atual <= 99) {

					for (int j = ultimo; j < atual; j++) {
						porcentagem[j] = individuo;
						ultimo = j;
					}
					individuo++;
				}
			}

		}

		Random random = new Random();

		for (int i = 0; i < (selecionados.length / 2); i++) {

			int indice = random.nextInt(atual);

			selecionados[i] = porcentagem[indice];
		}

		for (int i = 0; i < (geracao.length); i++) {
			for (int j = 0; j < geracao.length; j++) {
				if (i <= 1) {
					novaGeracao[i][j] = geracao[selecionados[i]][j];
				}
			}
		}

		CrossOver();
	}

	public static void CrossOver() {

		int paisF = 0, paisB = 1;// front e back

		int posicao = 2;

		do {

			for (int j = 0; j < (novaGeracao.length / 2); j++) {
				novaGeracao[posicao][j] = novaGeracao[paisF][j];
			}

			posicao++;

		} while (posicao == 2);

		posicao = 2;

		do {
			for (int j = (3 - 2); j <= 3; j++) {
				novaGeracao[posicao][j] = novaGeracao[paisB][j];
			}

			posicao++;

		} while (posicao == 2);
		// ------------------------
		posicao = 3;

		do {

			for (int j = 0; j < (novaGeracao.length / 2); j++) {
				novaGeracao[posicao][j] = novaGeracao[paisB][j];
			}

			posicao++;

		} while (posicao == 3);

		posicao = 3;

		do {
			for (int j = (3 - 2); j <= 3; j++) {
				novaGeracao[posicao][j] = novaGeracao[paisF][j];
			}

			posicao++;

		} while (posicao == 3);

		Mutacao();
	}

	public static void Mutacao() {

		int i = 0;

		int l, c;

		int[] mutanteL = { 2, 3 };
		int[] mutanteC = { 0, 1, 2, 3 };

		do {

			Random random = new Random();

			Random celula = new Random();

			l = random.nextInt(2);
			c = celula.nextInt(4);

			System.out.println();
			// System.out.println(mutanteL[l]);
			// System.out.println(mutanteC[c]);

			if (novaGeracao[mutanteL[l]][mutanteC[c]] == 0) {

				novaGeracao[mutanteL[l]][mutanteC[c]] = 1;
			} else {
				novaGeracao[mutanteL[l]][mutanteC[c]] = 0;
			}

			i++;
		} while (i != 2);

		if (primeira) {
			primeira = false;
		}
		
		GeraGeracoes();
	}

	public static void ObjetoSelecionado(int indice, Objetos obj) {

		Random r = new Random();
		quantidade = r.nextInt(399);

		if (quantidade == 0) {
			quantidade = 1;
		}

		switch (indice) {

		case 0:
			objetos = obj.Sandalia();
			obj.setQuantidadeSandalia(quantidade);
			obj.setIndice(indice);
			break;

		case 1:
			objetos = obj.SapatoMasculino();
			obj.setQuantidadeSapatoMasculino(quantidade);
			obj.setIndice(indice);
			break;

		case 2:
			objetos = obj.BotasFemininas();
			obj.setQuantidadeBotasFemininas(quantidade);
			obj.setIndice(indice);
			break;

		case 3:
			objetos = obj.SapatosFemininos();
			obj.setQuantidadeSapatosFemininos(quantidade);
			obj.setIndice(indice);
			break;

		default:
			break;
		}
	}

	public static void Penalidade() {

		for (int i = 0; i < objt.size(); i++) {

			if (objt.get(i).getCustoDeCriacao() > custoMaximo) {
				calculoFitness[i] = (objt.get(i).getBeneficioTotal() - (objt.get(i).getBeneficioTotal() / 2));
			} else {
				calculoFitness[i] = objt.get(i).getBeneficioTotal();
			}
		}

		for (int i = 0; i < objt.size(); i++) {

			if (objt.get(i).getQuantidadeMaterial() > materialMaximo) {
				calculoFitness[i] = (objt.get(i).getBeneficioTotal() - (objt.get(i).getBeneficioTotal() / 2));
			} else {
				calculoFitness[i] = (objt.get(i).getBeneficioTotal());
			}
		}

		for (int i = 0; i < objt.size(); i++) {

			if (objt.get(i).getTempoDeCriacao() > tempoMaximo) {
				calculoFitness[i] = (objt.get(i).getBeneficioTotal() - (objt.get(i).getBeneficioTotal() / 2));
			} else {
				calculoFitness[i] = (objt.get(i).getBeneficioTotal());
			}
		}
	}

	public static void MostraObjetosProduzidos() {

		System.out.println("Objetos Produzidos");

		for (int i = 0; i < objt.size(); i++) {

			System.out.println();
			System.out.println("individuo " + objt.get(i).getIndividuo());
			System.out.println();
			System.out.println("custo " + objt.get(i).getCustoDeCriacao());
			System.out.println("tempo " + objt.get(i).getTempoDeCriacao());
			System.out.println("material " + objt.get(i).getQuantidadeMaterial());
			System.out.println("beneficio " + objt.get(i).getBeneficioTotal());
			System.out.println();
			System.out.println("sandalias " + objt.get(i).getQuantidadeSandalia());
			System.out.println("sapatoMasculino " + objt.get(i).getQuantidadeSapatoMasculino());
			System.out.println("botasFemininas " + objt.get(i).getQuantidadeBotasFemininas());
			System.out.println("sapatosFemininas " + objt.get(i).getQuantidadeSapatosFemininos());
			System.out.println();
		}
	}

}
