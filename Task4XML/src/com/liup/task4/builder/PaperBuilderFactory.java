package com.liup.task4.builder;

public class PaperBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }
    public AbstractPaperBuilder createStudentBuilder(String typeParser) {
        TypeParser type = TypeParser. valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new PaperEditionDOMBuilder();
            case STAX:
                return new PaperEditionStAXBuilder();
            case SAX:
                return new PaperEditionSAXBuilder();
            default:
                throw new RuntimeException();
        }
    }
}
