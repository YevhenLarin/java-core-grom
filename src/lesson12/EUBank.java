package lesson12;

public class EUBank extends Bank {

    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        return getCurrency() == Currency.USD ? 2000 : 2200;
    }

    @Override
    public int getLimitOfFunding() {
        return getCurrency() == Currency.USD ? 10000 : 20000;
    }

    @Override
    public double getMonthlyRate() {
        return getCurrency() == Currency.USD ? 0 : 0.01;
    }

    @Override
    public double getCommission(int amount) {
        if (getCurrency() == Currency.USD)
            return amount <= 1000 ? 0.05 : 0.07;
        return amount <= 1000 ? 0.02 : 0.04;
    }
}
