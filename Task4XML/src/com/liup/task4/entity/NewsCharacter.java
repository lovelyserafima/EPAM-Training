package com.liup.task4.entity;

import java.util.Objects;

public class NewsCharacter {
    private boolean color;
    private int volume;
    private int subscriptionIndex;

    public NewsCharacter() {
    }

    public NewsCharacter(boolean color, int volume, int subscriptionIndex) {
        this.color = color;
        this.volume = volume;
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
        NewsCharacter that = (NewsCharacter) o;
        return color == that.color &&
                volume == that.volume &&
                subscriptionIndex == that.subscriptionIndex;
    }

    @Override
    public int hashCode() {

        return Objects.hash(color, volume, subscriptionIndex);
    }

    @Override
    public String toString() {
        return "NewsCharacter{" +
                "color=" + color +
                ", volume=" + volume +
                ", subscriptionIndex=" + subscriptionIndex +
                '}';
    }
}
