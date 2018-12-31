package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


class LibraryTest {
    private Library library;

    @BeforeEach
    void init() {
        library = new Library();
    }

    @Test
    void shouldContainAnItemInTheItemListInLibraryWhichIsAdded() {
        Item item = Mockito.mock(Book.class);
        library.addItems(item);
        assertTrue(library.searchItem(item));
    }

    @Test
    void shouldNotContainAnItemInLibraryItemsWhichIsNotAdded() {
        Item item = Mockito.mock(Book.class);
        assertFalse(library.searchItem(item));
    }
}
