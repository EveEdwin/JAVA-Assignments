package Books;

import java.util.ArrayList;
import java.util.Scanner;

class Publication {
    String title;
    double sellingPrice;
    double buyingPrice; 
    int copies;
    static int soldCopies = 0; 

    public Publication(String title, double buyingPrice, double sellingPrice, int copies) {
        this.title = title;
        this.sellingPrice = sellingPrice;
        this.buyingPrice = buyingPrice; 
        this.copies = copies;
    }

    public double saleCopy(int copiesSold) {
        if (copiesSold <= copies) {
            copies -= copiesSold;
            soldCopies += copiesSold; 
            return copiesSold * sellingPrice;
        } else {
            System.out.println("Not enough copies in inventory!");
            return 0;
        }
    }

    public double calculateProfit(int copiesSold) {
        return (sellingPrice - buyingPrice) * copiesSold;
    }

    public void addCopies(int additionalCopies) {
        copies += additionalCopies;
    }

    public int getCopies() {
        return copies;
    }

    public int getSoldCopies() {
        return soldCopies;
    }
}

class Book extends Publication {
    String author;

    public Book(String title, double buyingPrice, double sellingPrice, int copies, String author) {
        super(title, buyingPrice, sellingPrice, copies);
        this.author = author;
    }

    public void orderCopies(int additionalCopies) {
        addCopies(additionalCopies);
        System.out.println("Ordered " + additionalCopies + " more copies of the book: " + title);
    }

    public void sellCopies(int copiesSold) {
        double saleAmount = saleCopy(copiesSold);
        if (saleAmount > 0) {
            double profit = calculateProfit(copiesSold);
            System.out.println("Sold " + copiesSold + " copies of the book: " + title + " for $" + saleAmount + ". Profit: $" + profit);
        }
    }
}

class Magazine extends Publication {
    String currentIssue;

    public Magazine(String title, double buyingPrice, double sellingPrice, int copies, String currentIssue) {
        super(title, buyingPrice, sellingPrice, copies);
        this.currentIssue = currentIssue;
    }

    public void orderQty(int additionalCopies) {
        addCopies(additionalCopies);
        System.out.println("Ordered " + additionalCopies + " more copies of the magazine: " + title);
    }

    public void sellCopies(int copiesSold) {
        double saleAmount = saleCopy(copiesSold);
        if (saleAmount > 0) {
            double profit = calculateProfit(copiesSold);
            System.out.println("Sold " + copiesSold + " copies of the magazine: " + title + " for $" + saleAmount + ". Profit: $" + profit);
        }
    }
}

public class Books {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Magazine> magazines = new ArrayList<>();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Magazine");
            System.out.println("3. Order more copies of a Book");
            System.out.println("4. Sell copies of a Book");
            System.out.println("5. Order more copies of a Magazine");
            System.out.println("6. Sell copies of a Magazine");
            System.out.println("7. Display total sales");
            System.out.println("8. View current availability of Books and Magazines");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("\nEnter details for the new Book:");
                    System.out.print("Enter book title: ");
                    String bookTitle = sc.nextLine();
                    System.out.print("Enter buying price: ");
                    double bookBuyingPrice = sc.nextDouble();
                    System.out.print("Enter selling price: ");
                    double bookSellingPrice = sc.nextDouble();
                    System.out.print("Enter number of copies: ");
                    int bookCopies = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    books.add(new Book(bookTitle, bookBuyingPrice, bookSellingPrice, bookCopies, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("\nEnter details for the new Magazine:");
                    System.out.print("Enter magazine title: ");
                    String magazineTitle = sc.nextLine();
                    System.out.print("Enter buying price: ");
                    double magBuyingPrice = sc.nextDouble();
                    System.out.print("Enter selling price: ");
                    double magSellingPrice = sc.nextDouble();
                    System.out.print("Enter number of copies: ");
                    int magazineCopies = sc.nextInt();
                    sc.nextLine();  
                    System.out.print("Enter current issue: ");
                    String currentIssue = sc.nextLine();
                    magazines.add(new Magazine(magazineTitle, magBuyingPrice, magSellingPrice, magazineCopies, currentIssue));
                    System.out.println("Magazine added successfully!");
                    break;

                case 3:
                    if (books.isEmpty()) {
                        System.out.println("No books available to order more copies.");
                    } else {
                        System.out.println("Select a book to order more copies:");
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println((i + 1) + ". " + books.get(i).title + " (" + books.get(i).getCopies() + " copies available)");
                        }
                        int bookChoice = sc.nextInt();
                        if (bookChoice >= 1 && bookChoice <= books.size()) {
                            System.out.print("Enter number of additional copies for the book: ");
                            int additionalCopies = sc.nextInt();
                            books.get(bookChoice - 1).orderCopies(additionalCopies);
                        } else {
                            System.out.println("Invalid book choice!");
                        }
                    }
                    break;

                case 4:
                    if (books.isEmpty()) {
                        System.out.println("No books available to sell.");
                    } else {
                        System.out.println("Select a book to sell copies:");
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println((i + 1) + ". " + books.get(i).title + " (" + books.get(i).getCopies() + " copies available)");
                        }
                        int bookChoice = sc.nextInt();
                        if (bookChoice >= 1 && bookChoice <= books.size()) {
                            System.out.print("Enter number of copies to sell: ");
                            int copiesSold = sc.nextInt();
                            books.get(bookChoice - 1).sellCopies(copiesSold);
                        } else {
                            System.out.println("Invalid book choice!");
                        }
                    }
                    break;

                case 5:
                    if (magazines.isEmpty()) {
                        System.out.println("No magazines available to order more copies.");
                    } else {
                        System.out.println("Select a magazine to order more copies:");
                        for (int i = 0; i < magazines.size(); i++) {
                            System.out.println((i + 1) + ". " + magazines.get(i).title + " (" + magazines.get(i).getCopies() + " copies available)");
                        }
                        int magChoice = sc.nextInt();
                        if (magChoice >= 1 && magChoice <= magazines.size()) {
                            System.out.print("Enter number of additional copies for the magazine: ");
                            int additionalCopies = sc.nextInt();
                            magazines.get(magChoice - 1).orderQty(additionalCopies);
                        } else {
                            System.out.println("Invalid magazine choice!");
                        }
                    }
                    break;

                case 6:
                    if (magazines.isEmpty()) {
                        System.out.println("No magazines available to sell.");
                    } else {
                        System.out.println("Select a magazine to sell copies:");
                        for (int i = 0; i < magazines.size(); i++) {
                            System.out.println((i + 1) + ". " + magazines.get(i).title + " (" + magazines.get(i).getCopies() + " copies available)");
                        }
                        int magChoice = sc.nextInt();
                        if (magChoice >= 1 && magChoice <= magazines.size()) {
                            System.out.print("Enter number of copies to sell: ");
                            int copiesSold = sc.nextInt();
                            magazines.get(magChoice - 1).sellCopies(copiesSold);
                        } else {
                            System.out.println("Invalid magazine choice!");
                        }
                    }
                    break;

                case 7:
                    double totalSales = 0;
                    for (Book book : books) {
                        totalSales += book.getSoldCopies() * book.sellingPrice;
                    }
                    for (Magazine magazine : magazines) {
                        totalSales += magazine.getSoldCopies() * magazine.sellingPrice;
                    }
                    System.out.println("Total sales of publications: $" + totalSales);
                    break;

                case 8:
                    System.out.println("Current availability of Books and Magazines:");
                    for (Book book : books) {
                        System.out.println("Book: " + book.title + " - " + book.getCopies() + " copies available");
                    }
                    for (Magazine magazine : magazines) {
                        System.out.println("Magazine: " + magazine.title + " - " + magazine.getCopies() + " copies available");
                    }
                    break;

                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
                    break;
            }
        } while (choice != 0);

        sc.close();
    }
}
