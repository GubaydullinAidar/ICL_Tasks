package ru.ICLTask.customer;

import org.osgi.util.tracker.ServiceTracker;
import ru.ICLTask.service.TranslitServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TransliterationImpl implements Transliteration {

    private final ServiceTracker translitTracker;

    TransliterationImpl(ServiceTracker tracker) {
        translitTracker = tracker;
    }

    @Override
    public String getLatinName(String name) {
        TranslitServiceImpl service = (TranslitServiceImpl) translitTracker.getService();

        if (service == null) {
            System.out.println("service null");
            return new String();
        }

        //String name = "Иванов Иван Иванович";
        System.out.println("ФИО на русском:");
        System.out.println(name);

        System.out.println("ФИО на латинице:");
        String returned = service.translitToLatin(name);
        System.out.println(returned);
        return returned;


    }

    @Override
    public String getNameKyrillic() {
        System.out.println("Введите имя на русском:");
        String input = null;
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            input = is.readLine();
            if (input.length() == 0) {
                System.out.println("string null");
                return null;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return input;
    }
}