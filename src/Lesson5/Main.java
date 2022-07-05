package Lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // Задача 1. Реализовать сохранение данных в csv файл
        String[] header = {"Value 1", "Value 2", "Value 3"};
        int[][] data = {{100, 200, 123}, {300, 400, 500}};

        AppData newData = new AppData(header, data);


        File resultCSV = new File("result.csv");
        PrintWriter pw = new PrintWriter(resultCSV);

        System.out.println(resultCSV.exists());

        String outData = new String();
        for (int i = 0; i < newData.getHeader().length; i++) {
            if (i == 0) {
                outData = newData.getHeader()[i];
            } else {
                outData = outData + ";" + newData.getHeader()[i];
            }


        }
        System.out.println(outData);
        pw.println(outData);

        for (int i = 0; i < newData.getData().length; i++) {
            for (int j = 0; j < newData.getData()[i].length; j++) {
                pw.print(newData.getData()[i][j] + ";");
            }
            pw.print("\n");
        }


        pw.close();

        //Задача 2. Реализовать загрузку данных из csv файла

        try (BufferedReader br = new BufferedReader(new FileReader(resultCSV))) {

            List<List<String>> records = new ArrayList<>();
            String line = br.readLine();
            String[] newHeader = line.split(";");

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));}

            int[][] resultData = new int[records.size()][3];

            for(int i=0;i<records.size();i++){
                for(int j=0;j<records.get(i).size();j++){
                    resultData[i][j] = Integer.valueOf(records.get(i).get(j));
                }
            }
            AppData dataFromInput = new AppData(newHeader, resultData);
            }




    }
}
