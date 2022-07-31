package Lesson7.project;

import Lesson7.project.entity.WeatherData;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepositorySQLiteImpl implements DatabaseRepository{

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT NOT NULL, date_time TEXT NOT NULL, weather_text TEXT NOT NULL, temperature REAL NOT NULL);";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";


    public DatabaseRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    public void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getWeatherText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<WeatherData> getAllSavedData(String city) throws IOException {
        try (Connection connection = getConnection();
             ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM weather WHERE city='" + city + "'" )) {
            ArrayList<WeatherData> weatherDataArrayList = new ArrayList<>();
            while (resultSet.next()) {
                weatherDataArrayList.add(new WeatherData(resultSet.getString(2),resultSet.getString(3), resultSet.getString(4),resultSet.getDouble(5)));
            }
            return weatherDataArrayList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } throw new IOException("Not implemented exception");

    }
}
