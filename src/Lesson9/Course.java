package Lesson9;

import java.util.Objects;

public class Course {

    enum Position {
        MATH, ECONOMY, MARKETING, QA, PSYCH;
    }

    private Position position;
    //private String courseName;


    public Course(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Course{" +
                 position +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course room = (Course) o;
        return Objects.equals(position, room.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
