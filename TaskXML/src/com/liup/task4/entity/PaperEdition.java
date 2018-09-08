package com.liup.task4.entity;

import java.util.Objects;

public class PaperEdition {
    private String title;
    private boolean monthly;
    private String id;
    private String category;

    public PaperEdition(String title, boolean monthly, String id, String category) {
        this.title = title;
        this.monthly = monthly;
        this.id = id;
        this.category = category;
    }

    public PaperEdition() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public void setMonthly(boolean value) {
        this.monthly = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getCategory() {
        if (category == null) {
            return "news";
        } else {
            return category;
        }
    }

    public void setCategory(String value) {
        this.category = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperEdition that = (PaperEdition) o;
        return monthly == that.monthly &&
                Objects.equals(title, that.title) &&
                Objects.equals(id, that.id) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, monthly, id, category);
    }

    @Override
    public String toString() {
        return "->" +
                "title='" + title + '\'' +
                ", monthly=" + monthly +
                ", id='" + id + '\'' +
                ", category='" + category + "' ";
    }
}
