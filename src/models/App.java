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
    private double appCost = 0.0;

    private ArrayList<Rating> ratings = new ArrayList<>;

    public App(Developer developer, String appName, double appSize, double appCost, double appVersion){
        this.developer=developer;
        this.appName = Utilities.truncateString(appName, 100);

        if (Utilities.validRange(appSize,1,1000)) {
            this.appVersion =appVersion;
        }
        if (Utilities.greaterThanOrEqualTo(appCost,0.0)) {
            this.appVersion =appVersion;
        }
        if (Utilities.greaterThanOrEqualTo(appVersion,1)) {
            this.appVersion =appVersion;
        }
    }



    public static String appSummary(){
        String str =
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


    public ArrayList<Rating> getRating(){
        return ratings;
    }
    public boolean addRating(Rating rating){
        return ratings.add();
    }

    public double calculateRating(){
        if(numberOfStars != 0){
            th
        }
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

    public void setDeveloper(Developer developer){

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

    public boolean isRecommendedApp(){

    }

    public String toString(){
        return appName +"(V" + appVersion + ") "
                + "  by " +developer.getDeveloperName()
                + "€" + appCost
                +"Rating: "+ calculateRating();
    }


}
