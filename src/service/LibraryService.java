package service;

import model.Book;
import model.User;
import repository.BookRepository;
import exception.BookNotFoundException;
import java.util.*;

public class LibraryService {
    private BookRepository bookRepo = new BookRepository();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        bookRepo.addBook(book);
    }

    public void removeBook(String isbn) throws BookNotFoundException {
        Book book = bookRepo.findBookByIsbn(isbn);
        if (book != null) {
            bookRepo.removeBook(isbn);
        } else {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        }
    }

    public void borrowBook(String isbn) throws BookNotFoundException {
        Book book = bookRepo.findBookByIsbn(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed: " + book.getTitle());
        } else if (book == null) {
            throw new BookNotFoundException("Book not found.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(String isbn) throws BookNotFoundException {
        Book book = bookRepo.findBookByIsbn(isbn);
        if (book != null) {
            book.setAvailable(true);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            throw new BookNotFoundException("Book not found.");
        }
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public List<Book> getBooks() {
        return bookRepo.getAllBooks();
    }
}
