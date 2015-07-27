package manager;


/**
 * Created by Евгений on 20.07.2015.
 */
public class MessageManager extends Thread {

    public MessageManager() {
        this.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(HouseManager.getTime().toString());
                System.out.println(HouseManager.getLife().toString());
                System.out.println(HouseManager.getLightning().toString());
                if (HouseManager.getConditioner().isIsOn()) {
                    System.out.println(HouseManager.getConditioner().toString());
                } else {
                    System.out.println(HouseManager.getHeat().toString());
                }
                System.out.println("");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
