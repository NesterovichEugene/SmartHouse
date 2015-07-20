package controler;

import service.impl.Temperature;
import service.Switchable;

/**
 * Created by Евгений on 20.07.2015.
 */
public class Conditioner extends Thread implements Switchable {
    Temperature temperature;
    static boolean isOn = false;

    public Conditioner(Temperature temperature) {
        this.temperature = temperature;
        this.start();
    }

    @Override
    public boolean turnOn() { //включение кондиционера
        return isOn = true;
    } //включение кондиционера

    @Override
    public boolean turnOff() { //выключение кондиционера
        return isOn = false;
    } //выключение кондиционера

    @Override
    public void run() {      //работа кондиционера
        try {
            while (true) {
                if (temperature.getTemperature() > temperature.getMinTemperature() && !Heat.isOn) {
                    temperature.decrease();
                    turnOn();
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
        return "Включен кондиционер. " + temperature.toString();
    }

    public boolean isIsOn() {
        return isOn;
    } //getter
}
