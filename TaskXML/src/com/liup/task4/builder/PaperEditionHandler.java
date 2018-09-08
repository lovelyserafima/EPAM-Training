package com.liup.task4.builder;

import com.liup.task4.entity.Booklet;
import com.liup.task4.entity.Magazine;
import com.liup.task4.entity.Newspaper;
import com.liup.task4.entity.PaperEdition;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

public class PaperEditionHandler extends DefaultHandler {
    private Set<PaperEdition> paperEditionSet;
    private PaperEdition currentPaper;
    private PaperEditionEnum currentEnum;
    private EnumSet<PaperEditionEnum> withText;

    public PaperEditionHandler() {
        paperEditionSet = new LinkedHashSet<>();
        withText = EnumSet.range(PaperEditionEnum.TITLE, PaperEditionEnum.SUBSCRIPTION_INDEX);
    }

    public Set<PaperEdition> getPapers() {
        return Collections.unmodifiableSet(paperEditionSet);
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        switch (PaperEditionEnum.valueOf(localName.toUpperCase().replace('-', '_'))) {
            case NEWSPAPER:
                currentPaper = new Newspaper();
                defineAllAttribute(attrs);
                break;
            case MAGAZINE:
                currentPaper = new Magazine();
                defineAllAttribute(attrs);
                break;
            case BOOKLET:
                currentPaper = new Booklet();
                defineAllAttribute(attrs);
                break;
            default:
                PaperEditionEnum temp = PaperEditionEnum.valueOf(localName.toUpperCase().replace('-',
                        '_'));
                if (withText.contains(temp)) {
                    currentEnum = temp;
                }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (PaperEditionEnum.NEWSPAPER.getValue().equalsIgnoreCase(localName)
                || PaperEditionEnum.MAGAZINE.getValue().equalsIgnoreCase(localName)
                || PaperEditionEnum.BOOKLET.getValue().equalsIgnoreCase(localName)) {
            paperEditionSet.add(currentPaper);
        }
    }
    private void defineAllAttribute (Attributes attrs){
        for (int i = 0; i < attrs.getLength(); i++) {

            switch (PaperEditionEnum.valueOf(attrs.getLocalName(i).toUpperCase())) {
                case ID:
                    currentPaper.setId(attrs.getValue(i));
                    break;
                case CATEGORY:
                    currentPaper.setCategory(attrs.getValue(i));
                    break;
            }
        }
    }
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case TITLE:
                    currentPaper.setTitle(s);
                    break;
                case MONTHLY:
                    currentPaper.setMonthly(Boolean.valueOf(s));
                    break;
                case COLOR:
                    if (currentPaper instanceof Newspaper) {
                        ((Newspaper) currentPaper).getNewsCharacter().setColor(Boolean.valueOf(s));
                    } else if (currentPaper instanceof Magazine) {
                        ((Magazine) currentPaper).getMagazineCharacter().setColor(Boolean.valueOf(s));
                    } else if (currentPaper instanceof Booklet) {
                        ((Booklet) currentPaper).getBookletCharacter().setColor(Boolean.valueOf(s));
                    }
                    break;
                case VOLUME:
                    if (currentPaper instanceof Newspaper) {
                        ((Newspaper) currentPaper).getNewsCharacter().setVolume(Integer.parseInt(s));
                    } else if (currentPaper instanceof Magazine) {
                        ((Magazine) currentPaper).getMagazineCharacter().setVolume(Integer.parseInt(s));
                    } else if (currentPaper instanceof Booklet) {
                        ((Booklet) currentPaper).getBookletCharacter().setVolume(Integer.parseInt(s));
                    }
                    break;
                case SUBSCRIPTION_INDEX:
                    if (currentPaper instanceof Newspaper) {
                        ((Newspaper) currentPaper).getNewsCharacter().setSubscriptionIndex(Integer.parseInt(s));
                    } else if (currentPaper instanceof Magazine) {
                        ((Magazine) currentPaper).getMagazineCharacter().setSubscriptionIndex(Integer.parseInt(s));
                    }
                    break;
                case GLOSSINESS:
                    if (currentPaper instanceof Magazine) {
                        ((Magazine) currentPaper).getMagazineCharacter().setGlossiness(Boolean.valueOf(s));
                    } else if (currentPaper instanceof Booklet) {
                        ((Booklet) currentPaper).getBookletCharacter().setGlossiness(Boolean.valueOf(s));
                    }
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
