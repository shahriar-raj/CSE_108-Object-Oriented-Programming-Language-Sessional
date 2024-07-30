package sample;

public class Country {
    private String name;
    private int count;

    public Country(String name){
        this.name = name;
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void  increaseCount(){
        count++;
    }

}
