package entities;

public class Company extends TaxPayer {

	private int numberOfEmployees;

	public Company() {
		super();
	}

	public Company(String name, Double annualIncome, int numberOfEmployess) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployess;
	}

	@Override
	public Double tax() {
		if (numberOfEmployees > 10) {
			return getAnnualIncome() * 0.14;
		} else {
			return getAnnualIncome() * 0.16;
		}
	}
}
