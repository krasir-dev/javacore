package Lesson6;

import okhttp3.OkHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args)  throws IOException {
        //OkHttpClient okHttpClient = new OkHttpClient();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.weather.yandex.ru/v2/forecast?lat=59&lon=30&limit=5&hours=false").openConnection();
        httpURLConnection.setRequestProperty("X-Yandex-API-Key", "a1f43bb2-52af-4ee9-bd55-75b8b96a2eeb");
        System.out.println(httpURLConnection.getResponseCode());
        System.out.println(httpURLConnection.getRequestMethod());
        System.out.println(httpURLConnection.getResponseMessage());
        Map<String, List<String>> headers = httpURLConnection.getHeaderFields();
        for (String k: headers.keySet()) {
            System.out.printf("Ключ: %s, значение: %s \n", k, headers.get(k));
        }


        try (InputStream inputStream = httpURLConnection.getInputStream();){
            int c;
            while ((c = inputStream.read())!=-1){
                System.out.print((char) c);
            }
        }
    }
}
