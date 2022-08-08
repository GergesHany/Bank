
public class Account {

    private static double balance = 0.0;
    private static double interest = 0.02;
    private int Account_num;
    private static int number_of_acouunt = 1;

    Account(){
        Account_num = number_of_acouunt++;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest * 100;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getAccount_num() {
        return Account_num;
    }

    public void setAccount_num(int account_num) {
        this.Account_num = account_num;
    }


    static void withdraw(double amount) {

        if (amount + 5 > balance) {
            System.out.print("you have insficient funds.");
            return;
        }
        balance -= amount + 5;
        check_interest(0);
        System.out.println("you have whthdrow $ " + amount + " and incurred a fee of 5$");
        System.out.println("You Now have a balance of " + balance);
    }

    static void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("You cannot deposit negative money ");
            return;
        }
        check_interest(amount);

        amount = amount + (amount * interest);
        balance += amount;
        System.out.println("you have deposit $ : " + amount + " with and interest rate of : " + interest * 100);
        System.out.println("You Now have a balance of : " + balance);

    }


    public static void check_interest(double amount) {
        if (balance + amount >= 10000) interest = 0.05;
        else interest = 0.02;

    }



}
