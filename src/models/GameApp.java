package models;

import utils.Utilities;

public class GameApp extends App{

    private boolean isMultiplayer;


    public GameApp(Developer developer, String appName, double appSize, double appCost, double appVersion, boolean isMultiplayer){
        super(developer,appName,appSize,appCost,appVersion);
        setMultiplayer(isMultiplayer);
    }

    public void setMultiplayer(boolean isMultiplayer){
        if (isMultiplayer){
            this.isMultiplayer = true;
        }
        else this.isMultiplayer = false;
    }


    public boolean isMultiplayer(){
        return isMultiplayer;
    }

    public boolean isRecommendedApp(){
        return isMultiplayer() && Utilities.greaterThanOrEqualTo(calculateRating(), 4);
    }


    public String toString(){
        return getAppName() +"(V" + getAppVersion() + ") "
                + "  "+(isMultiplayer ? "[Multiplayer]":"[Solo]")
                + (isRecommendedApp() ? "  <Recommended>" : "")
                + "\n  by " + getDeveloper()
                + "\n  €" + getAppCost()
                + "\n  Rating: " + calculateRating()
                + "\n  Size: " + getAppSize();

    }

}
