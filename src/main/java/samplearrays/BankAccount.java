package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    double[] transactions = new double[1000];
    // creating a variable to keep track of the transactions array since java doesn't have a method to append elements to arrays
    int transactionIndex = 0;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if (amount <= 0) {
            // error message for unsuccessful deposits
            System.out.println("Enter a positive amount for deposit");
            return;
        }

        this.currentBalance += amount;  // adding the deposit amount
        transactions[transactionIndex] = amount;  // recording the transaction in the array
        transactionIndex++;

        // displaying a successful deposit message
        System.out.println("Successful deposit: {amount = " + amount + ", name: " + name + ", new balance = " + currentBalance + '}');
    }

    public void withdraw(double amount){

    }

    public void displayTransactions(){

    }

    public void displayBalance(){

    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
