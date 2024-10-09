package worddistribution;

public class Word{
    private final String word; 
    private int counter; 

    public Word(String word) {
        this.word = word;
        this.counter = 1; 
    }

    public int getCounter() {
        return counter; 
    }

    public void setCounter(int counter) {
        this.counter = counter; 
    }

    public String getWord() {
        return word;
    }
}
