package com.epam.training.task2.logic.common.restore;

/**
 * FileRestorer is the class-restorer of original file by file wth parsed lexemes.
 *
 * 5 August 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.exception.RestoreFileException;
import com.epam.training.task2.model.entity.composite.Composite;
import com.epam.training.task2.model.entity.composite.Leaf;
import com.epam.training.task2.util.file.Reader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRestorer {
    private static final String RECOGNIZE_PARAGRAPHS_AND_LISTINGS = "(Paragraph:.+)" +
            "|(Listing:\\n\\s{4}\\/\\*.+\\*\\/(?:(?:\\n.+)|(\\n\\s{4}\\}))+)";
    private static final String RECOGNIZE_PARAGRAPH = "(Paragraph:.+)";
    private static final int BEGIN_SUBSTRING_FOR_PARAGRAPHS = 10;
    private static final int BEGIN_SUBSTRING_FOR_LISTINGS = 8;

    public static Composite restoreFile(String parsedFile) throws IOException, RestoreFileException {
        Composite restoredFile = new Composite();
        try {
            String contentOfParsedFile = Reader.readFile(parsedFile);
            if (contentOfParsedFile.isEmpty()){
                throw new RestoreFileException("The content of parsed file is empty");
            }
            Pattern pattern = Pattern.compile(RECOGNIZE_PARAGRAPHS_AND_LISTINGS);
            Matcher matcher = pattern.matcher(contentOfParsedFile);
            while (matcher.find()){
                String plotOfText = matcher.group();
                if (Pattern.matches(RECOGNIZE_PARAGRAPH, plotOfText)){
                    plotOfText = plotOfText.substring(BEGIN_SUBSTRING_FOR_PARAGRAPHS);
                    restoredFile.addComponent(new Leaf("    " + plotOfText + "\n"));
                } else {
                    plotOfText = plotOfText.substring(BEGIN_SUBSTRING_FOR_LISTINGS);
                    restoredFile.addComponent(new Leaf("    " + plotOfText + "\n\n"));
                }
            }
        } catch (IOException e) {
            throw new IOException("Error! Problem with file");
        }
        return restoredFile;
    }
}
