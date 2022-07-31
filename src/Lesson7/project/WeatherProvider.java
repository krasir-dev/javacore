package Lesson7.project;



import Lesson7.project.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException, ParseException, SQLException;

}
