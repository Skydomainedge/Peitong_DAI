package models;

import utils.Utilities;

public class ProductivityApp extends App{

    public ProductivityApp(Developer developer, String appName, double appSize, double appCost, double appVersion){
        super(developer,appName,appSize,appCost,appVersion);
    }

    public boolean isRecommendedApp(){
        if(){

        }
        else return false;
    }

    public String toString(){
        return getAppName() +"(V" + getAppVersion() + ") "
                + "  by " + getDeveloper()
                + "€" + getAppCost()
                +"Rating: "+ calculateRating();
    }

}
