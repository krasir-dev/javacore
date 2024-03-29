package Lesson7.project;



import Lesson7.project.enums.Functionality;
import Lesson7.project.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(3, Functionality.GET_INFO);
    }

    public void onUserInput(String input) throws IOException, ParseException, SQLException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }

        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
            case GET_INFO:
                getBDInformation();
                break;
        }
    }

    public void getCurrentWeather() throws IOException, ParseException, SQLException {
        weatherProvider.getWeather(Periods.NOW);

    }

    public void getWeatherIn5Days() throws IOException, ParseException, SQLException {
        //throw new RuntimeException("Implement in h/w");
        weatherProvider.getWeather(Periods.FIVE_DAYS);
    }
    public void getBDInformation() throws IOException, ParseException, SQLException {

        DatabaseRepositorySQLiteImpl databaseRepositorySQLite = new DatabaseRepositorySQLiteImpl();
        System.out.println(databaseRepositorySQLite.getAllSavedData(ApplicationGlobalState.getInstance().getSelectedCity()).toString());


    }
}
