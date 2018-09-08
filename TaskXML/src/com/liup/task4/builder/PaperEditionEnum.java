package com.liup.task4.builder;

public enum PaperEditionEnum {
    PAPERS("papers"),
    NEWS_CHARS("news-chars"),
    MAGAZINE_CHARS("magazine-chars"),
    BOOKLET_CHARS("booklet-chars"),
    TITLE("title"),
    MONTHLY("monthly"),
    COLOR("color"),
    VOLUME("volume"),
    GLOSSINESS("glossiness"),
    SUBSCRIPTION_INDEX("subscription-index"),
    NEWSPAPER("newspaper"),
    MAGAZINE("magazine"),
    BOOKLET("booklet"),
    ID("id"),
    CATEGORY("category");
    private String value;

    private PaperEditionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
