package inhabitant;

import parser.Data;

public class InhabitantLife extends Thread {
    private int randomArrive;
    private Inhabitant inhabitant;

    public InhabitantLife(Inhabitant inhabitant) {
        this.inhabitant = inhabitant;
        this.start();
    }

    @Override
    public void run() {              //житель случайным образом приходит и уходит из дома
        Data data = new Data();
        try {
            while (true) {
                randomArrive = (int) (Math.random() * 2);
                if (randomArrive == 1) {
                    inhabitant.comeIn();
                    //System.out.println(inhabitant.toString());
                } else {
                    inhabitant.comeOut();
                    //System.out.println(inhabitant.toString());
                }
                Thread.sleep(3000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return inhabitant.toString();
    }

    public Inhabitant getInhabitant() {
        return inhabitant;
    }
}
