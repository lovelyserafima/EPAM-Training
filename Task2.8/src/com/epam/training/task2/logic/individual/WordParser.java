package com.epam.training.task2.logic.individual;

/**
 * WordParser is the class-parser of whole text to words.
 *
 * 5 August 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Word;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {
    private static final String PARSE_TO_WORDS = "\\W[eyuioaEYUIOA](\\w+|'|\\s)";

    public static List<Word> parse(String content) throws ParseTextException {
        if (content.isEmpty()){
            throw new ParseTextException("Error! Content is empty! Nothing to parse");
        }
        Pattern pattern = Pattern.compile(PARSE_TO_WORDS);
        Matcher matcher = pattern.matcher(content);
        List<Word> words = new ArrayList<>();
        while (matcher.find()){
            words.add(new Word(matcher.group().trim()));
        }
        return words;
    }
}
