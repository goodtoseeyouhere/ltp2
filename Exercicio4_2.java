package ltp2.Exercicios03;

import java.util.*;

public class Exercicio4_2 {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		double SALARIO_PECA_1 = 2.00;
		double SALARIO_PECA_2 = 2.30;
		double SALARIO_PECA_3 = 2.50;

		String[] vetorEmpregados = new String[100];
		int[] vetorPecasFabricadas = new int[100];
		int[] vetorCodigoEmpregado = new int[100];
		double[] vetorSalarios = new double[100];

		int pecasFabricadas;
		int codigoEmpregado;
		double salario;

		int totalEmpregados = 0;
		double totalSalario = 0;
		double mediaSalario;

		for (int i = 0; i < 100; i++) {

			System.out.println("Digite o nome do empregado: (ou ENCERRAR para sair)");
			String empregados = leia.nextLine();

			if (empregados.equalsIgnoreCase("ENCERRAR")) {
				break;
			}

			do {
				System.out.println("Digite o numero de pecas fabricadas: ");
				pecasFabricadas = leia.nextInt();

				if (pecasFabricadas < 0) {
					System.out.println("O número de peças deverá ser maior que zero.");
				}

			} while (pecasFabricadas < 0);

			do {
				System.out.println("Digite o codigo do empregado: ");
				codigoEmpregado = leia.nextInt();

				if (codigoEmpregado < 1 || codigoEmpregado > 999) {
					System.out.println("O codigo deve ser um numero entre 1 e 999.");
				}

			} while (codigoEmpregado < 1 || codigoEmpregado > 999);

			leia.nextLine();

			salario = calcularSalario(pecasFabricadas, SALARIO_PECA_1, SALARIO_PECA_2, SALARIO_PECA_3);

			vetorEmpregados[i] = empregados;
			vetorPecasFabricadas[i] = pecasFabricadas;
			vetorCodigoEmpregado[i] = codigoEmpregado;
			vetorSalarios[i] = salario;

			totalSalario = totalSalario + salario;

			totalEmpregados++;

		}

		for (int i = 0; i < totalEmpregados; i++) {
			System.out.println("Nome: " + vetorEmpregados[i]);
			System.out.println("Codigo: " + vetorCodigoEmpregado[i]);
			System.out.println("Salario: " + vetorSalarios[i]);
		}

		mediaSalario = totalSalario / totalEmpregados;

		System.out.println("Total de salarios: " + totalSalario);
		System.out.println("Media salarial: " + mediaSalario);

	}

	public static double calcularSalario(int pecas, double salarioPeca1, double salarioPeca2, double salarioPeca3) {

		if (pecas <= 200) {
			return (pecas * salarioPeca1);
		} else if (pecas <= 400) {
			return pecas * salarioPeca2;
		} else {
			return pecas * salarioPeca3;
		}

	}

}
