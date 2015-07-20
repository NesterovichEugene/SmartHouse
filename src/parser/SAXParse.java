package parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParse extends DefaultHandler {
    static Data data = new Data();
    String thisElement;

    public static Data getResult() {
        return data;
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("inhabitant")) {
            data.getInhabitant().setInHouse(new Boolean(new String(ch, start, length)));
        }
        if (thisElement.equals("hours")) {
            data.getTime().setHours(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("minutes")) {
            data.getTime().setMinutes(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("minTemperature")) {
            data.getTemperature().setMinTemperature(new Integer(new String(ch, start, length)));
            data.getTemperature().setTemperature(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("maxTemperature")) {
            data.getTemperature().setMaxTemperature(new Integer(new String(ch, start, length)));
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void endDocument() throws SAXException {
    }
}
