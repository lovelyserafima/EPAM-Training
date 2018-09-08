package com.epam.training.task2.logic.common.parse.concrete;

/**
 * WordAndSignParser is the class-parser of words and signs to symbols.
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

public class WordAndSignParser extends BaseParser {
    private static final String PARSE_TO_SYMBOLS = ".{1}";

    @Override
    public Composite parse(String wordWithSigns) throws ParseTextException {
        if (wordWithSigns.isEmpty()){
            throw new ParseTextException("Content is empty! Nothing to parse");
        }
        Pattern pattern = Pattern.compile(PARSE_TO_SYMBOLS);
        Matcher matcher = pattern.matcher(wordWithSigns);
        Composite symbols = new Composite();
        LOG.info("Parsing word into symbols...");
        while (matcher.find()){
            String symbol = matcher.group().trim();
            if (!symbol.isEmpty()) {
                symbols.addComponent(new Leaf(symbol + " "));
            }
        }
        return symbols;
    }
}

