import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static final ArrayList<String> myList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char choice;
        boolean quit = false;

        do {
            displayMenu();
            choice = getRegExString(scanner, "[ADPQadpq]");
            switch (choice) {
                case 'A', 'a':
                    addToList();
                    break;
                case 'D', 'd':
                    deleteFromList();
                    break;
                case 'P', 'p':
                    printList();
                    break;
                case 'Q', 'q':
                    quit = confirmQuit(scanner);
                    break;
            }
        } while (!quit);
    }

    private static char getRegExString(Scanner scanner, String s) {
        int i = 0;
        return 0;
    }

    private static void displayMenu() {
        System.out.println("Options:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
        System.out.println();
        System.out.println("Current list:");
        printList();
    }

    public static void addToList(ArrayList<String> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the item to add: ");
        String newItem = scanner.nextLine();
        list.add(newItem);
        System.out.println("Item added successfully.");
    }

    public static void deleteFromList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Select an item to delete:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        int indexToDelete = getRangedInt(new Scanner(System.in), "Enter the number of the item to delete", 1, list.size()) - 1;
        list.remove(indexToDelete);
        System.out.println("Item deleted successfully.");
    }

    public static void printList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Current list items:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public static boolean confirmQuit(Scanner pipe) {
        return getYNConfirm(pipe, "Are you sure you want to quit?");
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine().trim();
        } while (!input.matches(regEx));
        return input;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            while (!pipe.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer: ");
                pipe.next();
            }
            input = pipe.nextInt();
        } while (input < low || input > high);
        pipe.nextLine(); // Consume newline left-over
        return input;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        do {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine().trim().toUpperCase();
        } while (!input.equals("Y") && !input.equals("N"));
        return input.equals("Y");
    }
    public static void addToList() {
        System.out.print("Enter the item to add: ");
        String newItem = scanner.nextLine();
        myList.add(newItem);
        System.out.println("Item added successfully.");
    }

    public static void deleteFromList() {
        if (myList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Select an item to delete:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println((i + 1) + ". " + myList.get(i));
        }
        int indexToDelete = getRangedInt(scanner, "Enter the number of the item to delete", 1, myList.size()) - 1;
        myList.remove(indexToDelete);
        System.out.println("Item deleted successfully.");
    }

    public static void printList() {
        if (myList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Current list items:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println((i + 1) + ". " + myList.get(i));
        }
    }
}