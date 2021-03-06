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
    }

    @Test
    void shouldIssueABookWhenTheUserWantsToBorrowALibraryItem() {
        library.addItems(item);
        librarian.issueAnItem(borrower, item, library);
        doNothing().when(borrower).addItem(isA(Item.class));
        doNothing().when(item).update();
        doNothing().when(library).removeItem(isA(Item.class));
        verify(borrower, times(1)).addItem(item);
        verify(item, times(1)).update();
        verify(library, times(1)).removeItem(item);
    }

    @Test
    void shouldReturnALibraryItemWhenUserReturnsAnItem(){
        librarian.returnAnItem(borrower,item,library);
        doNothing().when(borrower).removeItem(isA(Item.class));
        doNothing().when(item).update();
        doNothing().when(library).addItems(isA(Item.class));
        verify(borrower, times(1)).removeItem(item);
        verify(item, times(1)).update();
        verify(library, times(1)).addItems(item);
    }
}
