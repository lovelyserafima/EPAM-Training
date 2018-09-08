package com.liup.task4.entity;

import java.util.Objects;

public class BookletCharacter {
    private boolean color;
    private int volume;
    private boolean glossiness;

    public BookletCharacter() {
    }

    public BookletCharacter(boolean color, int volume, boolean glossiness) {
        this.color = color;
        this.volume = volume;
        this.glossiness = glossiness;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean value) {
        this.color = value;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int value) {
        this.volume = value;
    }

    public boolean isGlossiness() {
        return glossiness;
    }

    public void setGlossiness(boolean value) {
        this.glossiness = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookletCharacter that = (BookletCharacter) o;
        return color == that.color &&
                volume == that.volume &&
                glossiness == that.glossiness;
    }

    @Override
    public int hashCode() {

        return Objects.hash(color, volume, glossiness);
    }

    @Override
    public String toString() {
        return "BookletCharacter{" +
                "color=" + color +
                ", volume=" + volume +
                ", glossiness=" + glossiness +
                '}';
    }
}
