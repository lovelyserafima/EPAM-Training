package com.epam.training.task2.model.entity.composite;

/**
 * Word is the class-entity which has content and firstConsonantLetter in content.
 *
 * 5 August 2018
 * @author Arthur Lyup
 */

public class Word extends Leaf implements Comparable<Word> {
    //first consonant letter in word
    private char firstConsonantLetter;

    //string of vowels
    private static final String vowels = "eyuioaEYUIOA";

    //the empty constructor
    public Word(){
        super();
    }

    //constructor with arg
    public Word(String content){
        super(content);
        firstConsonantLetter = searchFirstConsonantLetter(content);
    }

    //searching first consonant letter in word
    private char searchFirstConsonantLetter(String word){
        int length = word.length();
        for (int i = 0; i < length; i++){
            if (!vowels.contains(Character.toString(word.charAt(i)))){
                return word.charAt(i);
            }
        }
        return '\u0000';
    }

    //constructor with all args
    public Word(String content, char firstConsonantLetter) {
        super(content);
        this.firstConsonantLetter = firstConsonantLetter;
    }

    //getters and setters
    public char getFirstConsonantLetter() {
        return firstConsonantLetter;
    }

    public void setFirstConsonantLetter(char firstConsonantLetter) {
        this.firstConsonantLetter = firstConsonantLetter;
    }

    @Override
    public int compareTo(Word o) {
        return firstConsonantLetter < o.firstConsonantLetter ? -1 : 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null){ return false;}
        if (getClass() != o.getClass()){ return false;}

        Word word = (Word) o;
        if (!super.equals(word)){ return false;}
        if (firstConsonantLetter != word.firstConsonantLetter){ return false;}
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result += prime*firstConsonantLetter;
        return result;
    }

    @Override
    public String toString() {
        return content;
    }
}
