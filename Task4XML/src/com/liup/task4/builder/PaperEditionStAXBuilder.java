package com.liup.task4.builder;

import com.liup.task4.entity.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PaperEditionStAXBuilder extends AbstractPaperBuilder{
    private static final Logger LOGGER = LogManager.getLogger();
    private XMLInputFactory inputFactory;

    public PaperEditionStAXBuilder() {
        super();
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetPaperEdition(String fileName) {
        LOGGER.log(Level.DEBUG, "Start parsing...");
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    switch (PaperEditionEnum.valueOf(name.replace("-","_").toUpperCase())){
                        case NEWSPAPER:
                            Newspaper newspaper = buildNewspaper(reader);
                            paperEditions.add(newspaper);
                            break;
                        case MAGAZINE:
                            Magazine magazine = buildMagazine(reader);
                            paperEditions.add(magazine);
                            break;
                        case BOOKLET:
                            Booklet booklet = buildBooklet(reader);
                            paperEditions.add(booklet);
                            break;
                    }
                }
            }
            LOGGER.log(Level.INFO, "Successful parsing...");
            LOGGER.log(Level.INFO, paperEditions);
        } catch (XMLStreamException | FileNotFoundException ex) {
            LOGGER.log(Level.ERROR, ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.log(Level.ERROR, e.getMessage());
            }
        }
    }


    private Magazine buildMagazine(XMLStreamReader reader) throws XMLStreamException {
        Magazine magazine = new Magazine();

        magazine.setId(reader.getAttributeValue(null, PaperEditionEnum.ID.getValue()));
        magazine.setCategory(reader.getAttributeValue(null, PaperEditionEnum.CATEGORY.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PaperEditionEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
                        case TITLE:
                            magazine.setTitle(getXMLText(reader));
                            break;
                        case MONTHLY:
                            magazine.setMonthly(Boolean.valueOf(getXMLText(reader)));
                            break;
                        case MAGAZINE_CHARS:
                            magazine.setMagazineCharacter(getMagazineChars(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PaperEditionEnum.valueOf(name.replace("-","_").toUpperCase())
                            == PaperEditionEnum.MAGAZINE) {
                        return magazine;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag OlsCard");
    }

    private Newspaper buildNewspaper(XMLStreamReader reader) throws XMLStreamException {
        Newspaper newspaper = new Newspaper();

        newspaper.setId(reader.getAttributeValue(null, PaperEditionEnum.ID.getValue()));
        newspaper.setCategory(reader.getAttributeValue(null, PaperEditionEnum.CATEGORY.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PaperEditionEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
                        case TITLE:
                            newspaper.setTitle(getXMLText(reader));
                            break;
                        case MONTHLY:
                            newspaper.setMonthly(Boolean.valueOf(getXMLText(reader)));
                            break;
                        case NEWS_CHARS:
                            newspaper.setNewsCharacter(getNewChars(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PaperEditionEnum.valueOf(name.replace("-","_").toUpperCase())
                            == PaperEditionEnum.NEWSPAPER) {
                        return newspaper;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag OlsCard");
    }

    private Booklet buildBooklet(XMLStreamReader reader) throws XMLStreamException {
        Booklet booklet= new Booklet();

        booklet.setId(reader.getAttributeValue(null, PaperEditionEnum.ID.getValue()));
        booklet.setCategory(reader.getAttributeValue(null, PaperEditionEnum.CATEGORY.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PaperEditionEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
                        case TITLE:
                            booklet.setTitle(getXMLText(reader));
                            break;
                        case MONTHLY:
                            booklet.setMonthly(Boolean.valueOf(getXMLText(reader)));
                            break;
                        case BOOKLET_CHARS:
                            booklet.setBookletCharacter(getBookletChars(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PaperEditionEnum.valueOf(name.replace("-","_").toUpperCase())
                            == PaperEditionEnum.BOOKLET) {
                        return booklet;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag OlsCard");
    }

    private NewsCharacter getNewChars(XMLStreamReader reader) throws XMLStreamException {
        NewsCharacter newsCharacter = new NewsCharacter();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants. START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PaperEditionEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
                        case COLOR:
                            newsCharacter.setColor(Boolean.valueOf(getXMLText(reader)));
                            break;
                        case VOLUME:
                            newsCharacter.setVolume(Integer.parseInt(getXMLText(reader)));
                            break;
                        case SUBSCRIPTION_INDEX:
                            newsCharacter.setSubscriptionIndex(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PaperEditionEnum.valueOf(name.toUpperCase().replace('-', '_'))
                            == PaperEditionEnum.NEWS_CHARS){
                        return newsCharacter;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private BookletCharacter getBookletChars(XMLStreamReader reader) throws XMLStreamException {
        BookletCharacter bookletCharacter = new BookletCharacter();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PaperEditionEnum.valueOf(name.toUpperCase())) {
                        case COLOR:
                            bookletCharacter.setColor(Boolean.valueOf(getXMLText(reader)));
                            break;
                        case VOLUME:
                            bookletCharacter.setVolume(Integer.parseInt(getXMLText(reader)));
                            break;
                        case GLOSSINESS:
                            bookletCharacter.setGlossiness(Boolean.valueOf(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PaperEditionEnum.valueOf(name.toUpperCase().replace('-', '_'))
                            == PaperEditionEnum.BOOKLET_CHARS){
                        return bookletCharacter;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private MagazineCharacter getMagazineChars(XMLStreamReader reader) throws XMLStreamException {
        MagazineCharacter magazineCharacter = new MagazineCharacter();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants. START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PaperEditionEnum.valueOf(name.toUpperCase().replace('-','_'))) {
                        case COLOR:
                            magazineCharacter.setColor(Boolean.valueOf(getXMLText(reader)));
                            break;
                        case VOLUME:
                            magazineCharacter.setVolume(Integer.parseInt(getXMLText(reader)));
                            break;
                        case GLOSSINESS:
                            magazineCharacter.setGlossiness(Boolean.valueOf(getXMLText(reader)));
                            break;
                        case SUBSCRIPTION_INDEX:
                            magazineCharacter.setSubscriptionIndex(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PaperEditionEnum.valueOf(name.toUpperCase().replace('-', '_'))
                            == PaperEditionEnum.MAGAZINE_CHARS){
                        return magazineCharacter;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}


