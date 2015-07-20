package controler;

import service.impl.Temperature;
import service.Switchable;

public class Heat extends Thread implements Switchable {
    Temperature temperature;
    static boolean isOn = false;

    public Heat(Temperature temperature) {
        this.temperature = temperature;
        this.start();
    }

    @Override
    public boolean turnOn() { //включение обогрева
        return isOn = true;
    } //включение обогрева

    @Override
    public boolean turnOff() { //выключение обогрева
        return isOn = false;
    } //

    @Override
    public void run() {      //работа обогрева
        try {
            while (true) {
                if (temperature.getTemperature() < temperature.getMaxTemperature() && !Conditioner.isOn) {
                    temperature.increase();
                    turnOn();
                    //System.out.println("Включено отопление. " + temperature.toString());
                } else {
                    turnOff();
                }
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Включено отопление. " + temperature.toString();
    }
}