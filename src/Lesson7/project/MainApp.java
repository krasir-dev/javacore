package Lesson7.project;

public class MainApp {

    public static void main(String[] args)  {
        DatabaseRepositorySQLiteImpl databaseRepositorySQLite = new DatabaseRepositorySQLiteImpl();
        databaseRepositorySQLite.createTableIfNotExists();
        UserInterface userInterface = new UserInterface();
        userInterface.runApplication();
    }
}
