package ru.ICLTask.customer;

import java.util.List;

import ru.ICLTask.service.TranslitServiceImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

    private ServiceTracker tracker;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {

        String name = null;

        // Create and open tracker
        tracker = new ServiceTracker(context, TranslitServiceImpl.class.getName(), null);

        tracker.open();

        // Create customer service
        TransliterationImpl menu = new TransliterationImpl(tracker);

        // Execute the sample
        String item = menu.translitToLatin(name);

        System.out.println(item);
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {

        // Close the ColorizerService ServiceTracker
        tracker.close();
    }
}
