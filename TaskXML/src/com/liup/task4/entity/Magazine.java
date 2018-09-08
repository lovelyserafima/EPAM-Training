package com.liup.task4.entity;

import java.util.Objects;

public class Magazine extends PaperEdition {
    private MagazineCharacter magazineCharacter;

    public Magazine() {
        magazineCharacter = new MagazineCharacter();
    }

    public Magazine(String title, boolean monthly, String id, String category, MagazineCharacter magazineCharacter) {
        super(title, monthly, id, category);
        this.magazineCharacter = magazineCharacter;
    }

    public MagazineCharacter getMagazineCharacter() {
        return magazineCharacter;
    }

    public void setMagazineCharacter(MagazineCharacter value) {
        this.magazineCharacter = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(magazineCharacter, magazine.magazineCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magazineCharacter);
    }

    @Override
    public String toString() {
        return "Magazine: " + super.toString() +
                ", magazineCharacter=" + magazineCharacter + "\n";
    }
}
