import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }
}
public class main{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();
        int choice;
        do {
            System.out.println("\n================================");
            System.out.println("      PERSONAL EXPENSE TRACKER");
            System.out.println("================================");
            System.out.println("  1. Add Expense");
            System.out.println("  2. View Expenses");
            System.out.println("  3. Total Expenses");
            System.out.println("  4. Delete Expense");
            System.out.println("  5. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: Rs. ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    if (amount > 0) {
                        expenses.add(new Expense(category, amount));
                        System.out.println("Expense Added Successfully!");
                    } else {
                        System.out.println("Invalid Amount!");
                    }
                    break;

                case 2:
                    System.out.println("\n------ EXPENSE LIST ------");

                    if (expenses.isEmpty()) {
                        System.out.println("No Expenses Found!");
                    } else {
                        for (int i = 0; i < expenses.size(); i++) {
                            System.out.println(
                                (i + 1) + ". " +
                                expenses.get(i).category +
                                " - Rs. " +
                                expenses.get(i).amount
                            );
                        }
                    }
                    break;

                case 3:
                    double total = 0;

                    for (Expense e : expenses) {
                        total = total + e.amount;
                    }

                    System.out.println("Total Expenses: Rs. " + total);
                    break;

                case 4:
                    if (expenses.isEmpty()) {
                        System.out.println("No Expenses to Delete!");
                    } else {
                        System.out.print("Enter Expense Number: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        if (id >= 1 && id <= expenses.size()) {
                            expenses.remove(id - 1);
                            System.out.println("Expense Deleted!");
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank You for Using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 5);

        sc.close();
    }
}