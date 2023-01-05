package controllers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import models.*;
import utils.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;
import static utils.RatingUtility.generateRandomRating;

public class AppStoreAPI implements ISerializer{

    private List<App> apps = new ArrayList<>();

    public boolean addApp(App app){
        return apps.add(app);
    }

    public String allAppOverview(){
        String str = "";
        for (App app : apps) str += apps.indexOf(app) + ": " + app.toString() + "\n" + app.listRatings();
        return str.isEmpty()  ? "No Apps" : str;
    }
    public String listAllApps(){
        String str = "";
        for (App app : apps) str += apps.indexOf(app) + ": " + app.toString() + "\n";
        return str.isEmpty()  ? "No Apps" : str;
    }


    public String listSummaryOfAllApps(){
        String str = "";
        for (App app : apps) str += apps.indexOf(app) + ": " + app.appSummary() + "\n";
        return str == "" ? " No Apps In Summary " : str;
    }

    public String listAllGameApps(){
        String str = "";
        for (App app : apps) if (app instanceof GameApp) str += apps.indexOf(app) + ": " + app + "\n";

        return str.isEmpty() ? "No Game Apps" : str ;
    }

    public String listAllEducationApps(){
        String str = "";
        for (App app : apps) if (app instanceof EducationApp) str += apps.indexOf(app) + ": " + app + "\n";
        return str.isEmpty() ? "No Education Apps" : str ;
    }

    public String listAllProductivityApps(){
        String str = "";
        for (App app : apps) if (app instanceof ProductivityApp) str += apps.indexOf(app) + ": " + app + "\n";
        return str.isEmpty() ? "No Productivity Apps" : str ;
    }

    public String listAllAppsByName(String name){
        String str = "";
        for (App app : apps) if (app.getAppName().toLowerCase().contains(name.toLowerCase())) str += apps.indexOf(app) + ": " + app + "\n";
        return str.equals("") ? "No Apps For This Name : " + name  : str;

    }
    public int numberOfAppsByChosenDeveloper(Developer developer){
        int count = 0;
        for (App app : apps) if (app.getDeveloper().equals(developer)) count++;
        return count;
    }
    public String listAllAppsAboveOrEqualAGivenStarRating(double rate){
        String str = "";
        for (App app : apps) if (app.calculateRating() >= rate) str += apps.indexOf(app) + ": " + app + "\n";
        return str.equals("") ? "No Apps Rated " + rate + " Or Above" : str;
    }


    public String listAllRecommendedApps(){
        String str = "";
        for (App app : apps) if (app.isRecommendedApp()) str += apps.indexOf(app) + ": " + app + "\n";

        return str.isEmpty() ? "No Recommended Apps" : str ;
    }

    public String listAllAppsByChosenDeveloper(Developer developer){
        String str = "";
        for (App app : apps) if (app.getDeveloper().equals(developer)) str += apps.indexOf(app) + ": " + app + "\n";
        return str.equals("") ? "None of the apps by <" + developer + ">": str;
    }



    public App deleteAppByIndex(int index){
         return isValidIndex(index) ? apps.remove(index) : null;
    }

    public App randomApp(){
        return apps.isEmpty() ? null : apps.get ((int) (random() * (apps.size()-1)));
    }

    public void simulateRatings() {
        for (App app :apps) app.addRating(generateRandomRating());
    }

    public boolean isValidAppName(String appName){
        for (App app : apps) if (app.getAppName().equalsIgnoreCase(appName)) return true;
        return false;
    }

    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < apps.size());
    }
    public App getAppByName(String appName){
        if (isValidAppName(appName)) {
            for (App app : apps){
                if (app.getAppName().equalsIgnoreCase(appName)) return app;
            }
        }
        return null;
    }

    public App getAppByIndex(int index){
            return isValidIndex(index) ? apps.get(index) : null ;
    }


    public int numberOfApps(){
        return apps.size();
    }

    public void sortAppsByNameAscending(){
        for(int i=0;i<apps.size()-1;i++) for(int j=0;j<apps.size()-i-1;j++) if (apps.get(j).getAppName().compareTo(apps.get(j+1).getAppName()) > 0) swapApps(apps, j,j+1);
    }

    private void swapApps(List<App> list, int i, int j){
        App app = list.get(i);
        list.set(i, list.get(j));
        list.set(j, app);
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{App.class, EducationApp.class, GameApp.class, ProductivityApp.class, Rating.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader(fileName()));
        apps = (List<App>) in.readObject();
        in.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(fileName()));
        out.writeObject(apps);
        out.close();
    }

    public String fileName(){
        return "apps.xml";
    }

}
