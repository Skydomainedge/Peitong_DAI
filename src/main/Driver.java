package main;

import controllers.AppStoreAPI;
import controllers.DeveloperAPI;
import models.*;
import utils.ScannerInput;
import utils.Utilities;

public class Driver {

    //TODO Some skeleton code has been given to you.
    //     Familiarise yourself with the skeleton code...run the menu and then review the skeleton code.
    //     Then start working through the spec.

    private DeveloperAPI developerAPI = new DeveloperAPI();
    private AppStoreAPI appStoreAPI = new AppStoreAPI();

    public static void main(String[] args) {
        new Driver().start();
    }

    public void start() {
        loadAllData();
        runMainMenu();
    }

    private int mainMenu() {
        System.out.println("""
                ┌┈┈┈┈┈┈┈┈┈┈┈┈┈App Store┄┄┄┄┄┄┈┄┄┄┄┄┐
                ┊  1) Developer - Management MENU  ┊
                ┊  2) App - Management MENU        ┊
                ┊  3) Reports MENU                 ┊
                ├┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┤
                ┊  4) Search                       ┊
                ┊  5) Sort                         ┊
                ├┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┤
                ┊  6) Recommended Apps             ┊
                ┊  7) Random App of the Day        ┊
                ┊  8) Simulate ratings             ┊
                ├┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┤
                ┊  20) Save all                    ┊
                ┊  21) Load all                    ┊
                ├┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┤
                ┊  0) Exit                         ┊
                └┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┘
                 """);
        return ScannerInput.validNextInt("==>>  ");
    }

    private void runMainMenu() {
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> runDeveloperMenu();
                case 2 -> runAppStoreMenu();
                case 3 -> runReportsMenu();
                case 4 -> searchAppsBySpecificCriteria();
                case 5 -> // TODO Sort Apps by Name
                case 6 -> show
                case 7 -> // TODO print the random app of the day
                case 8 -> simulateRatings();
                case 20 -> saveAllData();
                case 21 -> loadAllData();
                default -> System.out.println("Invalid option entered: " + option);
            }
            ScannerInput.validNextLine("\n Press the enter key to continue");
            option = mainMenu();
        }
        exitApp();
    }

    private void exitApp() {
        saveAllData();
        System.out.println("Exiting....");
        System.exit(0);
    }

    //--------------------------------------------------
    //  Developer Management - Menu Items
    //--------------------------------------------------
    private int developerMenu() {
        System.out.println("""
                ┌┈┈┈┈┈┈┈Developer Menu┄┈┄┄┄┄┄┐
                ┊   1) Add a developer       ┊
                ┊   2) List developer        ┊
                ┊   3) Update developer      ┊
                ┊   4) Delete developer      ┊
                ┊   0) RETURN to main menu   ┊
                └┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┘
                 """);
        return ScannerInput.validNextInt("==>> ");
    }

    private void runDeveloperMenu() {
        int option = developerMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> addDeveloper();
                case 2 -> S {
                    System.out.println("List of Developers are:");
                    System.out.println(developerAPI.listDevelopers());
                }
                case 3 -> updateDeveloper();
                case 4 -> deleteDeveloper();
                default -> System.out.println("Invalid option entered" + option);
            }
            ScannerInput.validNextLine("\n Press the enter key to continue");
            option = mainMenu();
        }
    }


    private int appStoreMenu() {
        System.out.println("""
                ┌┈┈┈┈┈┈┈App Store Menu┄┈┄┄┄┄┄┐
                ┊   1) Add a app             ┊
                ┊   2) List apps             ┊
                ┊   3) Update a app          ┊
                ┊   4) Delete a app          ┊
                ┊   0) RETURN to main menu   ┊
                └┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┘
                 """);
        return ScannerInput.validNextInt("==>> ");
    }

    private void runAppStoreMenu() {
        int option = appStoreMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> runAddAppLists();
                case 2 -> runViewList();
                case 3 -> updateApp();
                case 4 -> deleteApp();
                default -> System.out.println("Invalid option entered" + option);
            }
            ScannerInput.validNextLine("\n Press the enter key to continue");
            option = mainMenu();
        }
    }

    private int addAppLists() {
        System.out.println("""
                ┌┈┈┈┈┈┈App Category Menu┄┄┄┄┄┐
                ┊   1) Education app         ┊
                ┊   2) Game app              ┊
                ┊   3) Productivity app      ┊
                ┊   0) RETURN                ┊
                └┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┘
                 """);
        return ScannerInput.validNextInt("==>> ");
    }


    private void runAddAppLists() {
        boolean isAdded = false;
        int option = addAppLists();
        while (option != 0) {
            switch (option) {
                case 1 ->{
                    System.out.println("List of Developers are:");
                    System.out.println(developerAPI.listDevelopers());

                    String developerName = ScannerInput.validNextLine("Enter the Developer Name:  ");
                    Developer developer = developerAPI.getDeveloperByName(developerName);
                    String appName = ScannerInput.validNextLine("Enter the App Name:  ");
                    double appSize = ScannerInput.validNextDouble("Enter the App Size:  ");
                    double appCost = ScannerInput.validNextDouble("Enter the App Cost:  ");
                    double appVersion = ScannerInput.validNextDouble("Enter the App Version:  ");
                    int level = ScannerInput.validNextInt("Enter the App Level:  ");
                    isAdded = appStoreAPI.addApp(new EducationApp(developer, appName, appSize, appCost, appVersion, level));
                }
                case 2 ->{
                    System.out.println("List of Developers are:");
                    System.out.println(developerAPI.listDevelopers());

                    String developerName = ScannerInput.validNextLine("Enter the Developer Name:  ");
                    Developer developer = developerAPI.getDeveloperByName(developerName);
                    String appName = ScannerInput.validNextLine("Enter the App Name:  ");

                    double appSize = ScannerInput.validNextDouble("Enter the App Size:  ");
                    double appCost = ScannerInput.validNextDouble("Enter the App Cost:  ");
                    double appVersion = ScannerInput.validNextDouble("Enter the App Version:  ");
                    boolean isMultiplayer = Utilities.YNtoBoolean(ScannerInput.validNextChar("Is it a Multiplayer Game(Y/N):  "));
                    isAdded = appStoreAPI.addApp(new GameApp(developer, appName, appSize, appCost, appVersion, isMultiplayer));

                }
                case 3 ->{
                    System.out.println("List of Developers are:");
                    System.out.println(developerAPI.listDevelopers());

                    String developerName = ScannerInput.validNextLine("Enter the Developer Name:  ");
                    Developer developer = developerAPI.getDeveloperByName(developerName);
                    String appName = ScannerInput.validNextLine("Enter the App Name:  ");

                    double appSize = ScannerInput.validNextDouble("Enter the App Size:  ");
                    double appCost = ScannerInput.validNextDouble("Enter the App Cost:  ");
                    double appVersion = ScannerInput.validNextDouble("Enter the App Version:  ");

                    isAdded = appStoreAPI.addApp(new ProductivityApp(developer, appName, appSize, appCost, appVersion));

                }

                default -> System.out.println("Invalid option entered      " + option);
            }
            if (isAdded){
                System.out.println("App Added Successfully");
            }
            else{
                System.out.println("No App Added");
            }
            ScannerInput.validNextLine("\n Press the enter key to continue");

            option = appStoreMenu();
        }
    }

    private int viewLists() {
        System.out.println("""
                ┌┈┈┈┈┈┈┈App Lists Menu┄┈┄┄┄┄┄┐
                ┊   1) All Apps              ┊
                ┊   2) Education apps        ┊
                ┊   3) Game apps             ┊
                ┊   4) Productivity apps     ┊
                ┊   0) RETURN                ┊
                └┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┘
                 """);
        return ScannerInput.validNextInt("==>> ");
    }

    private void runViewList() {
        int option = viewLists();
        while (option != 0) {
            switch (option) {
                case 1 ->showListOfAllApp();
                case 2 ->showListOfEducationApp();
                case 3 ->showListOfGameApp();
                case 4 ->showListOfProductivityApp();
                default -> System.out.println("Invalid option entered" + option);
            }
            ScannerInput.validNextLine("\n Press the enter key to continue");
            option = appStoreMenu();
        }
    }

    private int reportsMenu() {
        System.out.println("""
                ┌┈┈┈┈┈┈┈┈┈Report Menu┄┈┈┄┄┄┄┄┐
                ┊   1) Apps Overview         ┊
                ┊   2) Developer Overview    ┊
                ┊   0) RETURN to main menu   ┊
                └┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┘
                 """);
        return ScannerInput.validNextInt("==>>  ");
    }
    private void runReportsMenu() {
        int option = reportsMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> System.out.println(appStoreAPI.listAllApps());
                case 2 -> System.out.println(developerAPI.listDevelopers());
                default -> System.out.println("Invalid option entered" + option);
            }
            ScannerInput.validNextLine("\n Press the enter key to continue");
            option = mainMenu();
        }
    }



    private void addDeveloper() {
        String developerName = ScannerInput.validNextLine("Please enter the developer name: ");
        String developerWebsite = ScannerInput.validNextLine("Please enter the developer website: ");

        if (developerAPI.addDeveloper(new Developer(developerName, developerWebsite))) {
            System.out.println("Add successful");
        } else {
            System.out.println("Add not successful");
        }
    }

    private void updateDeveloper() {
        System.out.println(developerAPI.listDevelopers());
        Developer developer = readValidDeveloperByName();
        if (developer != null) {
            String developerWebsite = ScannerInput.validNextLine("Please enter new website: ");
            if (developerAPI.updateDeveloperWebsite(developer.getDeveloperName(), developerWebsite))
                System.out.println("Developer Website Updated");
            else
                System.out.println("Developer Website NOT Updated");
        } else
            System.out.println("Developer name is NOT valid");
    }

    private void deleteDeveloper() {
        System.out.println();
        String developerName = ScannerInput.validNextLine("Please enter the developer name: ");
        if (developerAPI.removeDeveloper(developerName) != null) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Delete not successful");
        }
    }

    private Developer readValidDeveloperByName() {
        String developerName = ScannerInput.validNextLine("Please enter the developer's name: ");
        if (developerAPI.isValidDeveloper(developerName)) {
            return developerAPI.getDeveloperByName(developerName);
        } else {
            return null;
        }
    }



    //--------------------------------------------------
    // TODO UNCOMMENT THIS CODE as you start working through this class
    //--------------------------------------------------
    private void searchAppsBySpecificCriteria() {
        System.out.println("""
                What criteria would you like to search apps by:
                  1) App Name
                  2) Developer Name
                  3) Rating (all apps of that rating or above)""");
        int option = ScannerInput.validNextInt("==>> ");
        switch (option) {
            // TODO Search methods below
            case 1 -> searchAppsByName();
            case 2 -> searchAppsByDeveloper(readValidDeveloperByName());
            case 3 -> searchAppsEqualOrAboveAStarRating();
            default -> System.out.println("Invalid option");
        }
    }
    private void searchAppsByName(){
        if (appStoreAPI.numberOfApps()==0){
            System.out.println("no apps");
        }else {
            String name = ScannerInput.validNextLine("Please enter Name");
            System.out.println(appStoreAPI.getAppByName(name));
        }
    }

    private void searchAppsByDeveloper(Developer readValidDeveloperByName){

    }
    private void searchAppsEqualOrAboveAStarRating(){

    }

    //--------------------------------------------------
    // TODO UNCOMMENT THIS COMPLETED CODE as you start working through this class
    //--------------------------------------------------
    private void simulateRatings() {

        if (appStoreAPI.numberOfApps() > 0) {
            System.out.println("Simulating ratings...");
            appStoreAPI.simulateRatings();
            System.out.println(appStoreAPI.listSummaryOfAllApps());
        } else {
           System.out.println("No apps");
        }
    }

    private void showListOfAllApp(){
        System.out.println("List of All Apps are:");
        System.out.println(appStoreAPI.listAllApps());
        ScannerInput.validNextLine("\n Press the enter key to continue");
    }

    private void showListOfEducationApp(){
        System.out.println("List of Education Apps are:");
        System.out.println(appStoreAPI.listAllEducationApps());
        ScannerInput.validNextLine("\n Press the enter key to continue");
    }

    private void showListOfGameApp(){
        System.out.println("List of Game Apps are:");
        System.out.println(appStoreAPI.listAllGameApps());
        ScannerInput.validNextLine("\n Press the enter key to continue");

    }

    private void showListOfProductivityApp(){
        System.out.println("List of Productivity Apps are:");
        System.out.println(appStoreAPI.listAllProductivityApps());
        ScannerInput.validNextLine("\n Press the enter key to continue");
    }

    private void showListOfRecommendedApp(){
        System.out.println("List of Recommended Apps are:");
        System.out.println(appStoreAPI.listAllRecommendedApps());
        ScannerInput.validNextLine("\n Press the enter key to continue");
    }
    //--------------------------------------------------
    //  Persistence Menu Items
    //--------------------------------------------------

    private void saveAllData() {
        try {
            System.out.println("Saving app store to file: " + appStoreAPI.fileName());
            appStoreAPI.save();
            System.out.println("Saving developers information to file: " + developerAPI.fileName());
            developerAPI.save();
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e);
        }
        ScannerInput.validNextLine("\n Press the enter key to continue");
    }

    private void loadAllData() {
        try {
            System.out.println("Saving app store to file: " + appStoreAPI.fileName());
            appStoreAPI.load();
            System.out.println("Saving developers information to file: " + developerAPI.fileName());
            developerAPI.load();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }
        ScannerInput.validNextLine("\n Press the enter key to continue");
    }

}
