import java.util.ArrayList;
public class Bank {

    static ArrayList < Customer > Customers = new ArrayList< Customer >();

    public static void add_customer(Customer customer) {
        Customers.add(customer);
    }

    Customer getcustomer(int account) {
        return Customers.get(account);
    }


    ArrayList < Customer > getcustomer(){
        return Customers;
    }
}
