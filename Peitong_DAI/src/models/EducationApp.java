package models;

import utils.Utilities;
public class EducationApp {

    private int level = 0;

    public EducationApp(Developer developer, String appName, double appSize, double appCost, double appVersion, boolean isRecommendedApp){

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

    public String appSummary(){

    }

    public String toString(){

    }

}
