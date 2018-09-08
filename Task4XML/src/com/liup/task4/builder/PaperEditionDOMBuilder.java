package com.liup.task4.builder;

import com.liup.task4.entity.Booklet;
import com.liup.task4.entity.Magazine;
import com.liup.task4.entity.Newspaper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PaperEditionDOMBuilder extends AbstractPaperBuilder{
    private static final Logger LOGGER = LogManager.getLogger();
    private DocumentBuilder docBuilder;

    public PaperEditionDOMBuilder() {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
        }
    }

    @Override
    public void buildSetPaperEdition(String fileName) {
        Document doc;
        LOGGER.log(Level.DEBUG, "Start parsing...");
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            paperEditions.clear();
            NodeList newspaperList = root.getElementsByTagName(PaperEditionEnum.NEWSPAPER.getValue());
            for (int i = 0; i < newspaperList.getLength(); i++) {
                Element element = (Element) newspaperList.item(i);
                Newspaper paperEdition = buildNewspaper(element);
                paperEditions.add(paperEdition);
            }
            NodeList magazineList = root.getElementsByTagName(PaperEditionEnum.MAGAZINE.getValue());
            for (int i = 0; i < magazineList.getLength(); i++) {
                Element element = (Element) magazineList.item(i);
                Magazine paperEdition = buildMagazine(element);
                paperEditions.add(paperEdition);
            }
            NodeList bookletList = root.getElementsByTagName(PaperEditionEnum.BOOKLET.getValue());
            for (int i = 0; i < bookletList.getLength(); i++) {
                Element element = (Element) bookletList.item(i);
                Booklet paperEdition = buildBooklet(element);
                paperEditions.add(paperEdition);
            }
            LOGGER.log(Level.INFO, "Successful parsing...");
            LOGGER.log(Level.INFO, paperEditions);
        } catch (IOException | SAXException e) {
           LOGGER.log(Level.ERROR, e.getMessage());
        }
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }

    private Newspaper buildNewspaper(Element newspaperElement) {
        Newspaper newspaper = new Newspaper();
        newspaper.setId(newspaperElement.getAttribute(PaperEditionEnum.ID.getValue()));
        newspaper.setCategory(newspaperElement.getAttribute(PaperEditionEnum.CATEGORY.getValue()));

        newspaper.setTitle(getElementTextContent(newspaperElement, PaperEditionEnum.TITLE.getValue()));
        newspaper.setMonthly(Boolean.valueOf(getElementTextContent(newspaperElement,
                PaperEditionEnum.MONTHLY.getValue())));
        newspaper.getNewsCharacter().setColor(Boolean.valueOf(getElementTextContent(newspaperElement,
                PaperEditionEnum.COLOR.getValue())));
        newspaper.getNewsCharacter().setVolume(Integer.parseInt(getElementTextContent(newspaperElement,
                PaperEditionEnum.VOLUME.getValue())));
        newspaper.getNewsCharacter().setSubscriptionIndex(Integer.parseInt(getElementTextContent(newspaperElement,
                PaperEditionEnum.SUBSCRIPTION_INDEX.getValue())));
        return newspaper;
    }

    private Magazine buildMagazine(Element magazineElement) {
        Magazine magazine = new Magazine();
        magazine.setId(magazineElement.getAttribute(PaperEditionEnum.ID.getValue()));
        magazine.setCategory(magazineElement.getAttribute(PaperEditionEnum.CATEGORY.getValue()));

        magazine.setTitle(getElementTextContent(magazineElement, PaperEditionEnum.TITLE.getValue()));
        magazine.setMonthly(Boolean.valueOf(getElementTextContent(magazineElement,
                PaperEditionEnum.MONTHLY.getValue())));
        magazine.getMagazineCharacter().setColor(Boolean.valueOf(getElementTextContent(magazineElement,
                PaperEditionEnum.COLOR.getValue())));
        magazine.getMagazineCharacter().setVolume(Integer.parseInt(getElementTextContent(magazineElement,
                PaperEditionEnum.VOLUME.getValue())));
        magazine.getMagazineCharacter().setSubscriptionIndex(Integer.parseInt(getElementTextContent(magazineElement,
                PaperEditionEnum.SUBSCRIPTION_INDEX.getValue())));
        magazine.getMagazineCharacter().setGlossiness(Boolean.valueOf(getElementTextContent(magazineElement,
                PaperEditionEnum.GLOSSINESS.getValue())));
        return magazine;
    }

    private Booklet buildBooklet(Element bookletElement) {
        Booklet booklet = new Booklet();
        booklet.setId(bookletElement.getAttribute(PaperEditionEnum.ID.getValue()));
        booklet.setCategory(bookletElement.getAttribute(PaperEditionEnum.CATEGORY.getValue()));

        booklet.setTitle(getElementTextContent(bookletElement, PaperEditionEnum.TITLE.getValue()));
        booklet.setMonthly(Boolean.valueOf(getElementTextContent(bookletElement,
                PaperEditionEnum.MONTHLY.getValue())));
        booklet.getBookletCharacter().setColor(Boolean.valueOf(getElementTextContent(bookletElement,
                PaperEditionEnum.COLOR.getValue())));
        booklet.getBookletCharacter().setVolume(Integer.parseInt(getElementTextContent(bookletElement,
                PaperEditionEnum.VOLUME.getValue())));
        booklet.getBookletCharacter().setGlossiness(Boolean.valueOf(getElementTextContent(bookletElement,
                PaperEditionEnum.GLOSSINESS.getValue())));
        return booklet;
    }
}
