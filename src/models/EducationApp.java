package models;


import utils.*;
public class EducationApp extends App{

    private int level = 0;

    public EducationApp(Developer developer, String appName, double appSize, double appCost, double appVersion, boolean isRecommendedApp){
        super(developer,appName,appSize,appCost,appVersion);
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        if (Utilities.validRange(level, 1, 10)){
            this.level = level;
        }
    }

    public boolean isRecommendedApp(){

    }

    public String toString(){
        return getAppName() +"(V" + getAppVersion() + ") "
                + "  by " + getDeveloper()
                + "€" + getAppCost()
                +"Rating: "+ calculateRating();
    }

}
