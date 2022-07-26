package Lesson7.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Lesson7.project.enums.Periods;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();


    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException, JsonProcessingException, ParseException {
        String cityKey = detectCityKey();
        //String cityKey = "292712";
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                .addPathSegment(API_VERSION)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .build();

            Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                //.addHeader("Accept-Encoding", "gzip")
                .url(url)
                .build();

            Response response = client.newCall(request).execute();
            String jsonResponse = response.body().string();
            //String jsonResponse = "[{\"LocalObservationDateTime\":\"2022-07-12T16:27:00+08:00\",\"EpochTime\":1657614420,\"WeatherText\":\"Sunny\",\"WeatherIcon\":1,\"HasPrecipitation\":false,\"PrecipitationType\":null,\"IsDayTime\":true,\"Temperature\":{\"Metric\":{\"Value\":25.0,\"Unit\":\"C\",\"UnitType\":17},\"Imperial\":{\"Value\":77.0,\"Unit\":\"F\",\"UnitType\":18}},\"MobileLink\":\"http://www.accuweather.com/en/ru/irkutsk/292712/current-weather/292712?lang=en-us\",\"Link\":\"http://www.accuweather.com/en/ru/irkutsk/292712/current-weather/292712?lang=en-us\"}]";

            //JsonNode weatherText = objectMapper.readTree(jsonResponse).at("/WeatherText");

            System.out.println("Текущие погодные условия: " + objectMapper.readTree(jsonResponse).get(0).at("/WeatherText").asText());
            System.out.println("Текущая температура воздуха С: " + objectMapper.readTree(jsonResponse).get(0).at("/Temperature/Metric/Value").asText());



            // TODO: Сделать в рамках д/з вывод более приятным для пользователя.
            //  Создать класс WeatherResponse, десериализовать ответ сервера в экземпляр класса
            //  Вывести пользователю только текущую температуру в C и сообщение (weather text)
        } else if(periods.equals(Periods.FIVE_DAYS)){
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment("daily")
                    .addPathSegment("5day")
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("metric", "true")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            String jsonResponse = response.body().string();
            //System.out.println(jsonResponse);
            //String jsonResponse = "{"Headline":{"EffectiveDate":"2022-07-22T01:00:00+08:00","EffectiveEpochDate":1658422800,"Severity":2,"Text":"Expect rainy weather late Thursday night through Saturday morning","Category":"rain","EndDate":"2022-07-23T13:00:00+08:00","EndEpochDate":1658552400,"MobileLink":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?lang=en-us","Link":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?lang=en-us"},"DailyForecasts":[{"Date":"2022-07-18T07:00:00+08:00","EpochDate":1658098800,"Temperature":{"Minimum":{"Value":58.0,"Unit":"F","UnitType":18},"Maximum":{"Value":84.0,"Unit":"F","UnitType":18}},"Day":{"Icon":14,"IconPhrase":"Partly sunny w/ showers","HasPrecipitation":true,"PrecipitationType":"Rain","PrecipitationIntensity":"Light"},"Night":{"Icon":35,"IconPhrase":"Partly cloudy","HasPrecipitation":false},"Sources":["AccuWeather"],"MobileLink":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?day=1&lang=en-us","Link":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?day=1&lang=en-us"},{"Date":"2022-07-19T07:00:00+08:00","EpochDate":1658185200,"Temperature":{"Minimum":{"Value":52.0,"Unit":"F","UnitType":18},"Maximum":{"Value":66.0,"Unit":"F","UnitType":18}},"Day":{"Icon":15,"IconPhrase":"Thunderstorms","HasPrecipitation":true,"PrecipitationType":"Rain","PrecipitationIntensity":"Light"},"Night":{"Icon":12,"IconPhrase":"Showers","HasPrecipitation":true,"PrecipitationType":"Rain","PrecipitationIntensity":"Moderate"},"Sources":["AccuWeather"],"MobileLink":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?day=2&lang=en-us","Link":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?day=2&lang=en-us"},{"Date":"2022-07-20T07:00:00+08:00","EpochDate":1658271600,"Temperature":{"Minimum":{"Value":51.0,"Unit":"F","UnitType":18},"Maximum":{"Value":69.0,"Unit":"F","UnitType":18}},"Day":{"Icon":12,"IconPhrase":"Showers","HasPrecipitation":true,"PrecipitationType":"Rain","PrecipitationIntensity":"Light"},"Night":{"Icon":34,"IconPhrase":"Mostly clear","HasPrecipitation":false},"Sources":["AccuWeather"],"MobileLink":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?day=3&lang=en-us","Link":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?day=3&lang=en-us"},{"Date":"2022-07-21T07:00:00+08:00","EpochDate":1658358000,"Temperature":{"Minimum":{"Value":54.0,"Unit":"F","UnitType":18},"Maximum":{"Value":72.0,"Unit":"F","UnitType":18}},"Day":{"Icon":6,"IconPhrase":"Mostly cloudy","HasPrecipitation":false},"Night":{"Icon":12,"IconPhrase":"Showers","HasPrecipitation":true,"PrecipitationType":"Rain","PrecipitationIntensity":"Moderate"},"Sources":["AccuWeather"],"MobileLink":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?day=4&lang=en-us","Link":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?day=4&lang=en-us"},{"Date":"2022-07-22T07:00:00+08:00","EpochDate":1658444400,"Temperature":{"Minimum":{"Value":54.0,"Unit":"F","UnitType":18},"Maximum":{"Value":70.0,"Unit":"F","UnitType":18}},"Day":{"Icon":18,"IconPhrase":"Rain","HasPrecipitation":true,"PrecipitationType":"Rain","PrecipitationIntensity":"Light"},"Night":{"Icon":12,"IconPhrase":"Showers","HasPrecipitation":true,"PrecipitationType":"Rain","PrecipitationIntensity":"Light"},"Sources":["AccuWeather"],"MobileLink":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?day=5&lang=en-us","Link":"http://www.accuweather.com/en/ru/irkutsk/292712/daily-weather-forecast/292712?day=5&lang=en-us"}]}";
            WeatherResponse weatherResponses = objectMapper.readValue(jsonResponse, WeatherResponse.class);
            //System.out.println(weatherResponses.getDailyForecasts().toString());
            for (int i=0; i < weatherResponses.getDailyForecasts().size(); i++){
                String date = weatherResponses.getDailyForecasts().get(i).getDate();
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+HH:mm");
                SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date parsedDate = inputFormat.parse(date);
                String formattedDate = outputFormat.format(parsedDate);

                //String formattedDate = weatherResponses.getDailyForecasts().get(i).getDate();
                System.out.println("В городе " + ApplicationGlobalState.getInstance().getSelectedCity() + " на дату " +
                        formattedDate + " ожидается " +
                        weatherResponses.getDailyForecasts().get(i).getDay().getIconPhrase() + ", температура С от " +
                        weatherResponses.getDailyForecasts().get(i).getTemperature().getMinimum().getValue() + " до " +
                        weatherResponses.getDailyForecasts().get(i).getTemperature().getMaximum().getValue()) ;




            }

        }
    }

    public String detectCityKey() throws IOException, JsonMappingException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
            .scheme("http")
            .host(BASE_HOST)
            .addPathSegment("locations")
            .addPathSegment(API_VERSION)
            .addPathSegment("cities")
            .addPathSegment("autocomplete")
            .addQueryParameter("apikey", API_KEY)
            .addQueryParameter("q", selectedCity)
            .build();

        Request request = new Request.Builder()
            .addHeader("accept", "application/json")
            .url(detectLocationURL)
            .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }
}
