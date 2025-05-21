package com.islington.decor.backend;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import com.islington.decor.model.Customer;
import com.islington.decor.service.CustomerService;
import com.islington.decor.serviceImpl.CustomerServiceImpl;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

@WebListener
public class AppStartUpListener implements ServletContextListener {

	 


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        CustomerService customerService = new CustomerServiceImpl();

        // Check if superadmin exists
        Customer existingCustomer = customerService.doesCustomerExist("superadmin");

        if (existingCustomer == null) {
            Customer superadmin = new Customer();
            superadmin.setFirstName("Super");
            superadmin.setLastName("Admin");
            superadmin.setUsername("superadmin");
            superadmin.setPassword("superadmin"); // Hash this in real apps
    		superadmin.setRole("superadmin");

            customerService.addCustomer(superadmin);
            System.out.println("Superadmin account initialized.");
        } else {
            System.out.println("Superadmin already exists.");
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
            AbandonedConnectionCleanupThread.checkedShutdown();
       
    }

   
}