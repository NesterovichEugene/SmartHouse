package controler;

import service.impl.Time;

public class Clock extends Thread {
    Time time;

    public Clock(Time time) {
        this.time = time;
        this.start();
    }

    @Override
    public void run() {      //ход часов
        try {
            while (true) {
                time.increase();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return time.toString();
    }
}
