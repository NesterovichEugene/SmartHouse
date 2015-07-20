package parser;

import service.impl.TemperatureServiceImpl;
import service.impl.TimeServiceImpl;
import inhabitant.Inhabitant;

public class Data {               //хранение всех полученных и XML-файла данных
    private static Inhabitant inhabitant = new Inhabitant();
    private static TimeServiceImpl time = new TimeServiceImpl();
    private static TemperatureServiceImpl temperature = new TemperatureServiceImpl();

    public TimeServiceImpl getTime() {
        return time;
    }

    public Inhabitant getInhabitant() {
        return inhabitant;
    }

    public TemperatureServiceImpl getTemperature() {
        return temperature;
    }
}
