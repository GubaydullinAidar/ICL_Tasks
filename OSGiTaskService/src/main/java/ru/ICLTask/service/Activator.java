package ru.ICLTask.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Properties;


public class Activator implements BundleActivator {


    public ServiceRegistration registration;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        System.out.println("Start Bundle Service");
        // create a service
        TranslitService service = new TranslitServiceImpl();
        // set some params
        Properties props = new Properties();
        props.put("category", "basic");
        // registrating the ColorizerService
        registration = context.registerService(service.getName(), service, props);
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        System.out.println("Stop Bundle Service");

        registration.unregister();
    }
}