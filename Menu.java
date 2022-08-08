import java.io.*;
import java.lang.Object;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner keybord = new Scanner(System.in);
    Bank bank = new Bank();
    boolean exist;

    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();
        menu.RUN_MAIN();

    }

    public void RUN_MAIN() {
        printHeadar();
        while(!exist) {
            printmenu();
            int chooise = getInput();
            performaction(chooise);
        }

    }

    private void printHeadar() {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                Welcome to mr.                 |");
        System.out.println("|                Awesome Bank App               |");
        System.out.println("+-----------------------------------------------+");
    }
    private void printmenu() {

        System.out.println("please make a selsection\n ");
        System.out.println("1) Create a New Account ");
        System.out.println("2) Make a deposit ");
        System.out.println("3) Make a withdeaw ");
        System.out.println("4) List account balance ");
        System.out.println("0) Exit ");
        System.out.println();

    }

    private int getInput() {
        int test = -1;
        do {
            System.out.print("Enter your chose  ");
            try {
                test = Integer.parseInt(keybord.nextLine());
            }catch(NumberFormatException e){
                System.out.print("un valid selection. Number only please");
            }
            if (test < 0 || test > 4)
                System.out.print("The number Outside of please chose agin :: the range -> (1 to 4)");

        }while(test < 0 || test > 4);
        return test;
    }

    private void performaction(int choise) {
        switch(choise) {
            case 0:
                System.out.println("Thank you for using our Aplication");
                System.exit(0);
                break;

            case 1:
                Create_Account();
                break;

            case 2:
                Make_deposit();
                break;

            case 3:
                Make_withdraw();
                break;

            case 4:
                List_balance();
                break;

            default:
                System.out.println("Un known error has occured. ");
        }

    }

    private void Create_Account() {
        String frist_name, last_name, SSN, Account_type = "";
        boolean valid = false;
        double intail_deposit = 0.0;
        while(!valid) {
            System.out.println("Please Enter an Account_type ( cheking or saving ) ");
            Account_type = keybord.nextLine();
            if ( Account_type.equalsIgnoreCase("cheking") || Account_type.equalsIgnoreCase("saving")) valid = true;
            else {
                System.out.println("In valid Account_type selected please Enter ( cheking or saving )");
            }
        }

        System.out.print("Enter your Frist name ");
        frist_name = keybord.nextLine();
        System.out.print("Enter your Last name ");
        last_name = keybord.nextLine();
        System.out.print("Enter your social security number ");
        SSN = keybord.nextLine();
        valid = false;

        while(!valid) {
            System.out.print("Please Enter an intail deposit ");
            try {
                intail_deposit = Double.parseDouble(keybord.nextLine());
            }catch(NumberFormatException e) {
                System.out.print("Deposit must be a number.");
            }
            if (Account_type.equals("cheking")) {
                if (intail_deposit < 500)
                    System.out.print("cheking Account require a minmum a 30 dollars to open");
                else
                    valid = true;
            }
            else if (Account_type.equals("saving")) {
                if (intail_deposit < 250)
                    System.out.print("saving Account require a minmum a 15 dollars to open");
                else
                    valid = true;
            }

        }
        Account account;
        if (Account_type.equals("cheking"))
            account = new Checking(intail_deposit);
        else
            account = new Savings(intail_deposit);

        Customer c = new Customer(frist_name, last_name, SSN, account);
        Bank.add_customer(c);


    }

    private void Make_deposit() {
        int account = selectaccount();
        if (account >= 0) {
            System.out.println("How much would you like to deposit ?: ");
            double amount = 0;
            try {
                amount = Double.parseDouble(keybord.nextLine());
            }catch(NumberFormatException e) {
                amount = 0;
            }


            bank.getcustomer(account).getaccount().deposit(amount);
        }

    }

    private void List_balance() {
        int account = selectaccount();
        if (account >= 0)
            System.out.println(bank.getcustomer(account).getaccount().getAccount_num());
        else
            System.out.println("In valid account selected ");

    }
    private void Make_withdraw() {

        int account = selectaccount();
        if (account >= 0) {
            System.out.println("How much would you like to withdraw ?: ");
            double amount = 0;
            try {
                amount = Double.parseDouble(keybord.nextLine());
            }catch(NumberFormatException e) {
                amount = 0;
            }


            bank.getcustomer(account).getaccount().withdraw(amount);
        }


    }

    private int selectaccount() {
        ArrayList < Customer > customers = bank.getcustomer();
        if (customers.size() == 0) {
            System.out.println("NO Customer at your Bank");
            return -1;
        }
        System.out.println("Select an account");
        int sz = customers.size();
        for (int i = 0; i < sz; i++) {
            System.out.print("\n" + (i + 1) + ") " + customers.get(i).disiplay());
        }
        System.out.println();
        int account = 0;
        System.out.println("Please Enter your selection");
        try {
            account = Integer.parseInt(keybord.nextLine()) - 1;
        }catch(NumberFormatException e) {
            account = -1;
        }
        if (account < 0 || account > customers.size() ) {
            System.out.println("In valid Selected ");
            account = -1;
        }

        return account;
    }


}
