package Lesson1;

public class Main {
    public static void main(String[] args) {
        Course c = new Course(20);
        Athlete[] athlete = new Athlete[4];
        athlete[0]=new Athlete("Mari",20);
        athlete[1]=new Athlete("Alex",5);
        athlete[2]=new Athlete("Olga",50);
        athlete[3]=new Athlete("Denis",9);

        Team team = new Team("Spartak", athlete);
        String result =c.doIt(team);
        team.showResults(result);

    }
}
