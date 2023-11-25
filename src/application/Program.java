package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + "data:");

			// TIPO
			System.out.print("Individual or company (i/c)? ");
			char tipo = sc.next().charAt(0);

			// NOME
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			// RENDA ANUAL
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();

			if (tipo == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();

				// INSTANCIAR O OBJETO DO TIPO FISICO JÀ ADICIONANDO A LISTA

				list.add(new Individual(name, anualIncome, healthExpenditures));

			}else {
				System.out.print("Number of employees: ");
				int numberOfEmplyee = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmplyee));
			}

		}

		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer tp : list) {
			double tax = tp.tax();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
			sum += tax;
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();

	}

}
