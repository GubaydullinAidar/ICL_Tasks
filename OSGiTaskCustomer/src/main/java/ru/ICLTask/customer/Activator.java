package ru.ICLTask.customer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import ru.ICLTask.service.TranslitServiceImpl;

import java.util.Scanner;

public class Activator implements BundleActivator {

    private ServiceTracker tracker;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {

        System.setOut(new java.io.PrintStream(System.out, true, "Cp866"));
        System.out.println("Start Bundle Customer");

        // Create and open tracker
        tracker = new ServiceTracker(context, TranslitServiceImpl.class.getName(), null);
        tracker.open();

        // Create customer service
        TransliterationImpl transliteration = new TransliterationImpl(tracker);

        String name = transliteration.getNameKyrillic();

        // Execute the sample
        String translitName = transliteration.getLatinName(name);

        System.out.println(translitName);
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {

        System.out.println("Stop Bundle Customer");

        // Close the ColorizerService ServiceTracker
        tracker.close();
    }
}