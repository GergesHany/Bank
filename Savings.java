
public class Savings extends Account{

    private static String account_type = "saving";

    Savings(double intail_deposit){
        super();
        super.setBalance(intail_deposit);
        super.check_interest(0);
    }

    @Override
    public String toString() {
        return "Account_type : " + account_type + " Account\n " + " Account_number " + this.getAccount_num() + "\n"
                + "Balance " + this.getBalance() + "\n" + "Interest Rate " + this.getInterest() + "\n";
    }

}
