package models;


import utils.*;
public class EducationApp extends App{

    private int level = 0;

    public EducationApp(Developer developer, String appName, double appSize, double appCost, double appVersion,int level){
        super(developer,appName,appSize,appCost,appVersion);
        this.level = level;
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
        if(getAppCost() > 0.99 && calculateRating() >= 3.5 && level >= 3){
            return true;
        }else return false;
    }

    public String toString(){
        return getAppName() +"(V" + getAppVersion() + ") "
                + (isRecommendedApp() ? "  [Recommended]" : "")
                + "  Level: " + level
                + "  by " + getDeveloper()
                + "  €" + getAppCost()
                + "  Rating: "+ calculateRating()
                + "  Size: " + getAppSize();
    }

}
