package models;

import utils.Utilities;

public class GameApp extends App{

    private boolean isMultiplayer;


    public GameApp(Developer developer, String appName, double appSize, double appCost, double appVersion, boolean isMultiplayer){
        super(developer,appName,appSize,appCost,appVersion);
        this.isMultiplayer = isMultiplayer;
    }

    public void setMultiplayer(boolean isMulti){
        if (isMulti){
            this.isMultiplayer = true;
        }
        else this.isMultiplayer = false;
    }


    public boolean isMultiplayer(){
        return  isMultiplayer;
    }

    public boolean isRecommendedApp(){
        if(isMultiplayer() && Utilities.greaterThanOrEqualTo(calculateRating(),4)){
            return true;
        }
        return false;
    }


    public String toString(){
        return getAppName() +"(V" + getAppVersion() + ") "
                + "  "+(isMultiplayer ? "[Multiplayer]":"[Solo]")
                + (isRecommendedApp() ? "  [Recommended]" : "")
                + "  by " + getDeveloper()
                + "  €" + getAppCost()
                + "  Rating: "+ calculateRating()
                + "  Size: " + getAppSize();

    }

}
