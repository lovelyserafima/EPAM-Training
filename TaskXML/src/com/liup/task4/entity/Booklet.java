package com.liup.task4.entity;

import java.util.Objects;

public class Booklet extends PaperEdition {
    private BookletCharacter bookletCharacter;

    public Booklet() {
        bookletCharacter = new BookletCharacter();
    }

    public Booklet(String title, boolean monthly, String id, String category, BookletCharacter bookletCharacter) {
        super(title, monthly, id, category);
        this.bookletCharacter = bookletCharacter;
    }

    public BookletCharacter getBookletCharacter() {
        return bookletCharacter;
    }

    public void setBookletCharacter(BookletCharacter value) {
        this.bookletCharacter = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Booklet booklet = (Booklet) o;
        return Objects.equals(bookletCharacter, booklet.bookletCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bookletCharacter);
    }

    @Override
    public String toString() {
        return "Booklet: " + super.toString() +
                ", bookletCharacter=" + bookletCharacter + "\n";
    }
}
