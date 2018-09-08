package com.liup.task4.entity;

import java.util.Objects;

public class MagazineCharacter {
    private boolean color;
    private int volume;
    private boolean glossiness;
    private int subscriptionIndex;

    public MagazineCharacter() {
    }

    public MagazineCharacter(boolean color, int volume, boolean glossiness, int subscriptionIndex) {
        this.color = color;
        this.volume = volume;
        this.glossiness = glossiness;
        this.subscriptionIndex = subscriptionIndex;
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

    public int getSubscriptionIndex() {
        return subscriptionIndex;
    }

    public void setSubscriptionIndex(int value) {
        this.subscriptionIndex = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MagazineCharacter that = (MagazineCharacter) o;
        return color == that.color &&
                volume == that.volume &&
                glossiness == that.glossiness &&
                subscriptionIndex == that.subscriptionIndex;
    }

    @Override
    public int hashCode() {

        return Objects.hash(color, volume, glossiness, subscriptionIndex);
    }

    @Override
    public String toString() {
        return "MagazineCharacter{" +
                "color=" + color +
                ", volume=" + volume +
                ", glossiness=" + glossiness +
                ", subscriptionIndex=" + subscriptionIndex +
                '}';
    }
}
