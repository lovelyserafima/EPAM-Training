package com.epam.audiomanager.entity.audio;

import com.epam.audiomanager.entity.Entity;
import java.math.BigDecimal;
import java.util.Objects;

public class AudioTrack extends Entity {
    private String name;
    private String band;
    private int year;
    private BigDecimal price;

    public AudioTrack(){super();}

    public AudioTrack(int id, String name, String band, int year, BigDecimal price) {
        super(id);
        this.name = name;
        this.band = band;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AudioTrack)) return false;
        if (!super.equals(o)) return false;
        AudioTrack that = (AudioTrack) o;
        return getYear() == that.getYear() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getBand(), that.getBand()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getBand(), getYear(), getPrice());
    }

    @Override
    public String toString() {
        return "AudioTrack{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", band='" + band + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
