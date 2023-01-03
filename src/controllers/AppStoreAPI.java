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

public class AppStoreAPI {

    private List<App> apps = new ArrayList<>;

    public boolean addApp(App app){
        return apps.add(app);
    }

    public String listAllApps(){
        String str = "";

        for (App app : apps) {
            str += apps.indexOf(app) + ": " + app.toString() + "\n";
        }

        if (str.isEmpty()) {
            return "No Posts";
        } else {
            return str;
        }
    }

    public String listSummaryOfAllApps(){
        if (apps.size() == 0) {
            return "No apps";
        } else return App.appSummary();

    }

    public String listAllGameApps(){
        String str = "";

        for (App app : apps) {
            if (app instanceof GameApp) {
                str += apps.indexOf(app) + ": " + app.display() + "\n";
            }
        }

        if (str.isEmpty()) {
            return "No Event Posts";
        } else {
            return str;
        }
    }

    public String listAllEducationApps(){

    }

    public String listAllProductivityApps(){
}
    }

    public String listAllAppsByName(){

    }
    public int numberOfAppsByChosenDeveloper(Developer developer){

    }
    public String listAllAppsAboveOrEqualAGivenStarRating(){

    }


    public String listAllRecommendedApps(){

    }

    public String listAllAppsByChosenDeveloper(Developer developer){

    }



    public App deleteAppByIndex(int Index){

    }

    public App randomApp(){
        return apps<int random(1,20) >
    }

    public void simulateRatings() {
    }

    public boolean isValidAppName(String appName){
        if(Utilities.validateStringLength(appName))
    }

    public App getAppByName(String appName){

    }

    public App getAppByIndex(String index){

    }

    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < apps.size());
    }

    public int numberOfApps(){
        return apps.size();
    }

    public void sortAppsByNameAscending(){

    }

    private void swapApps(){

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
