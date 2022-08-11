package Lesson9;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = getStudentList(10);
        //Задание 1
        System.out.println(studentList.stream().flatMap(student -> student.getCourses().stream()).distinct().collect(Collectors.toList()));
        //Задание 2
        System.out.println(studentList.stream().sorted((student1,student2) -> student2.getCourses().size() - student1.getCourses().size()).limit(3).collect(Collectors.toList()));
        //Задание 3
        Random randomCourse = new Random();
        Course paramCourse = new Course(Course.Position.values()[randomCourse.nextInt(4)]);
        System.out.println(paramCourse.getPosition());
        studentList.stream().filter(student -> student.getCourses().contains(paramCourse)).forEach(student -> System.out.println(student.getName()));



    }

    private static List<Student> getStudentList (int quantity){
        Faker faker = new Faker(new Locale("ru"));
        ArrayList<Student> result = new ArrayList<>();
        Random randomCourseQuant = new Random();
        Random randomCourse = new Random();

        for (int i=0; i<quantity ;i++){
            String name = faker.name().fullName();
            ArrayList<Course> courses = new ArrayList<>();
            for (int h=0; h<randomCourseQuant.nextInt(4) ;h++){
                courses.add(new Course(Course.Position.values()[randomCourse.nextInt(4)]));
            }
            result.add(new Student(name, courses));
        }
        return result;
    }
}
