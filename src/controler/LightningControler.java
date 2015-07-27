package controler;

import service.impl.LightServiceImpl;
import manager.HouseManager;

/**
 * Created by Евгений on 20.07.2015.
 */
public class LightningControler extends Thread {
    LightServiceImpl light;


    public LightningControler(LightServiceImpl light) {
        this.light = light;
        this.start();
    }

    @Override
    public void run() {      //работа света
        try {
            while (true) {
                if ((HouseManager.getTime().time.getHours() < 18 && HouseManager.getTime().time.getHours() > 9) || !HouseManager.getLife().getInhabitant().isInHouse()) {
                    light.turnOff();
                    //System.out.println(light.toString());
                } else {
                    light.turnOn();
                    //System.out.println(light.toString());
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return light.toString();
    }
}
