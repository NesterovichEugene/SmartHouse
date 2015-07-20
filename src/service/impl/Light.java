package service.impl;

import service.Switchable;

/**
 * Created by Евгений on 20.07.2015.
 */
public class Light implements Switchable {
    private boolean light = false;

    @Override
    public boolean turnOn() {  //включение света
        this.light = true;
        return true;
    }

    @Override
    public boolean turnOff() { //выключение света
        this.light = false;
        return false;
    }

    @Override
    public String toString() {
        if (light == true) {
            return "Свет включен";
        } else {
            return "Свет выключен";
        }
    }

    /**
     * getters/setters
     */

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }
}
