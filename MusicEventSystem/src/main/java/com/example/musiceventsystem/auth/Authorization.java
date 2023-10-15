package com.example.musiceventsystem.auth;

import java.util.*;

public class Authorization {
    public static final String ADMIN = "admin";
    public static final String PLANNER = "planner";
    public static final String CUSTOMER = "customer";

    private Set<String> adminPermissions = new HashSet<>();
    private Set<String> plannerPermissions = new HashSet<>();
    private Set<String> customerPermissions = new HashSet<>();

    public Authorization() {
        // initialize the authorization
        initializeAdmin();
        initializePlanner();
        initializeCustomer();
    }

    private void initializeAdmin() {
        adminPermissions.addAll(Arrays.asList("customer list","customer search", "customer save", "customer update", "customer delete"));
        adminPermissions.addAll(Arrays.asList("planner list","planner search", "planner save", "planner update", "planner delete"));
        adminPermissions.addAll(Arrays.asList("venue list","venue search", "venue save", "venue update", "venue delete"));
        adminPermissions.addAll(Arrays.asList("event list", "event search", "event save", "event update", "event delete"));
        adminPermissions.addAll(Arrays.asList("order list", "order search", "order save","order delete", "order update"));

    }

    private void initializePlanner() {
        plannerPermissions.addAll(Arrays.asList("venue list", "venue search"));
        plannerPermissions.addAll(Arrays.asList("event list", "event search", "event save", "event update", "event delete"));
    }

    private void initializeCustomer() {
        customerPermissions.addAll(Arrays.asList("event list", "event search"));
        customerPermissions.addAll(Arrays.asList("venue list", "venue search"));
        customerPermissions.addAll(Arrays.asList("purchase list", "purchase search", "purchase save", "purchase update", "purchase delete"));
        customerPermissions.addAll(Arrays.asList("order list", "order search", "order save","order delete", "order update"));
    }

    // check the permission of users
    public boolean checkPermission(String userType, String methodName) {
        System.out.println("Attribute Value: " + userType + "    methodname = " + methodName);
        Set<String> allowedMethods = getUserPermissions(userType);
        System.out.println("Result = " + (allowedMethods != null) + "other result" +allowedMethods.contains(methodName));
        return allowedMethods != null && allowedMethods.contains(methodName);
    }

    // get correspond permission by user type
    private Set<String> getUserPermissions(String userType) {
        switch (userType) {
            case "admin":
                return adminPermissions;
            case "planner":
                return plannerPermissions;
            case "customer":
                return customerPermissions;
            default:
                return null;
        }
    }
}
