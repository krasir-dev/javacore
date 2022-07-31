package Lesson7.project;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class UserInterface {

    private final Controller controller = new Controller();
    public String city;
    public void runApplication() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название города на английском языке");
            String city = scanner.nextLine();
            //city ="Irkutsk";
            setGlobalCity(city);
            checkIsExit(city);

            System.out.println("Введите ответ: 1 - Получить текущую погоду, " +
                "2 - Получить погоду на следующие 5 дней, " +
                "3 - Чтение из базы всех данных, " +
                "выход (exit) - завершить работу");
            String result = scanner.nextLine();

            checkIsExit(result);

            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                notifyController(result);
            } catch (IOException | ParseException | SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void checkIsExit(String result) {
        if (result.toLowerCase().equals("выход") || result.toLowerCase().equals("exit")) {
            System.out.println("Завершаю работу");
            System.exit(0);
        }
    }

    private void setGlobalCity(String city) {
        ApplicationGlobalState.getInstance().setSelectedCity(city);
    }


    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Incorrect user input: expected one digit as answer, but actually get " + userInput);
        }
        int answer = 0;
        try {
            if (Integer.parseInt(userInput) <= 3){
                answer = Integer.parseInt(userInput);
            }
            else {
                throw new IOException("Incorrect user input: expected 1, 2 or 3, but actually get " + userInput);
            }

        } catch (NumberFormatException e) {
            throw new IOException("Incorrect user input: character is not numeric!");
        }
    }

    private void notifyController(String input) throws IOException, ParseException, SQLException {
        controller.onUserInput(input);
    }

}
