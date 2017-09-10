package ru.ICLTask.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Properties;


public class Activator implements BundleActivator {


    public ServiceRegistration registration;

    public void start(BundleContext context) throws Exception {
        System.out.println("Start Bundle Service");

        TranslitService service = new TranslitServiceImpl();

        Properties props = new Properties();
        props.put("category", "basic");

        registration = context.registerService(service.getName(), service, props);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Stop Bundle Service");

        registration.unregister();
    }
}