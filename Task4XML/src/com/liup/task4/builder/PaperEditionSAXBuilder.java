package com.liup.task4.builder;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;

public class PaperEditionSAXBuilder extends AbstractPaperBuilder{
    private static final Logger LOGGER = LogManager.getLogger();
    private PaperEditionHandler paperEditionHandler;
    private XMLReader reader;
    public PaperEditionSAXBuilder() {
        super();
        paperEditionHandler = new PaperEditionHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(paperEditionHandler);
            LOGGER.log(Level.INFO, paperEditions);
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildSetPaperEdition(String fileName) {
        LOGGER.log(Level.DEBUG, "Start parsing...");
        try {
            paperEditions.clear();
            reader.parse(fileName);
        } catch (IOException | org.xml.sax.SAXException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
        }
        paperEditions = paperEditionHandler.getPapers();
        LOGGER.log(Level.INFO, "Successful parsing...");
        LOGGER.log(Level.INFO, paperEditions);
    }

}
