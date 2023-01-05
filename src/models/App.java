package models;


import utils.Utilities;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.math.BigDecimal;

public abstract class App {

    private Developer developer;
    private String appName = "No app name";
    private double appSize = 0;
    private double appVersion = 1.0;
    private double appCost = 0.0;

    private ArrayList<Rating> ratings = new ArrayList<>();

    public App(Developer developer, String appName, double appSize, double appCost, double appVersion){
        setDeveloper(developer);
        setAppName(appName);
        setAppSize(appSize);
        setAppVersion(appVersion);
        setAppCost(appCost);
    }



    public String appSummary(){
        String str = appName +"(V" + appVersion + ") "
                + "  by " + developer.toString()
                + "€" + appCost
                +"Rating: " + calculateRating()
                + listRatings();
        return str;
    }


    public Developer getDeveloper(){
        return developer;
    }

    public String getAppName(){
        return appName;
    }

    public double getAppSize(){
        return appSize;
    }

    public double getAppCost(){
        return appCost;
    }

    public double getAppVersion(){
        return appVersion;
    }


    public ArrayList<Rating> getRatings(){
        return ratings;
    }
    public boolean addRating(Rating rating){
        return ratings.add(rating);
    }

    public double calculateRating(){
        double allStars = 0;
        int counts = 0 ;
        double average;

        for (Rating rating : ratings) allStars += rating.getNumberOfStars();
        if (allStars != 0){
            average = allStars/counts;
            BigDecimal bd = new BigDecimal(average);
            double averageRating = bd.setScale(1, RoundingMode.DOWN).doubleValue();
            return averageRating;
        }
        else return 0.0;
    }


    public String listRatings(){
        String str ="";
        for (Rating rating : ratings) {
            str += rating.toString() + "\n";
        }
        return ratings.size() ==0 ?  "No ratings added yet" : str;
    }

    public void setDeveloper(Developer developer){
        this.developer = developer;
    }

    public void setAppName(String appName){
        if(Utilities.validateStringLength(appName,80)){
            this.appName = appName;
        }
    }

    public void setAppSize(Double appSize){
        if(Utilities.validRange(appSize,1,1000)){
            this.appSize = appSize;
        }
    }

    public void setAppCost(double appCost){
        if(Utilities.validRange(appCost,1,1000)){
            this.appCost = appCost;
        }
    }

    public void setAppVersion(double appVersion){
        if(Utilities.greaterThanOrEqualTo(appVersion,1.0)){
            this.appVersion = appVersion;
        }
    }

    public abstract boolean isRecommendedApp();

    public String toString(){
        return appName +"(V" + appVersion + ") "
                + "  by " +developer.getDeveloperName()
                + "€" + appCost
                +"Rating: "+ calculateRating();
    }


}
