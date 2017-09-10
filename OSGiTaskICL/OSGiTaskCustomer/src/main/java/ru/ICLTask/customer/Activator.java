package ru.ICLTask.customer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import ru.ICLTask.service.TranslitServiceImpl;

import java.io.UnsupportedEncodingException;

public class Activator implements BundleActivator {

    private ServiceTracker tracker;

    public void start(BundleContext context) {

        try {
            System.setOut(new java.io.PrintStream(System.out, true, "Cp866"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("Start Bundle Customer");

        tracker = new ServiceTracker(context, TranslitServiceImpl.class.getName(), null);
        tracker.open();

        TransliterationImpl transliteration = new TransliterationImpl(tracker);

        String name = transliteration.getNameKyrillic();
        transliteration.getLatinName(name);
    }

    public void stop(BundleContext context) throws Exception {

        System.out.println("Stop Bundle Customer");

        tracker.close();
    }
}