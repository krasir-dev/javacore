package Lesson1;

public class Course {
    String result;
    private int num;


    public Course(int num) {
        this.num = num;

    }

    public String doIt(Team team){
        result = "Команда: "+ team.getName()+ " " + '\n';
        for(Athlete person: team.getPeoples()){
            result += "имя спортсмена: " + person.getName()+ " " + '\n';
            int value = person.getCanDoIt();
            testJump(value);
            //testRun(value);
            //testSwim(value);

        }

        return result;
    }

    private void testJump(int value){
        if(value>=num) result += "Препятствие преодолено "+ '\n';

    }



}
