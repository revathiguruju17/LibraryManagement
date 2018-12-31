package model;

import java.util.List;

class Librarian extends Staff {
    List<IssuedItem> issuedItems;


    void issueAnItem(Borrower borrower, Item item, Library library) {
        library.removeItem(item);
        borrower.addItem(item);
        item.update();
    }
}
