package sample;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class XMLParserSAX {
    public static void main(String[] args) {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        try {
            SAXParser saxParser=factory.newSAXParser();
            MyHandler handler=new MyHandler();
            saxParser.parse(Controller.xmlData,handler);
            List<Country> countries=handler.getCountries();
            for (Country country : countries)
                System.out.println(country);
        } catch (ParserConfigurationException |SAXException|IOException e) {
            e.printStackTrace();
        }

    }
}
