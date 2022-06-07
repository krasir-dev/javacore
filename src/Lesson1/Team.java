package Lesson1;

public class Team {
    private String name;
    private Athlete[] peoples;

    public Team(String name, Athlete[] peoples) {
        this.name = name;
        this.peoples = peoples;
    }

    public String getName() {
        return name;
    }

    public Athlete[] getPeoples() {
        return peoples;
    }
    public void showResults (String result){
        System.out.println(result);
    }
}
