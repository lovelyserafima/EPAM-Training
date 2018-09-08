package com.epam.training.task2.logic.individual;

/**
 * Sorter is the class-sorter which sorts list of words with first vowel letter by first consonant letter.
 *
 * 5 August 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.model.entity.composite.Word;
import java.util.Collections;
import java.util.List;

public class Sorter {
    public static void sortWordsWithFirstVowelLetterByFirstConsonantLetter(List<Word> words){
        Collections.sort(words);
    }
}
