package model;

class ItemNotFoundException extends RuntimeException {

    ItemNotFoundException() {
        super("Library Item not found");
    }
}
