package Lesson1;

public class Athlete {
    private String name;
    private int canDoIt;

    public Athlete(String name, int canDoIt) {
        this.name = name;
        this.canDoIt = canDoIt;
    }

    public String getName() {
        return name;
    }

    public int getCanDoIt() {
        return canDoIt;
    }
}
