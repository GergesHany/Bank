
public class Customer {

    private String frist_name, last_name, SSN;
    Account account;

    public Customer(String frist_name, String last_name, String SSN, Account account) {
        this.frist_name = frist_name; this.last_name = last_name;
        this.SSN = SSN; this.account = account;
    }
    @Override
    public String toString() {
        return "customer information\n name :: \n" + "frist name" + frist_name + "\nlast name " + last_name + "\nSSN " + SSN +
                account;
    }

    public String disiplay() {
        return "name : " + frist_name + " " + last_name + " : " + "SSN  = " + SSN + " : " +
                "Account Number = " + account.getAccount_num() + "";
    }
    Account getaccount() {
        return account;
    }

}
