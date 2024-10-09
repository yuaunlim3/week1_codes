package bank;

public class Main {
    public static void main(String[] args) {
        BankAccount bobBank = new BankAccount("BOB");
        bobBank.deposit(1000);

        FixedDepositAccount fredBank = new FixedDepositAccount("Fred", 1000F);
        fredBank.deposit(1000);

        System.out.printf("Name: %s Amount: %.2f\n",fredBank.getName(),fredBank.getBalance());

        bobBank.withdraw(10);
        bobBank.withdraw(10);
        System.out.printf("Name: %s Amount: %.2f\n",bobBank.getName(),bobBank.getBalance());

    }
}
