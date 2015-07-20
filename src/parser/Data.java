package parser;

import service.impl.Temperature;
import service.impl.Time;
import inhabitant.Inhabitant;

public class Data {               //хранение всех полученных и XML-файла данных
    private static Inhabitant inhabitant = new Inhabitant();
    private static Time time = new Time();
    private static Temperature temperature = new Temperature();

    public Time getTime() {
        return time;
    }

    public Inhabitant getInhabitant() {
        return inhabitant;
    }

    public Temperature getTemperature() {
        return temperature;
    }
}
