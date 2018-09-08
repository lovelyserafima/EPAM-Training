package com.epam.training.task2.logic.common.parse;

/**
 * Parser is the interface for parsing text. Using pattern - chain of responsibility.
 *
 * 5 August 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Composite;

public interface Parser {
    void setNext(Parser parser);
    Composite parse(String content) throws ParseTextException;
}
