package googleStore;

public class App {
    private float rating;
    private String name;

    public App(String name){
        this.name = name;
        this.rating = 0F;
    }
    
    public App(String name, float rating){
        this.name = name;
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    
}
