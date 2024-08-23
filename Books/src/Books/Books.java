package Books;
import java.util.Scanner;

class Publication {
    String title;
    double price;
    int copies;

    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    public double saleCopy(int noOfCopies) {
        if (noOfCopies > copies) {
            System.out.println("Not enough copies available for book: " + title);
            return 0;
        } else {
            copies -= noOfCopies;
            double saleAmount = price * noOfCopies;
            System.out.println("Sold " + noOfCopies + " copies of publication " + title);
            return saleAmount;
        }
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getCopies() {
        return copies;
    }
}

class Book extends Publication {
    public static int bookCount = 0;
    public static double bookSale = 0;
    private String author;

    public Book(String title, String author, double price, int copies) {
        super(title, price, copies);
        this.author = author;
    }

    @Override
    public double saleCopy(int noOfCopies) {
        if (noOfCopies > copies) {
            System.out.println("Not enough copies available for book: " + title);
            return 0;
        } else {
            copies -= noOfCopies;
            double saleAmount = price * noOfCopies;
            bookCount += noOfCopies;
            bookSale += saleAmount;
            System.out.println("Sold " + noOfCopies + " copies of book: " + title);
            return saleAmount;
        }
    }

    public void orderCopies(int additionalCopies) {
        copies += additionalCopies;
        System.out.println("Ordered " + additionalCopies + " additional copies of book: " + title);
    }

    public String getAuthor() {
        return author;
    }
}

class Magazine extends Publication {
    int orderQty;
    String currentIssue;
    public static int magazineCount = 0;
    public static double magazineSale = 0;

    public Magazine(String title, double price, int copies, int orderQty, String currentIssue) {
        super(title, price, copies);
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }

    @Override
    public double saleCopy(int noOfCopies) {
        if (noOfCopies > copies) {
            System.out.println("Not enough copies available for magazine: " + title);
            return 0;
        } else {
            copies -= noOfCopies;
            double saleAmount = price * noOfCopies;
            magazineCount += noOfCopies;
            magazineSale += saleAmount;
            System.out.println("Sold " + noOfCopies + " copies of magazine: " + title);
            return saleAmount;
        }
    }

    public void receiveIssue(String newIssue, int additionalCopies) {
        currentIssue = newIssue;
        copies += additionalCopies;
        System.out.println("Received new issue (" + currentIssue + ") of magazine: " + title);
    }

    public int getOrderQty() {
        return orderQty;
    }

    public String getCurrentIssue() {
        return currentIssue;
    }
}

public class pub {
    public static void main(String[] args) {
        Book[] books = new Book[100000];
        Magazine[] magazines = new Magazine[100000];
        int bookCount = 0;
        int magazineCount = 0;
        double totalSales = 0.0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Publication Sales Manager!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Sell Copies(Books/Magazines)");
            System.out.println("4. Order Additional Copies for Book");
            System.out.println("5. Receive New Magazine Issue");
            System.out.println("6. Display Book Sales");
            System.out.println("7. Display Magazine Sales");
            System.out.println("8. Display Total Sales");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (bookCount >= 100000) {
                        System.out.println("Cannot add more books. Maximum limit reached.");
                        break;
                    }
                    System.out.print("Enter Book Title: ");
                    String bookTitle = sc.next();
                    System.out.print("Enter Author Name: ");
                    String author = sc.next();
                    System.out.print("Enter Price: ");
                    double bookPrice = sc.nextDouble();
                    System.out.print("Enter Number of Copies: ");
                    int bookCopies = sc.nextInt();

                    books[bookCount++] = new Book(bookTitle, author, bookPrice, bookCopies);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    if (magazineCount >= 100000) {
                        System.out.println("Cannot add more magazines. Maximum limit reached.");
                        break;
                    }
                    System.out.print("Enter Magazine Title: ");
                    String magazineTitle = sc.next();
                    System.out.print("Enter Current Issue: ");
                    String currentIssue = sc.next();
                    System.out.print("Enter Price: ");
                    double magazinePrice = sc.nextDouble();
                    System.out.print("Enter Number of Copies: ");
                    int magazineCopies = sc.nextInt();
                    System.out.print("Enter Order Quantity: ");
                    int orderQty = sc.nextInt();

                    magazines[magazineCount++] = new Magazine(magazineTitle, magazinePrice, magazineCopies, orderQty, currentIssue);
                    System.out.println("Magazine added successfully!");
                    break;

                case 3:
                    System.out.println("Select 1.Book  2.Magazine:");
                    int n = sc.nextInt();

                    if (n != 1 && n != 2) {
                        System.out.println("Invalid choice.");
                        break;
                    }
                    
                    if (n == 1) {
                        if (bookCount == 0) {
                            System.out.println("No books available for sale.");
                            break;
                        }
                        
                        System.out.println("Available Books:");
                        for (int i = 0; i < bookCount; i++) {
                            System.out.println((i + 1) + ". " + books[i].getTitle() + " (" + books[i].getCopies() + " copies available)");
                        }

                        System.out.print("Select Book to sell (enter number): ");
                        int bookChoice = sc.nextInt();

                        if (bookChoice < 1 || bookChoice > bookCount) {
                            System.out.println("Invalid selection.");
                            break;
                        }

                        Book selectedBook = books[bookChoice - 1];
                        System.out.print("Enter number of copies to sell: ");
                        int sellCopies = sc.nextInt();

                        double saleAmount = selectedBook.saleCopy(sellCopies);
                        totalSales += saleAmount;

                        if (saleAmount > 0) {
                            System.out.println("Sale successful. Amount: " + saleAmount);
                        }
                    } else {
                        if (magazineCount == 0) {
                            System.out.println("No magazines available for sale.");
                            break;
                        }
                        
                        System.out.println("Available Magazines:");
                        for (int i = 0; i < magazineCount; i++) {
                            System.out.println((i + 1) + ". " + magazines[i].getTitle() + " (" + magazines[i].getCopies() + " copies available)");
                        }

                        System.out.print("Select Magazine to sell (enter number): ");
                        int magChoice = sc.nextInt();

                        if (magChoice < 1 || magChoice > magazineCount) {
                            System.out.println("Invalid selection.");
                            break;
                        }

                        Magazine selectedMagazine = magazines[magChoice - 1];
                        System.out.print("Enter number of copies to sell: ");
                        int sellCopies = sc.nextInt();

                        double saleAmount = selectedMagazine.saleCopy(sellCopies);
                        totalSales += saleAmount;

                        if (saleAmount > 0) {
                            System.out.println("Sale successful. Amount: " + saleAmount);
                        }
                    }
                    break;

                case 4:
                    if (bookCount == 0) {
                        System.out.println("No books available to order copies.");
                        break;
                    }

                    System.out.println("Available Books:");
                    for (int i = 0; i < bookCount; i++) {
                        System.out.println((i + 1) + ". " + books[i].getTitle() + " by " + books[i].getAuthor() + " (" + books[i].getCopies() + " copies available)");
                    }

                    System.out.print("Select book to order additional copies (enter number): ");
                    int bookChoice = sc.nextInt();

                    if (bookChoice < 1 || bookChoice > bookCount) {
                        System.out.println("Invalid selection.");
                        break;
                    }

                    Book selectedBook = books[bookChoice - 1];
                    System.out.print("Enter number of additional copies to order: ");
                    int additionalCopies = sc.nextInt();

                    selectedBook.orderCopies(additionalCopies);
                    break;

                case 5:
                    if (magazineCount == 0) {
                        System.out.println("No magazines available to receive new issue.");
                        break;
                    }

                    System.out.println("Available Magazines:");
                    for (int i = 0; i < magazineCount; i++) {
                        System.out.println((i + 1) + ". " + magazines[i].getTitle() + " (Current Issue: " + magazines[i].getCurrentIssue() + ", " + magazines[i].getCopies() + " copies available)");
                    }

                    System.out.print("Select magazine to receive new issue (enter number): ");
                    int magChoice = sc.nextInt();

                    if (magChoice < 1 || magChoice > magazineCount) {
                        System.out.println("Invalid selection.");
                        break;
                    }

                    Magazine selectedMagazine = magazines[magChoice - 1];
                    sc.nextLine();  // Consume newline left-over
                    System.out.print("Enter new issue name: ");
                    String newIssue = sc.nextLine();
                    System.out.print("Enter number of copies received: ");
                    int receivedCopies = sc.nextInt();

                    selectedMagazine.receiveIssue(newIssue, receivedCopies);
                    break;

                case 6:
                    System.out.println("Total books sold: " + Book.bookCount + " and amount: " + Book.bookSale);
                    break;

                case 7:
                    System.out.println("Total magazines sold: " + Magazine.magazineCount + " and amount: " + Magazine.magazineSale);
                    break;

                case 8:
                    System.out.println("Total sales are: " + totalSales);
                    break;

                case 9:
                    System.out.println("Exited Successfully");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

























