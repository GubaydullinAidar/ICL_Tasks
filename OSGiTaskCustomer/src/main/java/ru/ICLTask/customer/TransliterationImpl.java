package ru.ICLTask.customer;

import ru.ICLTask.service.TranslitServiceImpl;

import org.osgi.util.tracker.ServiceTracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class TransliterationImpl implements Transliteration {

    String name = null;

    private final ServiceTracker translitTracker;

    public TransliterationImpl(ServiceTracker tracker) {
        translitTracker = tracker;
    }

    @Override
    public String getLatinName(String name) {
        TranslitServiceImpl service = (TranslitServiceImpl) translitTracker.getService();

        if (service == null) {
            System.out.println("service null");
            return new String();
        }

        return service.translitToLatin(name);
    }

    @Override
    public String getNameKyrillic() {
        System.out.println("Введите имя на русском:");
        String input = null;
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            input = is.readLine();
            if(input.length() == 0) {
                System.out.println("null");
                return null;
            }
        } catch(IOException e) {
            System.out.println(e);
        }
        return input;
    }
}