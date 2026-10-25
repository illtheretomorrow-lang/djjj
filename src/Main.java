import java.util.Scanner;
public class Main { public static void main(String[] args) { Scanner scanner = new Scanner(System.in);


    String correctPin = "1111";
    int attemptsLeft = 3;
    boolean isLoggedIn = false;
    double balance = 1000.0;

    System.out.println("====== SIMPLE ATM ======");


    while (attemptsLeft > 0) {
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (enteredPin.equals(correctPin)) {
            System.out.println("Login successful!");
            isLoggedIn = true;
            break;
        } else {
            attemptsLeft--;
            System.out.println("Incorrect PIN.");
            if (attemptsLeft > 0) {
                System.out.println("Attempts left: " + attemptsLeft);
            }
        }
    }


    if (!isLoggedIn) {
        System.out.println("Your account has been blocked.");
        scanner.close();
        return;
    }


    while (true) {
        System.out.println("\n====== ATM MENU ======");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();

        if (choice == 1) {

            System.out.println("Your current balance is: $" + balance);
        } else if (choice == 2) {

            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful.");
                System.out.println("Your new balance is: $" + balance);
            } else {
                System.out.println("Invalid amount!");
            }
        } else if (choice == 3) {

            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful.");
                System.out.println("Your new balance is: $" + balance);
            } else if (amount > balance) {
                System.out.println("Insufficient funds!");
            } else {
                System.out.println("Invalid amount!");
            }
        } else if (choice == 4) {

            System.out.println("Thank you for using Simple ATM!");
            break;
        } else {
            System.out.println("Invalid option. Please try again.");
        }
    }

    scanner.close();
}
}