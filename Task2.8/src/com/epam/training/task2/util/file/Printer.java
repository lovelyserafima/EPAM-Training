package com.epam.training.task2.util.file;

/**
 * Printer is the class-printer of information to files.
 *
 * 5 August 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.model.entity.composite.Component;
import com.epam.training.task2.model.entity.composite.Word;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Printer {
    public static void writeToFile(Component resultOfParsing, String fileName){
        try(FileWriter fileWriter = new FileWriter(fileName, false)) {
            fileWriter.write(resultOfParsing.print());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(List<Word> words, String fileName){
        try(FileWriter fileWriter = new FileWriter(fileName, false)) {
            fileWriter.write(words.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
