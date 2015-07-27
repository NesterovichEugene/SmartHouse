package manager;

import controler.ClockControler;
import controler.ConditionerControler;
import controler.HeatControler;
import controler.LightningControler;
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

    private static ClockControler time;
    private static InhabitantLife life;
    private static HeatControler heat;
    private static ConditionerControler conditioner;
    private static LightningControler lightning;
    private static MessageManager messenger;

    @Override
    public void run() {
        time = new ClockControler(currentTime); //запуск хода времени

        life = new InhabitantLife(inhabitant);  //запуск потока прихода\ухода жителя из дома

        heat = new HeatControler(temperature); //запуск работы отопления

        conditioner = new ConditionerControler(temperature); //запуск кондиционера

        lightning = new LightningControler(light);//запуск автоматического включения\выключения света

        messenger = new MessageManager();//запуск вывода инфы о состоянии дома на экран
    }

    /**
     * getters
     */

    public static ClockControler getTime() {
        return time;
    }

    public static InhabitantLife getLife() {
        return life;
    }

    public static HeatControler getHeat() {
        return heat;
    }

    public static ConditionerControler getConditioner() {
        return conditioner;
    }

    public static LightningControler getLightning() {
        return lightning;
    }

}
