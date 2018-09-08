package com.liup.task4.entity;

import java.util.Objects;


public class Newspaper extends PaperEdition {
    private NewsCharacter newsCharacter;

    public Newspaper() {
        newsCharacter = new NewsCharacter();
    }

    public Newspaper(String title, boolean monthly, String id, String category, NewsCharacter newsCharacter) {
        super(title, monthly, id, category);
        this.newsCharacter = newsCharacter;
    }

    public NewsCharacter getNewsCharacter() {
        return newsCharacter;
    }

    public void setNewsCharacter(NewsCharacter value) {
        this.newsCharacter = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Newspaper newspaper = (Newspaper) o;
        return Objects.equals(newsCharacter, newspaper.newsCharacter);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), newsCharacter);
    }

    @Override
    public String toString() {
        return "Newspaper: " + super.toString() +
                ", newsCharacter=" + newsCharacter + "\n";
    }
}
