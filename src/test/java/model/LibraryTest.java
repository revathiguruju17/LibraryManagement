package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


class LibraryTest {
    private Library library;
    private Item item;

    @BeforeEach
    void init() {
        library = new Library();
        item = Mockito.mock(Book.class);
    }

    @Test
    void shouldContainAnItemInTheItemListInLibraryWhichIsAdded() {
        library.addItems(item);
        assertTrue(library.searchItem(item));
    }

    @Test
    void shouldNotContainAnItemInLibraryItemsWhichIsNotAdded() {
        assertFalse(library.searchItem(item));
    }

    @Test
    void shouldRemoveTheGivenItemFromTheLibraryItems() {
        library.addItems(item);
        library.removeItem(item);
        assertFalse(library.searchItem(item));
    }

    @Test
    void shouldThrowAnExceptionIfTheUnAddedItemIsRemovedFromTheLibraryItems() {
        assertThrows(ItemNotFoundException.class, ()->{
            library.removeItem(item);
        },"un added item cannot be removed");
    }
}
