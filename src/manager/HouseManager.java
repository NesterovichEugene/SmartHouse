package manager;

import controler.Clock;
import controler.Conditioner;
import controler.Heat;
import controler.Lightning;
import service.impl.LightServiceImpl;
import service.impl.TemperatureServiceImpl;
import service.impl.TimeServiceImpl;
import inhabitant.Inhabitant;
import inhabitant.InhabitantLife;
import parser.Data;
import parser.SAXParse;

public class HouseManager implements Runnable {   //запускает все потоки
    private Data data = SAXParse.getResult();
    private TimeServiceImpl currentTime = data.getTime();
    private Inhabitant inhabitant = data.getInhabitant();
    private TemperatureServiceImpl temperature = data.getTemperature();
    private LightServiceImpl light = new LightServiceImpl();

    private static Clock time;
    private static InhabitantLife life;
    private static Heat heat;
    private static Conditioner conditioner;
    private static Lightning lightning;
    private static Messenger messenger;

    @Override
    public void run() {
        time = new Clock(currentTime); //запуск хода времени

        life = new InhabitantLife(inhabitant);  //запуск потока прихода\ухода жителя из дома

        heat = new Heat(temperature); //запуск работы отопления

        conditioner = new Conditioner(temperature); //запуск кондиционера

        lightning = new Lightning(light);//запуск автоматического включения\выключения света

        messenger = new Messenger();//запуск вывода инфы о состоянии дома на экран
    }

    /**
     * getters
     */

    public static Clock getTime() {
        return time;
    }

    public static InhabitantLife getLife() {
        return life;
    }

    public static Heat getHeat() {
        return heat;
    }

    public static Conditioner getConditioner() {
        return conditioner;
    }

    public static Lightning getLightning() {
        return lightning;
    }

}
