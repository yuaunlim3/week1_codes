package googleStore;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;



public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File(args[0]);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        //Create storage for the different categories
        Map<String, ArrayList<App>> categories = new HashMap<>();

        String line = "a";
        String delimiter = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";  // Regular expression to split by commas outside quotes
        Pattern pattern = Pattern.compile(delimiter);
        //Read the first row 
        bufferedReader.readLine();

        while(line != null){
            line = bufferedReader.readLine();
            if (null == line){
                break;
            }

            App app;

            String[] appInfo = pattern.split(line);
            String name = appInfo[0];
            String cat = appInfo[1];
            String rating = appInfo[2];

            //Check the rating
            if (!isNum(rating)){
                app = new App(name);
            }
            else{
                app = new App(name , Float.parseFloat(rating));
            }
            

            //Save app into the categories directory
            ArrayList<App> appList;
            if(!categories.containsKey(cat)){
                appList = new ArrayList<>();
                appList.add(app);
                categories.put(cat,appList);
            }
            else{
                appList = categories.get(cat);
                appList.add(app);
                categories.put(cat,appList);
            }

            //System.out.printf("Name: %s Cat: %s Rating: %.2f\n",name,cat,rating);  
            //System.out.printf("Name: %s Rating: %.2f\n",app.getName(),app.getRating());
            //System.out.printf("CAT: %s\n",cat) ;
            //System.out.printf("Ratings: %s\n",app.getRating());
            
        }
        reader.close();
        for (String catName :categories.keySet()){
            ArrayList<App> apps = categories.get(catName);
            System.out.println(catName);
            bestApp(apps);
            worstApp(apps);
            averageRate(apps);
        }

    }

    //Check is rating is a number
    public static boolean isNum(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Get best rating app

    public static void bestApp(ArrayList<App> appList){
        App best = new App("name");


        //Check the rating to the current best
        for(App app: appList){
            if (app.getRating() > best.getRating()){
                best = app;
            }
        }

        System.out.printf("Highest rated app name: %s  rating: %.2f\n",best.getName(),best.getRating());

    }

    //Get worst
    public static void worstApp(ArrayList<App> appList){
        App worst = new App("name",10);


        //Check the rating to the current best
        for(App app: appList){
            if (app.getRating() < worst.getRating()){
                worst = app;
            }
        }

        System.out.printf("Lowest rated app name: %s  rating: %.2f\n",worst.getName(),worst.getRating());

    }

    public static void averageRate(ArrayList<App> appList){
        float total = 0F;
        float size = appList.size();
        for(App app: appList){
            //System.out.printf("Name: %s, Rating %.2f\n",app.getName(),app.getRating());
            //Check if the float is not NaN
            if (!Float.isNaN(app.getRating())) {
                total += app.getRating();
            }
        }
        System.out.printf("Average Rating: %.2f\n",total/size);

    }

}