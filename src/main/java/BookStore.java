//Write a Java program to create a class called "BookStore" with instance variables "books" (a list of Book objects) and "numBooks" (the number of books in the list). Include the following methods:
//A method to add a book to the list
//A method to remove a book from the list
//A method to search for a book by its title
//A method to sort the books in the list by their price (ascending or descending order)
//A method to calculate the average price of all books in the store


import java.util.ArrayList;
import java.util.List;

public class BookStore {
    List<String> books = new ArrayList<>();
    int numBooks;

    public void addBook(String book) {
        books.add(book);
        numBooks++;
    }

    public void removeBook(String book) {
        if (books.contains(book)) {
            books.remove(book);
            numBooks--;
        }
    }

    public void searchBook(String book) {
        if (books.contains(book)) {
            System.out.println(book + " Book found");
        }
    }
}

class Price extends BookStore {
    List<Double> bookPrice = new ArrayList<>();

    public void addBookWithPrice(String book, double price) {
        super.addBook(book);
        bookPrice.add(price);

    }

    public void removeBook(String book) {
        int index = books.indexOf(book);
        super.removeBook(book);
        if(bookPrice.size() > books.size()){
            bookPrice.remove(index);
        }
    }
    public void averagePriceOfBooks(){
        double totalPrice = 0;
        for(Double i : bookPrice){
            totalPrice = totalPrice + i;
        }
        System.out.println("Average Price Of Books : " + totalPrice/bookPrice.size());
    }
}

class Main {
    public static void main(String[] args) {
        Price bookName = new Price();

        bookName.addBookWithPrice("rr", 100);
        bookName.addBookWithPrice("tt",30);
        bookName.addBookWithPrice("pp",70);
        bookName.addBookWithPrice("ss",50);
        bookName.removeBook("ss");
        bookName.averagePriceOfBooks();
    }
}