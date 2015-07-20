package service.impl;

import service.DecreasebleService;
import service.IncreasebleService;

/**
 * Created by Евгений on 20.07.2015.
 */
public class TemperatureServiceImpl implements IncreasebleService, DecreasebleService {
    private Integer temperature;
    private Integer minTemperature;
    private Integer maxTemperature;

    @Override
    public void increase() {
        this.temperature += 2;
    }

    @Override
    public void decrease() {
        this.temperature -= 2;
    }

    @Override
    public String toString() {
        return "Температура в доме " + temperature + "C";
    }

    /**
     * getters/setters
     */

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Integer maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Integer getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Integer minTemperature) {
        this.minTemperature = minTemperature;
    }
}
