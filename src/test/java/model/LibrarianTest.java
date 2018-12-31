package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;


class LibrarianTest {

    private Library library;
    private Librarian librarian;
    private Borrower borrower;
    private Item item;

    @BeforeEach
    void init() {
        library = Mockito.mock(Library.class);
        librarian = new Librarian();
        borrower = Mockito.mock(Borrower.class);
        item = Mockito.mock(Book.class);
        library.addItems(item);
    }

    @Test
    void shouldIssueABookToTheUser() {
        librarian.issueAnItem(borrower, item, library);
        doNothing().when(borrower).addItem(isA(Item.class));
        doNothing().when(item).update();
        doNothing().when(library).removeItem(isA(Item.class));
        verify(borrower, times(1)).addItem(item);
        verify(borrower,times(1)).addItem(item);
        verify(library, times(1)).removeItem(item);
    }
}
