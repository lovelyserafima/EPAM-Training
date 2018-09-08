package com.epam.training.task2.logic.common.parse.concrete;

/**
 * ParagraphParser is the class-parser of paragraphs to sentences.
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

public class ParagraphParser extends BaseParser {
    private static final String PARSE_TO_SENTENCES = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";

    @Override
    public Composite parse(String paragraph) throws ParseTextException {
        if (paragraph.isEmpty()){
            throw new ParseTextException("Content is empty! Nothing to parse");
        }
        Pattern pattern = Pattern.compile(PARSE_TO_SENTENCES);
        Matcher matcher = pattern.matcher(paragraph);
        Composite sentences = new Composite();
        LOG.info("Parsing paragraph into sentences...");
        while (matcher.find()) {
            String sentence = matcher.group().trim();
            sentences.addComponent(new Leaf("Sentence:" + sentence + "\n"));
            sentences.addComponent(next.parse(sentence));
        }
        return sentences;
    }
}

