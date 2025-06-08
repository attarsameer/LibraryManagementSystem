import model.User;
import service.LibraryService;
import java.util.Scanner;

public class LibraryApp {
    private static LibraryService libraryService = new LibraryService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample data
        libraryService.addBook(new model.Book("Java Basics", "John Doe", "12345"));
        libraryService.addBook(new model.Book("Advanced Java", "Jane Smith", "67890"));

        libraryService.addUser(new User("admin", "admin123", true));
        libraryService.addUser(new User("user", "user123", false));

        while (true) {
            System.out.println("Welcome to the Library Management System");
            System.out.println("1. Login");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                User user = libraryService.authenticateUser(username, password);
                if (user != null) {
                    System.out.println("Welcome " + username);
                    if (user.isAdmin()) {
                        adminMenu();
                    } else {
                        userMenu();
                    }
                } else {
                    System.out.println("Invalid credentials!");
                }
            } else {
                break;
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List Books");
            System.out.println("4. Log Out");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    listBooks();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void userMenu() {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. List Books");
            System.out.println("4. Log Out");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    listBooks();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        libraryService.addBook(new model.Book(title, author, isbn));
        System.out.println("Book added successfully.");
    }

    private static void removeBook() {
        System.out.print("Enter Book ISBN to remove: ");
        String isbn = scanner.nextLine();
        try {
            libraryService.removeBook(isbn);
            System.out.println("Book removed successfully.");
        } catch (exception.BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrowBook() {
        System.out.print("Enter ISBN of the book you want to borrow: ");
        String isbn = scanner.nextLine();
        try {
            libraryService.borrowBook(isbn);
        } catch (exception.BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void returnBook() {
        System.out.print("Enter ISBN of the book you want to return: ");
        String isbn = scanner.nextLine();
        try {
            libraryService.returnBook(isbn);
        } catch (exception.BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listBooks() {
        System.out.println("\nAvailable Books:");
        for (model.Book book : libraryService.getBooks()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
        }
    }
}
