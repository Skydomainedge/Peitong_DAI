package models;

import utils.Utilities;

public class ProductivityApp extends App{

    public ProductivityApp(Developer developer, String appName, double appSize, double appCost, double appVersion){
        super(developer,appName,appSize,appCost,appVersion);
    }

    public boolean isRecommendedApp(){
        if(Utilities.greaterThanOrEqualTo(getAppCost(),1.99) && Utilities.greaterThanOrEqualTo(calculateRating(),3)){
            return true;
        }
        else return false;
    }

    public String toString(){
        return getAppName() +"(V" + getAppVersion() + ") "
                + (isRecommendedApp() ? "  [Recommended]" : "")
                + "  by " + getDeveloper()
                + "  €" + getAppCost()
                + "  Rating: " + calculateRating();
    }

}
