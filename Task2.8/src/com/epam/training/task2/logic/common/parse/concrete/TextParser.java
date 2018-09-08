package com.epam.training.task2.logic.common.parse.concrete;

/**
 * TextParser is the class-parser which parse text to listings and paragraphs.
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

public class TextParser extends BaseParser {
    //regular expressions
    private static final String PARSE_TO_PARAGRAPHS_AND_LISTINGS = "([^(\\s{4}\\/\\*.+\\*\\/(?:(?:\\n.+)" +
            "|(\\n\\s{4}\\}))+)])(\\s*(.+))|(\\s{4}\\/\\*.+\\*\\/(?:(?:\\n.+)|(\\n\\s{4}\\}))+)";
    private static final String RECOGNIZE_LISTING = "(\\s{4}\\/\\*.+\\*\\/(?:(?:\\n.+)|(\\n\\s{4}\\}))+)";

    @Override
    public Composite parse(String fileText) throws ParseTextException {
        if (fileText.isEmpty()){
            throw new ParseTextException("Content is empty! Nothing to parse");
        }
        Pattern pattern = Pattern.compile(PARSE_TO_PARAGRAPHS_AND_LISTINGS);
        Matcher matcher = pattern.matcher(fileText);
        Composite wholeText = new Composite();
        LOG.info("Parsing text into paragraphs and listings...");
        while (matcher.find()) {
            String plotOfText = matcher.group();
            if (Pattern.matches(RECOGNIZE_LISTING, plotOfText)) {
                wholeText.addComponent(new Leaf("Listing:\n" + plotOfText + "\n\n"));
            } else {
                wholeText.addComponent(new Leaf("Paragraph:" + plotOfText + "\n"));
                wholeText.addComponent(next.parse(plotOfText));
            }
        }
        return wholeText;
    }
}
