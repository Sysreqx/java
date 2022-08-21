package java_core.request_parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Парсер реквестов
*/

public class RequestParser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String parameters = "";

        for (String retval : url.split("\\?")) {
            parameters = retval;
        }

        List<String> objList = new ArrayList<>();

        for (String retval : parameters.split("&")) {

            List<String> keyValueArr = new ArrayList<>(2);
            for (String keyValue : retval.split("=")) {

                keyValueArr.add(keyValue);
            }

            System.out.print(keyValueArr.get(0) + " ");

            if (keyValueArr.get(0).equals("obj")) {
                objList.add(keyValueArr.get(1));
            }
        }

        System.out.println();
        for (String s: objList) {
            try {
                Double doubleForAllert = Double.parseDouble(s);
                alert(doubleForAllert);
            } catch (Exception exception)
            {
                alert(s);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
