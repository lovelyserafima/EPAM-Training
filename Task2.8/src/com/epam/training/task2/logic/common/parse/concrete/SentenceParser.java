package com.epam.training.task2.logic.common.parse.concrete;

/**
 * SentenceParser is the class-parser of sentences to words and signs.
 *
 * 5 August 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Composite;
import com.epam.training.task2.model.entity.composite.Leaf;
import com.epam.training.task2.logic.common.parse.BaseParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends BaseParser {
    private static final String PARSE_TO_WORDS = "([^(\\s)]*)(\\s)*";

    @Override
    public Composite parse(String sentence) throws ParseTextException {
        if (sentence.isEmpty()){
            throw new ParseTextException("Content is empty! Nothing to parse");
        }
        Pattern pattern = Pattern.compile(PARSE_TO_WORDS);
        Matcher matcher = pattern.matcher(sentence.trim());
        Composite wordsWithSigns = new Composite();
        LOG.info("Parsing sentence into words...");
        while (matcher.find()){
            String wordWithSigns = matcher.group().trim();
            if (!wordWithSigns.isEmpty()) {
                wordsWithSigns.addComponent(new Leaf("Word:" + wordWithSigns + "\nSymbols:"));
                wordsWithSigns.addComponent(next.parse(wordWithSigns));
                wordsWithSigns.addComponent(new Leaf("\n"));
            }
        }
        return wordsWithSigns;
    }
}
