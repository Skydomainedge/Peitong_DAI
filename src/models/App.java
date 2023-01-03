package models;

import models.EducationApp;
import models.GameApp;
import models.ProductivityApp;
import models.Rating;

import utils.Utilities;
import java.util.ArrayList;

public abstract class App {

    private Developer developer;
    private String appName = "No app name";
    private double appSize = 0;
    private double appVersion = 1.0;
    private double appCost = 0;

    private ArrayList<Rating> ratings = new ArrayList<>;

    public App(Developer developer, String appName, double appSize, double appCost, double appVersion){
        this.developer=developer;
        this.appName = Utilities.truncateString(appName, 100);
        this.appSize = appSize;
        this.appCost = appCost;
        this.appVersion = appVersion;

    }

    public boolean addRating(Rating rating){
        return ratings.add();
    }

    public static String appSummary(){
        String str =
    }

    public double calculateRating(){
        if(numberOfStars != 0){
            th
        }
    }

    public double getAppCost(){
        return appCost;
    }

    public String getAppName(){
        return appName;
    }

    public double getAppSize(){
        return appSize;
    }

    public double getAppVersion(){
        return appVersion;
    }

    public Developer getDeveloper(){
        return developer;
    }

    public ArrayList<Rating> getRating(){
        return ratings;
    }

    public boolean isRecommendedApp(){

    }

    public String listRatings(){
        String str ="";
        if(ratings.size() !=0){
            for (int i =0;i <ratings.size();i++)
                str += ratings.toString();
            }
        else str ="No ratings added yet";
        return str;
    }

    public void setAppCost(){

    }

    public void setAppName(){

    }

    public void setAppSize(){

    }

    public void setAppVersion(){

    }

    public void setDeveloper(){

    }

    public String toString(){
        return appName +"(V" + appVersion + ") "
                + "  by " +developer.getDeveloperName()
                + "€" + appCost
                +"Rating: "+ ratings.getNumberOfStars();
    }


}
