package ru.ICLTask.customer;

import ru.ICLTask.service.TranslitServiceImpl;

import org.osgi.util.tracker.ServiceTracker;


public class TransliterationImpl implements Transliteration {

    String name = null;

    private final ServiceTracker colorizerTracker;

    public TransliterationImpl(ServiceTracker tracker) {
        colorizerTracker = tracker;
    }

    @Override
    public String translitToLatin(String name) {
        TranslitServiceImpl service = (TranslitServiceImpl) colorizerTracker.getService();

        if (service == null)
            return new String();

        return service.translitToLatin(name);
    }
}