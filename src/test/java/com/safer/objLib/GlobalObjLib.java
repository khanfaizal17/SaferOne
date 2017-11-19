package com.safer.objLib;

public class GlobalObjLib {
	
    // ************************************************
    //            Constants
    // ************************************************
    public static final long constant_MaxTimeoutPeriod = 60000;
    
    
    // ************************************************
    //            Global XML channel object
    // ************************************************
    public static String XML_Channel_Object = "//channel";

	
    // ************************************************
    //            Environment TEST DRIVER
    // ************************************************	
    // Change environment below:
    public static String environment;
    public static String URLStartString;
    public static String URLAddress;
    public static String URLLoginString;
    public static String dbServer;
    public static String dbport;
    public static String dbSID;
    public static String username;
    public static String password;


    static {
        // ************************************************
        //            QA DB Settings
        // ************************************************
         String QA_dbServer = "TBD";
        String QA_port = "TBD";
         String QA_dbSID = "TBD";
         String QA_username = "genaday@genady.com";
         String QA_password = "SaferOne";


        // ************************************************
        //            Beta2 DB Settings
        // ************************************************
         String beta2_dbServer = "TBD";
         String beta2_port = "TBD";
         String beta2_dbSID = "TBD";
        String beta2_username = "genaday@genady.com";
        String beta2_password = "SaferOne";

        environment = System.getProperty("environment");

        if (GlobalObjLib.environment.equalsIgnoreCase("qa")) {
        	URLStartString = "http:";
        	URLAddress = "//10.0.60.33/";
        	URLLoginString = "login.html";
            dbServer = QA_dbServer;
            dbport = QA_port;
            dbSID = QA_dbSID;
            username = QA_username;
            password = QA_password;
            
        } else if (GlobalObjLib.environment.equalsIgnoreCase("beta2")) {
        	URLStartString = "https:";
        	URLAddress = "//beta2.safersystem.com/";
        	URLLoginString = "login.html";
            dbServer = beta2_dbServer;
            dbport = beta2_port;
            dbSID = beta2_dbSID;
            username = beta2_username;
            password = beta2_password;
        }

    }



    
    
    
    // ************************************************
    //            Login Screen
    // ************************************************
    
    public static String Email_Input_Field = "//*[@id='x-auto-1-input']";
    
    
    
}
