import manager.HouseManager;
import parser.SAXParse;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXParse saxp = new SAXParse();

            parser.parse(new File("D:\\Intexsoft\\SmartHouse\\Config.xml"), saxp); //парсинг XML-файла с начальными конфигурациями

            HouseManager manager = new HouseManager(); //"оживление" дома
            manager.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
