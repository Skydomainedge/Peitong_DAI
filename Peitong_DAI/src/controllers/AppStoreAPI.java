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

    }

    public String listAllApps(){
        if (apps.size() == 0) {
            return "No apps";
        } else return apps.toString();

    }

    public String listSummaryOfAllApps(){
        if (apps.size() == 0) {
            return "No apps";
        } else return App.appSummary();

    }

    public String listAllGameApps(){
        String s = "";
        if (numberOfActiveNotes() == 0) {
            return "No active notes stored";
        } else {
            for (int i = 0; i < notes.size(); i++) {
                Note note = notes.get(i);
                if (!note.isNoteArchived()) {
                    s = s + note.toString();
                }
            }
        }

        return s;
    }

    public String listAllEducationApps(){
        if (notes.size() == 0) {
            return "No notes stored";
        } else {
            return notes.toString();
        }
    }

    public String listAllProductivityApps(){
        if (notes.size() == 0) {
            return "No notes stored";
        } else {
            return notes.toString();
        }
    }

    public String listAllAppsByName(){
        if (notes.size() == 0) {
            return "No notes stored";
        } else {
            return notes.toString();
        }
    }

    public String listAllAppsAboveOrEqualAGivenStarRating(){

    }


    public String listAllRecommendedApps(){

    }

    public String listAllAppsByChosenDeveloper(Developer developer){

    }

    public int numberOfAppsByChosenDeveloper(Developer developer){

    }

    public App deleteAppByIndex(int Index){

    }

    public App randomApp(){

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
        size.
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
