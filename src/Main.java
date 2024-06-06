import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankAccount bankAccount = new BankAccount("Tesla", 369);
        bankAccount.showMenu();
    }
}


class BankAccount {
    int balance;
    int previousTransactions;
    String customerName;
    int customerId;

BankAccount(String cName, int cId) {
    customerName = cName;
    customerId = cId;
}

  public void deposit(int amount) {
      if (amount != 0) {
          balance = balance + amount;
          previousTransactions = amount;
      }
  }


  public void withdraw(int amount) {
      if (amount != 0) {
          balance = balance - amount;
          previousTransactions = amount;
      }
  }


  public void getPreviousTransactions () {
      if (previousTransactions > 0) {
          System.out.println("Deposited: " + previousTransactions);
      }
      else if (previousTransactions < 0) {
          System.out.println("Withdrawn: " +  Math.abs(previousTransactions));
      }
      else {
          System.out.println("No previous transactions occur");
      }
  }


  public void showMenu() {
      String option = "/0";
      Scanner scanner = new Scanner(System.in);

      System.out.println("Welcome " + customerName);
      System.out.println("Your Id is: " + customerId);
      System.out.println();
      System.out.println("A. Check Balance");
      System.out.println("B. Check Deposit");
      System.out.println("C. withdraw");
      System.out.println("D. Previous transaction");
      System.out.println("E. Exit");

      do {
              System.out.println("###########################");
              System.out.println("Please Enter Options: ");
              option = scanner.next().toUpperCase();


              switch (option) {
                  case "A" -> {
                      System.out.println("###########################");
                      System.out.println("Your Balance is: " + balance);
                      System.out.println("###########################");
                      System.out.println(" ");
                  }
                  case "B" -> {
                      System.out.println("###########################");
                      System.out.println("Enter Amount of Money to deposit: ");
                      System.out.println("###########################");
                      int amount = scanner.nextInt();
                      deposit(amount);
                      System.out.println(" ");
                  }
                  case "C" -> {
                      System.out.println("###########################");
                      System.out.println("Enter Amount of Money to withdraw: ");
                      System.out.println("###########################");
                      int amount_2 = scanner.nextInt();
                      withdraw(amount_2);
                      System.out.println(" ");
                  }
                  case "D" -> {
                      System.out.println("###########################");
                      System.out.println("Your Previous transactions: ");
                      getPreviousTransactions();
                      System.out.println();
                  }
                  case "E" -> {
                      System.out.println("###########################");

                  }
                  default -> {
                      System.out.println("Invalid Options! Please try again ");
                      System.out.println(" ");
                  }
              }

      }
      while (!option.equalsIgnoreCase("E")) ;
   }
}