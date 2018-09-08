package com.epam.training.task2.controller;

/**
 * Starter is the class-tester of business-logic.
 *
 * 5 August 2018
 * @version 1.2
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.exception.RestoreFileException;
import com.epam.training.task2.logic.individual.Sorter;
import com.epam.training.task2.logic.individual.WordParser;
import com.epam.training.task2.model.entity.composite.Component;
import com.epam.training.task2.logic.common.parse.Parser;
import com.epam.training.task2.logic.common.parse.concrete.ParagraphParser;
import com.epam.training.task2.logic.common.parse.concrete.SentenceParser;
import com.epam.training.task2.logic.common.parse.concrete.TextParser;
import com.epam.training.task2.logic.common.parse.concrete.WordAndSignParser;
import com.epam.training.task2.logic.common.restore.FileRestorer;
import com.epam.training.task2.model.entity.composite.Word;
import com.epam.training.task2.util.file.Printer;
import com.epam.training.task2.util.file.Reader;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.List;

public class Starter {
    //log information
    private static Logger LOG = Logger.getLogger(Starter.class);

    public static void main(String[] args) {
        //common part of task
        //path of input file
        String inputFilePath = "resources/Programming text.txt";

        LOG.info("Started reading file \"" + inputFilePath + "\"...");
        try {
            String inputFileTextToParse = Reader.readFile(inputFilePath);

            LOG.info("The file was read successfully. Printing it to console:\n" + inputFileTextToParse);

            String outputFilePathOfResultOfParsing = "resources/parsing and restoring/Result of parsing.txt";
            LOG.info("Started parsing file text and printing results to \"" + outputFilePathOfResultOfParsing + "\"");

            //initialization of parsers. Chain of responsibility
            Parser textParser = new TextParser();
            Parser paragraphParser = new ParagraphParser();
            Parser sentenceParser = new SentenceParser();
            Parser wordAndSignParser = new WordAndSignParser();
            textParser.setNext(paragraphParser);
            paragraphParser.setNext(sentenceParser);
            sentenceParser.setNext(wordAndSignParser);
            Component resultOfParsing = textParser.parse(inputFileTextToParse);

            LOG.info("Parsing file was done successfully...");
            LOG.info("Printing result of parsing to file \"" + outputFilePathOfResultOfParsing  + "\"...");
            Printer.writeToFile(resultOfParsing, outputFilePathOfResultOfParsing);
            LOG.info("Result of parsing was written successfully...");

            LOG.info("Restoring file by using parsed file...");
            String restoredFilePath = "resources/parsing and restoring/Restored programming text.txt";
            Component restoredFile = FileRestorer.restoreFile(outputFilePathOfResultOfParsing );
            Printer.writeToFile(restoredFile, restoredFilePath);
            LOG.info("File was restored successfully...");

            //8 variant of individual task (sorting)
            LOG.info("Searching words with first vowel letter...");
            List<Word> wordsWithFirstVowelLetter = WordParser.parse(inputFileTextToParse);
            LOG.info("Searching words was completed successfully. Printing them to console:");
            LOG.info(wordsWithFirstVowelLetter);

            LOG.info("Sorting words by first consonant letter...");
            Sorter.sortWordsWithFirstVowelLetterByFirstConsonantLetter(wordsWithFirstVowelLetter);
            String resultOfSorting = "resources/sorting/Result of sorting.txt";
            LOG.info("Sorting was completed successfully and printing result to file \"" + resultOfSorting + "\"...");
            Printer.writeToFile(wordsWithFirstVowelLetter, resultOfSorting);
            LOG.info("Result of sorting was written successully...");
        } catch (IOException | RestoreFileException | ParseTextException e) {
            LOG.info(e.getMessage());
            LOG.error(e.getMessage(), e);
        } finally {
            LOG.info("The application stopped! Thank you for working with us:)");
        }
    }
}