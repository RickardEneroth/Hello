package se.eneroth.hello;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import se.eneroth.hello.exception.NegativeException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class AppTest {

    App app;
    private static BookShelf mockedBookShelf;
    private static Book book1;
    private static Book book2;
    List<Book> allBooks = new ArrayList<Book>();

    @BeforeTest
    public void setup() {
        app = new App();
    }

    @BeforeClass
    public void makeBooks() {
        mockedBookShelf = mock(BookShelf.class);
        book1 = new Book();
        book1.setIsbn("1234");
        book1.setPrice(12.34);
        book1.setTitle("The King and I");
        allBooks.add(book1);

        book2 = new Book();
        book2.setIsbn("5678");
        book2.setPrice(98.32);
        book2.setTitle("Free at last");
        allBooks.add(book2);

        when(mockedBookShelf.getAllBooks()).thenReturn(allBooks);
        when(mockedBookShelf.getBook("1234")).thenReturn(book1);
        when(mockedBookShelf.getBook("5678")).thenReturn(book2);
        when(mockedBookShelf.getPrice("1234")).thenReturn(book1.getPrice());
        when(mockedBookShelf.getPrice("5678")).thenReturn(book2.getPrice());
    }

    @Test
    public void testa() {
        System.out.println("Testar...");
        assertEquals(7, 7);
    }

    @Test
    public void testa2() {
        System.out.println("Testar2...");
        assertEquals(57, 57);
    }

    @Test
    public void test_add() {
        int result = app.add(7, 8);
        assertEquals(result, 15);
    }

    @Test
    public void test_up() {
        String str = "UPPER";
        assertEquals(app.up("upper"), str);
    }

    @Test
    public void test_exception() {
        try {
            app.addWithException(1, -6);
        } catch (NegativeException e) {
            assertEquals(e.getMessage(), "Minst ett av talen verkar vara negativt!");
        }
    }

    @Test
    public void test_exception_ok() {
        try {
            int result = app.addWithException(1, 6);
            assertEquals(7, result);
        } catch (NegativeException e) {
            assertEquals(e.getMessage(), "Minst ett av talen verkar vara negativt!");
        }
    }

    @Test
    public void test_get_all_books() {
        List<Book> allBooks = mockedBookShelf.getAllBooks();
        assertEquals(allBooks.size(), 2);
    }

    @Test
    public void test_get_book1() {
        Book book = mockedBookShelf.getBook("1234");
        assertEquals(book.getIsbn(), "1234");
        assertEquals(book.getPrice(), 12.34);
        assertEquals(book.getTitle(), "The King and I");
    }

    @Test
    public void test_get_book2() {
        Book book = mockedBookShelf.getBook("5678");
        assertEquals(book.getIsbn(), "5678");
        assertEquals(book.getPrice(), 98.32);
        assertEquals(book.getTitle(), "Free at last");
    }

    @Test
    public void test_get_book2_price() {
        double price = mockedBookShelf.getPrice("5678");
        assertEquals(price, 98.32);
    }
}
