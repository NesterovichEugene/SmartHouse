package inhabitant;

public class Inhabitant {
    private boolean inHouse;

    public void comeIn() { //метод входа жителя в дом
        this.inHouse = true;
    }

    public void comeOut() { //метод выхода жильца из дома
        this.inHouse = false;
    }

    @Override
    public String toString() {
        if (inHouse == true) {
            return "Житель дома";
        } else {
            return "Житель не дома";
        }
    }

    public boolean isInHouse() {
        return inHouse;
    }

    public void setInHouse(boolean inHouse) {
        this.inHouse = inHouse;
    }
}
